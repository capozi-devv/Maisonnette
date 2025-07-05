package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(BlockInit.SMOOTH_CALCITE_STAIRS)
                .add(BlockInit.CALCITE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(BlockInit.SMOOTH_CALCITE_SLAB)
                .add(BlockInit.CALCITE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(BlockInit.SMOOTH_CALCITE_WALL)
                .add(BlockInit.CALCITE_WALL);
        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(BlockInit.CALCITE_BUTTON)
                .add(BlockInit.SMOOTH_CALCITE_BUTTON)
                .add(BlockInit.DIORITE_BUTTON)
                .add(BlockInit.GRANITE_BUTTON);
    }
}
