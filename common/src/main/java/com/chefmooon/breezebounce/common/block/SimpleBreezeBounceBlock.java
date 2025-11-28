package com.chefmooon.breezebounce.common.block;

import com.chefmooon.breezebounce.common.registry.ModSounds;
import com.chefmooon.breezebounce.common.util.ValidConnectionUtil;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

public interface SimpleBreezeBounceBlock {
    BooleanProperty POWERED = BlockStateProperties.POWERED;
    BooleanProperty MACHINE_POWERED = BooleanProperty.create("machine_powered");
    int ticksToStayPowered = 80;
    double TERMINAL_VELOCITY = 1.0;

    int FLAMMABILITY = 30;
    int FIRE_SPREAD = 60;

    int DOUBLE_JUMP_SPREAD = 1;
    double DOUBLE_BOUNCE_ACTIVATION_THRESHOLD = 2.4;

    default void spawnParticles(Level level, BlockPos blockPos) {
    }

    default void updateEntityAfterSideCollision(Level level, BlockState blockState, BlockPos blockPos, Entity entity, Vec3 vec3) {
        boolean powered = blockState.getValue(POWERED);
        if (!entity.isSuppressingBounce()) {
            this.bounceHorizontal(level, blockPos, entity, vec3, powered, 1.0); // TODO get terminal velocity from block
        }
    }

    default void updateEntityAfterFlyUp(Level level, BlockState blockState, BlockPos blockPos, Entity entity, Vec3 vec3) {
        double VALID_HEAD_BOUNCE_THRESHOLD = 0.082;
        boolean powered = blockState.getValue(POWERED);
        if (vec3.y > VALID_HEAD_BOUNCE_THRESHOLD) {
            if (!entity.isSuppressingBounce()) {
                this.bounceDown(entity, powered, vec3, 1.0); // TODO get terminal velocity from block
            }
            this.playBounceSound(entity, level, blockPos, (float) vec3.y);
        }
    }

    default void bounceUp(Entity entity, Boolean powered, double terminalVelocity) {
        double VERTICAL_TERMINAL_VELOCITY = terminalVelocity * 1.2;
        Vec3 vec3 = entity.getDeltaMovement();
        if (vec3.y < 0.0) {
            double d = entity instanceof LivingEntity ? 1.0 : 0.8;
            if (powered) d *= 1.5;
            if (powered) VERTICAL_TERMINAL_VELOCITY *= 1.1;
            if (Math.abs(vec3.y * d) < VERTICAL_TERMINAL_VELOCITY) {
                entity.setDeltaMovement(vec3.x, -vec3.y * d, vec3.z);
            } else {
                entity.setDeltaMovement(vec3.x, VERTICAL_TERMINAL_VELOCITY, vec3.z);
            }

            float soundVelocityThreshold = entity instanceof ItemEntity ? -0.15f : -0.08f;
            if (vec3.y < soundVelocityThreshold) {
                this.playBounceSound(entity, (float) vec3.y);
            }
        }
    }

    default void bounceDown(Entity entity, Boolean powered, Vec3 vec3, double terminalVelocity) {
        double VERTICAL_TERMINAL_VELOCITY = terminalVelocity;
        double d = entity instanceof LivingEntity ? 1.5 : 0.8;
        if (powered) d *= 2;
        if (powered) VERTICAL_TERMINAL_VELOCITY *= 1.2;
        if (Math.abs(vec3.y * d) < VERTICAL_TERMINAL_VELOCITY) {
            if (vec3.y < 0.01) d *= 100;
            entity.setDeltaMovement(vec3.x, -vec3.y * d, vec3.z);
        } else {
            entity.setDeltaMovement(vec3.x, -VERTICAL_TERMINAL_VELOCITY, vec3.z);
        }
    }

