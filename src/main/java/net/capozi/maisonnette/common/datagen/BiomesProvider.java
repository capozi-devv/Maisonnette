package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.Maisonnette;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class BiomesProvider {
    public static void init(Registerable<Biome> context) {
        context.register(RED_WILLOW_FOREST, redWillowBiome(context));
    }
    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }
    public static Biome redWillowBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 5, 1, 3));
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        //biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeaturesProvider.RED_WILLOW_PLACED_KEY);
        DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
        DefaultBiomeFeatures.addLargeFerns(biomeBuilder);
        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);
        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x5ebfff)
                        .waterFogColor(0x5ebfff)
                        .skyColor(7972607)
                        .grassColor(0xa5c795)
                        .fogColor(12638463)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_FOREST)).build())
                .build();
    }
    public static final RegistryKey<Biome> RED_WILLOW_FOREST = RegistryKey.of(RegistryKeys.BIOME, new Identifier(Maisonnette.MOD_ID, "red_willow_forest"));

}
