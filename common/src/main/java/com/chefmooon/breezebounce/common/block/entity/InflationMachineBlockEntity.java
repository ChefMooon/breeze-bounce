package com.chefmooon.breezebounce.common.block.entity;

import com.chefmooon.breezebounce.common.block.*;
import com.chefmooon.breezebounce.common.registry.ModSounds;
import com.chefmooon.breezebounce.common.util.TextUtil;
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
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.properties.StairsShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

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
        this.lockKey = LockCode.fromTag(compoundTag);
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
        this.lockKey.addToTag(compoundTag);
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
        Set<BlockPos> connectedBlocks = findConnectedBlocks(level, blockPos, blockState.getValue(InflationMachineBlock.AXIS), RADIUS);
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
        Set<BlockPos> connectedBlocks = findConnectedBlocks(level, blockPos, blockState.getValue(InflationMachineBlock.AXIS), RADIUS);
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

    private static Set<BlockPos> findConnectedBlocks(Level level, BlockPos startPos, Direction.Axis axis, int radius) {
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();
        queue.add(startPos);

        while (!queue.isEmpty()) {
            BlockPos current = queue.poll();
            if (visited.contains(current) || !isWithinSquareRadius(startPos, current, axis, radius)) continue;

            visited.add(current);

            BlockState blockState = level.getBlockState(current);
            Block block = blockState.getBlock();
            Set<Direction> directions = new HashSet<>();
            if (block instanceof BreezeBounceWallBlock) {
                if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.X) {
                    directions.addAll(Arrays.asList(Direction.EAST, Direction.WEST));
                } else if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.Z) {
                    directions.addAll(Arrays.asList(Direction.NORTH, Direction.SOUTH));
                } else if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.Y) {
                    directions.addAll(Arrays.asList(Direction.UP, Direction.DOWN));
                }
            } else if (block instanceof BreezeBounceSlabBlock) {
                directions.addAll(Arrays.asList(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST));
                if (blockState.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.BOTTOM) {
                    directions.add(Direction.DOWN);
                } else if (blockState.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.TOP) {
                    directions.add(Direction.UP);
                } else if (blockState.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.DOUBLE) {
                    directions.addAll(Arrays.asList(Direction.UP, Direction.DOWN));
                }
            } else {
                directions.addAll(Arrays.asList(Direction.values()));
            }
            for (Direction direction : directions) {
                BlockPos neighbor = current.relative(direction);
                if (isValidConnection(level, blockState, neighbor, direction)) {
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    private static boolean isWithinSquareRadius(BlockPos start, BlockPos current, Direction.Axis axis, int radius) {
        return Math.abs(current.getX() - start.getX()) <= (axis == Direction.Axis.X ? 1 : radius) &&
                Math.abs(current.getY() - start.getY()) <= (axis == Direction.Axis.Y ? 1 : radius) &&
                Math.abs(current.getZ() - start.getZ()) <= (axis == Direction.Axis.Z ? 1 : radius);
    }

    private static boolean isValidConnection(Level level, BlockState sourceBlockState, BlockPos pos, Direction direction) {
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();
        Block sourceBlock = sourceBlockState.getBlock();

        return switch (block) {
            case BreezeBounceWallBlock ignored ->
                    isValidWallConnection(direction, state);
            case BreezeBounceSlabBlock ignored ->
                    isValidSlabConnection(direction, state, sourceBlock, sourceBlockState);
            case BreezeBounceStairBlock ignored ->
                    isValidStairConnection(block, sourceBlock, sourceBlockState, state, direction);
            default -> block instanceof SimpleBreezeBounceBlock;
        };
    }

    private static boolean isValidWallConnection(Direction direction, BlockState blockState) {
        if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.Y && (direction == Direction.UP || direction == Direction.DOWN)) {
            return true;
        } else if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.X && (direction == Direction.EAST || direction == Direction.WEST)) {
            return true;
        } else if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.Z && (direction == Direction.NORTH || direction == Direction.SOUTH)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValidSlabConnection(Direction direction, BlockState state, Block sourceBlock, BlockState sourceBlockState) {
        if (direction == Direction.UP || direction == Direction.DOWN) {
            if (direction == Direction.UP && !(state.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.TOP)) {
                return true;
            } else if (direction == Direction.DOWN && !(state.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.BOTTOM)) {
                return true;
            } else {
                return false;
            }
        } else if (sourceBlock instanceof BreezeBounceSlabBlock) {
            if (sourceBlockState.getValue(BreezeBounceSlabBlock.TYPE) == state.getValue(BreezeBounceSlabBlock.TYPE)) {
                return true;
            } else if (sourceBlockState.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.DOUBLE || state.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.DOUBLE) {
                return true;
            } else {
                return false;
            }
        } else if (sourceBlock instanceof BreezeBounceStairBlock) {
            SlabType type = state.getValue(BreezeBounceSlabBlock.TYPE);
            Half half = sourceBlockState.getValue(BreezeBounceStairBlock.HALF);
            if (type == SlabType.DOUBLE || (type == SlabType.BOTTOM && half == Half.BOTTOM) || (type == SlabType.TOP && half == Half.TOP)) {
                return true;
            } else {
                Direction sourceFacing = sourceBlockState.getValue(BreezeBounceStairBlock.FACING);
                StairsShape sourceShape = sourceBlockState.getValue(BreezeBounceStairBlock.SHAPE);
                if (sourceFacing == direction) {
                    return true;
                } else if (sourceFacing == direction.getClockWise()) {
                    return sourceShape != StairsShape.OUTER_RIGHT;
                } else if (sourceFacing == direction.getCounterClockWise()) {
                    return sourceShape != StairsShape.OUTER_LEFT;
                } else {
                    return sourceShape == StairsShape.INNER_LEFT || sourceShape == StairsShape.INNER_RIGHT;
                }
            }
        }
        return true;
    }

    private static boolean isValidStairConnection(Block block, Block sourceBlock, BlockState sourceBlockState, BlockState state, Direction direction) {
        if (sourceBlock instanceof BreezeBounceSlabBlock) {
            if (sourceBlockState.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.DOUBLE) {
                return true;
            } else {
                Direction facing = state.getValue(BreezeBounceStairBlock.FACING);
                StairsShape shape = state.getValue(BreezeBounceStairBlock.SHAPE);
                SlabType slabType = sourceBlockState.getValue(BreezeBounceSlabBlock.TYPE);
                Half stairHalf = state.getValue(BreezeBounceStairBlock.HALF);
                if ((slabType == SlabType.BOTTOM && stairHalf == Half.BOTTOM) || (slabType == SlabType.TOP && stairHalf == Half.TOP)) {
                    return true;
                } else {
                    if (facing == direction) {
                        return shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT;
                    } else {
                        if (facing == direction.getClockWise()) {
                            if (shape == StairsShape.OUTER_LEFT) {
                                return false;
                            }
                        } else if (facing == direction.getCounterClockWise()) {
                            if (shape == StairsShape.OUTER_RIGHT) {
                                return false;
                            }
                        } else {
                            return true;
                        }
                    }
                }
            }
        } else if (sourceBlock instanceof BreezeBounceStairBlock) {
            Half sourceHalf = sourceBlockState.getValue(BreezeBounceStairBlock.HALF);
            Half half = state.getValue(BreezeBounceStairBlock.HALF);
            Direction sourceFacing = sourceBlockState.getValue(BreezeBounceStairBlock.FACING);
            Direction facing = state.getValue(BreezeBounceStairBlock.FACING);
            StairsShape sourceShape = sourceBlockState.getValue(BreezeBounceStairBlock.SHAPE);
            StairsShape shape = state.getValue(BreezeBounceStairBlock.SHAPE);

            boolean innerConner = shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT || sourceShape == StairsShape.INNER_LEFT || sourceShape == StairsShape.INNER_RIGHT;

            if (direction == Direction.DOWN) {
                if (sourceHalf == Half.BOTTOM && half == Half.TOP) {
                    return true;
                }
                if (facing == sourceFacing.getOpposite()) {
                    if (sourceShape == StairsShape.OUTER_RIGHT && shape != StairsShape.INNER_LEFT) return false;
                    if (sourceShape == StairsShape.OUTER_LEFT && shape != StairsShape.INNER_RIGHT) return false;
                    return innerConner;
                } else if (facing == sourceFacing.getClockWise()) {
                    if (sourceShape == StairsShape.OUTER_LEFT ) {
                        return shape == StairsShape.INNER_LEFT;
                    } else {
                        return true;
                    }
                } else if (facing == sourceFacing.getCounterClockWise()) {
                    if (sourceShape == StairsShape.OUTER_RIGHT) {
                        return shape == StairsShape.INNER_RIGHT;
                    } else {
                        return true;
                    }
                }
            } else if (direction == Direction.UP) {
                if (sourceHalf == Half.TOP && half == Half.BOTTOM) {
                    return true;
                }
                if (facing == sourceFacing.getOpposite()) {
                    if (sourceShape == StairsShape.INNER_LEFT && shape == StairsShape.OUTER_LEFT) return false;
                    if (sourceShape == StairsShape.INNER_RIGHT && shape == StairsShape.OUTER_RIGHT) return false;
                    return innerConner;
                } else if (facing == sourceFacing.getClockWise()) {
                    if (sourceShape == StairsShape.INNER_LEFT ) {
                        return shape == StairsShape.OUTER_LEFT;
                    } else {
                        return true;
                    }
                } else if (facing == sourceFacing.getCounterClockWise()) {
                    if (sourceShape == StairsShape.INNER_RIGHT) {
                        return shape == StairsShape.OUTER_RIGHT;
                    } else {
                        return true;
                    }
                }
            } else {
                if (half == sourceHalf) {
                    return true;
                } else {
                    if (facing == sourceFacing.getOpposite()) {
                        return (direction == sourceFacing) || innerConner;
                    } else if (facing == sourceFacing.getClockWise()) {
                        if (sourceShape == StairsShape.OUTER_LEFT || shape == StairsShape.OUTER_RIGHT) {
                            return false;
                        }
                    } else if (facing == sourceFacing.getCounterClockWise()) {
                        if (sourceShape == StairsShape.OUTER_RIGHT || shape == StairsShape.OUTER_LEFT) {
                            return false;
                        }
                    } else {
                        return true;
                    }
                }
            }
        }
        return block instanceof SimpleBreezeBounceBlock;
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

    protected void applyImplicitComponents(BlockEntity.DataComponentInput componentInput) {
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