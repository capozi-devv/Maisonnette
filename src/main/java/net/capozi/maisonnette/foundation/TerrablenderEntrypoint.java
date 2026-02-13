package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.Maisonnette;
import net.minecraft.util.Identifier;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class TerrablenderEntrypoint implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new OverworldRegionInit.NormalWillow(Identifier.of(Maisonnette.MOD_ID, "overworld_willow"), RegionType.OVERWORLD, 2));
        Regions.register(new OverworldRegionInit.RareWillow(Identifier.of(Maisonnette.MOD_ID, "overworld_rare_willow"), RegionType.OVERWORLD, 1));
    }
}
