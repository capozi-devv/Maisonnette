package net.capozi.maisonnette.foundation;

import com.mojang.datafixers.util.Pair;
import net.capozi.maisonnette.common.datagen.BiomesProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class OverworldRegionInit {
     static class NormalWillow extends Region {
        public NormalWillow(Identifier name, RegionType type, int weight) {
            super(name, type, weight);
        }
        @Override
        public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
            VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
            new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.COOL, ParameterUtils.Temperature.NEUTRAL))
                    .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.DRY))
                    .continentalness(ParameterUtils.Continentalness.INLAND)
                    .erosion(ParameterUtils.Erosion.EROSION_0)
                    .depth(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.FLOOR)
                    .build().forEach(point -> builder.add(point, BiomesProvider.RED_WILLOW_FOREST));
            builder.build().forEach(mapper);
            new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.HOT, ParameterUtils.Temperature.WARM))
                    .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.ARID, ParameterUtils.Humidity.DRY))
                    .continentalness(ParameterUtils.Continentalness.NEAR_INLAND, ParameterUtils.Continentalness.COAST)
                    .erosion(ParameterUtils.Erosion.EROSION_1)
                    .depth(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.FLOOR)
                    .build().forEach(point -> builder.add(point, BiomesProvider.ORANGE_WILLOW_FOREST));
            builder.build().forEach(mapper);
        }
    }
    static class RareWillow extends Region {
        public RareWillow(Identifier name, RegionType type, int weight) {
            super(name, type, weight);
        }
        @Override
        public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
            VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
            new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.ICY)
                    .humidity(ParameterUtils.Humidity.DRY)
                    .continentalness(ParameterUtils.Continentalness.FAR_INLAND)
                    .erosion(ParameterUtils.Erosion.EROSION_1)
                    .depth(ParameterUtils.Depth.SURFACE)
                    .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING)
                    .build()
                    .forEach(point -> builder.add(point, BiomesProvider.YELLOW_WILLOW_FOREST));
            builder.build().forEach(mapper);
        }
    }

}
