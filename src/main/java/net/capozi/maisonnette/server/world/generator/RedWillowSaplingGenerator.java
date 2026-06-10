package net.capozi.maisonnette.server.world.generator;

import net.capozi.maisonnette.common.datagen.ConfiguredFeaturesProvider;
import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class RedWillowSaplingGenerator extends LargeTreeSaplingGenerator {
    @Override
    protected @Nullable RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return null;
    }

    @Override
    protected @Nullable RegistryKey<ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random) {
        return ConfiguredFeaturesProvider.RED_WILLOW_KEY;
    }
}
