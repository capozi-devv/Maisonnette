package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.Maisonnette;
import net.minecraft.util.Identifier;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class TerrablenderEntrypoint implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new OverworldRegionInit(new Identifier(Maisonnette.MOD_ID, "overworld"), RegionType.OVERWORLD, 2));
    }
}
