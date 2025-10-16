package net.capozi.maisonnette.common.block;

import net.capozi.maisonnette.foundation.BlockInit;
import net.capozi.maisonnette.foundation.SoundInit;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
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

import java.util.Collections;
import java.util.List;

public class BookStackBlock extends Block implements Waterloggable {
    public static final VoxelShape SHAPE_0 = createCuboidShape((double)2.0F, (double)0.0F, (double)2.0F, (double)14.0F, (double)4.0F, (double)14.0F);
    public static final VoxelShape SHAPE_1 = createCuboidShape((double)2.0F, (double)0.0F, (double)2.0F, (double)14.0F, (double)8.0F, (double)14.0F);
    public static final VoxelShape SHAPE_2 = createCuboidShape((double)2.0F, (double)0.0F, (double)2.0F, (double)14.0F, (double)12.0F, (double)14.0F);
    public static final VoxelShape SHAPE_3 = createCuboidShape((double)2.0F, (double)0.0F, (double)2.0F, (double)14.0F, (double)16.0F, (double)14.0F);
    public static final IntProperty BOOKS = IntProperty.of("books", 1, 4);
    public static final BooleanProperty WATERLOGGED;
    public BookStackBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.getDefaultState().with(WATERLOGGED, false)).with(BOOKS, 1));
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape var10000;
        switch ((Integer)state.get(BOOKS)) {
            case 1 -> var10000 = SHAPE_0;
            case 2 -> var10000 = SHAPE_1;
            case 3 -> var10000 = SHAPE_2;
            default -> var10000 = SHAPE_3;
        }
        return var10000;
    }
    public Item asItem() {
        return Items.BOOK;
    }
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(Items.BOOK);
    }
    public boolean canReplace(BlockState state, ItemPlacementContext ctx) {
        return !ctx.shouldCancelInteraction() && ctx.getStack().getItem() == this.asItem() && (Integer)state.get(BOOKS) < 4 || super.canReplace(state, ctx);
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = ctx.getWorld().getBlockState(ctx.getBlockPos());
        return state.isOf(this) ? (BlockState)state.cycle(BOOKS) : (BlockState)this.getDefaultState().with(WATERLOGGED, state.getFluidState().getFluid() == Fluids.WATER);
    }
    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BOOKS, WATERLOGGED});
    }
    public static ActionResult placeBookStack(PlayerEntity player, World world, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        if (stack.isOf(Items.BOOK)) {
            Block block = BlockInit.BOOK_STACK;
            ItemPlacementContext ctx = new ItemPlacementContext(world, player, hand, stack, hit);
            BlockState state = block.getPlacementState(ctx);
            BlockPos pos = ctx.getBlockPos();
            if (state != null && block.canPlaceAt(state, world, pos) && world.getBlockState(pos).canReplace(ctx)) {
                world.setBlockState(pos, state, 11);
                BlockState placedState = world.getBlockState(pos);
                if (placedState.isOf(state.getBlock())) {
                    placedState.getBlock().onPlaced(world, pos, placedState, player, stack);
                    if (player instanceof ServerPlayerEntity) {
                        ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)player;
                        Criteria.PLACED_BLOCK.trigger(serverPlayerEntity, pos, stack);
                    }
                }
                BlockSoundGroup blockSoundGroup = placedState.getSoundGroup();
                world.playSound(player, pos, placedState.getSoundGroup().getPlaceSound(), SoundCategory.BLOCKS, (blockSoundGroup.getVolume() + 1.0F) / 2.0F, blockSoundGroup.getPitch() * 0.8F);
                world.emitGameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Emitter.of(player, placedState));
                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
                return ActionResult.success(world.isClient);
            } else {
                return ActionResult.PASS;
            }
        } else {
            return ActionResult.PASS;
        }
    }
    static {
        WATERLOGGED = Properties.WATERLOGGED;
    }
    public static void registerBookUseCallback() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            ItemStack stack = player.getStackInHand(hand);
            if (stack.isOf(Items.BOOK)) {
                ActionResult result = BookStackBlock.placeBookStack(player, world, hand, hitResult);
                return result;
            }
            return ActionResult.PASS;
        });
    }
    @Override public List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        return Collections.singletonList(new ItemStack(Items.BOOK, state.get(BOOKS)));
    }
    @Override public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        if (blockState.isIn(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON)) {
            return false;
        } else {
            return blockState.isIn(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON) ? true : Block.isFaceFullSquare(blockState.getCollisionShape(world, pos.down()), Direction.UP) || blockState.isOf(this) && (Integer)blockState.get(BOOKS) == 8;
        }
    }
    @Override public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if ((Boolean)state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
}