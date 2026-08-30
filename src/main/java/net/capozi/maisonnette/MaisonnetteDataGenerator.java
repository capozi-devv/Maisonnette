package net.capozi.maisonnette;

import net.capozi.maisonnette.common.datagen.*;
import net.capozi.maisonnette.common.datagen.ConfiguredFeaturesProvider;
import net.capozi.maisonnette.common.datagen.PlacedFeaturesProvider;
import net.capozi.maisonnette.common.datagen.BiomesProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class MaisonnetteDataGenerator implements DataGeneratorEntrypoint {
	@Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(BlockTagProvider::new);
        pack.addProvider(ItemTagProvider::new);
		pack.addProvider(LootTableProvider::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(RecipeProvider::new);
        pack.addProvider(WorldGenProvider::new);
	}
    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeaturesProvider::init);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeaturesProvider::init);
        registryBuilder.addRegistry(RegistryKeys.BIOME, BiomesProvider::init);
    }
}
