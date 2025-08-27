package net.capozi.maisonnette.common.block;

import net.capozi.maisonnette.foundation.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.math.Direction;

import java.util.Collections;
import java.util.List;

public class MosaicBlock extends Block {
    public static final IntProperty TILES = IntProperty.of("tiles", 1, 4);
    public static final BooleanProperty WATERLOGGED;
    public static final DirectionProperty FACING;
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{TILES, WATERLOGGED, FACING});
    }
    public MosaicBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.getDefaultState().with(WATERLOGGED, false)).with(TILES, 1)).with(FACING, Direction.UP));
    }
    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        return Collections.singletonList(new ItemStack(BlockInit.MOSAIC, state.get(TILES)));
    }
    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getSide());
    }
    static {
        WATERLOGGED = Properties.WATERLOGGED;
        FACING = Properties.FACING;
    }
}
