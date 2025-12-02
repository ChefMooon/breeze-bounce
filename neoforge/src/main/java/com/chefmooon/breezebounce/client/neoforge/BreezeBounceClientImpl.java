package com.chefmooon.breezebounce.client.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.client.gui.InflationMachineScreen;
import com.chefmooon.breezebounce.client.particle.BounceParticle;
import com.chefmooon.breezebounce.common.registry.ModParticleTypes;
import com.chefmooon.breezebounce.common.registry.neoforge.ModItemsImpl;
import com.chefmooon.breezebounce.common.registry.neoforge.ModMenuTypesImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = BreezeBounce.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BreezeBounceClientImpl {

    public static void init(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public static void registerMenuScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypesImpl.INFLATION_MACHINE.get(), InflationMachineScreen::new);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticleTypes.BOUNCE_WHITE.get(), BounceParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerColorHandlers(RegisterColorHandlersEvent.Item event) {
        event.register((itemStack, i) -> i > 0 ? -1 : DyedItemColor.getOrDefault(itemStack, -6265536),
                ModItemsImpl.VELCRO_HELMET.get(),
                ModItemsImpl.VELCRO_CHESTPLATE.get(),
                ModItemsImpl.VELCRO_LEGGINGS.get(),
                ModItemsImpl.VELCRO_BOOTS.get());
    }
}
