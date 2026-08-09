package net.capozi.maisonnette.common.block;

import net.capozi.maisonnette.foundation.BlockInit;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class WisteriaHangingLeavesBlock extends AbstractPlantStemBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 9.0, 4.0, 12.0, 16.0, 12.0);
    public WisteriaHangingLeavesBlock(Settings settings) {
        super(settings, Direction.DOWN, SHAPE, true, 0.2);
    }
    @Override
    protected Block getPlant() {
        return BlockInit.WISTERIA_HANGING_LEAVES_PLANT;
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.offset(this.growthDirection.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return !this.canAttachTo(blockState) ? false : blockState.isOf(this.getStem()) || blockState.isOf(this.getPlant()) || blockState.isFullCube(world, blockPos);
    }

    @Override
    protected int getGrowthLength(Random random) {
        return VineLogic.getGrowthLength(random);
    }
    @Override
    protected boolean chooseStemState(BlockState state) {
        return VineLogic.isValidForWeepingStem(state);
    }
    public static class WisteriaHangingLeavesPlantBlock extends AbstractPlantBlock {
        public static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
        public WisteriaHangingLeavesPlantBlock(Settings settings) {
            super(settings, Direction.DOWN, SHAPE, false);
        }
        @Override
        protected AbstractPlantStemBlock getStem() {
            return (AbstractPlantStemBlock)BlockInit.WISTERIA_HANGING_LEAVES;
        }
        @Override
        public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
            BlockPos blockPos = pos.offset(this.growthDirection.getOpposite());
            BlockState blockState = world.getBlockState(blockPos);
            return !this.canAttachTo(blockState) ? false : blockState.isOf(this.getStem()) || blockState.isOf(this.getPlant()) || blockState.isFullCube(world, blockPos);
        }
    }
}
