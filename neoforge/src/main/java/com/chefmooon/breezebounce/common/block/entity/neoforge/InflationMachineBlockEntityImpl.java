package com.chefmooon.breezebounce.common.block.entity.neoforge;

import com.chefmooon.breezebounce.common.block.entity.InflationMachineBlockEntity;
import com.chefmooon.breezebounce.common.block.entity.container.InflationMachineMenu;
import com.chefmooon.breezebounce.common.registry.neoforge.ModBlockEntityTypesImpl;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class InflationMachineBlockEntityImpl extends InflationMachineBlockEntity implements MenuProvider {
    public InflationMachineBlockEntityImpl(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypesImpl.INFLATION_MACHINE.get(), blockPos, blockState);
    }

    @Override
    public Component getDisplayName() {
        return this.getName();
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return this.canOpen(player) ? new InflationMachineMenu(i, inventory, this, this.dataAccess) : null;
    }
}
