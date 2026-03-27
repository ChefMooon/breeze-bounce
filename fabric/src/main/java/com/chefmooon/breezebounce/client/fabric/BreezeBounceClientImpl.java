package com.chefmooon.breezebounce.client.fabric;

import com.chefmooon.breezebounce.client.gui.InflationMachineScreen;
import com.chefmooon.breezebounce.client.particle.BounceParticle;
import com.chefmooon.breezebounce.common.network.VelcroS2CPayload;
import com.chefmooon.breezebounce.common.registry.ModParticleTypes;
import com.chefmooon.breezebounce.common.registry.fabric.ModMenuTypesImpl;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;

public class BreezeBounceClientImpl implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleProviderRegistry.getInstance().register(ModParticleTypes.BOUNCE_WHITE.get(), BounceParticle.Provider::new);

        // TODO: fix register menu
        MenuScreens.register(ModMenuTypesImpl.INFLATION_MACHINE.get(), InflationMachineScreen::new);

        registerNetworking();
    }

    private static void registerNetworking() {
        ClientPlayNetworking.registerGlobalReceiver(VelcroS2CPayload.ID, (payload, context) -> {
            ClientLevel clientLevel = Minecraft.getInstance().level;

            if (clientLevel == null) return;

            Entity entity = clientLevel.getEntity(payload.entityId());
            if (entity != null) {
                entity.setDeltaMovement(payload.vec());
                entity.resetFallDistance();
            }
        });
    }
}
