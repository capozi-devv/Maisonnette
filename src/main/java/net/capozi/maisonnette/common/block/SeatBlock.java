package net.capozi.maisonnette.common.block;

import net.capozi.maisonnette.common.entity.custom.SeatEntity;
import net.capozi.maisonnette.foundation.EntityInit;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class SeatBlock extends Block {
    public static final VoxelShape SHAPE_1 = createCuboidShape((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)9.0F, (double)16.0F);
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape var10000;
        var10000 = SHAPE_1;
        return var10000;
    }
    public SeatBlock(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            List<SeatEntity> nearbySeats = world.getEntitiesByClass(SeatEntity.class,
                    new Box(pos), entity -> true);
            if (nearbySeats.isEmpty()) {
                SeatEntity seat = new SeatEntity(EntityInit.SEAT, world, pos);
                world.spawnEntity(seat);
                player.startRiding(seat);
            }
        }
        return ActionResult.SUCCESS;
    }
}
