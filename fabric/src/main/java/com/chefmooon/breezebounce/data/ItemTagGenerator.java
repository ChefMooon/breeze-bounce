package com.chefmooon.breezebounce.data;

import com.chefmooon.breezebounce.common.registry.fabric.ModItemsImpl;
import com.chefmooon.breezebounce.common.tag.BreezeBounceTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagsProvider.ItemTagsProvider {
    public ItemTagGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItemsImpl.VELCRO_HELMET)
                .add(ModItemsImpl.VELCRO_CHESTPLATE)
                .add(ModItemsImpl.VELCRO_LEGGINGS)
                .add(ModItemsImpl.VELCRO_BOOTS);

        valueLookupBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItemsImpl.VELCRO_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItemsImpl.VELCRO_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItemsImpl.VELCRO_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItemsImpl.VELCRO_BOOTS);

        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItemsImpl.VELCRO_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItemsImpl.VELCRO_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItemsImpl.VELCRO_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItemsImpl.VELCRO_BOOTS);

        valueLookupBuilder(BreezeBounceTags.BOUNCE_BLOCKS)
                .add(ModItemsImpl.BASIC_BOUNCE,
                        ModItemsImpl.BASIC_BOUNCE_ORANGE,
                        ModItemsImpl.BASIC_BOUNCE_MAGENTA,
                        ModItemsImpl.BASIC_BOUNCE_LIGHT_BLUE,
                        ModItemsImpl.BASIC_BOUNCE_YELLOW,
                        ModItemsImpl.BASIC_BOUNCE_LIME,
                        ModItemsImpl.BASIC_BOUNCE_PINK,
                        ModItemsImpl.BASIC_BOUNCE_GRAY,
                        ModItemsImpl.BASIC_BOUNCE_LIGHT_GRAY,
                        ModItemsImpl.BASIC_BOUNCE_CYAN,
                        ModItemsImpl.BASIC_BOUNCE_PURPLE,
                        ModItemsImpl.BASIC_BOUNCE_BLUE,
                        ModItemsImpl.BASIC_BOUNCE_BROWN,
                        ModItemsImpl.BASIC_BOUNCE_GREEN,
                        ModItemsImpl.BASIC_BOUNCE_RED,
                        ModItemsImpl.BASIC_BOUNCE_BLACK
                );

        valueLookupBuilder(BreezeBounceTags.BOUNCE_STAIRS)
                .add(ModItemsImpl.BASIC_BOUNCE_STAIR_WHITE,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_ORANGE,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_MAGENTA,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_LIGHT_BLUE,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_YELLOW,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_LIME,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_PINK,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_GRAY,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_LIGHT_GRAY,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_CYAN,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_PURPLE,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_BLUE,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_BROWN,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_GREEN,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_RED,
                        ModItemsImpl.BASIC_BOUNCE_STAIR_BLACK
                );

        valueLookupBuilder(BreezeBounceTags.BOUNCE_SLABS)
                .add(ModItemsImpl.BASIC_BOUNCE_SLAB_WHITE,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_ORANGE,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_MAGENTA,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_LIGHT_BLUE,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_YELLOW,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_LIME,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_PINK,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_GRAY,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_LIGHT_GRAY,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_CYAN,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_PURPLE,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_BLUE,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_BROWN,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_GREEN,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_RED,
                        ModItemsImpl.BASIC_BOUNCE_SLAB_BLACK
                );

        valueLookupBuilder(BreezeBounceTags.BOUNCE_WALLS)
                .add(ModItemsImpl.BASIC_BOUNCE_WALL,
                        ModItemsImpl.BASIC_BOUNCE_WALL_ORANGE,
                        ModItemsImpl.BASIC_BOUNCE_WALL_MAGENTA,
                        ModItemsImpl.BASIC_BOUNCE_WALL_LIGHT_BLUE,
                        ModItemsImpl.BASIC_BOUNCE_WALL_YELLOW,
                        ModItemsImpl.BASIC_BOUNCE_WALL_LIME,
                        ModItemsImpl.BASIC_BOUNCE_WALL_PINK,
                        ModItemsImpl.BASIC_BOUNCE_WALL_GRAY,
                        ModItemsImpl.BASIC_BOUNCE_WALL_LIGHT_GRAY,
                        ModItemsImpl.BASIC_BOUNCE_WALL_CYAN,
                        ModItemsImpl.BASIC_BOUNCE_WALL_PURPLE,
                        ModItemsImpl.BASIC_BOUNCE_WALL_BLUE,
                        ModItemsImpl.BASIC_BOUNCE_WALL_BROWN,
                        ModItemsImpl.BASIC_BOUNCE_WALL_GREEN,
                        ModItemsImpl.BASIC_BOUNCE_WALL_RED,
                        ModItemsImpl.BASIC_BOUNCE_WALL_BLACK
                );
    }
}
