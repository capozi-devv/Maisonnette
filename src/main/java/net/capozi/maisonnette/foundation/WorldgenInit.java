package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.common.datagen.BiomesProvider;
import net.capozi.maisonnette.common.datagen.PlacedFeaturesProvider;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class WorldgenInit {
    public static void init() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomesProvider.RED_WILLOW_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeaturesProvider.RED_WILLOW_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomesProvider.RED_WILLOW_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.DARK_FOREST_VEGETATION);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomesProvider.RED_WILLOW_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FOREST_FLOWERS);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomesProvider.RED_WILLOW_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_PLAIN);
    }
}
