package net.capozi.maisonnette.common.block;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class BulbBlock extends FacingBlock {
    public static final DirectionProperty FACING;
    public static final BooleanProperty POWERED;
    public static final BooleanProperty LIT;
    public BulbBlock(Oxidizable.OxidationLevel level, Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.UP)).with(POWERED, false).with(LIT, false));
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED, LIT);
    }
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return (Boolean)world.getBlockState(pos).get(LIT) ? 15 : 0;
    }
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.getBlock() != state.getBlock() && world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }

    }
    public void update(BlockState state, ServerWorld world, BlockPos pos) {
        boolean bl = world.isReceivingRedstonePower(pos);
        if (bl != (Boolean)state.get(POWERED)) {
            BlockState blockState = state;
            if (!(Boolean)state.get(POWERED)) {
                blockState = (BlockState)state.cycle(LIT);
            }

            world.setBlockState(pos, (BlockState)blockState.with(POWERED, bl), 3);
        }
    }
    static {
        POWERED = Properties.POWERED;
        LIT = Properties.LIT;
        FACING = Properties.FACING;
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getSide());
    }
    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            boolean lit = state.get(LIT);
            world.setBlockState(pos, state.with(LIT, !lit), Block.NOTIFY_ALL);
            world.playSound(player, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 1f, 1f);
            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }
}
