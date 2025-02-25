package com.chefmooon.breezebounce.data;

import com.chefmooon.breezebounce.common.registry.fabric.ModItemsImpl;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItemsImpl.INFLATION_MACHINE)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.COBBLESTONE)
                .define('B', Items.WIND_CHARGE)
                .unlockedBy(RecipeProvider.getHasName(Items.WIND_CHARGE), RecipeProvider.has(Items.WIND_CHARGE))
                .unlockedBy(RecipeProvider.getHasName(Items.COBBLESTONE), RecipeProvider.has(Items.COBBLESTONE))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ModItemsImpl.INFLATION_MACHINE))
        ;

        buildBasicBounceBlockRecipes(
                Items.WHITE_WOOL,
                ModItemsImpl.BASIC_BOUNCE,
                ModItemsImpl.BASIC_BOUNCE_STAIR_WHITE,
                ModItemsImpl.BASIC_BOUNCE_SLAB_WHITE,
                ModItemsImpl.BASIC_BOUNCE_WALL,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.LIGHT_GRAY_WOOL,
                ModItemsImpl.BASIC_BOUNCE_LIGHT_GRAY,
                ModItemsImpl.BASIC_BOUNCE_STAIR_LIGHT_GRAY,
                ModItemsImpl.BASIC_BOUNCE_SLAB_LIGHT_GRAY,
                ModItemsImpl.BASIC_BOUNCE_WALL_LIGHT_GRAY,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.GRAY_WOOL,
                ModItemsImpl.BASIC_BOUNCE_GRAY,
                ModItemsImpl.BASIC_BOUNCE_STAIR_GRAY,
                ModItemsImpl.BASIC_BOUNCE_SLAB_GRAY,
                ModItemsImpl.BASIC_BOUNCE_WALL_GRAY,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.BLACK_WOOL,
                ModItemsImpl.BASIC_BOUNCE_BLACK,
                ModItemsImpl.BASIC_BOUNCE_STAIR_BLACK,
                ModItemsImpl.BASIC_BOUNCE_SLAB_BLACK,
                ModItemsImpl.BASIC_BOUNCE_WALL_BLACK,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.BROWN_WOOL,
                ModItemsImpl.BASIC_BOUNCE_BROWN,
                ModItemsImpl.BASIC_BOUNCE_STAIR_BROWN,
                ModItemsImpl.BASIC_BOUNCE_SLAB_BROWN,
                ModItemsImpl.BASIC_BOUNCE_WALL_BROWN,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.RED_WOOL,
                ModItemsImpl.BASIC_BOUNCE_RED,
                ModItemsImpl.BASIC_BOUNCE_STAIR_RED,
                ModItemsImpl.BASIC_BOUNCE_SLAB_RED,
                ModItemsImpl.BASIC_BOUNCE_WALL_RED,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.ORANGE_WOOL,
                ModItemsImpl.BASIC_BOUNCE_ORANGE,
                ModItemsImpl.BASIC_BOUNCE_STAIR_ORANGE,
                ModItemsImpl.BASIC_BOUNCE_SLAB_ORANGE,
                ModItemsImpl.BASIC_BOUNCE_WALL_ORANGE,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.YELLOW_WOOL,
                ModItemsImpl.BASIC_BOUNCE_YELLOW,
                ModItemsImpl.BASIC_BOUNCE_STAIR_YELLOW,
                ModItemsImpl.BASIC_BOUNCE_SLAB_YELLOW,
                ModItemsImpl.BASIC_BOUNCE_WALL_YELLOW,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.LIME_WOOL,
                ModItemsImpl.BASIC_BOUNCE_LIME,
                ModItemsImpl.BASIC_BOUNCE_STAIR_LIME,
                ModItemsImpl.BASIC_BOUNCE_SLAB_LIME,
                ModItemsImpl.BASIC_BOUNCE_WALL_LIME,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.GREEN_WOOL,
                ModItemsImpl.BASIC_BOUNCE_GREEN,
                ModItemsImpl.BASIC_BOUNCE_STAIR_GREEN,
                ModItemsImpl.BASIC_BOUNCE_SLAB_GREEN,
                ModItemsImpl.BASIC_BOUNCE_WALL_GREEN,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.CYAN_WOOL,
                ModItemsImpl.BASIC_BOUNCE_CYAN,
                ModItemsImpl.BASIC_BOUNCE_STAIR_CYAN,
                ModItemsImpl.BASIC_BOUNCE_SLAB_CYAN,
                ModItemsImpl.BASIC_BOUNCE_WALL_CYAN,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.LIGHT_BLUE_WOOL,
                ModItemsImpl.BASIC_BOUNCE_LIGHT_BLUE,
                ModItemsImpl.BASIC_BOUNCE_STAIR_LIGHT_BLUE,
                ModItemsImpl.BASIC_BOUNCE_SLAB_LIGHT_BLUE,
                ModItemsImpl.BASIC_BOUNCE_WALL_LIGHT_BLUE,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.BLUE_WOOL,
                ModItemsImpl.BASIC_BOUNCE_BLUE,
                ModItemsImpl.BASIC_BOUNCE_STAIR_BLUE,
                ModItemsImpl.BASIC_BOUNCE_SLAB_BLUE,
                ModItemsImpl.BASIC_BOUNCE_WALL_BLUE,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.PURPLE_WOOL,
                ModItemsImpl.BASIC_BOUNCE_PURPLE,
                ModItemsImpl.BASIC_BOUNCE_STAIR_PURPLE,
                ModItemsImpl.BASIC_BOUNCE_SLAB_PURPLE,
                ModItemsImpl.BASIC_BOUNCE_WALL_PURPLE,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.MAGENTA_WOOL,
                ModItemsImpl.BASIC_BOUNCE_MAGENTA,
                ModItemsImpl.BASIC_BOUNCE_STAIR_MAGENTA,
                ModItemsImpl.BASIC_BOUNCE_SLAB_MAGENTA,
                ModItemsImpl.BASIC_BOUNCE_WALL_MAGENTA,
                exporter
        );

        buildBasicBounceBlockRecipes(
                Items.PINK_WOOL,
                ModItemsImpl.BASIC_BOUNCE_PINK,
                ModItemsImpl.BASIC_BOUNCE_STAIR_PINK,
                ModItemsImpl.BASIC_BOUNCE_SLAB_PINK,
                ModItemsImpl.BASIC_BOUNCE_WALL_PINK,
                exporter
        );
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
