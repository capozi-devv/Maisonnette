package net.capozi.maisonnette.common.block;

import net.capozi.maisonnette.foundation.BlockInit;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ColossalHibiscusBlock extends AbstractPlantBlock {
    public static final VoxelShape SHAPE_2 = createCuboidShape(3f, 0f, 3f, 13f, 16f, 13f);
    public ColossalHibiscusBlock(Settings settings, Direction direction, boolean bl) {
        super(settings, direction, SHAPE_2, bl);
    }
    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock)BlockInit.COLOSSAL_HIBISCUS_STEM;
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return BlockInit.COLOSSAL_HIBISCUS_STEM.getDefaultState();
    }

    public static class ColossalHibiscusStemBlock extends AbstractPlantStemBlock {
        public static final VoxelShape SHAPE_1 = createCuboidShape(-14F, 7F, -14F, 30F, 9F, 30F);
        public static final VoxelShape SHAPE_2 = createCuboidShape(5f, 0f, 5f, 10f, 8f, 10f);
        @Override
        public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            return createCuboidShape(-14F, 7F, -14F, 30F, 9F, 30F);
        }
        public ColossalHibiscusStemBlock(Settings settings, Direction growthDirection, boolean tickWater, double growthChance) {
            super(settings, growthDirection, VoxelShapes.union(SHAPE_1, SHAPE_2), tickWater, growthChance);
        }
        @Override
        protected int getGrowthLength(Random random) {
            return 1;
        }
        @Override
        protected boolean chooseStemState(BlockState state) {
            return state.isAir();
        }
        @Override
        protected Block getPlant() {
            return BlockInit.COLOSSAL_HIBISCUS;
        }
    }
}
