package com.chefmooon.breezebounce.common.block.entity;

import com.chefmooon.breezebounce.common.block.InflationMachineBlock;
import com.chefmooon.breezebounce.common.block.SimpleBreezeBounceBlock;
import com.chefmooon.breezebounce.common.registry.ModSounds;
import com.chefmooon.breezebounce.common.util.TextUtil;
import com.chefmooon.breezebounce.common.util.ValidConnectionUtil;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InflationMachineBlockEntity extends BlockEntity implements WorldlyContainer, Nameable {
    protected LockCode lockKey;
    @Nullable
    protected Component name;
    protected static final MutableComponent DISPLAY_NAME = TextUtil.getTranslatable("container.inflation_machine");
    protected NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    int inflateTime;
    int inflateDuration;
    @Nullable
    private static volatile Map<Item, Integer> fuelCache;
    protected final ContainerData dataAccess = new ContainerData() {
        @Override
        public int get(int i) {
            switch (i) {
                case 0:
                    return InflationMachineBlockEntity.this.inflateTime;
                case 1:
                    return InflationMachineBlockEntity.this.inflateDuration;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int i, int j) {
            switch (i) {
                case 0:
                    InflationMachineBlockEntity.this.inflateTime = j;
                    break;
                case 1:
                    InflationMachineBlockEntity.this.inflateDuration = j;
                    break;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    };

    int soundCooldownTime = -1;
    private static final int SOUND_COOLDOWN = 40;
    private static final int RADIUS = 5;
    private static final int HEIGHT = 1;
    private Set<BlockPos> previousBlocks = new HashSet<>();

    public InflationMachineBlockEntity(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
        super(type, blockPos, blockState);
        this.lockKey = LockCode.NO_LOCK;
    }

    public static Map<Item, Integer> getFuel() {
        Map<Item, Integer> map = fuelCache;
        if (map != null) {
            return map;
        } else {
            Map<Item, Integer> map2 = Maps.newLinkedHashMap();
            add(map2, Items.WIND_CHARGE, 240);
            add(map2, Items.BREEZE_ROD, 1200);
            fuelCache = map2;
            return map2;
        }
    }

    private static void add(Map<Item, Integer> map, ItemLike itemLike, int i) {
        Item item = itemLike.asItem();
        map.put(item, i);
    }

    public static boolean isFuel(ItemStack itemStack) {
        return getFuel().containsKey(itemStack.getItem());
    }

    private boolean isInflate() {
        return this.inflateTime > 0;
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.lockKey = LockCode.fromTag(compoundTag, provider);
        if (compoundTag.contains("CustomName", 8)) {
            this.name = parseCustomNameSafe(compoundTag.getString("CustomName"), provider);
        }
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.items, provider);
        this.inflateTime = compoundTag.getShort("InflateTime");
        this.inflateDuration = this.getInflateDuration(this.items.get(0));
        this.soundCooldownTime = compoundTag.getShort("SoundCooldownTime");
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        this.lockKey.addToTag(compoundTag, provider);
        if (this.name != null) {
            compoundTag.putString("CustomName", Component.Serializer.toJson(this.name, provider));
        }
        ContainerHelper.saveAllItems(compoundTag, this.items, provider);
        compoundTag.putShort("InflateTime", (short) this.inflateTime);
        compoundTag.putShort("InflateDuration", (short) this.inflateDuration);
        compoundTag.putShort("SoundCooldownTime", (short) this.soundCooldownTime);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        return this.saveCustomAndMetadata(provider);
    }

    protected int getInflateDuration(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return 0;
        } else {
            Item item = itemStack.getItem();
            return (Integer) getFuel().getOrDefault(item, 0);
        }
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, InflationMachineBlockEntity inflationMachineBlockEntity) {
        boolean isInflate = inflationMachineBlockEntity.isInflate();
        if (blockState.getValue(InflationMachineBlock.ENABLED)) {
            boolean progress = false;
            if (isInflate && !blockState.getValue(InflationMachineBlock.INFLATE)) {
                level.setBlock(blockPos, blockState.setValue(InflationMachineBlock.INFLATE, true), 3);
                playStartupSound(level, blockPos, inflationMachineBlockEntity);
            }
            if (inflationMachineBlockEntity.isInflate()) {
                inflateConnectedBlocks(level, blockPos, blockState, inflationMachineBlockEntity);
                tryPlayInflateSound(level, blockPos, inflationMachineBlockEntity);
                inflationMachineBlockEntity.inflateTime--;
            }

            ItemStack itemStack = inflationMachineBlockEntity.items.get(0);
            boolean hasFuel = !itemStack.isEmpty();
            if (inflationMachineBlockEntity.isInflate() || hasFuel) {

                if (!inflationMachineBlockEntity.isInflate()) {
                    inflationMachineBlockEntity.inflateTime = inflationMachineBlockEntity.getInflateDuration(itemStack);
                    inflationMachineBlockEntity.inflateDuration = inflationMachineBlockEntity.inflateTime;
                    if (inflationMachineBlockEntity.isInflate()) {
                        progress = true;
                        itemStack.shrink(1);
                    }
                }
            }

            if (!isInflate && inflationMachineBlockEntity.isInflate()) {
                playStartupSound(level, blockPos, inflationMachineBlockEntity);
            }

            if (isInflate != inflationMachineBlockEntity.isInflate()) {
                progress = true;
                blockState = blockState.setValue(InflationMachineBlock.INFLATE, inflationMachineBlockEntity.isInflate());
                level.setBlock(blockPos, blockState, 3);
            }

            if (progress) {
                setChanged(level, blockPos, blockState);
            }
        } else {
            if (inflationMachineBlockEntity.isInflate()) {
                blockState = blockState.setValue(InflationMachineBlock.INFLATE, false);
                level.setBlock(blockPos, blockState, 3);
            }
        }
    }

    public static void playStartupSound(Level level, BlockPos blockPos, InflationMachineBlockEntity inflationMachineBlockEntity) {
        level.playSound(null, blockPos, ModSounds.BLOCK_INFLATION_MACHINE_STARTUP.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
        inflationMachineBlockEntity.setSoundCooldownTime(SOUND_COOLDOWN);
    }

    public static void playShutdownSound(Level level, BlockPos blockPos) {
        level.playSound(null, blockPos, ModSounds.BLOCK_INFLATION_MACHINE_SHUTDOWN.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
    }

    private static void tryPlayInflateSound(Level level, BlockPos blockPos, InflationMachineBlockEntity inflationMachineBlockEntity) {
        if (inflationMachineBlockEntity.soundCooldownTime > -1) {
            inflationMachineBlockEntity.soundCooldownTime--;
        }
        if (!inflationMachineBlockEntity.isOnSoundCooldown()) {
            if (level.getRandom().nextFloat() < 0.01) {
                float pitchVariance = 0.9F + level.getRandom().nextFloat() * 0.2F;
                level.playSound(null, blockPos, ModSounds.BLOCK_INFLATION_MACHINE_INFLATE.get(), SoundSource.BLOCKS, 1.0F, pitchVariance);
                inflationMachineBlockEntity.setSoundCooldownTime(SOUND_COOLDOWN);
            }
        }
    }

    private static void inflateConnectedBlocks(Level level, BlockPos blockPos, BlockState blockState, InflationMachineBlockEntity inflationMachineBlockEntity) {
        Set<BlockPos> connectedBlocks = ValidConnectionUtil.findConnectedBlocks(level, blockPos, blockState.getValue(InflationMachineBlock.AXIS), HEIGHT, RADIUS);
        if (inflationMachineBlockEntity.inflateTime > 1) {
            inflationMachineBlockEntity.inflateBlocks(connectedBlocks, level);
        } else if (inflationMachineBlockEntity.isEmpty()) {
            removeMachinePowerTick(connectedBlocks, level);
            playShutdownSound(level, blockPos);
        }
    }

    public void inflateBlocks(Set<BlockPos> blocks, Level level) {
        for (BlockPos pos : blocks) {
            BlockState blockState = level.getBlockState(pos);
            Block block = blockState.getBlock();
            if (block instanceof SimpleBreezeBounceBlock simpleBreezeBounceBlock) {
                if (!blockState.getValue(SimpleBreezeBounceBlock.MACHINE_POWERED)) {
                    blockState = blockState.setValue(SimpleBreezeBounceBlock.MACHINE_POWERED, true);
                }
                simpleBreezeBounceBlock.machineInflation(block, blockState, level, pos, null);
            }
        }
        Set<BlockPos> blocksToDeflate = new HashSet<>(previousBlocks);
        blocksToDeflate.removeAll(blocks);

        if (!blocksToDeflate.isEmpty()) {
            for (BlockPos pos : blocksToDeflate) {
                BlockState blockState = level.getBlockState(pos);
                if (blockState.getBlock() instanceof SimpleBreezeBounceBlock) {
                    removeMachinePowerDeflate(Set.of(pos), level);
                }
            }
        }

        previousBlocks = new HashSet<>(blocks);
    }

    public void onRemoveMachinePower(Level level, BlockPos blockPos, BlockState blockState) {
        Set<BlockPos> connectedBlocks = ValidConnectionUtil.findConnectedBlocks(level, blockPos, blockState.getValue(InflationMachineBlock.AXIS), HEIGHT, RADIUS);
        removeMachinePowerTick(connectedBlocks, level);
    }

    private static void removeMachinePowerDeflate(Set<BlockPos> blocks, Level level) {
        for (BlockPos pos : blocks) {
            BlockState blockState = level.getBlockState(pos);
            Block block = blockState.getBlock();
            if (block instanceof SimpleBreezeBounceBlock simpleBreezeBounceBlock) {
                simpleBreezeBounceBlock.deflate(block, blockState, level, pos);
            }
        }
    }

    private static void removeMachinePowerTick(Set<BlockPos> blocks, Level level) {
        for (BlockPos pos : blocks) {
            BlockState blockState = level.getBlockState(pos);
            Block block = blockState.getBlock();
            if (block instanceof SimpleBreezeBounceBlock) {
                level.setBlock(pos, blockState.setValue(SimpleBreezeBounceBlock.MACHINE_POWERED, false), 3);
                if (!level.getBlockTicks().hasScheduledTick(pos, block)) level.scheduleTick(pos, block, 1);
            }
        }
    }

    private void setSoundCooldownTime(int soundCooldownTime) {
        this.soundCooldownTime = soundCooldownTime;
    }

    private boolean isOnSoundCooldown() {
        return soundCooldownTime > 0;
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.getFirst().isEmpty();
    }

    @Override
    public ItemStack getItem(int slot) {
        return this.items.get(slot);
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        ItemStack itemStack = ContainerHelper.removeItem(this.getItems(), slot, amount);
        if (!itemStack.isEmpty()) {
            this.setChanged();
        }
        return itemStack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(this.getItems(), slot);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        this.getItems().set(slot, stack);
        stack.limitSize(this.getMaxStackSize(stack));
        this.setChanged();
    }

    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        this.getItems().clear();
    }

    @Override
    public Component getName() {
        return this.name != null ? this.name : this.getDefaultName();
    }

    protected Component getDefaultName() {
        return DISPLAY_NAME;
    }

    @Nullable
    @Override
    public Component getCustomName() {
        return this.name;
    }

    public boolean canOpen(Player player) {
        return canUnlock(player, this.lockKey, this.getDisplayName());
    }

    public static boolean canUnlock(Player player, LockCode code, Component displayName) {
        if (!player.isSpectator() && !code.unlocksWith(player.getMainHandItem())) {
            player.displayClientMessage(Component.translatable("container.isLocked", displayName), true);
            player.playNotifySound(SoundEvents.CHEST_LOCKED, SoundSource.BLOCKS, 1.0F, 1.0F);
            return false;
        } else {
            return true;
        }
    }

    protected void applyImplicitComponents(DataComponentInput componentInput) {
        super.applyImplicitComponents(componentInput);
        this.name = componentInput.get(DataComponents.CUSTOM_NAME);
        this.lockKey = componentInput.getOrDefault(DataComponents.LOCK, LockCode.NO_LOCK);
        (componentInput.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY)).copyInto(this.getItems());
    }

    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        super.collectImplicitComponents(components);
        components.set(DataComponents.CUSTOM_NAME, this.name);
        if (!this.lockKey.equals(LockCode.NO_LOCK)) {
            components.set(DataComponents.LOCK, this.lockKey);
        }

        components.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getItems()));
    }

    @Override
    public void removeComponentsFromTag(CompoundTag tag) {
        tag.remove("CustomName");
        tag.remove("Lock");
        tag.remove("Items");
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return new int[]{0};
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack itemStack, @Nullable Direction direction) {
        return isFuel(itemStack);
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return false;
    }
}