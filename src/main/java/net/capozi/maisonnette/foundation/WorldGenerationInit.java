package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.common.datagen.PlacedFeaturesProvider;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public final class WorldGenerationInit {
    private WorldGenerationInit() {}

    public static void init() {
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.CHERRY_GROVE, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                PlacedFeaturesProvider.CARNATION_PATCH_PLACED_KEY
        );
    }
}
