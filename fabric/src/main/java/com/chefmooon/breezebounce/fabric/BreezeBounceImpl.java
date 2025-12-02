package com.chefmooon.breezebounce.fabric;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.common.fabric.CommonSetup;
import com.chefmooon.breezebounce.common.registry.fabric.*;
import net.fabricmc.api.ModInitializer;

public class BreezeBounceImpl implements ModInitializer {
	public static final String MOD_ID = "breezebounce";

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

	}
}