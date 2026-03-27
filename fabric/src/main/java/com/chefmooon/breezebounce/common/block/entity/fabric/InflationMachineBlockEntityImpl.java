package com.chefmooon.breezebounce.common.block.entity.fabric;

import com.chefmooon.breezebounce.common.block.entity.InflationMachineBlockEntity;
import com.chefmooon.breezebounce.common.block.entity.container.InflationMachineMenu;
import com.chefmooon.breezebounce.common.registry.fabric.ModBlockEntityTypesImpl;
import com.chefmooon.breezebounce.common.util.TextUtil;
import net.fabricmc.fabric.api.menu.v1.ExtendedMenuProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class InflationMachineBlockEntityImpl extends InflationMachineBlockEntity implements ExtendedMenuProvider<BlockPos> {
    public InflationMachineBlockEntityImpl(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypesImpl.INFLATION_MACHINE, blockPos, blockState);
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayer player) {
        return this.getBlockPos();
    }

    @Override
    public Component getDisplayName() {
        return this.getName();
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        if (this.canOpen(player)) {
            return new InflationMachineMenu(i, inventory, this, this.dataAccess);
        } else {
            sendChestLockedNotifications(this.getBlockPos().getCenter(), player, this.getDisplayName());
            return null;
        }
//        return this.canOpen(player) ? new InflationMachineMenu(i, inventory, this, this.dataAccess) : sendChestLockedNotifications(this.getBlockPos().getCenter(), player, this.getDisplayName());
    }
}
