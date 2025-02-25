package com.chefmooon.breezebounce.common.block;

import com.chefmooon.breezebounce.common.registry.ModParticleTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.function.BiConsumer;

public class BreezeBounceBlock extends Block implements SimpleBreezeBounceBlock {
    public static final MapCodec<BreezeBounceBlock> CODEC = simpleCodec(BreezeBounceBlock::new);
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public MapCodec<? extends BreezeBounceBlock> codec() {
        return CODEC;
    }

    public BreezeBounceBlock(Properties properties) {
        super(properties.sound(SimpleBreezeBounceBlock.bounceSoundType()));
        this.registerDefaultState(this.defaultBlockState().setValue(POWERED, false).setValue(MACHINE_POWERED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED, MACHINE_POWERED);
    }

    @Override
    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float f) {
        if (entity.isSuppressingBounce()) {
            if (f > DOUBLE_JUMP_ACTIVATION_THRESHOLD) tryDoubleJumpSpread(level, blockState, blockPos);
        } else {
            entity.causeFallDamage(f, 0.0F, level.damageSources().fall());
        }
    }

    @Override
    public void updateEntityMovementAfterFallOn(BlockGetter blockGetter, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityMovementAfterFallOn(blockGetter, entity);
        } else {
            BlockPos blockPos = entity.getBlockPosBelowThatAffectsMyMovement();
            if (blockGetter.getBlockState(blockPos).getBlock() instanceof BreezeBounceBlock) {
                this.bounceUp(entity, blockGetter.getBlockState(blockPos).getValue(POWERED), TERMINAL_VELOCITY);
            }
        }
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (level instanceof LevelAccessor levelAccessor) {
            checkMachinePower(levelAccessor, this, pos, state, neighborState);
        }
        return super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    public float getJumpFactor() {
        return this.jumpFactor + 0.5f;
    }

    @Override
    protected void onExplosionHit(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Explosion explosion, BiConsumer<ItemStack, BlockPos> biConsumer) {
        if (explosion.canTriggerBlocks() && !(Boolean)blockState.getValue(POWERED)) {
            inflate(this, blockState, serverLevel, blockPos, (Player) null);
        }
        super.onExplosionHit(blockState, serverLevel, blockPos, explosion, biConsumer);
    }

    @Override
    protected void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if ((Boolean)blockState.getValue(POWERED) && !(Boolean)blockState.getValue(MACHINE_POWERED)) {
            checkPower(this, blockState, serverLevel, blockPos);
        }
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if ((Boolean)blockState.getValue(POWERED)) {
            this.spawnParticles(level, blockPos);
        }
    }

    @Override
    public void spawnParticles(Level level, BlockPos blockPos) {
        double d = 0.5625;
        RandomSource randomSource = level.random;
        Direction[] directions = Direction.values();

        for (Direction direction : directions) {
            BlockPos blockPos2 = blockPos.relative(direction);
//            if (!level.getBlockState(blockPos2).isSolidRender(level, blockPos2)) {
            if (!level.getBlockState(blockPos2).isSolidRender()) {
                Direction.Axis axis = direction.getAxis();
                double e = axis == Direction.Axis.X ? 0.5 + d * (double) direction.getStepX() : (double) randomSource.nextFloat();
                double f = axis == Direction.Axis.Y ? 0.5 + d * (double) direction.getStepY() : (double) randomSource.nextFloat();
                double g = axis == Direction.Axis.Z ? 0.5 + d * (double) direction.getStepZ() : (double) randomSource.nextFloat();
                level.addParticle(ModParticleTypes.BOUNCE_WHITE.get(), (double) blockPos.getX() + e, (double) blockPos.getY() + f, (double) blockPos.getZ() + g, 0.0, 0.0, 0.0);
            }
        }
    }
}
