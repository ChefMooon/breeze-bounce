package com.chefmooon.breezebounce.common.registry.fabric;

import com.chefmooon.breezebounce.common.registry.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.chefmooon.breezebounce.common.registry.ModItems.basicItemProperties;

public class ModItemsImpl {

    public static final Item INFLATION_MACHINE = registerItem(ModItems.INFLATION_MACHINE, ModBlocksImpl.INFLATION_MACHINE);

    public static final Item BASIC_BOUNCE = registerItem(ModItems.BASIC_BOUNCE, ModBlocksImpl.BASIC_BOUNCE_WHITE);
    public static final Item BASIC_BOUNCE_STAIR_WHITE = registerItem(ModItems.BASIC_BOUNCE_STAIR_WHITE, ModBlocksImpl.BASIC_BOUNCE_STAIR_WHITE);
    public static final Item BASIC_BOUNCE_SLAB_WHITE = registerItem(ModItems.BASIC_BOUNCE_SLAB_WHITE, ModBlocksImpl.BASIC_BOUNCE_SLAB_WHITE);
    public static final Item BASIC_BOUNCE_WALL = registerItem(ModItems.BASIC_BOUNCE_WALL, ModBlocksImpl.BASIC_BOUNCE_WALL_WHITE);

    public static final Item BASIC_BOUNCE_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_LIGHT_GRAY, ModBlocksImpl.BASIC_BOUNCE_LIGHT_GRAY);
    public static final Item BASIC_BOUNCE_STAIR_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_STAIR_LIGHT_GRAY, ModBlocksImpl.BASIC_BOUNCE_STAIR_LIGHT_GRAY);
    public static final Item BASIC_BOUNCE_SLAB_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_SLAB_LIGHT_GRAY, ModBlocksImpl.BASIC_BOUNCE_SLAB_LIGHT_GRAY);
    public static final Item BASIC_BOUNCE_WALL_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_WALL_LIGHT_GRAY, ModBlocksImpl.BASIC_BOUNCE_WALL_LIGHT_GRAY);

    public static final Item BASIC_BOUNCE_GRAY = registerItem(ModItems.BASIC_BOUNCE_GRAY, ModBlocksImpl.BASIC_BOUNCE_GRAY);
    public static final Item BASIC_BOUNCE_STAIR_GRAY = registerItem(ModItems.BASIC_BOUNCE_STAIR_GRAY, ModBlocksImpl.BASIC_BOUNCE_STAIR_GRAY);
    public static final Item BASIC_BOUNCE_SLAB_GRAY = registerItem(ModItems.BASIC_BOUNCE_SLAB_GRAY, ModBlocksImpl.BASIC_BOUNCE_SLAB_GRAY);
    public static final Item BASIC_BOUNCE_WALL_GRAY = registerItem(ModItems.BASIC_BOUNCE_WALL_GRAY, ModBlocksImpl.BASIC_BOUNCE_WALL_GRAY);

    public static final Item BASIC_BOUNCE_BLACK = registerItem(ModItems.BASIC_BOUNCE_BLACK, ModBlocksImpl.BASIC_BOUNCE_BLACK);
    public static final Item BASIC_BOUNCE_STAIR_BLACK = registerItem(ModItems.BASIC_BOUNCE_STAIR_BLACK, ModBlocksImpl.BASIC_BOUNCE_STAIR_BLACK);
    public static final Item BASIC_BOUNCE_SLAB_BLACK = registerItem(ModItems.BASIC_BOUNCE_SLAB_BLACK, ModBlocksImpl.BASIC_BOUNCE_SLAB_BLACK);
    public static final Item BASIC_BOUNCE_WALL_BLACK = registerItem(ModItems.BASIC_BOUNCE_WALL_BLACK, ModBlocksImpl.BASIC_BOUNCE_WALL_BLACK);

    public static final Item BASIC_BOUNCE_BROWN = registerItem(ModItems.BASIC_BOUNCE_BROWN, ModBlocksImpl.BASIC_BOUNCE_BROWN);
    public static final Item BASIC_BOUNCE_STAIR_BROWN = registerItem(ModItems.BASIC_BOUNCE_STAIR_BROWN, ModBlocksImpl.BASIC_BOUNCE_STAIR_BROWN);
    public static final Item BASIC_BOUNCE_SLAB_BROWN = registerItem(ModItems.BASIC_BOUNCE_SLAB_BROWN, ModBlocksImpl.BASIC_BOUNCE_SLAB_BROWN);
    public static final Item BASIC_BOUNCE_WALL_BROWN = registerItem(ModItems.BASIC_BOUNCE_WALL_BROWN, ModBlocksImpl.BASIC_BOUNCE_WALL_BROWN);

    public static final Item BASIC_BOUNCE_RED = registerItem(ModItems.BASIC_BOUNCE_RED, ModBlocksImpl.BASIC_BOUNCE_RED);
    public static final Item BASIC_BOUNCE_STAIR_RED = registerItem(ModItems.BASIC_BOUNCE_STAIR_RED, ModBlocksImpl.BASIC_BOUNCE_STAIR_RED);
    public static final Item BASIC_BOUNCE_SLAB_RED = registerItem(ModItems.BASIC_BOUNCE_SLAB_RED, ModBlocksImpl.BASIC_BOUNCE_SLAB_RED);
    public static final Item BASIC_BOUNCE_WALL_RED = registerItem(ModItems.BASIC_BOUNCE_WALL_RED, ModBlocksImpl.BASIC_BOUNCE_WALL_RED);

    public static final Item BASIC_BOUNCE_ORANGE = registerItem(ModItems.BASIC_BOUNCE_ORANGE, ModBlocksImpl.BASIC_BOUNCE_ORANGE);
    public static final Item BASIC_BOUNCE_STAIR_ORANGE = registerItem(ModItems.BASIC_BOUNCE_STAIR_ORANGE, ModBlocksImpl.BASIC_BOUNCE_STAIR_ORANGE);
    public static final Item BASIC_BOUNCE_SLAB_ORANGE = registerItem(ModItems.BASIC_BOUNCE_SLAB_ORANGE, ModBlocksImpl.BASIC_BOUNCE_SLAB_ORANGE);
    public static final Item BASIC_BOUNCE_WALL_ORANGE = registerItem(ModItems.BASIC_BOUNCE_WALL_ORANGE, ModBlocksImpl.BASIC_BOUNCE_WALL_ORANGE);

    public static final Item BASIC_BOUNCE_YELLOW = registerItem(ModItems.BASIC_BOUNCE_YELLOW, ModBlocksImpl.BASIC_BOUNCE_YELLOW);
    public static final Item BASIC_BOUNCE_STAIR_YELLOW = registerItem(ModItems.BASIC_BOUNCE_STAIR_YELLOW, ModBlocksImpl.BASIC_BOUNCE_STAIR_YELLOW);
    public static final Item BASIC_BOUNCE_SLAB_YELLOW = registerItem(ModItems.BASIC_BOUNCE_SLAB_YELLOW, ModBlocksImpl.BASIC_BOUNCE_SLAB_YELLOW);
    public static final Item BASIC_BOUNCE_WALL_YELLOW = registerItem(ModItems.BASIC_BOUNCE_WALL_YELLOW, ModBlocksImpl.BASIC_BOUNCE_WALL_YELLOW);

    public static final Item BASIC_BOUNCE_LIME = registerItem(ModItems.BASIC_BOUNCE_LIME, ModBlocksImpl.BASIC_BOUNCE_LIME);
    public static final Item BASIC_BOUNCE_STAIR_LIME = registerItem(ModItems.BASIC_BOUNCE_STAIR_LIME, ModBlocksImpl.BASIC_BOUNCE_STAIR_LIME);
    public static final Item BASIC_BOUNCE_SLAB_LIME = registerItem(ModItems.BASIC_BOUNCE_SLAB_LIME, ModBlocksImpl.BASIC_BOUNCE_SLAB_LIME);
    public static final Item BASIC_BOUNCE_WALL_LIME = registerItem(ModItems.BASIC_BOUNCE_WALL_LIME, ModBlocksImpl.BASIC_BOUNCE_WALL_LIME);

    public static final Item BASIC_BOUNCE_GREEN = registerItem(ModItems.BASIC_BOUNCE_GREEN, ModBlocksImpl.BASIC_BOUNCE_GREEN);
    public static final Item BASIC_BOUNCE_STAIR_GREEN = registerItem(ModItems.BASIC_BOUNCE_STAIR_GREEN, ModBlocksImpl.BASIC_BOUNCE_STAIR_GREEN);
    public static final Item BASIC_BOUNCE_SLAB_GREEN = registerItem(ModItems.BASIC_BOUNCE_SLAB_GREEN, ModBlocksImpl.BASIC_BOUNCE_SLAB_GREEN);
    public static final Item BASIC_BOUNCE_WALL_GREEN = registerItem(ModItems.BASIC_BOUNCE_WALL_GREEN, ModBlocksImpl.BASIC_BOUNCE_WALL_GREEN);

    public static final Item BASIC_BOUNCE_CYAN = registerItem(ModItems.BASIC_BOUNCE_CYAN, ModBlocksImpl.BASIC_BOUNCE_CYAN);
    public static final Item BASIC_BOUNCE_STAIR_CYAN = registerItem(ModItems.BASIC_BOUNCE_STAIR_CYAN, ModBlocksImpl.BASIC_BOUNCE_STAIR_CYAN);
    public static final Item BASIC_BOUNCE_SLAB_CYAN = registerItem(ModItems.BASIC_BOUNCE_SLAB_CYAN, ModBlocksImpl.BASIC_BOUNCE_SLAB_CYAN);
    public static final Item BASIC_BOUNCE_WALL_CYAN = registerItem(ModItems.BASIC_BOUNCE_WALL_CYAN, ModBlocksImpl.BASIC_BOUNCE_WALL_CYAN);

    public static final Item BASIC_BOUNCE_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_LIGHT_BLUE, ModBlocksImpl.BASIC_BOUNCE_LIGHT_BLUE);
    public static final Item BASIC_BOUNCE_STAIR_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_STAIR_LIGHT_BLUE, ModBlocksImpl.BASIC_BOUNCE_STAIR_LIGHT_BLUE);
    public static final Item BASIC_BOUNCE_SLAB_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_SLAB_LIGHT_BLUE, ModBlocksImpl.BASIC_BOUNCE_SLAB_LIGHT_BLUE);
    public static final Item BASIC_BOUNCE_WALL_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_WALL_LIGHT_BLUE, ModBlocksImpl.BASIC_BOUNCE_WALL_LIGHT_BLUE);

    public static final Item BASIC_BOUNCE_BLUE = registerItem(ModItems.BASIC_BOUNCE_BLUE, ModBlocksImpl.BASIC_BOUNCE_BLUE);
    public static final Item BASIC_BOUNCE_STAIR_BLUE = registerItem(ModItems.BASIC_BOUNCE_STAIR_BLUE, ModBlocksImpl.BASIC_BOUNCE_STAIR_BLUE);
    public static final Item BASIC_BOUNCE_SLAB_BLUE = registerItem(ModItems.BASIC_BOUNCE_SLAB_BLUE, ModBlocksImpl.BASIC_BOUNCE_SLAB_BLUE);
    public static final Item BASIC_BOUNCE_WALL_BLUE = registerItem(ModItems.BASIC_BOUNCE_WALL_BLUE, ModBlocksImpl.BASIC_BOUNCE_WALL_BLUE);

    public static final Item BASIC_BOUNCE_PURPLE = registerItem(ModItems.BASIC_BOUNCE_PURPLE, ModBlocksImpl.BASIC_BOUNCE_PURPLE);
    public static final Item BASIC_BOUNCE_STAIR_PURPLE = registerItem(ModItems.BASIC_BOUNCE_STAIR_PURPLE, ModBlocksImpl.BASIC_BOUNCE_STAIR_PURPLE);
    public static final Item BASIC_BOUNCE_SLAB_PURPLE = registerItem(ModItems.BASIC_BOUNCE_SLAB_PURPLE, ModBlocksImpl.BASIC_BOUNCE_SLAB_PURPLE);
    public static final Item BASIC_BOUNCE_WALL_PURPLE = registerItem(ModItems.BASIC_BOUNCE_WALL_PURPLE, ModBlocksImpl.BASIC_BOUNCE_WALL_PURPLE);

    public static final Item BASIC_BOUNCE_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_MAGENTA, ModBlocksImpl.BASIC_BOUNCE_MAGENTA);
    public static final Item BASIC_BOUNCE_STAIR_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_STAIR_MAGENTA, ModBlocksImpl.BASIC_BOUNCE_STAIR_MAGENTA);
    public static final Item BASIC_BOUNCE_SLAB_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_SLAB_MAGENTA, ModBlocksImpl.BASIC_BOUNCE_SLAB_MAGENTA);
    public static final Item BASIC_BOUNCE_WALL_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_WALL_MAGENTA, ModBlocksImpl.BASIC_BOUNCE_WALL_MAGENTA);

    public static final Item BASIC_BOUNCE_PINK = registerItem(ModItems.BASIC_BOUNCE_PINK, ModBlocksImpl.BASIC_BOUNCE_PINK);
    public static final Item BASIC_BOUNCE_STAIR_PINK = registerItem(ModItems.BASIC_BOUNCE_STAIR_PINK, ModBlocksImpl.BASIC_BOUNCE_STAIR_PINK);
    public static final Item BASIC_BOUNCE_SLAB_PINK = registerItem(ModItems.BASIC_BOUNCE_SLAB_PINK, ModBlocksImpl.BASIC_BOUNCE_SLAB_PINK);
    public static final Item BASIC_BOUNCE_WALL_PINK = registerItem(ModItems.BASIC_BOUNCE_WALL_PINK, ModBlocksImpl.BASIC_BOUNCE_WALL_PINK);


    private static Item registerItem(ResourceLocation location, Block block) {
        BlockItem blockItem = new BlockItem(block, basicItemProperties().setId(key(location)).useBlockDescriptionPrefix());
        ItemGroupEvents.modifyEntriesEvent(ModCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(blockItem));
        return Registry.register(BuiltInRegistries.ITEM, location, blockItem);
    }

    private static Item registerItem(ResourceLocation location, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ModCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item));
        return Registry.register(BuiltInRegistries.ITEM, location, item);
    }

    private static ResourceKey<Item> key(ResourceLocation resourceLocation) {
        return ResourceKey.create(Registries.ITEM, resourceLocation);
    }

    public static void register() {

    }
}
