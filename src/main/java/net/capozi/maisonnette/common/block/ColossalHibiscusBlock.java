package net.capozi.maisonnette.common.block;

import net.capozi.maisonnette.foundation.BlockInit;
import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class ColossalHibiscusBlock extends AbstractPlantBlock {
    public static final VoxelShape SHAPE_1 = createCuboidShape(-14F, 8F, -14F, 14F, 9F, 14F);
    public static final VoxelShape SHAPE_2 = createCuboidShape(5f, 0f, 5f, 10f, 8f, 10f);
    public ColossalHibiscusBlock(Settings settings, Direction direction, boolean bl) {
        super(settings, direction, VoxelShapes.union(SHAPE_1, SHAPE_2), bl);
    }
    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock)BlockInit.COLOSSAL_HIBISCUS_STEM;
    }
    public static class ColossalHibiscusStemBlock extends AbstractPlantStemBlock {
        public static final VoxelShape SHAPE_2 = createCuboidShape(5f, 0f, 5f, 10f, 16f, 10f);
        public ColossalHibiscusStemBlock(Settings settings, Direction growthDirection, boolean tickWater, double growthChance) {
            super(settings, growthDirection, SHAPE_2, tickWater, growthChance);
        }
        @Override
        protected int getGrowthLength(Random random) {
            return 0;
        }
        @Override
        protected boolean chooseStemState(BlockState state) {
            return false;
        }
        @Override
        protected Block getPlant() {
            return BlockInit.COLOSSAL_HIBISCUS;
        }
    }
}
