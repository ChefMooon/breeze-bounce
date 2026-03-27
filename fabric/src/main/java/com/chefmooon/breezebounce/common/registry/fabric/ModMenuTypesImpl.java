package com.chefmooon.breezebounce.common.registry.fabric;

import com.chefmooon.breezebounce.common.block.entity.container.InflationMachineMenu;
import com.chefmooon.breezebounce.common.registry.ModMenuTypes;
import com.chefmooon.breezebounce.common.util.TextUtil;
import net.fabricmc.fabric.api.menu.v1.ExtendedMenuType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class ModMenuTypesImpl {
    public static final Supplier<MenuType<InflationMachineMenu>> INFLATION_MACHINE = register(ModMenuTypes.INFLATION_MACHINE.getPath(),
            () -> new ExtendedMenuType<>(InflationMachineMenu::new, BlockPos.STREAM_CODEC));

    public static <B extends MenuType<?>> Supplier<B> register(String name, Supplier<B> supplier) {
        return () -> Registry.register(BuiltInRegistries.MENU, TextUtil.res(name), supplier.get());
    }

    public static void register() {
    }
}
