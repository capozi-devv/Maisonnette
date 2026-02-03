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
import net.minecraft.world.gen.trunk.*;

public class ConfiguredFeaturesProvider {
    public static final RegistryEntryList<Block> WILLOW_CAN_GROW = RegistryEntryList.of(Blocks.AIR.getRegistryEntry(), Blocks.ACACIA_LEAVES.getRegistryEntry(), Blocks.AZALEA_LEAVES.getRegistryEntry(), Blocks.BIRCH_LEAVES.getRegistryEntry(), Blocks.CHERRY_LEAVES.getRegistryEntry(), Blocks.FLOWERING_AZALEA_LEAVES.getRegistryEntry(), Blocks.DARK_OAK_LEAVES.getRegistryEntry(), Blocks.JUNGLE_LEAVES.getRegistryEntry(), Blocks.OAK_LEAVES.getRegistryEntry(), Blocks.MANGROVE_LEAVES.getRegistryEntry(), Blocks.SPRUCE_LEAVES.getRegistryEntry());
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
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockInit.WILLOW_LOG), new DarkOakTrunkPlacer(7, 5, 1), BlockStateProvider.of(BlockInit.ORANGE_WILLOW_LEAVES), new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }
    private static TreeFeatureConfig.Builder yellowWillow() {
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(BlockInit.WILLOW_LOG), new DarkOakTrunkPlacer(7, 5, 1), BlockStateProvider.of(BlockInit.YELLOW_WILLOW_LEAVES), new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
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
