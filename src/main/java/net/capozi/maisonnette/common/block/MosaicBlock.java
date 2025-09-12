package net.capozi.maisonnette.common.block;

import net.capozi.maisonnette.foundation.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.Collections;
import java.util.List;

public class MosaicBlock extends Block implements Waterloggable {
    public static final VoxelShape SHAPE_0 = createCuboidShape((double)0.0F, (double)0.0F, (double)0.0F, (double)8.0F, (double)2.0F, (double)8.0F);
    public static final VoxelShape SHAPE_1 = createCuboidShape((double)0.0F, (double)0.0F, (double)0.0F, (double)8.0F, (double)2.0F, (double)16.0F);
    public static final VoxelShape SHAPE_2 = createCuboidShape((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)2.0F, (double)16.0F);
    public static final IntProperty TILES = IntProperty.of("tiles", 1, 4);
    public static final BooleanProperty WATERLOGGED;
    public static final DirectionProperty FACING;
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{TILES, WATERLOGGED, FACING});
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape var10000;
        switch ((Integer)state.get(TILES)) {
            case 1 -> var10000 = SHAPE_0;
            case 2 -> var10000 = SHAPE_1;
            case 3 -> var10000 = SHAPE_2;
            case 4 -> var10000 = SHAPE_2;
            default -> var10000 = SHAPE_2;
        }
        return var10000;
    }
    public MosaicBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.getDefaultState().with(WATERLOGGED, false)).with(TILES, 1)).with(FACING, Direction.UP));
    }
    @Override public List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        return Collections.singletonList(new ItemStack(BlockInit.MOSAIC, state.get(TILES)));
    }
    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
    @Override public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = ctx.getWorld().getBlockState(ctx.getBlockPos());
        return state.isOf(this) ? (BlockState)state.cycle(TILES) : (BlockState)this.getDefaultState().with(FACING, Direction.UP);
    }
    static {
        WATERLOGGED = Properties.WATERLOGGED;
        FACING = Properties.FACING;
    }
}
