package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool calcitePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CALCITE);
        calcitePool.stairs(BlockInit.CALCITE_STAIRS);
        calcitePool.slab(BlockInit.CALCITE_SLAB);
        calcitePool.wall(BlockInit.CALCITE_WALL);
        calcitePool.button(BlockInit.CALCITE_BUTTON);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.CHISELED_CALCITE);
        BlockStateModelGenerator.BlockTexturePool granitePool =blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.GRANITE);
        granitePool.button(BlockInit.GRANITE_BUTTON);
        BlockStateModelGenerator.BlockTexturePool smoothCalcitePool = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockInit.SMOOTH_CALCITE);
        smoothCalcitePool.stairs(BlockInit.SMOOTH_CALCITE_STAIRS);
        smoothCalcitePool.slab(BlockInit.SMOOTH_CALCITE_SLAB);
        smoothCalcitePool.wall(BlockInit.SMOOTH_CALCITE_WALL);
        smoothCalcitePool.button(BlockInit.SMOOTH_CALCITE_BUTTON);
        BlockStateModelGenerator.BlockTexturePool dioritePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.DIORITE);
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
