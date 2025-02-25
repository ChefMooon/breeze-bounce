package com.chefmooon.breezebounce.common.registry.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.common.block.entity.neoforge.InflationMachineBlockEntityImpl;
import com.chefmooon.breezebounce.common.registry.ModBlockEntityTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntityTypesImpl {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, BreezeBounce.MOD_ID);

    public static final Supplier<BlockEntityType<InflationMachineBlockEntityImpl>> INFLATION_MACHINE = BLOCK_ENTITIES.register(ModBlockEntityTypes.INFLATION_MACHINE.getPath(),
            () -> BlockEntityType.Builder.of(InflationMachineBlockEntityImpl::new, ModBlocksImpl.INFLATION_MACHINE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
