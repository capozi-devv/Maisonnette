package net.capozi.maisonnette;

import net.capozi.maisonnette.common.datagen.BlockTagProvider;
import net.capozi.maisonnette.common.datagen.LootTableProvider;
import net.capozi.maisonnette.common.datagen.ModelProvider;
import net.capozi.maisonnette.common.datagen.RecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MaisonnetteDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(LootTableProvider::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(RecipeProvider::new);
	}
}
