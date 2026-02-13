package net.capozi.maisonnette.mixin.access;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(AbstractBlock.class)
public interface AbstractBlockAccessor {
    @Invoker("canPlaceAt")
    boolean invokeCanPlaceAt(BlockState state, WorldView world, BlockPos pos);
}
