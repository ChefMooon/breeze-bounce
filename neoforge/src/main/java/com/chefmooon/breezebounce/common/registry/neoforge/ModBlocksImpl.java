package com.chefmooon.breezebounce.common.registry.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.common.block.neoforge.*;
import com.chefmooon.breezebounce.common.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.chefmooon.breezebounce.common.registry.ModBlocks.basicBounce;

public class ModBlocksImpl {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, BreezeBounce.MOD_ID);

    public static final Supplier<Block> INFLATION_MACHINE = registerBlock(ModBlocks.INFLATION_MACHINE,
            () -> new InflationMachineBlockImpl(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));

    public static final Supplier<Block> BASIC_BOUNCE_WHITE = registerBlock(ModBlocks.BASIC_BOUNCE_WHITE,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.SNOW)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_WHITE = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_WHITE,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_WHITE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_WHITE.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_WHITE = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_WHITE,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_WHITE.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_WHITE = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_WHITE,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_WHITE.get())));

    public static final Supplier<Block> BASIC_BOUNCE_LIGHT_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_LIGHT_GRAY,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_LIGHT_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_LIGHT_GRAY,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_LIGHT_GRAY.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIGHT_GRAY.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_LIGHT_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_LIGHT_GRAY,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIGHT_GRAY.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_LIGHT_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_LIGHT_GRAY,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIGHT_GRAY.get())));

    public static final Supplier<Block> BASIC_BOUNCE_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_GRAY,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_GRAY)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_GRAY,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_GRAY.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_GRAY.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_GRAY,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_GRAY.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_GRAY = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_GRAY,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_GRAY.get())));

    public static final Supplier<Block> BASIC_BOUNCE_BLACK = registerBlock(ModBlocks.BASIC_BOUNCE_BLACK,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_BLACK)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_BLACK = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_BLACK,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_BLACK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BLACK.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_BLACK = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_BLACK,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BLACK.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_BLACK = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_BLACK,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BLACK.get())));

    public static final Supplier<Block> BASIC_BOUNCE_BROWN = registerBlock(ModBlocks.BASIC_BOUNCE_BROWN,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_BROWN)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_BROWN = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_BROWN,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_BROWN.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BROWN.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_BROWN = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_BROWN,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BROWN.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_BROWN = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_BROWN,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BROWN.get())));

    public static final Supplier<Block> BASIC_BOUNCE_RED = registerBlock(ModBlocks.BASIC_BOUNCE_RED,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_RED)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_RED = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_RED,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_RED.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_RED.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_RED = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_RED,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_RED.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_RED = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_RED,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_RED.get())));

    public static final Supplier<Block> BASIC_BOUNCE_ORANGE = registerBlock(ModBlocks.BASIC_BOUNCE_ORANGE,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_ORANGE)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_ORANGE = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_ORANGE,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_ORANGE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_ORANGE.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_ORANGE = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_ORANGE,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_ORANGE.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_ORANGE = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_ORANGE,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_ORANGE.get())));

    public static final Supplier<Block> BASIC_BOUNCE_YELLOW = registerBlock(ModBlocks.BASIC_BOUNCE_YELLOW,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_YELLOW)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_YELLOW = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_YELLOW,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_YELLOW.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_YELLOW.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_YELLOW = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_YELLOW,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_YELLOW.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_YELLOW = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_YELLOW,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_YELLOW.get())));

    public static final Supplier<Block> BASIC_BOUNCE_LIME = registerBlock(ModBlocks.BASIC_BOUNCE_LIME,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_LIME = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_LIME,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_LIME.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIME.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_LIME = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_LIME,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIME.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_LIME = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_LIME,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIME.get())));

    public static final Supplier<Block> BASIC_BOUNCE_GREEN = registerBlock(ModBlocks.BASIC_BOUNCE_GREEN,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_GREEN)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_GREEN = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_GREEN,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_GREEN.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_GREEN.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_GREEN = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_GREEN,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_GREEN.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_GREEN = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_GREEN,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_GREEN.get())));

    public static final Supplier<Block> BASIC_BOUNCE_CYAN = registerBlock(ModBlocks.BASIC_BOUNCE_CYAN,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_CYAN)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_CYAN = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_CYAN,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_CYAN.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_CYAN.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_CYAN = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_CYAN,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_CYAN.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_CYAN = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_CYAN,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_CYAN.get())));

    public static final Supplier<Block> BASIC_BOUNCE_LIGHT_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_LIGHT_BLUE,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_LIGHT_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_LIGHT_BLUE,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_LIGHT_BLUE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIGHT_BLUE.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_LIGHT_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_LIGHT_BLUE,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIGHT_BLUE.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_LIGHT_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_LIGHT_BLUE,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_LIGHT_BLUE.get())));

    public static final Supplier<Block> BASIC_BOUNCE_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_BLUE,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_BLUE)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_BLUE,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_BLUE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BLUE.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_BLUE,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BLUE.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_BLUE = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_BLUE,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_BLUE.get())));

    public static final Supplier<Block> BASIC_BOUNCE_PURPLE = registerBlock(ModBlocks.BASIC_BOUNCE_PURPLE,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_PURPLE)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_PURPLE = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_PURPLE,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_PURPLE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_PURPLE.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_PURPLE = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_PURPLE,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_PURPLE.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_PURPLE = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_PURPLE,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_PURPLE.get())));

    public static final Supplier<Block> BASIC_BOUNCE_MAGENTA = registerBlock(ModBlocks.BASIC_BOUNCE_MAGENTA,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_MAGENTA)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_MAGENTA = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_MAGENTA,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_MAGENTA.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_MAGENTA.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_MAGENTA = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_MAGENTA,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_MAGENTA.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_MAGENTA = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_MAGENTA,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_MAGENTA.get())));

    public static final Supplier<Block> BASIC_BOUNCE_PINK = registerBlock(ModBlocks.BASIC_BOUNCE_PINK,
            () -> new BreezeBounceBlockImpl(basicBounce().mapColor(MapColor.COLOR_PINK)));
    public static final Supplier<Block> BASIC_BOUNCE_STAIR_PINK = registerBlock(ModBlocks.BASIC_BOUNCE_STAIR_PINK,
            () -> new BreezeBounceStairBlockImpl(BASIC_BOUNCE_PINK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_PINK.get())));
    public static final Supplier<Block> BASIC_BOUNCE_SLAB_PINK = registerBlock(ModBlocks.BASIC_BOUNCE_SLAB_PINK,
            () -> new BreezeBounceSlabBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_PINK.get())));
    public static final Supplier<Block> BASIC_BOUNCE_WALL_PINK = registerBlock(ModBlocks.BASIC_BOUNCE_WALL_PINK,
            () -> new BreezeBounceWallBlockImpl(BlockBehaviour.Properties.ofFullCopy(BASIC_BOUNCE_PINK.get())));
    
    public static Supplier<Block> registerBlock(final ResourceLocation location, final Supplier<Block> block) {
        return BLOCKS.register(location.getPath(), block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
