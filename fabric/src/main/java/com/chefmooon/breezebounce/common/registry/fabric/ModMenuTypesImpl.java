package com.chefmooon.breezebounce.common.registry.fabric;

import com.chefmooon.breezebounce.common.block.entity.container.InflationMachineMenu;
import com.chefmooon.breezebounce.common.registry.ModMenuTypes;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class ModMenuTypesImpl {
    public static final MenuType<InflationMachineMenu> INFLATION_MACHINE = register(ModMenuTypes.INFLATION_MACHINE,
            new ExtendedScreenHandlerType<>(InflationMachineMenu::new, BlockPos.STREAM_CODEC));
    private static <T extends AbstractContainerMenu> MenuType<T> register(Identifier location, MenuType<T> menuType) {
        return Registry.register(BuiltInRegistries.MENU, location, menuType);
    }

    public static void register() {
    }
}
