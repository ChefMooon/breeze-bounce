package com.chefmooon.breezebounce.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.client.neoforge.BreezeBounceClientImpl;
import com.chefmooon.breezebounce.common.network.VelcroS2CPayload;
import com.chefmooon.breezebounce.common.registry.neoforge.*;
import com.chefmooon.breezebounce.common.util.neoforge.PayloadUtilImpl;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.handling.MainThreadPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@Mod(BreezeBounce.MOD_ID)
public class BreezeBounceImpl {
    public BreezeBounceImpl(IEventBus modEventBus, ModContainer modContainer) {
        BreezeBounce.init();

        if (FMLEnvironment.dist.isClient()) {
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
        ModArmorMaterialsImpl.register(modEventBus);
    }

    @EventBusSubscriber(modid = BreezeBounce.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerPayloadHandlers(final RegisterPayloadHandlersEvent event) {
            final PayloadRegistrar registrar = event.registrar("3");
            registrar.playToClient(VelcroS2CPayload.ID, VelcroS2CPayload.CODEC, BreezeBounceClientImpl::handleVelcroS2CPayload);
//            registrar.playBidirectional(VelcroS2CPayload.ID, VelcroS2CPayload.CODEC, new DirectionalPayloadHandler<>(BreezeBounceClientImpl::handleVelcroS2CPayload, PayloadUtilImpl::handleDataOnNetwork));
        }
    }
}
