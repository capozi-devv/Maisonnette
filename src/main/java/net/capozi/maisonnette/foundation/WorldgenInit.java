package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.common.datagen.BiomesProvider;
import net.capozi.maisonnette.common.datagen.PlacedFeaturesProvider;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class WorldgenInit {
    public static void init() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomesProvider.RED_WILLOW_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeaturesProvider.RED_WILLOW_PLACED_KEY);
    }
}
