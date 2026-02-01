package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.foundation.BlockInit;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class PlacedFeaturesProvider {
    public static final RegistryKey<PlacedFeature> RED_WILLOW_PLACED_KEY = registerKey("red_willow_placed");
    public static final RegistryKey<PlacedFeature> ORANGE_WILLOW_PLACED_KEY = registerKey("orange_willow_placed");
    public static final RegistryKey<PlacedFeature> YELLOW_WILLOW_PLACED_KEY = registerKey("yellow_willow_placed");
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Maisonnette.MOD_ID, name));
    }
    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, RED_WILLOW_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeaturesProvider.RED_WILLOW_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.5f, 2), BlockInit.RED_WILLOW_SAPLING));
        register(context, ORANGE_WILLOW_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeaturesProvider.ORANGE_WILLOW_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.5f, 2), BlockInit.ORANGE_WILLOW_SAPLING));
        register(context, YELLOW_WILLOW_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeaturesProvider.YELLOW_WILLOW_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.5f, 2), BlockInit.YELLOW_WILLOW_SAPLING));
    }
}
