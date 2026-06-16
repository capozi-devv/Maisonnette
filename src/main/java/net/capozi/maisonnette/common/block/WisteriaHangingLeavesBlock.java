package net.capozi.maisonnette.common.block;

import net.capozi.maisonnette.foundation.BlockInit;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class WisteriaHangingLeavesBlock extends WeepingVinesBlock {
    public WisteriaHangingLeavesBlock(Settings settings) {
        super(settings);
    }
    @Override
    protected Block getPlant() {
        return BlockInit.WISTERIA_HANGING_LEAVES_PLANT;
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.offset(this.growthDirection.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return !this.canAttachTo(blockState)
                ? false
                : blockState.isOf(this.getStem()) || blockState.isOf(this.getPlant()) || blockState.isFullCube(world, blockPos);
    }
    public static class WisteriaHangingLeavesPlantBlock extends WeepingVinesPlantBlock {
        public WisteriaHangingLeavesPlantBlock(Settings settings) {
            super(settings);
        }

        @Override
        protected AbstractPlantStemBlock getStem() {
            return (AbstractPlantStemBlock)BlockInit.WISTERIA_HANGING_LEAVES;
        }
    }
}