    default void bounceHorizontal(Level level, BlockPos blockPos, Entity entity, Vec3 vec3, Boolean powered, double terminalVelocity) {
        double HORIZONTAL_TERMINAL_VELOCITY = terminalVelocity;
        double VALID_BOUNCE_THRESHOLD = 0.1;
        double d = entity instanceof LivingEntity ? 1.5 : 0.8;
        if (powered) d *= 2;
        if (powered) HORIZONTAL_TERMINAL_VELOCITY *= 2;
        Vec3 reverseVector = getBounceDirection(vec3);
        if (Math.abs(vec3.z) > VALID_BOUNCE_THRESHOLD || Math.abs(vec3.x) > VALID_BOUNCE_THRESHOLD) {
            if (Math.abs(vec3.z * d) < HORIZONTAL_TERMINAL_VELOCITY && Math.abs(vec3.x * d) < HORIZONTAL_TERMINAL_VELOCITY) {
                entity.setDeltaMovement(reverseVector.x * d, reverseVector.y, reverseVector.z * d);
            } else {
                entity.setDeltaMovement(reverseVector.x, reverseVector.y, reverseVector.z);
            }
            this.playBounceSound(entity, level, blockPos, (float) reverseVector.length());
        }
    }

    default void doubleBounceUp(Level level, BlockPos blockPos, Entity entity, double terminalVelocity) {
        double VERTICAL_TERMINAL_VELOCITY = terminalVelocity * 1.2;
        Vec3 vec3 = entity.getDeltaMovement();
        entity.setDeltaMovement(vec3.x, VERTICAL_TERMINAL_VELOCITY, vec3.z);
        level.playLocalSound(blockPos.getX(), blockPos.getY(), blockPos.getZ(), this.getBounceSound(), SoundSource.BLOCKS, getVolume((float) VERTICAL_TERMINAL_VELOCITY - 0.7f), getPitch((float) VERTICAL_TERMINAL_VELOCITY), false);
    }

