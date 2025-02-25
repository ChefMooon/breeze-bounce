package com.chefmooon.breezebounce.data;

import com.chefmooon.breezebounce.common.block.BreezeBounceBlock;
import com.chefmooon.breezebounce.data.model.ModModelTemplates;
import com.chefmooon.breezebounce.common.registry.fabric.ModBlocksImpl;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Direction;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.properties.StairsShape;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_WHITE, ModBlocksImpl.BASIC_BOUNCE_SLAB_WHITE, ModBlocksImpl.BASIC_BOUNCE_STAIR_WHITE, ModBlocksImpl.BASIC_BOUNCE_WALL_WHITE, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_LIGHT_GRAY, ModBlocksImpl.BASIC_BOUNCE_SLAB_LIGHT_GRAY, ModBlocksImpl.BASIC_BOUNCE_STAIR_LIGHT_GRAY, ModBlocksImpl.BASIC_BOUNCE_WALL_LIGHT_GRAY, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_GRAY, ModBlocksImpl.BASIC_BOUNCE_SLAB_GRAY, ModBlocksImpl.BASIC_BOUNCE_STAIR_GRAY, ModBlocksImpl.BASIC_BOUNCE_WALL_GRAY, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_BLACK, ModBlocksImpl.BASIC_BOUNCE_SLAB_BLACK, ModBlocksImpl.BASIC_BOUNCE_STAIR_BLACK, ModBlocksImpl.BASIC_BOUNCE_WALL_BLACK, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_BROWN, ModBlocksImpl.BASIC_BOUNCE_SLAB_BROWN, ModBlocksImpl.BASIC_BOUNCE_STAIR_BROWN, ModBlocksImpl.BASIC_BOUNCE_WALL_BROWN, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_RED, ModBlocksImpl.BASIC_BOUNCE_SLAB_RED, ModBlocksImpl.BASIC_BOUNCE_STAIR_RED, ModBlocksImpl.BASIC_BOUNCE_WALL_RED, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_ORANGE, ModBlocksImpl.BASIC_BOUNCE_SLAB_ORANGE, ModBlocksImpl.BASIC_BOUNCE_STAIR_ORANGE, ModBlocksImpl.BASIC_BOUNCE_WALL_ORANGE, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_YELLOW, ModBlocksImpl.BASIC_BOUNCE_SLAB_YELLOW, ModBlocksImpl.BASIC_BOUNCE_STAIR_YELLOW, ModBlocksImpl.BASIC_BOUNCE_WALL_YELLOW, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_LIME, ModBlocksImpl.BASIC_BOUNCE_SLAB_LIME, ModBlocksImpl.BASIC_BOUNCE_STAIR_LIME, ModBlocksImpl.BASIC_BOUNCE_WALL_LIME, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_GREEN, ModBlocksImpl.BASIC_BOUNCE_SLAB_GREEN, ModBlocksImpl.BASIC_BOUNCE_STAIR_GREEN, ModBlocksImpl.BASIC_BOUNCE_WALL_GREEN, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_CYAN, ModBlocksImpl.BASIC_BOUNCE_SLAB_CYAN, ModBlocksImpl.BASIC_BOUNCE_STAIR_CYAN, ModBlocksImpl.BASIC_BOUNCE_WALL_CYAN, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_LIGHT_BLUE, ModBlocksImpl.BASIC_BOUNCE_SLAB_LIGHT_BLUE, ModBlocksImpl.BASIC_BOUNCE_STAIR_LIGHT_BLUE, ModBlocksImpl.BASIC_BOUNCE_WALL_LIGHT_BLUE, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_BLUE, ModBlocksImpl.BASIC_BOUNCE_SLAB_BLUE, ModBlocksImpl.BASIC_BOUNCE_STAIR_BLUE, ModBlocksImpl.BASIC_BOUNCE_WALL_BLUE, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_PURPLE, ModBlocksImpl.BASIC_BOUNCE_SLAB_PURPLE, ModBlocksImpl.BASIC_BOUNCE_STAIR_PURPLE, ModBlocksImpl.BASIC_BOUNCE_WALL_PURPLE, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_MAGENTA, ModBlocksImpl.BASIC_BOUNCE_SLAB_MAGENTA, ModBlocksImpl.BASIC_BOUNCE_STAIR_MAGENTA, ModBlocksImpl.BASIC_BOUNCE_WALL_MAGENTA, blockStateModelGenerator);
        createBasicBounce(ModBlocksImpl.BASIC_BOUNCE_PINK, ModBlocksImpl.BASIC_BOUNCE_SLAB_PINK, ModBlocksImpl.BASIC_BOUNCE_STAIR_PINK, ModBlocksImpl.BASIC_BOUNCE_WALL_PINK, blockStateModelGenerator);

        blockStateModelGenerator.createRotatedPillarWithHorizontalVariant(ModBlocksImpl.INFLATION_MACHINE, TexturedModel.COLUMN, TexturedModel.COLUMN_HORIZONTAL);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }

    private void createBasicBounce(Block block, Block slabBlock, Block stairBlock, Block wallBlock, BlockModelGenerators blockStateModelGenerator) {
        createBasicBounceBlock(block, blockStateModelGenerator);
        createBasicBounceStair(block, stairBlock, blockStateModelGenerator);
        createBasicBounceSlab(block, slabBlock, blockStateModelGenerator);
        createBasicBounceWall(wallBlock, blockStateModelGenerator);
    }

    private void createBasicBounceBlock(Block block, BlockModelGenerators blockStateModelGenerator) {
        ResourceLocation BASIC_BOUNCE = ModelTemplates.CUBE_ALL.create(ModelLocationUtils.getModelLocation(block),
                TextureMapping.singleSlot(TextureSlot.ALL, ModelLocationUtils.getModelLocation(block)), blockStateModelGenerator.modelOutput);
        ResourceLocation BASIC_BOUNCE_POWERED = ModelTemplates.CUBE_ALL.create(ModelLocationUtils.getModelLocation(block, "_powered"),
                TextureMapping.singleSlot(TextureSlot.ALL, ModelLocationUtils.getModelLocation(block, "_powered")), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(BlockModelGenerators.createBooleanModelDispatch(BreezeBounceBlock.POWERED, BASIC_BOUNCE_POWERED, BASIC_BOUNCE)));
        blockStateModelGenerator.delegateItemModel(block, ModelLocationUtils.getModelLocation(block));
    }

    private void createBasicBounceStair(Block fullBlock, Block stairBlock, BlockModelGenerators blockStateModelGenerator) {
        TextureMapping mapping = TextureMapping.singleSlot(TextureSlot.BOTTOM, ModelLocationUtils.getModelLocation(fullBlock))
                .put(TextureSlot.TOP, ModelLocationUtils.getModelLocation(fullBlock))
                .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(fullBlock));
        TextureMapping mappingPowered = TextureMapping.singleSlot(TextureSlot.BOTTOM, ModelLocationUtils.getModelLocation(fullBlock).withSuffix("_powered"))
                .put(TextureSlot.TOP, ModelLocationUtils.getModelLocation(fullBlock).withSuffix("_powered"))
                .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(fullBlock).withSuffix("_powered"));

        ResourceLocation BASIC_BOUNCE_STAIRS_INNER = ModelTemplates.STAIRS_INNER.create(ModelLocationUtils.getModelLocation(stairBlock, "_inner"),
                mapping, blockStateModelGenerator.modelOutput);
        ResourceLocation BASIC_BOUNCE_STAIRS_STRAIGHT = ModelTemplates.STAIRS_STRAIGHT.create(ModelLocationUtils.getModelLocation(stairBlock, "_straight"),
                mapping, blockStateModelGenerator.modelOutput);
        ResourceLocation BASIC_BOUNCE_STAIRS_OUTER = ModelTemplates.STAIRS_OUTER.create(ModelLocationUtils.getModelLocation(stairBlock, "_outer"),
                mapping, blockStateModelGenerator.modelOutput);

        ResourceLocation BASIC_BOUNCE_STAIRS_INNER_POWERED = ModelTemplates.STAIRS_INNER.create(ModelLocationUtils.getModelLocation(stairBlock, "_inner_powered"),
                mappingPowered, blockStateModelGenerator.modelOutput);
        ResourceLocation BASIC_BOUNCE_STAIRS_STRAIGHT_POWERED = ModelTemplates.STAIRS_STRAIGHT.create(ModelLocationUtils.getModelLocation(stairBlock, "_straight_powered"),
                mappingPowered, blockStateModelGenerator.modelOutput);
        ResourceLocation BASIC_BOUNCE_STAIRS_OUTER_POWERED = ModelTemplates.STAIRS_OUTER.create(ModelLocationUtils.getModelLocation(stairBlock, "_outer_powered"),
                mappingPowered, blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(stairBlock).with(
                PropertyDispatch.properties(BreezeBounceBlock.POWERED, BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.STAIRS_SHAPE)
                        .select(Boolean.FALSE, Direction.EAST, Half.BOTTOM, StairsShape.STRAIGHT,
                                Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT))
                        .select(Boolean.FALSE, Direction.WEST, Half.BOTTOM, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.SOUTH, Half.BOTTOM, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.NORTH, Half.BOTTOM, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.EAST, Half.BOTTOM, StairsShape.OUTER_RIGHT,
                                Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER))
                        .select(Boolean.FALSE, Direction.WEST, Half.BOTTOM, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.EAST, Half.BOTTOM, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.WEST, Half.BOTTOM, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_LEFT,
                                Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER))
                        .select(Boolean.FALSE, Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.EAST, Half.BOTTOM, StairsShape.INNER_RIGHT,
                                Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER))
                        .select(Boolean.FALSE, Direction.WEST, Half.BOTTOM, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.NORTH, Half.BOTTOM, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.EAST, Half.BOTTOM, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.WEST, Half.BOTTOM, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_LEFT,
                                Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER))
                        .select(Boolean.FALSE, Direction.NORTH, Half.BOTTOM, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.EAST, Half.TOP, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.WEST, Half.TOP, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.SOUTH, Half.TOP, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.NORTH, Half.TOP, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.EAST, Half.TOP, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.WEST, Half.TOP, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.SOUTH, Half.TOP, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.NORTH, Half.TOP, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.EAST, Half.TOP, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.WEST, Half.TOP, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.SOUTH, Half.TOP, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.NORTH, Half.TOP, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.EAST, Half.TOP, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.WEST, Half.TOP, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.SOUTH, Half.TOP, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.NORTH, Half.TOP, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.EAST, Half.TOP, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.WEST, Half.TOP, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.SOUTH, Half.TOP, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.FALSE, Direction.NORTH, Half.TOP, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )

                        // ***** THE DIVIDE ***** //

                        .select(Boolean.TRUE, Direction.EAST, Half.BOTTOM, StairsShape.STRAIGHT,
                                Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT_POWERED))
                        .select(Boolean.TRUE, Direction.WEST, Half.BOTTOM, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.SOUTH, Half.BOTTOM, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.NORTH, Half.BOTTOM, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.EAST, Half.BOTTOM, StairsShape.OUTER_RIGHT,
                                Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED))
                        .select(Boolean.TRUE, Direction.WEST, Half.BOTTOM, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.EAST, Half.BOTTOM, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.WEST, Half.BOTTOM, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_LEFT,
                                Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED))
                        .select(Boolean.TRUE, Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.EAST, Half.BOTTOM, StairsShape.INNER_RIGHT,
                                Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED))
                        .select(Boolean.TRUE, Direction.WEST, Half.BOTTOM, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.NORTH, Half.BOTTOM, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.EAST, Half.BOTTOM, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.WEST, Half.BOTTOM, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_LEFT,
                                Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED))
                        .select(Boolean.TRUE, Direction.NORTH, Half.BOTTOM, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.EAST, Half.TOP, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.WEST, Half.TOP, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.SOUTH, Half.TOP, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.NORTH, Half.TOP, StairsShape.STRAIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_STRAIGHT_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.EAST, Half.TOP, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.WEST, Half.TOP, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.SOUTH, Half.TOP, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.NORTH, Half.TOP, StairsShape.OUTER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.EAST, Half.TOP, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.WEST, Half.TOP, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.SOUTH, Half.TOP, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.NORTH, Half.TOP, StairsShape.OUTER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_OUTER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.EAST, Half.TOP, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.WEST, Half.TOP, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.SOUTH, Half.TOP, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.NORTH, Half.TOP, StairsShape.INNER_RIGHT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.EAST, Half.TOP, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.WEST, Half.TOP, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.SOUTH, Half.TOP, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
                        .select(Boolean.TRUE, Direction.NORTH, Half.TOP, StairsShape.INNER_LEFT,
                                Variant.variant()
                                        .with(VariantProperties.MODEL, BASIC_BOUNCE_STAIRS_INNER_POWERED)
                                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                        .with(VariantProperties.UV_LOCK, true)
                        )
        ));

        blockStateModelGenerator.delegateItemModel(stairBlock, BASIC_BOUNCE_STAIRS_STRAIGHT);
    }

    private void createBasicBounceSlab(Block fullBlock, Block slabBlock, BlockModelGenerators blockStateModelGenerator){
        ResourceLocation slabModelLocation = ModelLocationUtils.getModelLocation(slabBlock);
        ResourceLocation fullModelLocation = ModelLocationUtils.getModelLocation(fullBlock);

        TextureMapping mapping = TextureMapping.singleSlot(TextureSlot.BOTTOM, fullModelLocation)
                .put(TextureSlot.TOP, fullModelLocation);
        TextureMapping mappingPowered = TextureMapping.singleSlot(TextureSlot.BOTTOM, fullModelLocation.withSuffix("_powered"))
                .put(TextureSlot.TOP, fullModelLocation.withSuffix("_powered"));

        ResourceLocation BASIC_BOUNCE_SLAB_BOTTOM = ModelTemplates.SLAB_BOTTOM.create(slabModelLocation,
                mapping.put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(slabBlock, "_side_bottom")),
                blockStateModelGenerator.modelOutput);
        ResourceLocation BASIC_BOUNCE_SLAB_TOP = ModelTemplates.SLAB_TOP.create(slabModelLocation.withSuffix("_top"),
                mapping.put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(slabBlock, "_side_top")),
                blockStateModelGenerator.modelOutput);

        ResourceLocation BASIC_BOUNCE_SLAB_BOTTOM_POWERED = ModelTemplates.SLAB_BOTTOM.create(slabModelLocation.withSuffix("_powered"),
                mappingPowered.put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(slabBlock, "_side_bottom_powered")),
                blockStateModelGenerator.modelOutput);
        ResourceLocation BASIC_BOUNCE_SLAB_TOP_POWERED = ModelTemplates.SLAB_TOP.create(slabModelLocation.withSuffix("_top_powered"),
                mappingPowered.put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(slabBlock, "_side_top_powered")),
                blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(slabBlock)
                .with(PropertyDispatch.properties(BreezeBounceBlock.POWERED, BlockStateProperties.SLAB_TYPE)
                        .select(Boolean.FALSE, SlabType.BOTTOM, Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_SLAB_BOTTOM))
                        .select(Boolean.FALSE, SlabType.TOP, Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_SLAB_TOP))
                        .select(Boolean.FALSE, SlabType.DOUBLE, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(fullBlock)))
                        .select(Boolean.TRUE, SlabType.BOTTOM, Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_SLAB_BOTTOM_POWERED))
                        .select(Boolean.TRUE, SlabType.TOP, Variant.variant().with(VariantProperties.MODEL, BASIC_BOUNCE_SLAB_TOP_POWERED))
                        .select(Boolean.TRUE, SlabType.DOUBLE, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(fullBlock, "_powered"))))
        );
    }

    private void createBasicBounceWall(Block block, BlockModelGenerators blockStateModelGenerator) {
        ResourceLocation BASIC_BOUNCE_WALL = ModModelTemplates.TEMPLATE_BOUNCE_WALL.create(ModelLocationUtils.getModelLocation(block),
                TextureMapping.singleSlot(TextureSlot.ALL, ModelLocationUtils.getModelLocation(block)), blockStateModelGenerator.modelOutput);
        ResourceLocation BASIC_BOUNCE_POWERED_WALL = ModModelTemplates.TEMPLATE_BOUNCE_WALL.create(ModelLocationUtils.getModelLocation(block, "_powered"),
                TextureMapping.singleSlot(TextureSlot.ALL, ModelLocationUtils.getModelLocation(block, "_powered")), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(BlockModelGenerators.createBooleanModelDispatch(BreezeBounceBlock.POWERED, BASIC_BOUNCE_POWERED_WALL, BASIC_BOUNCE_WALL))
                .with(BlockModelGenerators.createRotatedPillar()));
        blockStateModelGenerator.delegateItemModel(block, BASIC_BOUNCE_WALL);
    }
}
