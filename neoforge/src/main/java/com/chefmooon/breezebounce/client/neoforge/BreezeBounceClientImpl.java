package com.chefmooon.breezebounce.client.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.client.gui.InflationMachineScreen;
import com.chefmooon.breezebounce.client.particle.BounceParticle;
import com.chefmooon.breezebounce.common.network.VelcroS2CPayload;
import com.chefmooon.breezebounce.common.registry.ModParticleTypes;
import com.chefmooon.breezebounce.common.registry.neoforge.ModMenuTypesImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;

@EventBusSubscriber(modid = BreezeBounce.MOD_ID, value = Dist.CLIENT)
public class BreezeBounceClientImpl {

    public static void init(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public static void registerMenuScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypesImpl.INFLATION_MACHINE.get(), InflationMachineScreen::new);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticleTypes.BOUNCE_WHITE.get(), BounceParticle.Provider::new);
    }

    public static void handleVelcroS2CPayload(final VelcroS2CPayload payload, final IPayloadContext context) { // should this be somewhere else?
        ClientLevel clientLevel = Minecraft.getInstance().level;

        if (clientLevel == null) return;

        Entity entity = clientLevel.getEntity(payload.entityId());
        if (entity != null) {
            entity.setDeltaMovement(payload.vec());
            entity.resetFallDistance();
        }
    }
}
