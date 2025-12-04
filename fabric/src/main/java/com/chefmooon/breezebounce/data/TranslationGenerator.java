package com.chefmooon.breezebounce.data;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.common.registry.ModMenuTypes;
import com.chefmooon.breezebounce.common.registry.fabric.ModCreativeTabs;
import com.chefmooon.breezebounce.common.registry.fabric.ModItemsImpl;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class TranslationGenerator extends FabricLanguageProvider {

    protected TranslationGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        String SUBTITLE = BreezeBounce.MOD_ID + ".subtitles.";
        String CONTAINER = BreezeBounce.MOD_ID + ".container.";
        String TAG = "tag.item." + BreezeBounce.MOD_ID + ".";
        String EFFECT = "effect." + BreezeBounce.MOD_ID + ".";

        translationBuilder.add(ModCreativeTabs.ITEM_GROUP, "Breeze Bounce");

        translationBuilder.add(CONTAINER + ModMenuTypes.INFLATION_MACHINE.getPath(), "Inflation Machine");

        translationBuilder.add(SUBTITLE + "block.inflation_machine.startup", "Inflation Machine Startup");
        translationBuilder.add(SUBTITLE + "block.inflation_machine.shutdown", "Inflation Machine Shutdown");
        translationBuilder.add(SUBTITLE + "block.inflation_machine.inflate", "Inflation Machine Inflating");

        translationBuilder.add(SUBTITLE + "bounce_block_inflate", "Bounce Block Inflated");
        translationBuilder.add(SUBTITLE + "bounce_block_deflate", "Bounce Block Deflated");
        translationBuilder.add(SUBTITLE + "bounce_block_bounce", "Squeaky Bounce");
        translationBuilder.add(SUBTITLE + "bounce_block_step", "Squeaky Step");
        translationBuilder.add(SUBTITLE + "bounce_block_double_bounce", "Squeaky Double Bounce");

        translationBuilder.add(SUBTITLE + "item.velcro_armour.equip", "Velcro armor tears");
        translationBuilder.add(SUBTITLE + "item.velcro_armour.tear", "Velcro tear");

        translationBuilder.add(ModItemsImpl.VELCRO_HELMET, "Velcro Helmet");
        translationBuilder.add(ModItemsImpl.VELCRO_CHESTPLATE, "Velcro Chestplate");
        translationBuilder.add(ModItemsImpl.VELCRO_LEGGINGS, "Velcro Leggings");
        translationBuilder.add(ModItemsImpl.VELCRO_BOOTS, "Velcro Boots");

        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE, "White Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_LIGHT_GRAY, "Light Gray Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_GRAY, "Gray Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_BLACK, "Black Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_BROWN, "Brown Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_RED, "Red Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_ORANGE, "Orange Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_YELLOW, "Yellow Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_LIME, "Lime Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_GREEN, "Green Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_CYAN, "Cyan Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_LIGHT_BLUE, "Light Blue Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_BLUE, "Blue Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_PURPLE, "Purple Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_MAGENTA, "Magenta Bounce Block");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_PINK, "Pink Bounce Block");

        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_WHITE, "White Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_LIGHT_GRAY, "Light Gray Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_GRAY, "Gray Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_BLACK, "Black Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_BROWN, "Brown Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_RED, "Red Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_ORANGE, "Orange Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_YELLOW, "Yellow Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_LIME, "Lime Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_GREEN, "Green Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_CYAN, "Cyan Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_LIGHT_BLUE, "Light Blue Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_BLUE, "Blue Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_PURPLE, "Purple Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_MAGENTA, "Magenta Bounce Slab");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_SLAB_PINK, "Pink Bounce Slab");

        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_WHITE, "White Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_LIGHT_GRAY, "Light Gray Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_GRAY, "Gray Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_BLACK, "Black Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_BROWN, "Brown Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_RED, "Red Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_ORANGE, "Orange Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_YELLOW, "Yellow Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_LIME, "Lime Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_GREEN, "Green Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_CYAN, "Cyan Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_LIGHT_BLUE, "Light Blue Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_BLUE, "Blue Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_PURPLE, "Purple Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_MAGENTA, "Magenta Bounce Stair");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_STAIR_PINK, "Pink Bounce Stair");


        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL, "White Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_LIGHT_GRAY, "Light Gray Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_GRAY, "Gray Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_BLACK, "Black Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_BROWN, "Brown Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_RED, "Red Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_ORANGE, "Orange Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_YELLOW, "Yellow Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_LIME, "Lime Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_GREEN, "Green Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_CYAN, "Cyan Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_LIGHT_BLUE, "Light Blue Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_BLUE, "Blue Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_PURPLE, "Purple Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_MAGENTA, "Magenta Bounce Post");
        translationBuilder.add(ModItemsImpl.BASIC_BOUNCE_WALL_PINK, "Pink Bounce Post");

        translationBuilder.add(ModItemsImpl.INFLATION_MACHINE, "Inflation Machine");

        translationBuilder.add(EFFECT + "velcro", "Velcro");

        translationBuilder.add(TAG + "bounce_blocks", "Bounce Blocks");
        translationBuilder.add(TAG + "bounce_stairs", "Bounce Stairs");
        translationBuilder.add(TAG + "bounce_slabs", "Bounce Slabs");
        translationBuilder.add(TAG + "bounce_walls", "Bounce Posts");
    }
}
