package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) { super(output, registriesFuture); }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(BlockInit.WILLOW_STAIRS)
                .add(BlockInit.CHARRED_STAIRS)
                .add(BlockInit.TUFF_STAIRS)
                .add(BlockInit.CALCITE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(BlockInit.WILLOW_SLAB)
                .add(BlockInit.CHARRED_SLAB)
                .add(BlockInit.TUFF_SLAB)
                .add(BlockInit.CALCITE_SLAB);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(BlockInit.TUFF_WALL)
                .add(BlockInit.CALCITE_WALL);
        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(BlockInit.WILLOW_BUTTON)
                .add(BlockInit.CHARRED_BUTTON)
                .add(BlockInit.CALCITE_BUTTON)
                .add(BlockInit.TUFF_BUTTON);
        getOrCreateTagBuilder(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON)
                .add(BlockInit.BOOK_STACK);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(BlockInit.WILLOW_LOG)
                .add(BlockInit.STRIPPED_WILLOW_LOG)
                .add(BlockInit.WILLOW_WOOD)
                .add(BlockInit.STRIPPED_WILLOW_WOOD)
                .add(BlockInit.WILLOW_PLANKS)
                .add(BlockInit.RED_WILLOW_LEAVES)
                .add(BlockInit.ORANGE_WILLOW_LEAVES)
                .add(BlockInit.YELLOW_WILLOW_LEAVES)
                .add(BlockInit.RED_WILLOW_SAPLING)
                .add(BlockInit.ORANGE_WILLOW_SAPLING)
                .add(BlockInit.YELLOW_WILLOW_SAPLING)
                .add(BlockInit.WILLOW_SLAB)
                .add(BlockInit.WILLOW_STAIRS)
                .add(BlockInit.WILLOW_FENCE)
                .add(BlockInit.WILLOW_FENCE_GATE)
                .add(BlockInit.WILLOW_BUTTON)
                .add(BlockInit.WILLOW_PRESSURE_PLATE)
                .add(BlockInit.WILLOW_DOOR)
                .add(BlockInit.WILLOW_TRAPDOOR)
                .add(BlockInit.CHARRED_LOG)
                .add(BlockInit.STRIPPED_CHARRED_LOG)
                .add(BlockInit.CHARRED_WOOD)
                .add(BlockInit.STRIPPED_CHARRED_WOOD)
                .add(BlockInit.CHARRED_PLANKS)
                .add(BlockInit.CHARRED_SLAB)
                .add(BlockInit.CHARRED_STAIRS)
                .add(BlockInit.CHARRED_FENCE)
                .add(BlockInit.CHARRED_FENCE_GATE)
                .add(BlockInit.CHARRED_BUTTON)
                .add(BlockInit.CHARRED_PRESSURE_PLATE)
                .add(BlockInit.CHARRED_DOOR)
                .add(BlockInit.CHARRED_TRAPDOOR)
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
                .add(BlockInit.MAGENTA_SEAT)
                .add(BlockInit.BOOK_STACK);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(BlockInit.WILLOW_LOG)
                .add(BlockInit.STRIPPED_WILLOW_LOG)
                .add(BlockInit.WILLOW_WOOD)
                .add(BlockInit.STRIPPED_WILLOW_WOOD);
        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(BlockInit.CHARRED_LOG)
                .add(BlockInit.STRIPPED_CHARRED_LOG)
                .add(BlockInit.CHARRED_WOOD)
                .add(BlockInit.STRIPPED_CHARRED_WOOD)
                .add(BlockInit.WILLOW_LOG)
                .add(BlockInit.STRIPPED_WILLOW_LOG)
                .add(BlockInit.WILLOW_WOOD)
                .add(BlockInit.STRIPPED_WILLOW_WOOD);
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(BlockInit.ORANGE_WILLOW_LEAVES)
                .add(BlockInit.RED_WILLOW_LEAVES)
                .add(BlockInit.YELLOW_WILLOW_LEAVES);
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(BlockInit.CHARRED_FENCE)
                .add(BlockInit.WILLOW_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(BlockInit.CHARRED_FENCE_GATE)
                .add(BlockInit.WILLOW_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(BlockInit.CHARRED_TRAPDOOR)
                .add(BlockInit.WILLOW_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(BlockInit.WILLOW_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(BlockInit.CHARRED_DOOR)
                .add(BlockInit.WILLOW_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(BlockInit.WILLOW_DOOR);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(BlockInit.CHARRED_PRESSURE_PLATE)
                .add(BlockInit.WILLOW_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(BlockInit.WILLOW_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.ENCHANTMENT_POWER_PROVIDER)
                .add(BlockInit.BOOK_STACK);
        getOrCreateTagBuilder(BlockTags.ENCHANTMENT_POWER_TRANSMITTER)
                .add(BlockInit.BOOK_STACK);
        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(BlockInit.COLOSSAL_HIBISCUS);
    }
}
