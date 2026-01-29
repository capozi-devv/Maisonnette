package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.foundation.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.FeatureSize;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.UpwardsBranchingTrunkPlacer;

import java.util.OptionalInt;

public class ConfiguredFeaturesProvider {
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Maisonnette.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    private static TreeFeatureConfig.Builder cherry() {
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.CHERRY_LOG), new CherryTrunkPlacer(7, 1, 0, new WeightedListIntProvider(DataPool.builder().add(ConstantIntProvider.create(1), 1).add(ConstantIntProvider.create(2), 1).add(ConstantIntProvider.create(3), 1).build()), UniformIntProvider.create(2, 4), UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)), BlockStateProvider.of(Blocks.CHERRY_LEAVES), new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }
    public static void init(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, RED_WILLOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(BlockInit.WILLOW_LOG),
                new CherryTrunkPlacer(7, 2, 1, UniformIntProvider.create(2, 4), UniformIntProvider.create(3, 6), UniformIntProvider.create(3, 4), UniformIntProvider.create(5, 6)),
                BlockStateProvider.of(BlockInit.RED_WILLOW_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25f, 0.25f, 0.95f, 0.9f),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());
        register(context, ORANGE_WILLOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(BlockInit.WILLOW_LOG),
                new StraightTrunkPlacer(5, 4, 3),
                BlockStateProvider.of(BlockInit.ORANGE_WILLOW_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());
        register(context, YELLOW_WILLOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(BlockInit.WILLOW_LOG),
                new StraightTrunkPlacer(5, 4, 3),
                BlockStateProvider.of(BlockInit.YELLOW_WILLOW_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());
    }
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_WILLOW_KEY = registerKey("red_willow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_WILLOW_KEY = registerKey("orange_willow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_WILLOW_KEY = registerKey("yellow_willow");
}
