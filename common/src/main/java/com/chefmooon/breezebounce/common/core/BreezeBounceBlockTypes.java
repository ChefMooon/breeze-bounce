package com.chefmooon.breezebounce.common.core;

import com.chefmooon.breezebounce.common.registry.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public enum BreezeBounceBlockTypes implements StringRepresentable {
    WHITE(0, "white", Items.WHITE_WOOL, Items.WHITE_DYE, getItem(ModItems.BASIC_BOUNCE), getItem(ModItems.BASIC_BOUNCE_STAIR_WHITE), getItem(ModItems.BASIC_BOUNCE_SLAB_WHITE), getItem(ModItems.BASIC_BOUNCE_WALL)),
    ORANGE(1, "orange", Items.ORANGE_WOOL, Items.ORANGE_DYE, getItem(ModItems.BASIC_BOUNCE_ORANGE), getItem(ModItems.BASIC_BOUNCE_STAIR_ORANGE), getItem(ModItems.BASIC_BOUNCE_SLAB_ORANGE), getItem(ModItems.BASIC_BOUNCE_WALL_ORANGE)),
    MAGENTA(2, "magenta", Items.MAGENTA_WOOL, Items.MAGENTA_DYE, getItem(ModItems.BASIC_BOUNCE_MAGENTA), getItem(ModItems.BASIC_BOUNCE_STAIR_MAGENTA), getItem(ModItems.BASIC_BOUNCE_SLAB_MAGENTA), getItem(ModItems.BASIC_BOUNCE_WALL_MAGENTA)),
    LIGHT_BLUE(3, "light_blue", Items.LIGHT_BLUE_WOOL, Items.LIGHT_BLUE_DYE, getItem(ModItems.BASIC_BOUNCE_LIGHT_BLUE), getItem(ModItems.BASIC_BOUNCE_STAIR_LIGHT_BLUE), getItem(ModItems.BASIC_BOUNCE_SLAB_LIGHT_BLUE), getItem(ModItems.BASIC_BOUNCE_WALL_LIGHT_BLUE)),
    YELLOW(4, "yellow", Items.YELLOW_WOOL, Items.YELLOW_DYE, getItem(ModItems.BASIC_BOUNCE_YELLOW), getItem(ModItems.BASIC_BOUNCE_STAIR_YELLOW), getItem(ModItems.BASIC_BOUNCE_SLAB_YELLOW), getItem(ModItems.BASIC_BOUNCE_WALL_YELLOW)),
    LIME(5, "lime", Items.LIME_WOOL, Items.LIME_DYE, getItem(ModItems.BASIC_BOUNCE_LIME), getItem(ModItems.BASIC_BOUNCE_STAIR_LIME), getItem(ModItems.BASIC_BOUNCE_SLAB_LIME), getItem(ModItems.BASIC_BOUNCE_WALL_LIME)),
    PINK(6, "pink", Items.PINK_WOOL, Items.PINK_DYE, getItem(ModItems.BASIC_BOUNCE_PINK), getItem(ModItems.BASIC_BOUNCE_STAIR_PINK), getItem(ModItems.BASIC_BOUNCE_SLAB_PINK), getItem(ModItems.BASIC_BOUNCE_WALL_PINK)),
    GRAY(7, "gray", Items.GRAY_WOOL, Items.GRAY_DYE, getItem(ModItems.BASIC_BOUNCE_GRAY), getItem(ModItems.BASIC_BOUNCE_STAIR_GRAY), getItem(ModItems.BASIC_BOUNCE_SLAB_GRAY), getItem(ModItems.BASIC_BOUNCE_WALL_GRAY)),
    LIGHT_GRAY(8, "light_gray", Items.LIGHT_GRAY_WOOL, Items.LIGHT_GRAY_DYE, getItem(ModItems.BASIC_BOUNCE_LIGHT_GRAY), getItem(ModItems.BASIC_BOUNCE_STAIR_LIGHT_GRAY), getItem(ModItems.BASIC_BOUNCE_SLAB_LIGHT_GRAY), getItem(ModItems.BASIC_BOUNCE_WALL_LIGHT_GRAY)),
    CYAN(9, "cyan", Items.CYAN_WOOL, Items.CYAN_DYE, getItem(ModItems.BASIC_BOUNCE_CYAN), getItem(ModItems.BASIC_BOUNCE_STAIR_CYAN), getItem(ModItems.BASIC_BOUNCE_SLAB_CYAN), getItem(ModItems.BASIC_BOUNCE_WALL_CYAN)),
    PURPLE(10, "purple", Items.PURPLE_WOOL, Items.PURPLE_DYE, getItem(ModItems.BASIC_BOUNCE_PURPLE), getItem(ModItems.BASIC_BOUNCE_STAIR_PURPLE), getItem(ModItems.BASIC_BOUNCE_SLAB_PURPLE), getItem(ModItems.BASIC_BOUNCE_WALL_PURPLE)),
    BLUE(11, "blue", Items.BLUE_WOOL, Items.BLUE_DYE, getItem(ModItems.BASIC_BOUNCE_BLUE), getItem(ModItems.BASIC_BOUNCE_STAIR_BLUE), getItem(ModItems.BASIC_BOUNCE_SLAB_BLUE), getItem(ModItems.BASIC_BOUNCE_WALL_BLUE)),
    BROWN(12, "brown", Items.BROWN_WOOL, Items.BROWN_DYE, getItem(ModItems.BASIC_BOUNCE_BROWN), getItem(ModItems.BASIC_BOUNCE_STAIR_BROWN), getItem(ModItems.BASIC_BOUNCE_SLAB_BROWN), getItem(ModItems.BASIC_BOUNCE_WALL_BROWN)),
    GREEN(13, "green", Items.GREEN_WOOL, Items.GREEN_DYE, getItem(ModItems.BASIC_BOUNCE_GREEN), getItem(ModItems.BASIC_BOUNCE_STAIR_GREEN), getItem(ModItems.BASIC_BOUNCE_SLAB_GREEN), getItem(ModItems.BASIC_BOUNCE_WALL_GREEN)),
    RED(14, "red", Items.RED_WOOL, Items.RED_DYE, getItem(ModItems.BASIC_BOUNCE_RED), getItem(ModItems.BASIC_BOUNCE_STAIR_RED), getItem(ModItems.BASIC_BOUNCE_SLAB_RED), getItem(ModItems.BASIC_BOUNCE_WALL_RED)),
    BLACK(15, "black", Items.BLACK_WOOL, Items.BLACK_DYE, getItem(ModItems.BASIC_BOUNCE_BLACK), getItem(ModItems.BASIC_BOUNCE_STAIR_BLACK), getItem(ModItems.BASIC_BOUNCE_SLAB_BLACK), getItem(ModItems.BASIC_BOUNCE_WALL_BLACK))
    ;

    private final int id;
    private final String name;
    private final Item dyeItem;
    private final Item woolItem;
    private final Item blockItem;
    private final Item stairItem;
    private final Item slabItem;

    private final Item wallItem;

    BreezeBounceBlockTypes(int id, String name, Item woolItem, Item dyeItem, Item blockItem, Item stairItem, Item slabItem, Item wallItem) {
        this.id = id;
        this.name = name;
        this.dyeItem = dyeItem;
        this.woolItem = woolItem;
        this.blockItem = blockItem;
        this.stairItem = stairItem;
        this.slabItem = slabItem;
        this.wallItem = wallItem;
    }

    public int getId() {
        return id;
    }

    public Item getWoolItem() {
        return woolItem;
    }

    public Item getDyeItem() {
        return dyeItem;
    }

    public Item getBlockItem() {
        return blockItem;
    }

    public Item getStairItem() {
        return stairItem;
    }

    public Item getSlabItem() {
        return slabItem;
    }

    public Item getWallItem() {
        return wallItem;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSerializedName() {
        return "";
    }

    private static Item getItem(Identifier identifier) {
        return BuiltInRegistries.ITEM.get(identifier).get().value();
    }
}
