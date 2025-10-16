package net.capozi.maisonnette.common.item;

import net.capozi.maisonnette.common.block.MosaicBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public class MosaicTileItem extends BlockItem {
    public MosaicTileItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockState blockState = context.getWorld().getBlockState(context.getBlockPos());
        if (blockState.getBlock() instanceof MosaicBlock mosaicBlock) {
            int num = blockState.get(MosaicBlock.TILES);
            if (num <4) {
                context.getWorld().setBlockState(context.getBlockPos(), blockState.with(MosaicBlock.TILES, num + 1));
            }else{
                return super.useOnBlock(context);
            }
            return ActionResult.CONSUME;
        }else{
            return super.useOnBlock(context);
        }
    }
}
