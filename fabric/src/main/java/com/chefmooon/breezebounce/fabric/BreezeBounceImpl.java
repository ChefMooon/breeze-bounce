package com.chefmooon.breezebounce.fabric;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.common.fabric.CommonSetup;
import com.chefmooon.breezebounce.common.network.VelcroS2CPayload;
import com.chefmooon.breezebounce.common.registry.fabric.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class BreezeBounceImpl implements ModInitializer {

	@Override
	public void onInitialize() {
		BreezeBounce.init();

        ModEffectsImpl.register();
		ModBlocksImpl.register();
		ModCreativeTabs.register();
		ModItemsImpl.register();
		ModBlockEntityTypesImpl.register();
		ModMenuTypesImpl.register();
		ModParticleTypesImpl.register();
		ModSoundsImpl.register();
        ModArmorMaterialsImpl.register();

		CommonSetup.init();

        registerNetwork();
	}

    private static void registerNetwork() {
        PayloadTypeRegistry.playS2C().register(VelcroS2CPayload.ID, VelcroS2CPayload.CODEC);
    }
}