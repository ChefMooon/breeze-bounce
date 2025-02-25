package com.chefmooon.breezebounce.data;

import com.chefmooon.breezebounce.common.registry.ModItems;
import com.chefmooon.breezebounce.common.registry.fabric.ModItemsImpl;
import com.chefmooon.breezebounce.common.util.TextUtil;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                build(provider, recipeOutput);
            }
        };
    }

    public void build(HolderLookup.Provider provider, RecipeOutput exporter) {

        ShapedRecipeBuilder.shaped(provider.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItemsImpl.INFLATION_MACHINE)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.COBBLESTONE)
                .define('B', Items.WIND_CHARGE)
                .unlockedBy(RecipeProvider.getHasName(Items.WIND_CHARGE), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), Items.WIND_CHARGE)))
                .unlockedBy(RecipeProvider.getHasName(Items.COBBLESTONE), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), Items.COBBLESTONE)))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ModItemsImpl.INFLATION_MACHINE))
        ;

        buildBasicBounceBlockRecipes(
                Items.WHITE_WOOL,
                ModItemsImpl.BASIC_BOUNCE,
                ModItemsImpl.BASIC_BOUNCE_STAIR_WHITE,
                ModItemsImpl.BASIC_BOUNCE_SLAB_WHITE,
                ModItemsImpl.BASIC_BOUNCE_WALL,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.LIGHT_GRAY_WOOL,
                ModItemsImpl.BASIC_BOUNCE_LIGHT_GRAY,
                ModItemsImpl.BASIC_BOUNCE_STAIR_LIGHT_GRAY,
                ModItemsImpl.BASIC_BOUNCE_SLAB_LIGHT_GRAY,
                ModItemsImpl.BASIC_BOUNCE_WALL_LIGHT_GRAY,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.GRAY_WOOL,
                ModItemsImpl.BASIC_BOUNCE_GRAY,
                ModItemsImpl.BASIC_BOUNCE_STAIR_GRAY,
                ModItemsImpl.BASIC_BOUNCE_SLAB_GRAY,
                ModItemsImpl.BASIC_BOUNCE_WALL_GRAY,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.BLACK_WOOL,
                ModItemsImpl.BASIC_BOUNCE_BLACK,
                ModItemsImpl.BASIC_BOUNCE_STAIR_BLACK,
                ModItemsImpl.BASIC_BOUNCE_SLAB_BLACK,
                ModItemsImpl.BASIC_BOUNCE_WALL_BLACK,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.BROWN_WOOL,
                ModItemsImpl.BASIC_BOUNCE_BROWN,
                ModItemsImpl.BASIC_BOUNCE_STAIR_BROWN,
                ModItemsImpl.BASIC_BOUNCE_SLAB_BROWN,
                ModItemsImpl.BASIC_BOUNCE_WALL_BROWN,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.RED_WOOL,
                ModItemsImpl.BASIC_BOUNCE_RED,
                ModItemsImpl.BASIC_BOUNCE_STAIR_RED,
                ModItemsImpl.BASIC_BOUNCE_SLAB_RED,
                ModItemsImpl.BASIC_BOUNCE_WALL_RED,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.ORANGE_WOOL,
                ModItemsImpl.BASIC_BOUNCE_ORANGE,
                ModItemsImpl.BASIC_BOUNCE_STAIR_ORANGE,
                ModItemsImpl.BASIC_BOUNCE_SLAB_ORANGE,
                ModItemsImpl.BASIC_BOUNCE_WALL_ORANGE,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.YELLOW_WOOL,
                ModItemsImpl.BASIC_BOUNCE_YELLOW,
                ModItemsImpl.BASIC_BOUNCE_STAIR_YELLOW,
                ModItemsImpl.BASIC_BOUNCE_SLAB_YELLOW,
                ModItemsImpl.BASIC_BOUNCE_WALL_YELLOW,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.LIME_WOOL,
                ModItemsImpl.BASIC_BOUNCE_LIME,
                ModItemsImpl.BASIC_BOUNCE_STAIR_LIME,
                ModItemsImpl.BASIC_BOUNCE_SLAB_LIME,
                ModItemsImpl.BASIC_BOUNCE_WALL_LIME,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.GREEN_WOOL,
                ModItemsImpl.BASIC_BOUNCE_GREEN,
                ModItemsImpl.BASIC_BOUNCE_STAIR_GREEN,
                ModItemsImpl.BASIC_BOUNCE_SLAB_GREEN,
                ModItemsImpl.BASIC_BOUNCE_WALL_GREEN,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.CYAN_WOOL,
                ModItemsImpl.BASIC_BOUNCE_CYAN,
                ModItemsImpl.BASIC_BOUNCE_STAIR_CYAN,
                ModItemsImpl.BASIC_BOUNCE_SLAB_CYAN,
                ModItemsImpl.BASIC_BOUNCE_WALL_CYAN,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.LIGHT_BLUE_WOOL,
                ModItemsImpl.BASIC_BOUNCE_LIGHT_BLUE,
                ModItemsImpl.BASIC_BOUNCE_STAIR_LIGHT_BLUE,
                ModItemsImpl.BASIC_BOUNCE_SLAB_LIGHT_BLUE,
                ModItemsImpl.BASIC_BOUNCE_WALL_LIGHT_BLUE,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.BLUE_WOOL,
                ModItemsImpl.BASIC_BOUNCE_BLUE,
                ModItemsImpl.BASIC_BOUNCE_STAIR_BLUE,
                ModItemsImpl.BASIC_BOUNCE_SLAB_BLUE,
                ModItemsImpl.BASIC_BOUNCE_WALL_BLUE,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.PURPLE_WOOL,
                ModItemsImpl.BASIC_BOUNCE_PURPLE,
                ModItemsImpl.BASIC_BOUNCE_STAIR_PURPLE,
                ModItemsImpl.BASIC_BOUNCE_SLAB_PURPLE,
                ModItemsImpl.BASIC_BOUNCE_WALL_PURPLE,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.MAGENTA_WOOL,
                ModItemsImpl.BASIC_BOUNCE_MAGENTA,
                ModItemsImpl.BASIC_BOUNCE_STAIR_MAGENTA,
                ModItemsImpl.BASIC_BOUNCE_SLAB_MAGENTA,
                ModItemsImpl.BASIC_BOUNCE_WALL_MAGENTA,
                provider, exporter
        );

        buildBasicBounceBlockRecipes(
                Items.PINK_WOOL,
                ModItemsImpl.BASIC_BOUNCE_PINK,
                ModItemsImpl.BASIC_BOUNCE_STAIR_PINK,
                ModItemsImpl.BASIC_BOUNCE_SLAB_PINK,
                ModItemsImpl.BASIC_BOUNCE_WALL_PINK,
                provider, exporter
        );
    }

    private void buildBasicBounceBlockRecipes(Item wool, Item basicBounce, Item basicBounceStair, Item basicBounceSlab, Item basicBounceWall, HolderLookup.Provider provider, RecipeOutput exporter) {
        HolderGetter<Item> holderGetter = provider.lookupOrThrow(Registries.ITEM);
        basicBounceBlock(holderGetter, basicBounce, wool, exporter);
        basicBounceStairBlock(holderGetter, basicBounceStair, basicBounce, exporter);
        basicBounceSlabBlock(holderGetter, basicBounceSlab, basicBounce, exporter);
        basicBounceWallBlock(holderGetter, basicBounceWall, basicBounce, exporter);
    }

    private static void basicBounceBlock(HolderGetter<Item> holderGetter, Item output, Item wool, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.MISC, output, 4)
                .pattern("BAB")
                .pattern("ACA")
                .pattern("BAB")
                .define('A', wool)
                .define('B', Items.LEATHER)
                .define('C', Items.WIND_CHARGE)
                .unlockedBy(RecipeProvider.getHasName(Items.WIND_CHARGE), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, Items.WIND_CHARGE)))
                .save(exporter, RecipeProvider.getSimpleRecipeName(output));
    }

    private static void basicBounceStairBlock(HolderGetter<Item> holderGetter, Item output, Item input, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.MISC, output, 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', input)
                .unlockedBy(RecipeProvider.getHasName(input), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, input)))
                .save(exporter, RecipeProvider.getSimpleRecipeName(output));
    }

    private static void basicBounceSlabBlock(HolderGetter<Item> holderGetter, Item output, Item input, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.MISC, output, 6)
                .pattern("AAA")
                .define('A', input)
                .unlockedBy(RecipeProvider.getHasName(input), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, input)))
                .save(exporter, RecipeProvider.getSimpleRecipeName(output));
    }

    private static void basicBounceWallBlock(HolderGetter<Item> holderGetter, Item output, Item input, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.MISC, output, 8)
                .pattern("A")
                .pattern("A")
                .define('A', input)
                .unlockedBy(RecipeProvider.getHasName(input), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, input)))
                .save(exporter, RecipeProvider.getSimpleRecipeName(output));
    }

    @Override
    public String getName() {
        return "";
    }
}
