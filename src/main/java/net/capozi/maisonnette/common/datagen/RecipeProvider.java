package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.CALCITE_SLAB, Blocks.CALCITE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.CALCITE_STAIRS, Blocks.CALCITE, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.CALCITE_WALL, Blocks.CALCITE, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.CALCITE_BUTTON, Blocks.CALCITE, 3);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.CALCITE_BRICKS, Blocks.CALCITE, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.CHISELED_CALCITE, Blocks.CALCITE, 1);
    }
}
