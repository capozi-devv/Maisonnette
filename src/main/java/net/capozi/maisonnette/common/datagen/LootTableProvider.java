package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class LootTableProvider extends FabricBlockLootTableProvider {
    public LootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }
    @Override
    public void generate() {
        addDrop(BlockInit.CALCITE_STAIRS);
        addDrop(BlockInit.CALCITE_BRICKS);
        addDrop(BlockInit.CALCITE_SLAB, slabDrops(BlockInit.CALCITE_SLAB));
        addDrop(BlockInit.CALCITE_BUTTON);
        addDrop(BlockInit.CALCITE_WALL);
        addDrop(BlockInit.CHISELED_CALCITE);
    }
}
