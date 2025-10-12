package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) { super(output, registriesFuture); }
    @Override protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(BlockInit.TUFF_STAIRS)
                .add(BlockInit.CALCITE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(BlockInit.TUFF_SLAB)
                .add(BlockInit.CALCITE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(BlockInit.TUFF_WALL)
                .add(BlockInit.CALCITE_WALL);
        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(BlockInit.CALCITE_BUTTON)
                .add(BlockInit.TUFF_BUTTON)
                .add(BlockInit.DIORITE_BUTTON)
                .add(BlockInit.GRANITE_BUTTON);
        getOrCreateTagBuilder(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON)
                .add(BlockInit.BOOK_STACK);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(BlockInit.BLACK_SEAT)
                .add(BlockInit.WHITE_SEAT)
                .add(BlockInit.ORANGE_SEAT)
                .add(BlockInit.LIGHT_BLUE_SEAT)
                .add(BlockInit.YELLOW_SEAT)
                .add(BlockInit.LIME_SEAT)
                .add(BlockInit.PINK_SEAT)
                .add(BlockInit.GRAY_SEAT)
                .add(BlockInit.LIGHT_GRAY_SEAT)
                .add(BlockInit.CYAN_SEAT)
                .add(BlockInit.BLUE_SEAT)
                .add(BlockInit.PURPLE_SEAT)
                .add(BlockInit.BROWN_SEAT)
                .add(BlockInit.GREEN_SEAT)
                .add(BlockInit.RED_SEAT)
                .add(BlockInit.GREEN_SEAT)
                .add(BlockInit.MAGENTA_SEAT);
    }
}
