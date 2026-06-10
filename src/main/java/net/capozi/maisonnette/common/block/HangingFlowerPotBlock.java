package net.capozi.maisonnette.common.block;

import net.capozi.maisonnette.common.block.entity.HangingFlowerPotBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.Registries;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class HangingFlowerPotBlock extends BlockWithEntity {
    private static final VoxelShape SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);

    public HangingFlowerPotBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos supportPos = pos.up();
        BlockState supportState = world.getBlockState(supportPos);
        return supportState.isSideSolidFullSquare(world, supportPos, Direction.DOWN)
                || (supportState.isOf(Blocks.CHAIN) && supportState.get(ChainBlock.AXIS) == Direction.Axis.Y);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState state = getDefaultState();
        return state.canPlaceAt(context.getWorld(), context.getBlockPos()) ? state : null;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.UP && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HangingFlowerPotBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (!(blockEntity instanceof HangingFlowerPotBlockEntity hangingPot)) {
            return ActionResult.PASS;
        }

        ItemStack heldStack = player.getStackInHand(hand);
        Block pottedBlock = Blocks.AIR;
        if (heldStack.getItem() instanceof BlockItem blockItem) {
            pottedBlock = getPottedBlock(blockItem.getBlock());
        }

        if (hangingPot.isEmpty() && pottedBlock != Blocks.AIR) {
            if (!world.isClient) {
                hangingPot.setPottedBlock(pottedBlock);
                player.incrementStat(Stats.POT_FLOWER);
                if (!player.getAbilities().creativeMode) {
                    heldStack.decrement(1);
                }
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            }
            return ActionResult.success(world.isClient);
        }

        if (!hangingPot.isEmpty() && pottedBlock == Blocks.AIR) {
            if (!world.isClient) {
                ItemStack contentStack = hangingPot.getContentStack();
                if (heldStack.isEmpty()) {
                    player.setStackInHand(hand, contentStack);
                } else if (!player.getInventory().insertStack(contentStack)) {
                    player.dropItem(contentStack, false);
                }
                hangingPot.clear();
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            }
            return ActionResult.success(world.isClient);
        }

        return ActionResult.CONSUME;
    }

    private static Block getPottedBlock(Block content) {
        for (Block block : Registries.BLOCK) {
            if (block instanceof FlowerPotBlock flowerPotBlock && flowerPotBlock.getContent() == content) {
                return block;
            }
        }
        return Blocks.AIR;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof HangingFlowerPotBlockEntity hangingPot && !hangingPot.isEmpty()) {
                Block.dropStack(world, pos, hangingPot.getContentStack());
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }
}
