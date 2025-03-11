package com.chefmooon.breezebounce.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BreezeBounceDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelGenerator::new);
		pack.addProvider(TranslationGenerator::new);
		pack.addProvider(RecipeGenerator::new);
		pack.addProvider(LootTableGenerator::new);
		pack.addProvider(BlockTagGenerator::new);
		pack.addProvider(ItemTagGenerator::new);
	}
}
