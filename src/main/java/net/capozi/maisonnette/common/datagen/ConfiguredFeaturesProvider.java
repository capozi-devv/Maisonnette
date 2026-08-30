package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.foundation.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.*;

public class ConfiguredFeaturesProvider {
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Maisonnette.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    private static TreeFeatureConfig.Builder redWillow() {
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockInit.WILLOW_LOG), new DarkOakTrunkPlacer(7, 5, 1), BlockStateProvider.of(BlockInit.RED_WILLOW_LEAVES), new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.5F, 0.5F), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }
    private static TreeFeatureConfig.Builder orangeWillow() {
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockInit.WILLOW_LOG), new DarkOakTrunkPlacer(7, 5, 1), BlockStateProvider.of(BlockInit.ORANGE_WILLOW_LEAVES), new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.5F, 0.5F), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }
    private static TreeFeatureConfig.Builder yellowWillow() {
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockInit.WILLOW_LOG), new DarkOakTrunkPlacer(7, 5, 1), BlockStateProvider.of(BlockInit.YELLOW_WILLOW_LEAVES), new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.5F, 0.5F), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }
    private static TreeFeatureConfig.Builder wisteria() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockInit.WISTERIA_LOG), new CherryTrunkPlacer(7, 1, 0, new WeightedListIntProvider(DataPool.<IntProvider>builder().add(ConstantIntProvider.create(1), 1).add(ConstantIntProvider.create(2), 1).add(ConstantIntProvider.create(3), 1).build()), UniformIntProvider.create(2, 4), UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)), BlockStateProvider.of(BlockInit.WISTERIA_LEAVES), new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1), ConstantIntProvider.create(4), 0.25f, 0.25f, 1f, 0.75f) , new TwoLayersFeatureSize(1, 0, 2)).ignoreVines();
    }
    private static RandomPatchFeatureConfig flowerPatch(Block block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(
                tries,
                PlacedFeatures.createEntry(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(block))
                )
        );
    }

    public static void init(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, WISTERIA_KEY, Feature.TREE, wisteria().build());
        register(context, RED_WILLOW_KEY, Feature.TREE, redWillow().build());
        register(context, ORANGE_WILLOW_KEY, Feature.TREE, orangeWillow().build());
        register(context, YELLOW_WILLOW_KEY, Feature.TREE, yellowWillow().build());
        register(context, CARNATION_PATCH_KEY, Feature.FLOWER, flowerPatch(BlockInit.CARNATION, 5));
        register(context, BLACK_STARLETTE_PATCH_KEY, Feature.FLOWER, flowerPatch(BlockInit.BLACK_STARLETTE, 36));
        register(context, ORANGE_STARLETTE_PATCH_KEY, Feature.FLOWER, flowerPatch(BlockInit.ORANGE_STARLETTE, 36));
        register(context, YELLOW_STARLETTE_PATCH_KEY, Feature.FLOWER, flowerPatch(BlockInit.YELLOW_STARLETTE, 36));
        register(context, DELPHINIUM_PATCH_KEY, Feature.FLOWER, flowerPatch(BlockInit.DELPHINIUM_FLOWER, 36));
    }
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_WILLOW_KEY = registerKey("red_willow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_WILLOW_KEY = registerKey("orange_willow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_WILLOW_KEY = registerKey("yellow_willow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WISTERIA_KEY = registerKey("wisteria");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CARNATION_PATCH_KEY = registerKey("carnation_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACK_STARLETTE_PATCH_KEY = registerKey("black_starlette_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_STARLETTE_PATCH_KEY = registerKey("orange_starlette_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_STARLETTE_PATCH_KEY = registerKey("yellow_starlette_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DELPHINIUM_PATCH_KEY = registerKey("delphinium_patch");
}
