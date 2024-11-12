package com.chefmooon.breezebounce.common.registry.fabric;

import com.chefmooon.breezebounce.common.block.BreezeBounceBlock;
import com.chefmooon.breezebounce.common.block.BreezeBounceSlabBlock;
import com.chefmooon.breezebounce.common.block.BreezeBounceStairBlock;
import com.chefmooon.breezebounce.common.block.BreezeBounceWallBlock;
import com.chefmooon.breezebounce.common.registry.ModBlocks;
import com.chefmooon.breezebounce.common.registry.ModSounds;
import com.chefmooon.breezebounce.common.util.TextUtil;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import static com.chefmooon.breezebounce.common.registry.ModBlocks.basicBounce;

public class ModBlocksImpl {

    public static final Block BASIC_BOUNCE_WHITE = registerBlock(ModBlocks.BASIC_BOUNCE_WHITE,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.SNOW).setId(key(ModBlocks.BASIC_BOUNCE_WHITE))));
    public static final Block BASIC_BOUNCE_STAIR_WHITE = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_WHITE,
            new BreezeBounceStairBlock(BASIC_BOUNCE_WHITE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_WHITE).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_WHITE))));
    public static final Block BASIC_BOUNCE_SLAB_WHITE = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_WHITE,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_WHITE).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_WHITE))));
    public static final Block BASIC_BOUNCE_WALL_WHITE = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_WHITE,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_WHITE).setId(key(ModBlocks.BASIC_BOUNCE_WALL_WHITE))));

    public static final Block BASIC_BOUNCE_LIGHT_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_LIGHT_GRAY,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_LIGHT_GRAY).setId(key(ModBlocks.BASIC_BOUNCE_LIGHT_GRAY))));
    public static final Block BASIC_BOUNCE_STAIR_LIGHT_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_LIGHT_GRAY,
            new BreezeBounceStairBlock(BASIC_BOUNCE_LIGHT_GRAY.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIGHT_GRAY).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_LIGHT_GRAY))));
    public static final Block BASIC_BOUNCE_SLAB_LIGHT_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_LIGHT_GRAY,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIGHT_GRAY).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_LIGHT_GRAY))));
    public static final Block BASIC_BOUNCE_WALL_LIGHT_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_LIGHT_GRAY,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIGHT_GRAY).setId(key(ModBlocks.BASIC_BOUNCE_WALL_LIGHT_GRAY))));

    public static final Block BASIC_BOUNCE_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_GRAY,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_GRAY).setId(key(ModBlocks.BASIC_BOUNCE_GRAY))));
    public static final Block BASIC_BOUNCE_STAIR_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_GRAY,
            new BreezeBounceStairBlock(BASIC_BOUNCE_GRAY.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_GRAY).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_GRAY))));
    public static final Block BASIC_BOUNCE_SLAB_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_GRAY,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_GRAY).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_GRAY))));
    public static final Block BASIC_BOUNCE_WALL_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_GRAY,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_GRAY).setId(key(ModBlocks.BASIC_BOUNCE_WALL_GRAY))));

    public static final Block BASIC_BOUNCE_BLACK = registerBlock(ModBlocks.BASIC_BOUNCE_BLACK,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_BLACK).setId(key(ModBlocks.BASIC_BOUNCE_BLACK))));
    public static final Block BASIC_BOUNCE_STAIR_BLACK = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_BLACK,
            new BreezeBounceStairBlock(BASIC_BOUNCE_BLACK.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BLACK).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_BLACK))));
    public static final Block BASIC_BOUNCE_SLAB_BLACK = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_BLACK,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BLACK).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_BLACK))));
    public static final Block BASIC_BOUNCE_WALL_BLACK = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_BLACK,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BLACK).setId(key(ModBlocks.BASIC_BOUNCE_WALL_BLACK))));

    public static final Block BASIC_BOUNCE_BROWN = registerBlock(ModBlocks.BASIC_BOUNCE_BROWN,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_BROWN).setId(key(ModBlocks.BASIC_BOUNCE_BROWN))));
    public static final Block BASIC_BOUNCE_STAIR_BROWN = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_BROWN,
            new BreezeBounceStairBlock(BASIC_BOUNCE_BROWN.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BROWN).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_BROWN))));
    public static final Block BASIC_BOUNCE_SLAB_BROWN = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_BROWN,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BROWN).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_BROWN))));
    public static final Block BASIC_BOUNCE_WALL_BROWN = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_BROWN,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BROWN).setId(key(ModBlocks.BASIC_BOUNCE_WALL_BROWN))));

    public static final Block BASIC_BOUNCE_RED = registerBlock(ModBlocks.BASIC_BOUNCE_RED,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_RED).setId(key(ModBlocks.BASIC_BOUNCE_RED))));
    public static final Block BASIC_BOUNCE_STAIR_RED = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_RED,
            new BreezeBounceStairBlock(BASIC_BOUNCE_RED.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_RED).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_RED))));
    public static final Block BASIC_BOUNCE_SLAB_RED = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_RED,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_RED).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_RED))));
    public static final Block BASIC_BOUNCE_WALL_RED = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_RED,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_RED).setId(key(ModBlocks.BASIC_BOUNCE_WALL_RED))));

    public static final Block BASIC_BOUNCE_ORANGE = registerBlock(ModBlocks.BASIC_BOUNCE_ORANGE,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_ORANGE).setId(key(ModBlocks.BASIC_BOUNCE_ORANGE))));
    public static final Block BASIC_BOUNCE_STAIR_ORANGE = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_ORANGE,
            new BreezeBounceStairBlock(BASIC_BOUNCE_ORANGE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_ORANGE).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_ORANGE))));
    public static final Block BASIC_BOUNCE_SLAB_ORANGE = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_ORANGE,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_ORANGE).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_ORANGE))));
    public static final Block BASIC_BOUNCE_WALL_ORANGE = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_ORANGE,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_ORANGE).setId(key(ModBlocks.BASIC_BOUNCE_WALL_ORANGE))));

    public static final Block BASIC_BOUNCE_YELLOW = registerBlock(ModBlocks.BASIC_BOUNCE_YELLOW,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_YELLOW).setId(key(ModBlocks.BASIC_BOUNCE_YELLOW))));
    public static final Block BASIC_BOUNCE_STAIR_YELLOW = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_YELLOW,
            new BreezeBounceStairBlock(BASIC_BOUNCE_YELLOW.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_YELLOW).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_YELLOW))));
    public static final Block BASIC_BOUNCE_SLAB_YELLOW = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_YELLOW,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_YELLOW).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_YELLOW))));
    public static final Block BASIC_BOUNCE_WALL_YELLOW = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_YELLOW,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_YELLOW).setId(key(ModBlocks.BASIC_BOUNCE_WALL_YELLOW))));

    public static final Block BASIC_BOUNCE_LIME = registerBlock(ModBlocks.BASIC_BOUNCE_LIME,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_LIGHT_GREEN).setId(key(ModBlocks.BASIC_BOUNCE_LIME))));
    public static final Block BASIC_BOUNCE_STAIR_LIME = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_LIME,
            new BreezeBounceStairBlock(BASIC_BOUNCE_LIME.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIME).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_LIME))));
    public static final Block BASIC_BOUNCE_SLAB_LIME = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_LIME,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIME).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_LIME))));
    public static final Block BASIC_BOUNCE_WALL_LIME = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_LIME,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIME).setId(key(ModBlocks.BASIC_BOUNCE_WALL_LIME))));

    public static final Block BASIC_BOUNCE_GREEN = registerBlock(ModBlocks.BASIC_BOUNCE_GREEN,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_GREEN).setId(key(ModBlocks.BASIC_BOUNCE_GREEN))));
    public static final Block BASIC_BOUNCE_STAIR_GREEN = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_GREEN,
            new BreezeBounceStairBlock(BASIC_BOUNCE_GREEN.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_GREEN).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_GREEN))));
    public static final Block BASIC_BOUNCE_SLAB_GREEN = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_GREEN,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_GREEN).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_GREEN))));
    public static final Block BASIC_BOUNCE_WALL_GREEN = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_GREEN,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_GREEN).setId(key(ModBlocks.BASIC_BOUNCE_WALL_GREEN))));

    public static final Block BASIC_BOUNCE_CYAN = registerBlock(ModBlocks.BASIC_BOUNCE_CYAN,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_CYAN).setId(key(ModBlocks.BASIC_BOUNCE_CYAN))));
    public static final Block BASIC_BOUNCE_STAIR_CYAN = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_CYAN,
            new BreezeBounceStairBlock(BASIC_BOUNCE_CYAN.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_CYAN).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_CYAN))));
    public static final Block BASIC_BOUNCE_SLAB_CYAN = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_CYAN,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_CYAN).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_CYAN))));
    public static final Block BASIC_BOUNCE_WALL_CYAN = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_CYAN,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_CYAN).setId(key(ModBlocks.BASIC_BOUNCE_WALL_CYAN))));

    public static final Block BASIC_BOUNCE_LIGHT_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_LIGHT_BLUE,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_LIGHT_BLUE).setId(key(ModBlocks.BASIC_BOUNCE_LIGHT_BLUE))));
    public static final Block BASIC_BOUNCE_STAIR_LIGHT_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_LIGHT_BLUE,
            new BreezeBounceStairBlock(BASIC_BOUNCE_LIGHT_BLUE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIGHT_BLUE).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_LIGHT_BLUE))));
    public static final Block BASIC_BOUNCE_SLAB_LIGHT_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_LIGHT_BLUE,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIGHT_BLUE).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_LIGHT_BLUE))));
    public static final Block BASIC_BOUNCE_WALL_LIGHT_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_LIGHT_BLUE,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIGHT_BLUE).setId(key(ModBlocks.BASIC_BOUNCE_WALL_LIGHT_BLUE))));

    public static final Block BASIC_BOUNCE_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_BLUE,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_BLUE).setId(key(ModBlocks.BASIC_BOUNCE_BLUE))));
    public static final Block BASIC_BOUNCE_STAIR_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_BLUE,
            new BreezeBounceStairBlock(BASIC_BOUNCE_BLUE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BLUE).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_BLUE))));
    public static final Block BASIC_BOUNCE_SLAB_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_BLUE,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BLUE).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_BLUE))));
    public static final Block BASIC_BOUNCE_WALL_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_BLUE,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BLUE).setId(key(ModBlocks.BASIC_BOUNCE_WALL_BLUE))));

    public static final Block BASIC_BOUNCE_PURPLE = registerBlock(ModBlocks.BASIC_BOUNCE_PURPLE,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_PURPLE).setId(key(ModBlocks.BASIC_BOUNCE_PURPLE))));
    public static final Block BASIC_BOUNCE_STAIR_PURPLE = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_PURPLE,
            new BreezeBounceStairBlock(BASIC_BOUNCE_PURPLE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_PURPLE).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_PURPLE))));
    public static final Block BASIC_BOUNCE_SLAB_PURPLE = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_PURPLE,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_PURPLE).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_PURPLE))));
    public static final Block BASIC_BOUNCE_WALL_PURPLE = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_PURPLE,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_PURPLE).setId(key(ModBlocks.BASIC_BOUNCE_WALL_PURPLE))));

    public static final Block BASIC_BOUNCE_MAGENTA = registerBlock(ModBlocks.BASIC_BOUNCE_MAGENTA,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_MAGENTA).setId(key(ModBlocks.BASIC_BOUNCE_MAGENTA))));
    public static final Block BASIC_BOUNCE_STAIR_MAGENTA = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_MAGENTA,
            new BreezeBounceStairBlock(BASIC_BOUNCE_MAGENTA.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_MAGENTA).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_MAGENTA))));
    public static final Block BASIC_BOUNCE_SLAB_MAGENTA = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_MAGENTA,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_MAGENTA).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_MAGENTA))));
    public static final Block BASIC_BOUNCE_WALL_MAGENTA = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_MAGENTA,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_MAGENTA).setId(key(ModBlocks.BASIC_BOUNCE_WALL_MAGENTA))));

    public static final Block BASIC_BOUNCE_PINK = registerBlock(ModBlocks.BASIC_BOUNCE_PINK,
            new BreezeBounceBlock(basicBounce().mapColor(MapColor.COLOR_PINK).setId(key(ModBlocks.BASIC_BOUNCE_PINK))));
    public static final Block BASIC_BOUNCE_STAIR_PINK = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_PINK,
            new BreezeBounceStairBlock(BASIC_BOUNCE_PINK.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_PINK).setId(key(ModBlocks.BASIC_BOUNCE_STAIR_PINK))));
    public static final Block BASIC_BOUNCE_SLAB_PINK = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_PINK,
            new BreezeBounceSlabBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_PINK).setId(key(ModBlocks.BASIC_BOUNCE_SLAB_PINK))));
    public static final Block BASIC_BOUNCE_WALL_PINK = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_PINK,
            new BreezeBounceWallBlock(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_PINK).setId(key(ModBlocks.BASIC_BOUNCE_WALL_PINK))));

    private static Block registerBlock(ResourceLocation location, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, location, block);
    }

    private static ResourceKey<Block> key(ResourceLocation resourceLocation) {
        return ResourceKey.create(Registries.BLOCK, resourceLocation);
    }

    public static void register() {

    }
}