    default AABB getEntityCheckAABB(Block block, BlockState blockState, BlockPos blockPos) {
        AABB checkAABB;
        switch (block) {
            case BreezeBounceStairBlock breezeBounceStairBlock -> {
                if (blockState.getValue(BreezeBounceStairBlock.HALF) == Half.BOTTOM) {
                    checkAABB = new AABB(blockPos).inflate(0.0, 0.5, 0.0);
                } else {
                    checkAABB = new AABB(blockPos.above());
                }
            }
            case BreezeBounceSlabBlock breezeBounceSlabBlock -> {
                SlabType slabType = blockState.getValue(BreezeBounceSlabBlock.TYPE);
                if (slabType == SlabType.TOP || slabType == SlabType.DOUBLE) {
                    checkAABB = new AABB(blockPos.above());
                } else {
                    checkAABB = new AABB(blockPos);
                }
            }
            case BreezeBounceWallBlock breezeBounceWallBlock -> {
                if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.Y) {
                    checkAABB = new AABB(blockPos.above());
                } else {
                    checkAABB = new AABB(blockPos);
                }
            }
            case null, default -> checkAABB = new AABB(blockPos.above());
        }
        return checkAABB;
    }

    default void doubleBounceEntities(Block block, BlockState blockState, Level level, BlockPos blockPos, Entity sourceEntity) {
        AABB checkAABB = getEntityCheckAABB(block, blockState, blockPos);
        List<Entity> entities = level.getEntitiesOfClass(Entity.class, checkAABB, entity -> true);
        for (Entity entity : entities) {
            if (entity != null && !entity.is(sourceEntity)) this.doubleBounceUp(level, blockPos, entity, TERMINAL_VELOCITY);
        }
    }

    default void inflate(Block block, BlockState blockState, Level level, BlockPos blockPos, @Nullable Player player) {
        level.setBlock(blockPos, (BlockState)blockState.setValue(POWERED, true), 3);
        level.updateNeighborsAt(blockPos, block);
        level.scheduleTick(blockPos, block, getPoweredTime());
        this.playSound((Player) null, level, blockPos, true);
        level.gameEvent(player, GameEvent.BLOCK_ACTIVATE, blockPos);
    }

    default void machineInflate(Block block, BlockState blockState, Level level, BlockPos blockPos, @Nullable Player player) {
        level.setBlock(blockPos, blockState.setValue(POWERED, true), 3);
        level.updateNeighborsAt(blockPos, block);
        level.scheduleTick(blockPos, block, 5);
        this.playSound((Player) null, level, blockPos, true);
        level.gameEvent(player, GameEvent.BLOCK_ACTIVATE, blockPos);
    }

    default void machineSilentInflate(Block block, BlockState blockState, Level level, BlockPos blockPos, @Nullable Player player) {
        level.setBlock(blockPos, blockState.setValue(POWERED, true), 3);
        level.updateNeighborsAt(blockPos, block);
        level.scheduleTick(blockPos, block, 5);
        level.gameEvent(player, GameEvent.BLOCK_ACTIVATE, blockPos);
    }

    default void machineInflation(Block block, BlockState blockState, Level level, BlockPos blockPos, @Nullable Player player) {
        if (!level.getBlockTicks().hasScheduledTick(blockPos, block)) {
            if (!blockState.getValue(POWERED)) {
                machineInflate(block, blockState, level, blockPos, player);
            } else {
                machineSilentInflate(block, blockState, level, blockPos, player);
            }
        }
    }

    default int getPoweredTime() {
        return ticksToStayPowered;
    }

    default void checkPower(Block block, BlockState blockState, Level level, BlockPos blockPos) {
        if ((Boolean)blockState.getValue(POWERED)) {
            level.setBlock(blockPos, (BlockState)blockState.setValue(POWERED, false), 3);
            level.updateNeighborsAt(blockPos, block);
            this.playSound((Player)null, level, blockPos, false);
            level.gameEvent((Player)null, GameEvent.BLOCK_DEACTIVATE, blockPos);
        }
    }

    default void checkMachinePower(LevelAccessor level, Block block, BlockPos pos, BlockState state, BlockState neighborState) {
        if (block instanceof SimpleBreezeBounceBlock) {
            if (state.getValue(POWERED)) {
                if (((neighborState.is(Blocks.MOVING_PISTON) || neighborState.is(Blocks.PISTON_HEAD)))) {
                    this.deflate(block, state, level, pos);
                } else {
                    if (neighborState.getBlock() instanceof SimpleBreezeBounceBlock && !neighborState.getValue(MACHINE_POWERED)) {
                        if (!level.getBlockTicks().hasScheduledTick(pos, block)) {
                            level.setBlock(pos, state.setValue(MACHINE_POWERED, false), 3);
                            level.scheduleTick(pos, block, 5);
                        }
                    }
                }
            }
        }
    }

    default void deflate(Block block, BlockState blockState, LevelAccessor level, BlockPos blockPos) {
        level.setBlock(blockPos, blockState.setValue(POWERED, false).setValue(MACHINE_POWERED, false), 3);
        level.blockUpdated(blockPos, block);
        this.playSound((Player)null, level, blockPos, false);
        level.gameEvent((Player)null, GameEvent.BLOCK_DEACTIVATE, blockPos);
    }

    default Vec3 getBounceDirection(Vec3 vec3) {
        double VALID_BOUNCE_THRESHOLD = 0.1;
        double x = vec3.x;
        double z = vec3.z;
        Vec3 bounceVector = vec3;

        Pair<Direction, Float> xVector = getDirectionVector(x, Direction.WEST, Direction.EAST, VALID_BOUNCE_THRESHOLD);
        Pair<Direction, Float> zVector = getDirectionVector(z, Direction.NORTH, Direction.SOUTH, VALID_BOUNCE_THRESHOLD);

        Pair<Direction, Float> majorVector = Math.abs(xVector.getSecond()) > Math.abs(zVector.getSecond()) ? xVector : zVector;
        Direction majorDirection = majorVector.getFirst();

        if (majorDirection == Direction.NORTH || majorDirection == Direction.SOUTH) { // Major vector z
            bounceVector = new Vec3(bounceVector.x, bounceVector.y, -bounceVector.z);
        } else if (majorDirection == Direction.EAST || majorDirection == Direction.WEST) { // Major vector x
            bounceVector = new Vec3(-bounceVector.x, bounceVector.y, bounceVector.z);
        }

        return bounceVector;
    }

    default Pair<Direction, Float> getDirectionVector(double d, Direction positiveDirection, Direction negativeDirection, double threshold) {
        if (d > threshold) {
            return Pair.of(positiveDirection, (float) d);
        } else if (d < -threshold) {
            return Pair.of(negativeDirection, (float) d);
        }
        return Pair.of(Direction.UP, 0.0f);
    }

    default void playBounceSound(Entity entity, float y) {
        Level level = entity.level();
        float volume = getVolume(y);
        float pitch = getPitch(y);

        int xPos = entity.getBlockX();
        int yPos = entity.getBlockY();
        int zPos = entity.getBlockZ();
        SoundEvent sound = this.getBounceSound();

        if (entity instanceof Player player) {
            level.playSound(player, xPos,yPos, zPos, sound, SoundSource.BLOCKS, volume, pitch);
        } else if (level.isClientSide()) {
            level.playLocalSound(xPos, yPos, zPos, sound, SoundSource.BLOCKS, volume, pitch, false);
        } else {
            level.playSound(null, xPos, yPos, zPos, sound, SoundSource.BLOCKS, volume, pitch);
        }
    }

    default void playBounceSound(Entity entity, LevelAccessor levelAccessor, BlockPos blockPos, float y) {
        if (entity instanceof Player player) {
            levelAccessor.playSound(player, blockPos, this.getBounceSound(), SoundSource.BLOCKS, getVolume(y), getPitch(y));
        } else {
            levelAccessor.playSound((Player) null, blockPos, this.getBounceSound(), SoundSource.BLOCKS);
        }
    }

    default void playSound(@Nullable Player player, LevelAccessor levelAccessor, BlockPos blockPos, boolean bl) {
        levelAccessor.playSound(bl ? player : null, blockPos, this.getSound(bl), SoundSource.BLOCKS);
    }

    default float getVolume(float y) {
        return Math.clamp(0.6f + (Math.abs(y) * 0.3f), 0.6f, 1.2f);
    }

    default float getPitch(float y) {
        return Math.clamp(0.2f + (Math.abs(y) * 0.4f), 0.2f, 1.1f);
    }

    default SoundEvent getBounceSound() {
        return ModSounds.BOUNCE_BLOCK_BOUNCE.get();
    }

    default SoundEvent getSound(boolean bl) {
        return bl ? ModSounds.BOUNCE_BLOCK_INFLATE.get() : ModSounds.BOUNCE_BLOCK_DEFLATE.get();
    }

    default void tryDoubleBounceSpread(Level level, BlockState blockState, BlockPos blockPos, Entity entity) {
        if (blockState.getBlock() instanceof SimpleBreezeBounceBlock && !blockState.getValue(POWERED)) {
            level.playSound(null, blockPos, ModSounds.BOUNCE_BLOCK_DOUBLE_BOUNCE.get(), SoundSource.BLOCKS, 1.0f, 0.6f);
            Set<BlockPos> blocks = ValidConnectionUtil.findDoubleJumpBlocks(level, blockPos, DOUBLE_JUMP_SPREAD);
            for (BlockPos pos : blocks) {
                BlockState doubleJumpBlockState = level.getBlockState(pos);
                Block block = doubleJumpBlockState.getBlock();
                if (block instanceof SimpleBreezeBounceBlock && !doubleJumpBlockState.getValue(POWERED)) {
                    this.inflate(block, doubleJumpBlockState, level, pos, null);
                    this.doubleBounceEntities(block, doubleJumpBlockState, level, pos, entity);
                }
            }
        }
    }
}
