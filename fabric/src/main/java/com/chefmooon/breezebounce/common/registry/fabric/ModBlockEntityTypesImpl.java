package com.chefmooon.breezebounce.common.registry.fabric;

import com.chefmooon.breezebounce.common.block.entity.InflationMachineBlockEntity;
import com.chefmooon.breezebounce.common.block.entity.fabric.InflationMachineBlockEntityImpl;
import com.chefmooon.breezebounce.common.registry.ModBlockEntityTypes;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityTypesImpl {

    public static final BlockEntityType<InflationMachineBlockEntity> INFLATION_MACHINE = registerBlockEntity(ModBlockEntityTypes.INFLATION_MACHINE,
            InflationMachineBlockEntityImpl::new, ModBlocksImpl.INFLATION_MACHINE);

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(ResourceLocation location, FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, location, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

//    public static final BlockEntityType<InflationMachineBlockEntity> INFLATION_MACHINE = registerBlockEntity(ModBlockEntityTypes.INFLATION_MACHINE,
//            BlockEntityType.Builder.of(InflationMachineBlockEntityImpl::new, ModBlocksImpl.INFLATION_MACHINE));
//
//    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(ResourceLocation location, BlockEntityType.Builder<T> builder) {
//        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, location, builder.build(null));
//    }

    public static void register() {
    }
}
