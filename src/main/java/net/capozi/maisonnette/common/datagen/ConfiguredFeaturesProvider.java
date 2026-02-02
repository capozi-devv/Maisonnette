package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.foundation.BlockInit;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ConfiguredFeaturesProvider {
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Maisonnette.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    private static TreeFeatureConfig.Builder redWillow() {
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockInit.WILLOW_LOG), new CherryTrunkPlacer(7, 1, 0, UniformIntProvider.create(1, 3), UniformIntProvider.create(2, 4), UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)), BlockStateProvider.of(BlockInit.RED_WILLOW_LEAVES), new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }
    private static TreeFeatureConfig.Builder orangeWillow() {
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockInit.WILLOW_LOG), new CherryTrunkPlacer(7, 1, 0, UniformIntProvider.create(1, 3), UniformIntProvider.create(2, 4), UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)), BlockStateProvider.of(BlockInit.ORANGE_WILLOW_LEAVES), new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }
    private static TreeFeatureConfig.Builder yellowWillow() {
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockInit.WILLOW_LOG), new CherryTrunkPlacer(7, 1, 0, UniformIntProvider.create(1, 3), UniformIntProvider.create(2, 4), UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)), BlockStateProvider.of(BlockInit.YELLOW_WILLOW_LEAVES), new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }
    public static void init(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, RED_WILLOW_KEY, Feature.TREE, redWillow().build());
        register(context, ORANGE_WILLOW_KEY, Feature.TREE, orangeWillow().build());
        register(context, YELLOW_WILLOW_KEY, Feature.TREE, yellowWillow().build());
    }
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_WILLOW_KEY = registerKey("red_willow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_WILLOW_KEY = registerKey("orange_willow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_WILLOW_KEY = registerKey("yellow_willow");
}
