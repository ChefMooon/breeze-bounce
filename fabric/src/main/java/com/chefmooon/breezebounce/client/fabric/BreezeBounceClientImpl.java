package com.chefmooon.breezebounce.client.fabric;

import com.chefmooon.breezebounce.client.gui.InflationMachineScreen;
import com.chefmooon.breezebounce.client.particle.BounceParticle;
import com.chefmooon.breezebounce.common.registry.ModParticleTypes;
import com.chefmooon.breezebounce.common.registry.fabric.ModItemsImpl;
import com.chefmooon.breezebounce.common.registry.fabric.ModMenuTypesImpl;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.component.DyedItemColor;

public class BreezeBounceClientImpl implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.BOUNCE_WHITE.get(), BounceParticle.Provider::new);

        MenuScreens.register(ModMenuTypesImpl.INFLATION_MACHINE, InflationMachineScreen::new);

        ColorProviderRegistry.ITEM.register((itemStack, i) -> i > 0 ? -1 : DyedItemColor.getOrDefault(itemStack, -6265536),
                ModItemsImpl.VELCRO_HELMET,
                ModItemsImpl.VELCRO_CHESTPLATE,
                ModItemsImpl.VELCRO_LEGGINGS,
                ModItemsImpl.VELCRO_BOOTS
        );
    }
}
