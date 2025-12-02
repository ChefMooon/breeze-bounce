package com.chefmooon.breezebounce.data;

import com.chefmooon.breezebounce.common.core.BreezeBounceBlockTypes;
import com.chefmooon.breezebounce.common.registry.fabric.ModItemsImpl;
import com.chefmooon.breezebounce.common.tag.BreezeBounceTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        buildDyeRecipes(exporter);
        buildBounceBlockRecipes(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItemsImpl.INFLATION_MACHINE)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.COBBLESTONE)
                .define('B', Items.WIND_CHARGE)
                .unlockedBy(RecipeProvider.getHasName(Items.WIND_CHARGE), RecipeProvider.has(Items.WIND_CHARGE))
                .unlockedBy(RecipeProvider.getHasName(Items.COBBLESTONE), RecipeProvider.has(Items.COBBLESTONE))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ModItemsImpl.INFLATION_MACHINE));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItemsImpl.VELCRO_HELMET)
                .pattern("BAB")
                .pattern("A A")
                .define('A', Items.LEATHER)
                .define('B', Items.CACTUS)
                .unlockedBy(RecipeProvider.getHasName(Items.LEATHER), RecipeProvider.has(Items.LEATHER))
                .unlockedBy(RecipeProvider.getHasName(Items.CACTUS), RecipeProvider.has(Items.CACTUS))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ModItemsImpl.VELCRO_HELMET));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItemsImpl.VELCRO_CHESTPLATE)
                .pattern("B B")
                .pattern("AAA")
                .pattern("BAB")
                .define('A', Items.LEATHER)
                .define('B', Items.CACTUS)
                .unlockedBy(RecipeProvider.getHasName(Items.LEATHER), RecipeProvider.has(Items.LEATHER))
                .unlockedBy(RecipeProvider.getHasName(Items.CACTUS), RecipeProvider.has(Items.CACTUS))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ModItemsImpl.VELCRO_CHESTPLATE));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItemsImpl.VELCRO_LEGGINGS)
                .pattern("BAB")
                .pattern("A A")
                .pattern("B B")
                .define('A', Items.LEATHER)
                .define('B', Items.CACTUS)
                .unlockedBy(RecipeProvider.getHasName(Items.LEATHER), RecipeProvider.has(Items.LEATHER))
                .unlockedBy(RecipeProvider.getHasName(Items.CACTUS), RecipeProvider.has(Items.CACTUS))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ModItemsImpl.VELCRO_LEGGINGS));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItemsImpl.VELCRO_BOOTS)
                .pattern("A A")
                .pattern("B B")
                .define('A', Items.LEATHER)
                .define('B', Items.CACTUS)
                .unlockedBy(RecipeProvider.getHasName(Items.LEATHER), RecipeProvider.has(Items.LEATHER))
                .unlockedBy(RecipeProvider.getHasName(Items.CACTUS), RecipeProvider.has(Items.CACTUS))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ModItemsImpl.VELCRO_BOOTS));
    }

    private void buildBounceBlockRecipes(RecipeOutput exporter) {
        for (BreezeBounceBlockTypes type : BreezeBounceBlockTypes.values()) {
            buildBasicBounceBlockRecipes(type.getWoolItem(), type.getBlockItem(), type.getStairItem(), type.getSlabItem(), type.getWallItem(), exporter);
        }
    }

    private void buildDyeRecipes(RecipeOutput exporter) {
        for (BreezeBounceBlockTypes type : BreezeBounceBlockTypes.values()) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, type.getBlockItem())
                    .requires(type.getDyeItem())
                    .requires(BreezeBounceTags.BOUNCE_BLOCKS)
                    .unlockedBy(RecipeProvider.getHasName(type.getDyeItem()), RecipeProvider.has(type.getDyeItem()))
                    .unlockedBy("has_bounce_block", RecipeProvider.has(BreezeBounceTags.BOUNCE_BLOCKS))
                    .save(exporter, "dye_" + RecipeProvider.getSimpleRecipeName(type.getBlockItem()));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, type.getStairItem())
                    .requires(type.getDyeItem())
                    .requires(BreezeBounceTags.BOUNCE_STAIRS)
                    .unlockedBy(RecipeProvider.getHasName(type.getDyeItem()), RecipeProvider.has(type.getDyeItem()))
                    .unlockedBy("has_bounce_stair", RecipeProvider.has(BreezeBounceTags.BOUNCE_STAIRS))
                    .save(exporter, "dye_" + RecipeProvider.getSimpleRecipeName(type.getStairItem()));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, type.getSlabItem())
                    .requires(type.getDyeItem())
                    .requires(BreezeBounceTags.BOUNCE_SLABS)
                    .unlockedBy(RecipeProvider.getHasName(type.getDyeItem()), RecipeProvider.has(type.getDyeItem()))
                    .unlockedBy("has_bounce_slab", RecipeProvider.has(BreezeBounceTags.BOUNCE_SLABS))
                    .save(exporter, "dye_" + RecipeProvider.getSimpleRecipeName(type.getSlabItem()));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, type.getWallItem())
                    .requires(type.getDyeItem())
                    .requires(BreezeBounceTags.BOUNCE_WALLS)
                    .unlockedBy(RecipeProvider.getHasName(type.getDyeItem()), RecipeProvider.has(type.getDyeItem()))
                    .unlockedBy("has_bounce_wall", RecipeProvider.has(BreezeBounceTags.BOUNCE_WALLS))
                    .save(exporter, "dye_" + RecipeProvider.getSimpleRecipeName(type.getWallItem()));
        }
    }

    private void buildBasicBounceBlockRecipes(Item wool, Item basicBounce, Item basicBounceStair, Item basicBounceSlab, Item basicBounceWall, RecipeOutput exporter) {
        basicBounceBlock(basicBounce, wool, exporter);
        basicBounceStairBlock(basicBounceStair, basicBounce, exporter);
        basicBounceSlabBlock(basicBounceSlab, basicBounce, exporter);
        basicBounceWallBlock(basicBounceWall, basicBounce, exporter);
    }

    private static void basicBounceBlock(Item output, Item wool, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 4)
                .pattern("BAB")
                .pattern("ACA")
                .pattern("BAB")
                .define('A', wool)
                .define('B', Items.LEATHER)
                .define('C', Items.WIND_CHARGE)
                .unlockedBy(RecipeProvider.getHasName(Items.WIND_CHARGE), RecipeProvider.has(Items.WIND_CHARGE))
                .save(exporter, RecipeProvider.getSimpleRecipeName(output));
    }

    private static void basicBounceStairBlock(Item output, Item input, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', input)
                .unlockedBy(RecipeProvider.getHasName(input), RecipeProvider.has(input))
                .save(exporter, RecipeProvider.getSimpleRecipeName(output));
    }

    private static void basicBounceSlabBlock(Item output, Item input, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 6)
                .pattern("AAA")
                .define('A', input)
                .unlockedBy(RecipeProvider.getHasName(input), RecipeProvider.has(input))
                .save(exporter, RecipeProvider.getSimpleRecipeName(output));
    }

    private static void basicBounceWallBlock(Item output, Item input, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 8)
                .pattern("A")
                .pattern("A")
                .define('A', input)
                .unlockedBy(RecipeProvider.getHasName(input), RecipeProvider.has(input))
                .save(exporter, RecipeProvider.getSimpleRecipeName(output));
    }
}
