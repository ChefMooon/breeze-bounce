package com.chefmooon.breezebounce.common.registry.fabric;

import com.chefmooon.breezebounce.common.item.VelcroArmorItem;
import com.chefmooon.breezebounce.common.registry.ModArmorMaterials;
import com.chefmooon.breezebounce.common.registry.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import static com.chefmooon.breezebounce.common.registry.ModItems.basicItemProperties;

public class ModItemsImpl {

    public static final Item VELCRO_HELMET = registerItem(ModItems.VELCRO_HELMET, new VelcroArmorItem(ModArmorMaterials.VELCRO, ArmorItem.Type.HELMET, (basicItemProperties().durability(ArmorItem.Type.HELMET.getDurability(5)))));
    public static final Item VELCRO_CHESTPLATE = registerItem(ModItems.VELCRO_CHESTPLATE, new VelcroArmorItem(ModArmorMaterials.VELCRO, ArmorItem.Type.CHESTPLATE, (basicItemProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(5)))));
    public static final Item VELCRO_LEGGINGS = registerItem(ModItems.VELCRO_LEGGINGS, new VelcroArmorItem(ModArmorMaterials.VELCRO, ArmorItem.Type.LEGGINGS, (basicItemProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(5)))));
    public static final Item VELCRO_BOOTS = registerItem(ModItems.VELCRO_BOOTS, new VelcroArmorItem(ModArmorMaterials.VELCRO, ArmorItem.Type.BOOTS, (basicItemProperties().durability(ArmorItem.Type.BOOTS.getDurability(5)))));

    public static final Item INFLATION_MACHINE = registerItem(ModItems.INFLATION_MACHINE, new BlockItem(ModBlocksImpl.INFLATION_MACHINE, basicItemProperties()));

    public static final Item BASIC_BOUNCE = registerItem(ModItems.BASIC_BOUNCE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WHITE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_WHITE = registerItem(ModItems.BASIC_BOUNCE_STAIR_WHITE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_WHITE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_WHITE = registerItem(ModItems.BASIC_BOUNCE_SLAB_WHITE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_WHITE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL = registerItem(ModItems.BASIC_BOUNCE_WALL, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_WHITE, basicItemProperties()));

    public static final Item BASIC_BOUNCE_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_LIGHT_GRAY, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_LIGHT_GRAY, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_STAIR_LIGHT_GRAY, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_LIGHT_GRAY, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_SLAB_LIGHT_GRAY, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_LIGHT_GRAY, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_WALL_LIGHT_GRAY, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_LIGHT_GRAY, basicItemProperties()));

    public static final Item BASIC_BOUNCE_GRAY = registerItem(ModItems.BASIC_BOUNCE_GRAY, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_GRAY, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_GRAY = registerItem(ModItems.BASIC_BOUNCE_STAIR_GRAY, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_GRAY, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_GRAY = registerItem(ModItems.BASIC_BOUNCE_SLAB_GRAY, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_GRAY, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_GRAY = registerItem(ModItems.BASIC_BOUNCE_WALL_GRAY, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_GRAY, basicItemProperties()));

    public static final Item BASIC_BOUNCE_BLACK = registerItem(ModItems.BASIC_BOUNCE_BLACK, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_BLACK, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_BLACK = registerItem(ModItems.BASIC_BOUNCE_STAIR_BLACK, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_BLACK, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_BLACK = registerItem(ModItems.BASIC_BOUNCE_SLAB_BLACK, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_BLACK, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_BLACK = registerItem(ModItems.BASIC_BOUNCE_WALL_BLACK, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_BLACK, basicItemProperties()));

    public static final Item BASIC_BOUNCE_BROWN = registerItem(ModItems.BASIC_BOUNCE_BROWN, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_BROWN, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_BROWN = registerItem(ModItems.BASIC_BOUNCE_STAIR_BROWN, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_BROWN, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_BROWN = registerItem(ModItems.BASIC_BOUNCE_SLAB_BROWN, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_BROWN, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_BROWN = registerItem(ModItems.BASIC_BOUNCE_WALL_BROWN, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_BROWN, basicItemProperties()));

    public static final Item BASIC_BOUNCE_RED = registerItem(ModItems.BASIC_BOUNCE_RED, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_RED, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_RED = registerItem(ModItems.BASIC_BOUNCE_STAIR_RED, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_RED, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_RED = registerItem(ModItems.BASIC_BOUNCE_SLAB_RED, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_RED, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_RED = registerItem(ModItems.BASIC_BOUNCE_WALL_RED, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_RED, basicItemProperties()));

    public static final Item BASIC_BOUNCE_ORANGE = registerItem(ModItems.BASIC_BOUNCE_ORANGE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_ORANGE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_ORANGE = registerItem(ModItems.BASIC_BOUNCE_STAIR_ORANGE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_ORANGE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_ORANGE = registerItem(ModItems.BASIC_BOUNCE_SLAB_ORANGE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_ORANGE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_ORANGE = registerItem(ModItems.BASIC_BOUNCE_WALL_ORANGE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_ORANGE, basicItemProperties()));

    public static final Item BASIC_BOUNCE_YELLOW = registerItem(ModItems.BASIC_BOUNCE_YELLOW, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_YELLOW, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_YELLOW = registerItem(ModItems.BASIC_BOUNCE_STAIR_YELLOW, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_YELLOW, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_YELLOW = registerItem(ModItems.BASIC_BOUNCE_SLAB_YELLOW, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_YELLOW, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_YELLOW = registerItem(ModItems.BASIC_BOUNCE_WALL_YELLOW, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_YELLOW, basicItemProperties()));

    public static final Item BASIC_BOUNCE_LIME = registerItem(ModItems.BASIC_BOUNCE_LIME, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_LIME, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_LIME = registerItem(ModItems.BASIC_BOUNCE_STAIR_LIME, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_LIME, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_LIME = registerItem(ModItems.BASIC_BOUNCE_SLAB_LIME, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_LIME, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_LIME = registerItem(ModItems.BASIC_BOUNCE_WALL_LIME, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_LIME, basicItemProperties()));

    public static final Item BASIC_BOUNCE_GREEN = registerItem(ModItems.BASIC_BOUNCE_GREEN, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_GREEN, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_GREEN = registerItem(ModItems.BASIC_BOUNCE_STAIR_GREEN, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_GREEN, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_GREEN = registerItem(ModItems.BASIC_BOUNCE_SLAB_GREEN, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_GREEN, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_GREEN = registerItem(ModItems.BASIC_BOUNCE_WALL_GREEN, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_GREEN, basicItemProperties()));

    public static final Item BASIC_BOUNCE_CYAN = registerItem(ModItems.BASIC_BOUNCE_CYAN, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_CYAN, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_CYAN = registerItem(ModItems.BASIC_BOUNCE_STAIR_CYAN, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_CYAN, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_CYAN = registerItem(ModItems.BASIC_BOUNCE_SLAB_CYAN, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_CYAN, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_CYAN = registerItem(ModItems.BASIC_BOUNCE_WALL_CYAN, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_CYAN, basicItemProperties()));

    public static final Item BASIC_BOUNCE_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_LIGHT_BLUE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_LIGHT_BLUE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_STAIR_LIGHT_BLUE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_LIGHT_BLUE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_SLAB_LIGHT_BLUE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_LIGHT_BLUE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_WALL_LIGHT_BLUE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_LIGHT_BLUE, basicItemProperties()));

    public static final Item BASIC_BOUNCE_BLUE = registerItem(ModItems.BASIC_BOUNCE_BLUE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_BLUE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_BLUE = registerItem(ModItems.BASIC_BOUNCE_STAIR_BLUE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_BLUE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_BLUE = registerItem(ModItems.BASIC_BOUNCE_SLAB_BLUE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_BLUE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_BLUE = registerItem(ModItems.BASIC_BOUNCE_WALL_BLUE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_BLUE, basicItemProperties()));

    public static final Item BASIC_BOUNCE_PURPLE = registerItem(ModItems.BASIC_BOUNCE_PURPLE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_PURPLE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_PURPLE = registerItem(ModItems.BASIC_BOUNCE_STAIR_PURPLE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_PURPLE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_PURPLE = registerItem(ModItems.BASIC_BOUNCE_SLAB_PURPLE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_PURPLE, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_PURPLE = registerItem(ModItems.BASIC_BOUNCE_WALL_PURPLE, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_PURPLE, basicItemProperties()));

    public static final Item BASIC_BOUNCE_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_MAGENTA, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_MAGENTA, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_STAIR_MAGENTA, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_MAGENTA, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_SLAB_MAGENTA, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_MAGENTA, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_WALL_MAGENTA, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_MAGENTA, basicItemProperties()));

    public static final Item BASIC_BOUNCE_PINK = registerItem(ModItems.BASIC_BOUNCE_PINK, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_PINK, basicItemProperties()));
    public static final Item BASIC_BOUNCE_STAIR_PINK = registerItem(ModItems.BASIC_BOUNCE_STAIR_PINK, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_PINK, basicItemProperties()));
    public static final Item BASIC_BOUNCE_SLAB_PINK = registerItem(ModItems.BASIC_BOUNCE_SLAB_PINK, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_PINK, basicItemProperties()));
    public static final Item BASIC_BOUNCE_WALL_PINK = registerItem(ModItems.BASIC_BOUNCE_WALL_PINK, new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_PINK, basicItemProperties()));


    private static Item registerItem(ResourceLocation location, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ModCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item));
        return Registry.register(BuiltInRegistries.ITEM, location, item);
    }

    public static void register() {

    }
}
