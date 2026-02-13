package net.capozi.maisonnette.server.world.generator;

import net.capozi.maisonnette.common.datagen.ConfiguredFeaturesProvider;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class OrangeWillowSaplingGenerator extends SaplingGenerator {
    @Override
    protected @Nullable RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ConfiguredFeaturesProvider.ORANGE_WILLOW_KEY;
    }
}
