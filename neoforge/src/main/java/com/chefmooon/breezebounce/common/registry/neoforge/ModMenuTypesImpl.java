package com.chefmooon.breezebounce.common.registry.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.common.block.entity.container.InflationMachineMenu;
import com.chefmooon.breezebounce.common.registry.ModMenuTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModMenuTypesImpl {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, BreezeBounce.MOD_ID);
    public static final Supplier<MenuType<InflationMachineMenu>> INFLATION_MACHINE = MENU_TYPES.register(ModMenuTypes.INFLATION_MACHINE.getPath(),
            () -> new MenuType<>(InflationMachineMenu::new, FeatureFlags.DEFAULT_FLAGS));

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }
}
