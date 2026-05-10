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

public interface OverworldRegionInit {
    class YellowWillow extends Region {
        public YellowWillow(Identifier name, RegionType type, int weight) {
            super(name, type, weight);
        }
        @Override
        public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
            this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
                builder.replaceBiome(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomesProvider.YELLOW_WILLOW_FOREST);
            });
        }
    }
    class OrangeWillow extends Region {
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
    class RedWillow extends Region {
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
