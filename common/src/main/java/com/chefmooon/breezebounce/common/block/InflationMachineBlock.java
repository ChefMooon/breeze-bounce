package com.chefmooon.breezebounce.common.block;

import com.chefmooon.breezebounce.common.block.entity.InflationMachineBlockEntity;
import com.chefmooon.breezebounce.common.registry.ModParticleTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class InflationMachineBlock extends BaseEntityBlock {
    public static final MapCodec<InflationMachineBlock> CODEC = simpleCodec(InflationMachineBlock::new);
    public static final BooleanProperty INFLATE = BooleanProperty.create("inflate");
    public static final BooleanProperty ENABLED = BlockStateProperties.ENABLED;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public InflationMachineBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(INFLATE, false).setValue(ENABLED, false).setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(INFLATE, ENABLED, AXIS);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis());
    }

    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            this.openContainer(level, blockPos, player);
            return InteractionResult.CONSUME;
        }
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return null;
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if (!oldState.is(state.getBlock())) {
            this.checkPoweredState(level, pos, state);
        }
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        this.checkPoweredState(level, pos, state);
    }

    private void checkPoweredState(Level level, BlockPos pos, BlockState state) {
        boolean bl = !level.hasNeighborSignal(pos);
        if (bl != (Boolean)state.getValue(ENABLED)) {
            level.setBlock(pos, state.setValue(ENABLED, bl), 2);
            if (level instanceof ServerLevel) {
                if (!bl && level.getBlockEntity(pos) instanceof InflationMachineBlockEntity inflationMachineBlockEntity) {
                    if (state.getValue(INFLATE)) InflationMachineBlockEntity.playShutdownSound(level, pos);
                    inflationMachineBlockEntity.onRemoveMachinePower(level, pos, state);
                }
            }
        }
    }

    protected void openContainer(Level level, BlockPos blockPos, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof InflationMachineBlockEntity) {
            player.openMenu((MenuProvider) blockEntity);
//            player.awardStat(); // TODO: add interact stat?
        }
    }

    @Override
    protected void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (!blockState.is(blockState2.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof InflationMachineBlockEntity inflationMachineBlockEntity) {
                if (level instanceof ServerLevel) {
                    Containers.dropContents(level, blockPos, inflationMachineBlockEntity);
                    if (blockState.getValue(INFLATE)) inflationMachineBlockEntity.onRemoveMachinePower(level, blockPos, blockState);
                }

                super.onRemove(blockState, level, blockPos, blockState2, bl);
                level.updateNeighbourForOutputSignal(blockPos, this);
            } else {
                super.onRemove(blockState, level, blockPos, blockState2, bl);
            }
        }
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if ((Boolean)blockState.getValue(INFLATE)) {
            this.spawnParticles(level, blockPos);
        }
    }

    public void spawnParticles(Level level, BlockPos blockPos) {
        double d = 0.5625;
        RandomSource randomSource = level.random;
        Direction[] directions = Direction.values();

        for (Direction direction : directions) {
            BlockPos blockPos2 = blockPos.relative(direction);
            if (!level.getBlockState(blockPos2).isSolidRender(level, blockPos2)) {
                Direction.Axis axis = direction.getAxis();
                double e = axis == Direction.Axis.X ? 0.5 + d * (double) direction.getStepX() : (double) randomSource.nextFloat();
                double f = axis == Direction.Axis.Y ? 0.5 + d * (double) direction.getStepY() : (double) randomSource.nextFloat();
                double g = axis == Direction.Axis.Z ? 0.5 + d * (double) direction.getStepZ() : (double) randomSource.nextFloat();
                level.addParticle(ModParticleTypes.BOUNCE_WHITE.get(), (double) blockPos.getX() + e, (double) blockPos.getY() + f, (double) blockPos.getZ() + g, 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }

    protected BlockState rotate(BlockState blockState, Rotation rotation) {
        return rotateAxis(blockState, rotation);
    }

    public static BlockState rotateAxis(BlockState blockState, Rotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch ((Direction.Axis)blockState.getValue(AXIS)) {
                    case X -> {
                        return (BlockState)blockState.setValue(AXIS, Direction.Axis.Z);
                    }
                    case Z -> {
                        return (BlockState)blockState.setValue(AXIS, Direction.Axis.X);
                    }
                    default -> {
                        return blockState;
                    }
                }
            default:
                return blockState;
        }
    }
}
