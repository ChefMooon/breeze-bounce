package com.chefmooon.breezebounce.common.registry.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.common.block.neoforge.BreezeBounceBlockImpl;
import com.chefmooon.breezebounce.common.block.neoforge.BreezeBounceSlabBlockImpl;
import com.chefmooon.breezebounce.common.block.neoforge.BreezeBounceStairBlockImpl;
import com.chefmooon.breezebounce.common.block.neoforge.BreezeBounceWallBlockImpl;
import com.chefmooon.breezebounce.common.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

import static com.chefmooon.breezebounce.common.registry.ModBlocks.*;

public class ModBlocksImpl {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BreezeBounce.MOD_ID);

    public static final DeferredBlock<Block> BASIC_BOUNCE_WHITE = registerBaseBlock(ModBlocks.BASIC_BOUNCE_WHITE,
            basicBounceWhite());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_WHITE = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_WHITE,
            Blocks.WHITE_WOOL.defaultBlockState(), basicBounceWhite());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_WHITE = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_WHITE,
            basicBounceWhite());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_WHITE = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_WHITE,
            basicBounceWhite());

    public static final DeferredBlock<Block> BASIC_BOUNCE_LIGHT_GRAY = registerBaseBlock(ModBlocks.BASIC_BOUNCE_LIGHT_GRAY,
            basicBounceLightGray());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_LIGHT_GRAY = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_LIGHT_GRAY,
            Blocks.WHITE_WOOL.defaultBlockState(), basicBounceLightGray());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_LIGHT_GRAY = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_LIGHT_GRAY,
            basicBounceLightGray());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_LIGHT_GRAY = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_LIGHT_GRAY,
            basicBounceLightGray());

    public static final DeferredBlock<Block> BASIC_BOUNCE_GRAY = registerBaseBlock(ModBlocks.BASIC_BOUNCE_GRAY,
            basicBounceGray());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_GRAY = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_GRAY,
            Blocks.WHITE_WOOL.defaultBlockState(), basicBounceGray());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_GRAY = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_GRAY,
            basicBounceGray());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_GRAY = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_GRAY,
            basicBounceGray());

    public static final DeferredBlock<Block> BASIC_BOUNCE_BLACK = registerBaseBlock(ModBlocks.BASIC_BOUNCE_BLACK,
            basicBounceBlack());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_BLACK = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_BLACK,
            Blocks.WHITE_WOOL.defaultBlockState(), basicBounceBlack());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_BLACK = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_BLACK,
            basicBounceBlack());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_BLACK = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_BLACK,
            basicBounceBlack());

    public static final DeferredBlock<Block> BASIC_BOUNCE_BROWN = registerBaseBlock(ModBlocks.BASIC_BOUNCE_BROWN,
            basicBounceBrown());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_BROWN = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_BROWN,
            Blocks.WHITE_WOOL.defaultBlockState(), basicBounceBrown());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_BROWN = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_BROWN,
            basicBounceBrown());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_BROWN = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_BROWN,
            basicBounceBrown());

    public static final DeferredBlock<Block> BASIC_BOUNCE_RED = registerBaseBlock(ModBlocks.BASIC_BOUNCE_RED,
            basicBounceRed());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_RED = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_RED,
             Blocks.WHITE_WOOL.defaultBlockState(), basicBounceRed());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_RED = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_RED,
            basicBounceRed());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_RED = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_RED,
            basicBounceRed());

    public static final DeferredBlock<Block> BASIC_BOUNCE_ORANGE = registerBaseBlock(ModBlocks.BASIC_BOUNCE_ORANGE,
            basicBounceOrange());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_ORANGE = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_ORANGE,
            Blocks.WHITE_WOOL.defaultBlockState(), basicBounceOrange());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_ORANGE = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_ORANGE,
            basicBounceOrange());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_ORANGE = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_ORANGE,
            basicBounceOrange());

    public static final DeferredBlock<Block> BASIC_BOUNCE_YELLOW = registerBaseBlock(ModBlocks.BASIC_BOUNCE_YELLOW,
            basicBounceYellow());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_YELLOW = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_YELLOW,
             Blocks.WHITE_WOOL.defaultBlockState(), basicBounceYellow());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_YELLOW = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_YELLOW,
            basicBounceYellow());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_YELLOW = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_YELLOW,
            basicBounceYellow());

    public static final DeferredBlock<Block> BASIC_BOUNCE_LIME = registerBaseBlock(ModBlocks.BASIC_BOUNCE_LIME,
            basicBounceLime());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_LIME = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_LIME,
            Blocks.WHITE_WOOL.defaultBlockState(), basicBounceLime());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_LIME = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_LIME,
            basicBounceLime());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_LIME = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_LIME,
            basicBounceLime());

    public static final DeferredBlock<Block> BASIC_BOUNCE_GREEN = registerBaseBlock(ModBlocks.BASIC_BOUNCE_GREEN,
            basicBounceGreen());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_GREEN = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_GREEN,
            Blocks.WHITE_WOOL.defaultBlockState(), basicBounceGreen());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_GREEN = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_GREEN,
            basicBounceGreen());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_GREEN = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_GREEN,
            basicBounceGreen());

    public static final DeferredBlock<Block> BASIC_BOUNCE_CYAN = registerBaseBlock(ModBlocks.BASIC_BOUNCE_CYAN,
            basicBounceCyan());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_CYAN = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_CYAN,
             Blocks.WHITE_WOOL.defaultBlockState(), basicBounceCyan());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_CYAN = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_CYAN,
            basicBounceCyan());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_CYAN = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_CYAN,
            basicBounceCyan());

    public static final DeferredBlock<Block> BASIC_BOUNCE_LIGHT_BLUE = registerBaseBlock(ModBlocks.BASIC_BOUNCE_LIGHT_BLUE,
            basicBounceLightBlue());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_LIGHT_BLUE = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_LIGHT_BLUE,
            Blocks.WHITE_WOOL.defaultBlockState(), basicBounceLightBlue());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_LIGHT_BLUE = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_LIGHT_BLUE,
            basicBounceLightBlue());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_LIGHT_BLUE = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_LIGHT_BLUE,
            basicBounceLightBlue());

    public static final DeferredBlock<Block> BASIC_BOUNCE_BLUE = registerBaseBlock(ModBlocks.BASIC_BOUNCE_BLUE,
            basicBounceBlue());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_BLUE = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_BLUE,
             Blocks.WHITE_WOOL.defaultBlockState(), basicBounceBlue());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_BLUE = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_BLUE,
            basicBounceBlue());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_BLUE = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_BLUE,
            basicBounceBlue());

    public static final DeferredBlock<Block> BASIC_BOUNCE_PURPLE = registerBaseBlock(ModBlocks.BASIC_BOUNCE_PURPLE,
            basicBouncePurple());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_PURPLE = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_PURPLE,
             Blocks.WHITE_WOOL.defaultBlockState(), basicBouncePurple());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_PURPLE = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_PURPLE,
            basicBouncePurple());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_PURPLE = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_PURPLE,
            basicBouncePurple());

    public static final DeferredBlock<Block> BASIC_BOUNCE_MAGENTA = registerBaseBlock(ModBlocks.BASIC_BOUNCE_MAGENTA,
            basicBounceMagenta());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_MAGENTA = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_MAGENTA,
             Blocks.WHITE_WOOL.defaultBlockState(), basicBounceMagenta());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_MAGENTA = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_MAGENTA,
            basicBounceMagenta());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_MAGENTA = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_MAGENTA,
            basicBounceMagenta());

    public static final DeferredBlock<Block> BASIC_BOUNCE_PINK = registerBaseBlock(ModBlocks.BASIC_BOUNCE_PINK,
            basicBouncePink());
    public static final DeferredBlock<BreezeBounceStairBlockImpl> BASIC_BOUNCE_STAIR_PINK = registerStairBlock(ModBlocks.BASIC_BOUNCE_STAIR_PINK,
             Blocks.WHITE_WOOL.defaultBlockState(), basicBouncePink());
    public static final DeferredBlock<Block> BASIC_BOUNCE_SLAB_PINK = registerSlabBlock(ModBlocks.BASIC_BOUNCE_SLAB_PINK,
            basicBouncePink());
    public static final DeferredBlock<Block> BASIC_BOUNCE_WALL_PINK = registerWallBlock(ModBlocks.BASIC_BOUNCE_WALL_PINK,
            basicBouncePink());

    public static DeferredBlock<BreezeBounceStairBlockImpl> registerStairBlock(ResourceLocation location, BlockState blockState, BlockBehaviour.Properties properties) {
        return BLOCKS.register(location.getPath(), key -> new BreezeBounceStairBlockImpl(blockState, properties.setId(ResourceKey.create(Registries.BLOCK, key))));
    }

    public static DeferredBlock<Block> registerBaseBlock(ResourceLocation location, BlockBehaviour.Properties properties) {
        return registerBlock(location, BreezeBounceBlockImpl::new, properties);
    }

    public static DeferredBlock<Block> registerSlabBlock(ResourceLocation location, BlockBehaviour.Properties properties) {
        return registerBlock(location, BreezeBounceSlabBlockImpl::new, properties);
    }

    public static DeferredBlock<Block> registerWallBlock(ResourceLocation location, BlockBehaviour.Properties properties) {
        return registerBlock(location, BreezeBounceWallBlockImpl::new, properties);
    }

    public static <B extends Block> DeferredBlock<B> registerBlock(ResourceLocation location, Function<BlockBehaviour.Properties, ? extends B> function, BlockBehaviour.Properties properties) {
        return BLOCKS.registerBlock(location.getPath(), function, properties);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
