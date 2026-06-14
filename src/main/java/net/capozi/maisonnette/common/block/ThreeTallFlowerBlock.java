package net.capozi.maisonnette.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class ThreeTallFlowerBlock extends PlantBlock {
    public static final EnumProperty<Part> PART =
            EnumProperty.of("part", Part.class);

    private static final VoxelShape SHAPE =
            Block.createCuboidShape(
                    2.0,
                    0.0,
                    2.0,
                    14.0,
                    16.0,
                    14.0
            );

    public ThreeTallFlowerBlock(Settings settings) {
        super(settings);

        this.setDefaultState(
                this.stateManager.getDefaultState()
                        .with(PART, Part.BOTTOM)
        );
    }

    @Override
    protected void appendProperties(
            StateManager.Builder<Block, BlockState> builder
    ) {
        builder.add(PART);
    }

    @Override
    public @Nullable BlockState getPlacementState(
            ItemPlacementContext context
    ) {
        BlockPos bottomPos = context.getBlockPos();
        World world = context.getWorld();

        if (bottomPos.getY() + 2 >= world.getTopY()) {
            return null;
        }

        BlockPos middlePos = bottomPos.up();
        BlockPos topPos = bottomPos.up(2);

        if (!world.getBlockState(middlePos).canReplace(context)
                || !world.getBlockState(topPos).canReplace(context)) {
            return null;
        }

        BlockState placementState = super.getPlacementState(context);

        if (placementState == null) {
            return null;
        }

        return placementState.with(PART, Part.BOTTOM);
    }

    @Override
    public void onPlaced(
            World world,
            BlockPos pos,
            BlockState state,
            @Nullable LivingEntity placer,
            ItemStack itemStack
    ) {
        super.onPlaced(world, pos, state, placer, itemStack);

        if (world.isClient) {
            return;
        }

        BlockState commonState = state.getBlock().getDefaultState();

        world.setBlockState(
                pos.up(),
                commonState.with(PART, Part.MIDDLE),
                Block.NOTIFY_ALL
        );

        world.setBlockState(
                pos.up(2),
                commonState.with(PART, Part.TOP),
                Block.NOTIFY_ALL
        );
    }

    @Override
    public boolean canPlaceAt(
            BlockState state,
            WorldView world,
            BlockPos pos
    ) {
        return switch (state.get(PART)) {
            case BOTTOM -> super.canPlaceAt(state, world, pos);

            case MIDDLE -> isExpectedPart(
                    world,
                    pos.down(),
                    Part.BOTTOM
            );

            case TOP -> isExpectedPart(
                    world,
                    pos.down(),
                    Part.MIDDLE
            );
        };
    }

    @Override
    public BlockState getStateForNeighborUpdate(
            BlockState state,
            Direction direction,
            BlockState neighborState,
            WorldAccess world,
            BlockPos pos,
            BlockPos neighborPos
    ) {
        Part part = state.get(PART);

        boolean invalid = switch (part) {
            case BOTTOM ->
                    direction == Direction.DOWN
                            && !super.canPlaceAt(state, world, pos)
                            || direction == Direction.UP
                            && !isExpectedPart(
                                    world,
                                    pos.up(),
                                    Part.MIDDLE
                            );

            case MIDDLE ->
                    direction == Direction.DOWN
                            && !isExpectedPart(
                                    world,
                                    pos.down(),
                                    Part.BOTTOM
                            )
                            || direction == Direction.UP
                            && !isExpectedPart(
                                    world,
                                    pos.up(),
                                    Part.TOP
                            );

            case TOP ->
                    direction == Direction.DOWN
                            && !isExpectedPart(
                                    world,
                                    pos.down(),
                                    Part.MIDDLE
                            );
        };

        if (invalid) {
            return Blocks.AIR.getDefaultState();
        }

        return super.getStateForNeighborUpdate(
                state,
                direction,
                neighborState,
                world,
                pos,
                neighborPos
        );
    }

    @Override
    public void onBreak(
            World world,
            BlockPos pos,
            BlockState state,
            PlayerEntity player
    ) {
        if (!world.isClient) {
            removeOtherParts(world, pos, state);
        }

        super.onBreak(world, pos, state, player);
    }

    private void removeOtherParts(
            World world,
            BlockPos brokenPos,
            BlockState brokenState
    ) {
        BlockPos origin = getOrigin(brokenPos, brokenState);

        for (Part part : Part.values()) {
            BlockPos partPos = getPartPos(origin, part);

            if (partPos.equals(brokenPos)) {
                continue;
            }

            BlockState partState = world.getBlockState(partPos);

            if (partState.isOf(this)
                    && partState.get(PART) == part) {
                world.setBlockState(
                        partPos,
                        Blocks.AIR.getDefaultState(),
                        Block.NOTIFY_LISTENERS
                );
            }
        }
    }

    public BlockPos getOrigin(
            BlockPos pos,
            BlockState state
    ) {
        return switch (state.get(PART)) {
            case BOTTOM -> pos;
            case MIDDLE -> pos.down();
            case TOP -> pos.down(2);
        };
    }

    public BlockPos getPartPos(
            BlockPos origin,
            Part part
    ) {
        return origin.up(part.getYOffset());
    }

    private boolean isExpectedPart(
            BlockView world,
            BlockPos pos,
            Part expectedPart
    ) {
        BlockState state = world.getBlockState(pos);

        return state.isOf(this)
                && state.get(PART) == expectedPart;
    }

    @Override
    public VoxelShape getOutlineShape(
            BlockState state,
            BlockView world,
            BlockPos pos,
            ShapeContext context
    ) {
        return SHAPE;
    }

    public enum Part implements StringIdentifiable {
        BOTTOM("bottom", 0),
        MIDDLE("middle", 1),
        TOP("top", 2);

        private final String name;
        private final int yOffset;

        Part(String name, int yOffset) {
            this.name = name;
            this.yOffset = yOffset;
        }

        @Override
        public String asString() {
            return this.name;
        }

        public int getYOffset() {
            return this.yOffset;
        }
    }
}