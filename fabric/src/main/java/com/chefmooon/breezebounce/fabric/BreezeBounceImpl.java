package com.chefmooon.breezebounce.fabric;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.common.registry.fabric.*;
import com.chefmooon.breezebounce.common.fabric.CommonSetup;
import net.fabricmc.api.ModInitializer;

public class BreezeBounceImpl implements ModInitializer {

	@Override
	public void onInitialize() {
		BreezeBounce.init();

		ModBlocksImpl.register();
		ModCreativeTabs.register();
		ModItemsImpl.register();
		ModParticleTypesImpl.register();
		ModSoundsImpl.register();

		CommonSetup.init();

	}
}