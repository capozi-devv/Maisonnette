package net.capozi.maisonnette.server.world;

import net.capozi.maisonnette.common.datagen.ConfiguredFeaturesProvider;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class WillowSaplingGenerator extends SaplingGenerator {
    @Override
    protected @Nullable RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ConfiguredFeaturesProvider.WILLOW_KEY;
    }
}
