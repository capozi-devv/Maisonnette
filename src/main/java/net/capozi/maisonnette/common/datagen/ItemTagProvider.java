package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(BlockInit.CHARRED_PLANKS.asItem())
                .add(BlockInit.WILLOW_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(BlockInit.WILLOW_LOG.asItem())
                .add(BlockInit.STRIPPED_WILLOW_LOG.asItem())
                .add(BlockInit.WILLOW_WOOD.asItem())
                .add(BlockInit.STRIPPED_WILLOW_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(BlockInit.WILLOW_LOG.asItem())
                .add(BlockInit.STRIPPED_WILLOW_LOG.asItem())
                .add(BlockInit.WILLOW_WOOD.asItem())
                .add(BlockInit.STRIPPED_WILLOW_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(BlockInit.CHARRED_LOG.asItem())
                .add(BlockInit.STRIPPED_CHARRED_LOG.asItem())
                .add(BlockInit.CHARRED_WOOD.asItem())
                .add(BlockInit.STRIPPED_CHARRED_WOOD.asItem())
                .add(BlockInit.WILLOW_LOG.asItem())
                .add(BlockInit.STRIPPED_WILLOW_LOG.asItem())
                .add(BlockInit.WILLOW_WOOD.asItem())
                .add(BlockInit.STRIPPED_WILLOW_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(BlockInit.ORANGE_WILLOW_LEAVES.asItem())
                .add(BlockInit.RED_WILLOW_LEAVES.asItem())
                .add(BlockInit.YELLOW_WILLOW_LEAVES.asItem());
        getOrCreateTagBuilder(ItemTags.FENCES)
                .add(BlockInit.CHARRED_FENCE.asItem())
                .add(BlockInit.WILLOW_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(BlockInit.CHARRED_FENCE_GATE.asItem())
                .add(BlockInit.WILLOW_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.TRAPDOORS)
                .add(BlockInit.CHARRED_TRAPDOOR.asItem())
                .add(BlockInit.WILLOW_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(BlockInit.WILLOW_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.DOORS)
                .add(BlockInit.CHARRED_DOOR.asItem())
                .add(BlockInit.WILLOW_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(BlockInit.WILLOW_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(BlockInit.WILLOW_PRESSURE_PLATE.asItem());
    }
}
