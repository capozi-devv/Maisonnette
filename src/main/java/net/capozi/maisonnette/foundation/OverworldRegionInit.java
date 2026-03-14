package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.common.datagen.BiomesProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import com.mojang.datafixers.util.Pair;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.*;

import java.util.function.Consumer;

public class OverworldRegionInit {
    public static class YellowWillow extends Region {
        public YellowWillow(Identifier name, RegionType type, int weight) {
            super(name, type, weight);
        }
        @Override
        public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
            VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
            new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.ICY, ParameterUtils.Temperature.FROZEN))
                    .humidity(ParameterUtils.Humidity.DRY)
                    .continentalness(ParameterUtils.Continentalness.FAR_INLAND)
                    .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_1)
                    .depth(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.SURFACE)
                    .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.HIGH_SLICE_NORMAL_ASCENDING)
                    .build().forEach(point -> builder.add(point, BiomesProvider.YELLOW_WILLOW_FOREST));
            builder.build().forEach(mapper);
        }
    }
    public static class OrangeWillow extends Region {
        public OrangeWillow(Identifier name, RegionType type, int weight) {
            super(name, type, weight);
        }
        @Override
        public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
            this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
                modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.WOODED_BADLANDS, BiomesProvider.ORANGE_WILLOW_FOREST);
            });
        }
    }
    public static class RedWillow extends Region {
        public RedWillow(Identifier name, RegionType type, int weight) {
            super(name, type, weight);
        }
        @Override
        public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
            this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
                modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.DARK_FOREST, BiomesProvider.RED_WILLOW_FOREST);
            });
        }
    }
}
