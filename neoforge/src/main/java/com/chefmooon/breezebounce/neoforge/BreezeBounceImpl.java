package com.chefmooon.breezebounce.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.client.neoforge.BreezeBounceClientImpl;
import com.chefmooon.breezebounce.common.registry.neoforge.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(BreezeBounce.MOD_ID)
public class BreezeBounceImpl {
    public BreezeBounceImpl(IEventBus modEventBus, ModContainer modContainer) {
        BreezeBounce.init();

        if (FMLEnvironment.dist.isClient()) {
            modEventBus.addListener(BreezeBounceClientImpl::init);
        }

        ModBlocksImpl.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModItemsImpl.register(modEventBus);
        ModBlockEntityTypesImpl.register(modEventBus);
        ModMenuTypesImpl.register(modEventBus);
        ModParticleTypesImpl.register(modEventBus);
        ModSoundsImpl.register(modEventBus);
    }
}
