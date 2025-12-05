package com.chefmooon.breezebounce.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.client.neoforge.BreezeBounceClientImpl;
import com.chefmooon.breezebounce.common.network.VelcroS2CPayload;
import com.chefmooon.breezebounce.common.registry.neoforge.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@Mod(BreezeBounce.MOD_ID)
public class BreezeBounceImpl {
    public BreezeBounceImpl(IEventBus modEventBus, ModContainer modContainer) {
        BreezeBounce.init();

        if (FMLEnvironment.getDist().isClient()) {
            modEventBus.addListener(BreezeBounceClientImpl::init);
        }

        ModEffectsImpl.register(modEventBus);
        ModBlocksImpl.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModItemsImpl.register(modEventBus);
        ModBlockEntityTypesImpl.register(modEventBus);
        ModMenuTypesImpl.register(modEventBus);
        ModParticleTypesImpl.register(modEventBus);
        ModSoundsImpl.register(modEventBus);
    }

    @EventBusSubscriber(modid = BreezeBounce.MOD_ID)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerPayloads(final RegisterPayloadHandlersEvent event) {
            final PayloadRegistrar registrar = event.registrar("1");
            registrar.playToClient(VelcroS2CPayload.ID, VelcroS2CPayload.CODEC, BreezeBounceClientImpl::handleVelcroS2CPayload);
        }
    }
}
