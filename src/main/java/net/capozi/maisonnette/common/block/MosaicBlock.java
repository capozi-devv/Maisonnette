package net.capozi.maisonnette.common.block;

import net.capozi.maisonnette.foundation.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.state.property.IntProperty;

import java.util.Collections;
import java.util.List;

public class MosaicBlock extends Block {
    public static final IntProperty TILES = IntProperty.of("tiles", 1, 4);
    public MosaicBlock(Settings settings) {
        super(settings);
    }
    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        return Collections.singletonList(new ItemStack(BlockInit.MOSAIC, state.get(TILES)));
    }
}
