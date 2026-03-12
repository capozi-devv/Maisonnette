package net.capozi.maisonnette;

import net.capozi.maisonnette.foundation.OverworldRegionInit;
import net.minecraft.util.Identifier;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class MaisonnetteTerrablenderEntrypoint implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new OverworldRegionInit.RedWillow(new Identifier(Maisonnette.MOD_ID, "red_willow"), RegionType.OVERWORLD, 3));
        Regions.register(new OverworldRegionInit.OrangeWillow(new Identifier(Maisonnette.MOD_ID, "orange_willow"), RegionType.OVERWORLD, 3));
        Regions.register(new OverworldRegionInit.YellowWillow(new Identifier(Maisonnette.MOD_ID, "yellow_willow"), RegionType.OVERWORLD, 1));
    }
}
