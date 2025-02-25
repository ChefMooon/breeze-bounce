package com.chefmooon.breezebounce.common.block.entity.container;

import com.chefmooon.breezebounce.common.block.entity.InflationMachineBlockEntity;
import com.chefmooon.breezebounce.common.registry.ModMenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.Objects;

public class InflationMachineMenu extends AbstractContainerMenu {
    private final Container container;
    private final ContainerData data;

    public InflationMachineMenu(int i, Inventory inventory, BlockPos blockPos) {
        this(i, inventory, getBlockEntity(inventory, blockPos), new SimpleContainerData(4));
    }

    public InflationMachineMenu(int i, Inventory inventory) {
        this(i, inventory, new SimpleContainer(1), new SimpleContainerData(4));
    }

    public InflationMachineMenu(int i, Inventory inventory, Container container, ContainerData containerData) {
        super(BuiltInRegistries.MENU.get(ModMenuTypes.INFLATION_MACHINE).orElseThrow().value(), i);
//        super(BuiltInRegistries.MENU.get(ModMenuTypes.INFLATION_MACHINE), i); // OG
//        super(BuiltInRegistries.MENU.get(ModMenuTypes.INFLATION_MACHINE).get().value(), i);
        checkContainerSize(container, 1);
        checkContainerDataCount(containerData, 2);
        this.container = container;
        this.data = containerData;
        this.addSlot(new InflationMachineFuelSlot(container, 0, 80, 45));

        for(int l = 0; l < 3; ++l) {
            for(int m = 0; m < 9; ++m) {
                this.addSlot(new Slot(inventory, m + l * 9 + 9, 8 + m * 18, 84 + l * 18));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(inventory, l, 8 + l * 18, 142));
        }

        this.addDataSlots(containerData);
    }


    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(i);
        if (slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            itemStack = slotStack.copy();
            if (i == 0) {
                if (!this.moveItemStackTo(slotStack, 1, 37, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(slotStack, itemStack);
            } else {
                if (this.isFuel(slotStack)) {
                    if (!this.moveItemStackTo(slotStack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (i >= 1 && i < 28) {
                    if (!this.moveItemStackTo(slotStack, 28, 37, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (i >= 28 && i < 37 && !this.moveItemStackTo(slotStack, 1, 28, false)) {
                    return ItemStack.EMPTY;
                } else if (!this.moveItemStackTo(slotStack, 1, 37, false)) {
                    return ItemStack.EMPTY;
                }
            }


            if (slotStack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (slotStack.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, slotStack);
        }

        return itemStack;
    }

    protected boolean isFuel(ItemStack itemStack) {
        return InflationMachineBlockEntity.isFuel(itemStack);
    }

    private static InflationMachineBlockEntity getBlockEntity(final Inventory playerInventory, final FriendlyByteBuf data) {

        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final BlockEntity tileAtPos = playerInventory.player.level().getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof InflationMachineBlockEntity) {
            return (InflationMachineBlockEntity) tileAtPos;
        }
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }

    private static InflationMachineBlockEntity getBlockEntity(Inventory inventory, BlockPos blockPos) {
        Objects.requireNonNull(inventory, "playerInventory cannot be null");
        Objects.requireNonNull(blockPos, "data cannot be null");
        final BlockEntity blockEntity = inventory.player.level().getBlockEntity(blockPos);
        if (blockEntity instanceof InflationMachineBlockEntity inflationMachineBlockEntity) {
            return inflationMachineBlockEntity;
        }
        throw new IllegalStateException("Tile entity is not correct! " + blockEntity);
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    public float getInflateProgress() {
        int i = this.data.get(1);
        if (i == 0) {
            i = 200;
        }

        return Mth.clamp((float)this.data.get(0) / (float)i, 0.0F, 1.0F);
    }

    public boolean isInflate() {
        return this.data.get(0) > 0;
    }

    class InflationMachineFuelSlot extends Slot {
        public InflationMachineFuelSlot(Container container, int i, int j, int k) {
            super(container, i, j, k);
        }

        @Override
        public boolean mayPlace(ItemStack itemStack) {
            return itemStack.is(Items.WIND_CHARGE) || itemStack.is(Items.BREEZE_ROD);
        }
    }
}
