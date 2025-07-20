package net.capozi.maisonnette.common.block;

import net.capozi.maisonnette.common.block.entity.SeatEntity;
import net.capozi.maisonnette.foundation.EntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SeatBlock extends BlockWithEntity {
    public static final VoxelShape SHAPE_1 = createCuboidShape((double)2.0F, (double)0.0F, (double)2.0F, (double)14.0F, (double)8.0F, (double)14.0F);
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape var10000;
        var10000 = SHAPE_1;
        return var10000;
    }
    public SeatBlock(Settings settings) {
        super(settings);
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;

        if (!hasSeat(world, pos)) {
            SeatEntity seat = new SeatEntity(EntityInit.SEAT, world, pos);
            world.spawnEntity(seat);
            player.startRiding(seat);
        }

        return ActionResult.CONSUME;
    }
    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (hasSeat(world, pos)) {
            SeatEntity seat = new SeatEntity(EntityInit.SEAT, world, pos);
            seat.discard();
        }
    }
    private boolean hasSeat(World world, BlockPos pos) {
        for (Entity entity : world.getOtherEntities(null,
                new Box(pos).expand(0.1))) {
            if (entity instanceof SeatEntity) return true;
        }
        return false;
    }
}
