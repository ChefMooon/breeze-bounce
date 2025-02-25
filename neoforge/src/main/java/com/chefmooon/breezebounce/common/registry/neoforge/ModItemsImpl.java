package com.chefmooon.breezebounce.common.registry.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.common.block.neoforge.BreezeBounceStairBlockImpl;
import com.chefmooon.breezebounce.common.registry.ModItems;
import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashSet;

import static com.chefmooon.breezebounce.common.registry.ModItems.basicItemProperties;

public class ModItemsImpl {
//    public static final DeferredRegister<Item> ITEMS = DeferredRegister.Items.create(Registries.ITEM, BreezeBounce.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BreezeBounce.MOD_ID);
    public static LinkedHashSet<DeferredItem<BlockItem>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

    public static final DeferredItem<BlockItem> INFLATION_MACHINE = registerItem(ModItems.INFLATION_MACHINE, ModBlocksImpl.INFLATION_MACHINE);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE = registerItem(ModItems.BASIC_BOUNCE, ModBlocksImpl.BASIC_BOUNCE_WHITE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_WHITE = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_WHITE, ModBlocksImpl.BASIC_BOUNCE_STAIR_WHITE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_WHITE = registerItem(ModItems.BASIC_BOUNCE_SLAB_WHITE, ModBlocksImpl.BASIC_BOUNCE_SLAB_WHITE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL = registerItem(ModItems.BASIC_BOUNCE_WALL, ModBlocksImpl.BASIC_BOUNCE_WALL_WHITE);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_LIGHT_GRAY, ModBlocksImpl.BASIC_BOUNCE_LIGHT_GRAY);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_LIGHT_GRAY = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_LIGHT_GRAY, ModBlocksImpl.BASIC_BOUNCE_STAIR_LIGHT_GRAY);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_SLAB_LIGHT_GRAY, ModBlocksImpl.BASIC_BOUNCE_SLAB_LIGHT_GRAY);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_WALL_LIGHT_GRAY, ModBlocksImpl.BASIC_BOUNCE_WALL_LIGHT_GRAY);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_GRAY = registerItem(ModItems.BASIC_BOUNCE_GRAY, ModBlocksImpl.BASIC_BOUNCE_GRAY);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_GRAY = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_GRAY, ModBlocksImpl.BASIC_BOUNCE_STAIR_GRAY);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_GRAY = registerItem(ModItems.BASIC_BOUNCE_SLAB_GRAY, ModBlocksImpl.BASIC_BOUNCE_SLAB_GRAY);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_GRAY = registerItem(ModItems.BASIC_BOUNCE_WALL_GRAY, ModBlocksImpl.BASIC_BOUNCE_WALL_GRAY);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_BLACK = registerItem(ModItems.BASIC_BOUNCE_BLACK, ModBlocksImpl.BASIC_BOUNCE_BLACK);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_BLACK = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_BLACK, ModBlocksImpl.BASIC_BOUNCE_STAIR_BLACK);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_BLACK = registerItem(ModItems.BASIC_BOUNCE_SLAB_BLACK, ModBlocksImpl.BASIC_BOUNCE_SLAB_BLACK);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_BLACK = registerItem(ModItems.BASIC_BOUNCE_WALL_BLACK, ModBlocksImpl.BASIC_BOUNCE_WALL_BLACK);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_BROWN = registerItem(ModItems.BASIC_BOUNCE_BROWN, ModBlocksImpl.BASIC_BOUNCE_BROWN);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_BROWN = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_BROWN, ModBlocksImpl.BASIC_BOUNCE_STAIR_BROWN);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_BROWN = registerItem(ModItems.BASIC_BOUNCE_SLAB_BROWN, ModBlocksImpl.BASIC_BOUNCE_SLAB_BROWN);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_BROWN = registerItem(ModItems.BASIC_BOUNCE_WALL_BROWN, ModBlocksImpl.BASIC_BOUNCE_WALL_BROWN);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_RED = registerItem(ModItems.BASIC_BOUNCE_RED, ModBlocksImpl.BASIC_BOUNCE_RED);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_RED = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_RED, ModBlocksImpl.BASIC_BOUNCE_STAIR_RED);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_RED = registerItem(ModItems.BASIC_BOUNCE_SLAB_RED, ModBlocksImpl.BASIC_BOUNCE_SLAB_RED);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_RED = registerItem(ModItems.BASIC_BOUNCE_WALL_RED, ModBlocksImpl.BASIC_BOUNCE_WALL_RED);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_ORANGE = registerItem(ModItems.BASIC_BOUNCE_ORANGE, ModBlocksImpl.BASIC_BOUNCE_ORANGE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_ORANGE = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_ORANGE, ModBlocksImpl.BASIC_BOUNCE_STAIR_ORANGE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_ORANGE = registerItem(ModItems.BASIC_BOUNCE_SLAB_ORANGE, ModBlocksImpl.BASIC_BOUNCE_SLAB_ORANGE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_ORANGE = registerItem(ModItems.BASIC_BOUNCE_WALL_ORANGE, ModBlocksImpl.BASIC_BOUNCE_WALL_ORANGE);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_YELLOW = registerItem(ModItems.BASIC_BOUNCE_YELLOW, ModBlocksImpl.BASIC_BOUNCE_YELLOW);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_YELLOW = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_YELLOW, ModBlocksImpl.BASIC_BOUNCE_STAIR_YELLOW);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_YELLOW = registerItem(ModItems.BASIC_BOUNCE_SLAB_YELLOW, ModBlocksImpl.BASIC_BOUNCE_SLAB_YELLOW);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_YELLOW = registerItem(ModItems.BASIC_BOUNCE_WALL_YELLOW, ModBlocksImpl.BASIC_BOUNCE_WALL_YELLOW);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_LIME = registerItem(ModItems.BASIC_BOUNCE_LIME, ModBlocksImpl.BASIC_BOUNCE_LIME);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_LIME = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_LIME, ModBlocksImpl.BASIC_BOUNCE_STAIR_LIME);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_LIME = registerItem(ModItems.BASIC_BOUNCE_SLAB_LIME, ModBlocksImpl.BASIC_BOUNCE_SLAB_LIME);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_LIME = registerItem(ModItems.BASIC_BOUNCE_WALL_LIME, ModBlocksImpl.BASIC_BOUNCE_WALL_LIME);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_GREEN = registerItem(ModItems.BASIC_BOUNCE_GREEN, ModBlocksImpl.BASIC_BOUNCE_GREEN);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_GREEN = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_GREEN, ModBlocksImpl.BASIC_BOUNCE_STAIR_GREEN);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_GREEN = registerItem(ModItems.BASIC_BOUNCE_SLAB_GREEN, ModBlocksImpl.BASIC_BOUNCE_SLAB_GREEN);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_GREEN = registerItem(ModItems.BASIC_BOUNCE_WALL_GREEN, ModBlocksImpl.BASIC_BOUNCE_WALL_GREEN);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_CYAN = registerItem(ModItems.BASIC_BOUNCE_CYAN, ModBlocksImpl.BASIC_BOUNCE_CYAN);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_CYAN = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_CYAN, ModBlocksImpl.BASIC_BOUNCE_STAIR_CYAN);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_CYAN = registerItem(ModItems.BASIC_BOUNCE_SLAB_CYAN, ModBlocksImpl.BASIC_BOUNCE_SLAB_CYAN);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_CYAN = registerItem(ModItems.BASIC_BOUNCE_WALL_CYAN, ModBlocksImpl.BASIC_BOUNCE_WALL_CYAN);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_LIGHT_BLUE, ModBlocksImpl.BASIC_BOUNCE_LIGHT_BLUE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_LIGHT_BLUE = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_LIGHT_BLUE, ModBlocksImpl.BASIC_BOUNCE_STAIR_LIGHT_BLUE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_SLAB_LIGHT_BLUE, ModBlocksImpl.BASIC_BOUNCE_SLAB_LIGHT_BLUE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_WALL_LIGHT_BLUE, ModBlocksImpl.BASIC_BOUNCE_WALL_LIGHT_BLUE);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_BLUE = registerItem(ModItems.BASIC_BOUNCE_BLUE, ModBlocksImpl.BASIC_BOUNCE_BLUE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_BLUE = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_BLUE, ModBlocksImpl.BASIC_BOUNCE_STAIR_BLUE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_BLUE = registerItem(ModItems.BASIC_BOUNCE_SLAB_BLUE, ModBlocksImpl.BASIC_BOUNCE_SLAB_BLUE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_BLUE = registerItem(ModItems.BASIC_BOUNCE_WALL_BLUE, ModBlocksImpl.BASIC_BOUNCE_WALL_BLUE);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_PURPLE = registerItem(ModItems.BASIC_BOUNCE_PURPLE, ModBlocksImpl.BASIC_BOUNCE_PURPLE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_PURPLE = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_PURPLE, ModBlocksImpl.BASIC_BOUNCE_STAIR_PURPLE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_PURPLE = registerItem(ModItems.BASIC_BOUNCE_SLAB_PURPLE, ModBlocksImpl.BASIC_BOUNCE_SLAB_PURPLE);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_PURPLE = registerItem(ModItems.BASIC_BOUNCE_WALL_PURPLE, ModBlocksImpl.BASIC_BOUNCE_WALL_PURPLE);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_MAGENTA, ModBlocksImpl.BASIC_BOUNCE_MAGENTA);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_MAGENTA = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_MAGENTA, ModBlocksImpl.BASIC_BOUNCE_STAIR_MAGENTA);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_SLAB_MAGENTA, ModBlocksImpl.BASIC_BOUNCE_SLAB_MAGENTA);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_WALL_MAGENTA, ModBlocksImpl.BASIC_BOUNCE_WALL_MAGENTA);

    public static final DeferredItem<BlockItem> BASIC_BOUNCE_PINK = registerItem(ModItems.BASIC_BOUNCE_PINK, ModBlocksImpl.BASIC_BOUNCE_PINK);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_STAIR_PINK = registerStairItem(ModItems.BASIC_BOUNCE_STAIR_PINK, ModBlocksImpl.BASIC_BOUNCE_STAIR_PINK);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_SLAB_PINK = registerItem(ModItems.BASIC_BOUNCE_SLAB_PINK, ModBlocksImpl.BASIC_BOUNCE_SLAB_PINK);
    public static final DeferredItem<BlockItem> BASIC_BOUNCE_WALL_PINK = registerItem(ModItems.BASIC_BOUNCE_WALL_PINK, ModBlocksImpl.BASIC_BOUNCE_WALL_PINK);

    public static DeferredItem<BlockItem> registerStairItem(final ResourceLocation location, final DeferredBlock<BreezeBounceStairBlockImpl> block) {
        DeferredItem<BlockItem> item = ITEMS.registerSimpleBlockItem(location.getPath(), block, basicItemProperties());
        CREATIVE_TAB_ITEMS.add(item);
        return item;
    }

    public static DeferredItem<BlockItem> registerItem(final ResourceLocation location, final DeferredBlock<Block> block) {
        DeferredItem<BlockItem> item = ITEMS.registerSimpleBlockItem(location.getPath(), block, basicItemProperties());
        CREATIVE_TAB_ITEMS.add(item);
        return item;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
