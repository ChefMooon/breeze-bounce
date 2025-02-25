package com.chefmooon.breezebounce.common.block.neoforge;

import com.chefmooon.breezebounce.common.block.InflationMachineBlock;
import com.chefmooon.breezebounce.common.block.entity.neoforge.InflationMachineBlockEntityImpl;
import com.chefmooon.breezebounce.common.registry.neoforge.ModBlockEntityTypesImpl;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class InflationMachineBlockImpl extends InflationMachineBlock {
    public InflationMachineBlockImpl(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return ModBlockEntityTypesImpl.INFLATION_MACHINE.get().create(blockPos, blockState);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntity) {
        return createTickerHelper(blockEntity, ModBlockEntityTypesImpl.INFLATION_MACHINE.get(), InflationMachineBlockEntityImpl::serverTick);
    }
}
