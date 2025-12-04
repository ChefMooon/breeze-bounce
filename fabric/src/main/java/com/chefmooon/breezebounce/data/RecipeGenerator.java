package com.chefmooon.breezebounce.data;

import com.chefmooon.breezebounce.common.core.BreezeBounceBlockTypes;
import com.chefmooon.breezebounce.common.registry.fabric.ModItemsImpl;
import com.chefmooon.breezebounce.common.tag.BreezeBounceTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

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
        buildDyeRecipes(provider, exporter);
        buildBounceBlockRecipes(provider, exporter);

        ShapedRecipeBuilder.shaped(provider.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItemsImpl.INFLATION_MACHINE)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.COBBLESTONE)
                .define('B', Items.WIND_CHARGE)
                .unlockedBy(RecipeProvider.getHasName(Items.WIND_CHARGE), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), Items.WIND_CHARGE)))
                .unlockedBy(RecipeProvider.getHasName(Items.COBBLESTONE), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), Items.COBBLESTONE)))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ModItemsImpl.INFLATION_MACHINE));

        ShapedRecipeBuilder.shaped(provider.lookupOrThrow(Registries.ITEM), RecipeCategory.COMBAT, ModItemsImpl.VELCRO_HELMET)
                .pattern("BAB")
                .pattern("A A")
                .define('A', Items.LEATHER)
                .define('B', Items.CACTUS)
                .unlockedBy(RecipeProvider.getHasName(Items.LEATHER), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), Items.LEATHER)))
                .unlockedBy(RecipeProvider.getHasName(Items.CACTUS), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), Items.CACTUS)))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ModItemsImpl.VELCRO_HELMET));

        ShapedRecipeBuilder.shaped(provider.lookupOrThrow(Registries.ITEM), RecipeCategory.COMBAT, ModItemsImpl.VELCRO_CHESTPLATE)
                .pattern("B B")
                .pattern("AAA")
                .pattern("BAB")
                .define('A', Items.LEATHER)
                .define('B', Items.CACTUS)
                .unlockedBy(RecipeProvider.getHasName(Items.LEATHER), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), Items.LEATHER)))
                .unlockedBy(RecipeProvider.getHasName(Items.CACTUS), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), Items.CACTUS)))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ModItemsImpl.VELCRO_CHESTPLATE));

        ShapedRecipeBuilder.shaped(provider.lookupOrThrow(Registries.ITEM), RecipeCategory.COMBAT, ModItemsImpl.VELCRO_LEGGINGS)
                .pattern("BAB")
                .pattern("A A")
                .pattern("B B")
                .define('A', Items.LEATHER)
                .define('B', Items.CACTUS)
                .unlockedBy(RecipeProvider.getHasName(Items.LEATHER), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), Items.LEATHER)))
                .unlockedBy(RecipeProvider.getHasName(Items.CACTUS), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), Items.CACTUS)))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ModItemsImpl.VELCRO_LEGGINGS));

        ShapedRecipeBuilder.shaped(provider.lookupOrThrow(Registries.ITEM), RecipeCategory.COMBAT, ModItemsImpl.VELCRO_BOOTS)
                .pattern("A A")
                .pattern("B B")
                .define('A', Items.LEATHER)
                .define('B', Items.CACTUS)
                .unlockedBy(RecipeProvider.getHasName(Items.LEATHER), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), Items.LEATHER)))
                .unlockedBy(RecipeProvider.getHasName(Items.CACTUS), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), Items.CACTUS)))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ModItemsImpl.VELCRO_BOOTS));
    }

    private void buildBounceBlockRecipes(HolderLookup.Provider provider, RecipeOutput exporter) {
        for (BreezeBounceBlockTypes type : BreezeBounceBlockTypes.values()) {
            buildBasicBounceBlockRecipes(type.getWoolItem(), type.getBlockItem(), type.getStairItem(), type.getSlabItem(), type.getWallItem(), provider, exporter);
        }
    }

    private void buildDyeRecipes(HolderLookup.Provider provider, RecipeOutput exporter) {
        HolderGetter<Item> holderGetter = provider.lookupOrThrow(Registries.ITEM);
        for (BreezeBounceBlockTypes type : BreezeBounceBlockTypes.values()) {
            ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.MISC, type.getBlockItem())
                    .requires(type.getDyeItem())
                    .requires(BreezeBounceTags.BOUNCE_BLOCKS)
                    .unlockedBy(RecipeProvider.getHasName(type.getDyeItem()), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, type.getDyeItem())))
                    .unlockedBy("has_bounce_block", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, BreezeBounceTags.BOUNCE_BLOCKS)))
                    .save(exporter, "dye_" + RecipeProvider.getSimpleRecipeName(type.getBlockItem()));

            ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.MISC, type.getStairItem())
                    .requires(type.getDyeItem())
                    .requires(BreezeBounceTags.BOUNCE_STAIRS)
                    .unlockedBy(RecipeProvider.getHasName(type.getDyeItem()), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, type.getDyeItem())))
                    .unlockedBy("has_bounce_stair", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, BreezeBounceTags.BOUNCE_STAIRS)))
                    .save(exporter, "dye_" + RecipeProvider.getSimpleRecipeName(type.getStairItem()));

            ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.MISC, type.getSlabItem())
                    .requires(type.getDyeItem())
                    .requires(BreezeBounceTags.BOUNCE_SLABS)
                    .unlockedBy(RecipeProvider.getHasName(type.getDyeItem()), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, type.getDyeItem())))
                    .unlockedBy("has_bounce_slab", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, BreezeBounceTags.BOUNCE_SLABS)))
                    .save(exporter, "dye_" + RecipeProvider.getSimpleRecipeName(type.getSlabItem()));

            ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.MISC, type.getWallItem())
                    .requires(type.getDyeItem())
                    .requires(BreezeBounceTags.BOUNCE_WALLS)
                    .unlockedBy(RecipeProvider.getHasName(type.getDyeItem()), RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, type.getDyeItem())))
                    .unlockedBy("has_bounce_wall", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, BreezeBounceTags.BOUNCE_WALLS)))
                    .save(exporter, "dye_" + RecipeProvider.getSimpleRecipeName(type.getWallItem()));
        }
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
