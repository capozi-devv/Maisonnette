package net.capozi.maisonnette.common.block;

import net.capozi.maisonnette.foundation.BlockInit;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
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
        @Override
        public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
            if (entity.bypassesLandingEffects()) {
                super.onLandedUpon(world, state, pos, entity, fallDistance);
            } else {
                entity.handleFallDamage(fallDistance, 0.0F, world.getDamageSources().fall());
            }
        }

        @Override
        public void onEntityLand(BlockView world, Entity entity) {
            if (entity.bypassesLandingEffects()) {
                super.onEntityLand(world, entity);
            } else {
                this.bounce(entity);
            }
        }

        private void bounce(Entity entity) {
            Vec3d vec3d = entity.getVelocity();
            if (vec3d.y < 0.0) {
                double d = 0.8;
                entity.setVelocity(vec3d.x, -vec3d.y * d, vec3d.z);
            }
        }
    }
}
