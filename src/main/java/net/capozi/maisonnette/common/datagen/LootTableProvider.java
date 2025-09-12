package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;

public class LootTableProvider extends FabricBlockLootTableProvider {
    public LootTableProvider(FabricDataOutput dataOutput) { super(dataOutput); }
    @Override public void generate() {
        addDrop(BlockInit.CALCITE_STAIRS);
        addDrop(BlockInit.CALCITE_BRICKS);
        addDrop(BlockInit.CALCITE_SLAB, slabDrops(BlockInit.CALCITE_SLAB));
        addDrop(BlockInit.CALCITE_BUTTON);
        addDrop(BlockInit.CALCITE_WALL);
        addDrop(BlockInit.CHISELED_CALCITE);
        addDrop(BlockInit.GRANITE_BUTTON);
        addDrop(BlockInit.DIORITE_BUTTON);
        addDrop(BlockInit.TUFF_STAIRS);
        addDrop(BlockInit.TUFF_BUTTON);
        addDrop(BlockInit.TUFF_SLAB, slabDrops(BlockInit.TUFF_SLAB));
        addDrop(BlockInit.TUFF_WALL);
        addDrop(BlockInit.TUFF_BRICKS);
        addDrop(BlockInit.COPPER_TORCHBULB);
        addDrop(BlockInit.EXPOSED_COPPER_TORCHBULB);
        addDrop(BlockInit.WAXED_COPPER_TORCHBULB);
        addDrop(BlockInit.OXIDIZED_COPPER_TORCHBULB);
        addDrop(BlockInit.WAXED_COPPER_TORCHBULB);
        addDrop(BlockInit.WAXED_EXPOSED_COPPER_TORCHBULB);
        addDrop(BlockInit.WAXED_COPPER_TORCHBULB);
        addDrop(BlockInit.OXIDIZED_COPPER_TORCHBULB);
    }
}
