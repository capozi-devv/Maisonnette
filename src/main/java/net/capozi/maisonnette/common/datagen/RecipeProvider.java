package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

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
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.GRANITE_BUTTON, Blocks.GRANITE, 3);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.TUFF_SLAB, Blocks.TUFF, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.TUFF_STAIRS, Blocks.TUFF, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.TUFF_BRICKS, Blocks.TUFF, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.TUFF_BUTTON, Blocks.TUFF, 3);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.CHISELED_TUFF, Blocks.TUFF, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.TUFF_WALL, Blocks.TUFF, 1);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.COPPER_TORCHBULB, 1)
                .pattern("CCC")
                .pattern("RFR")
                .pattern("CGC")
                .input('C', Items.COPPER_INGOT)
                .input('R', Items.REDSTONE)
                .input('F', Items.CAMPFIRE)
                .input('G', Items.GLASS_PANE)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.COPPER_TORCHBULB)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.COPPER_SOULBULB, 1)
                .pattern("CCC")
                .pattern("RFR")
                .pattern("CGC")
                .input('C', Items.COPPER_INGOT)
                .input('R', Items.REDSTONE)
                .input('F', Items.CAMPFIRE)
                .input('G', Items.GLASS_PANE)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.COPPER_SOULBULB)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.WHITE_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.WHITE_WOOL)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.WHITE_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.ORANGE_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.ORANGE_WOOL)
                .criterion(hasItem(Items.ORANGE_WOOL), conditionsFromItem(Items.ORANGE_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.ORANGE_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.MAGENTA_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.MAGENTA_WOOL)
                .criterion(hasItem(Items.MAGENTA_WOOL), conditionsFromItem(Items.MAGENTA_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.MAGENTA_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.LIGHT_BLUE_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.LIGHT_BLUE_WOOL)
                .criterion(hasItem(Items.LIGHT_BLUE_WOOL), conditionsFromItem(Items.LIGHT_BLUE_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.LIGHT_BLUE_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.YELLOW_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.YELLOW_WOOL)
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.YELLOW_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.LIME_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.LIME_WOOL)
                .criterion(hasItem(Items.LIME_WOOL), conditionsFromItem(Items.LIME_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.LIME_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.PINK_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.PINK_WOOL)
                .criterion(hasItem(Items.PINK_WOOL), conditionsFromItem(Items.PINK_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.PINK_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.GRAY_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.GRAY_WOOL)
                .criterion(hasItem(Items.GRAY_WOOL), conditionsFromItem(Items.GRAY_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.GRAY_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.LIGHT_GRAY_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.LIGHT_GRAY_WOOL)
                .criterion(hasItem(Items.LIGHT_GRAY_WOOL), conditionsFromItem(Items.LIGHT_GRAY_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.LIGHT_GRAY_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.CYAN_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.CYAN_WOOL)
                .criterion(hasItem(Items.CYAN_WOOL), conditionsFromItem(Items.CYAN_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.CYAN_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.PURPLE_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.PURPLE_WOOL)
                .criterion(hasItem(Items.PURPLE_WOOL), conditionsFromItem(Items.PURPLE_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.PURPLE_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.BLUE_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.BLUE_WOOL)
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.BLUE_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.BROWN_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.BROWN_WOOL)
                .criterion(hasItem(Items.BROWN_WOOL), conditionsFromItem(Items.BROWN_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.BROWN_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.GREEN_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.GREEN_WOOL)
                .criterion(hasItem(Items.GREEN_WOOL), conditionsFromItem(Items.GREEN_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.GREEN_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.RED_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.RED_WOOL)
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.RED_SEAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.BLACK_SEAT, 1)
                .pattern("   ")
                .pattern("WNW")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', Items.BLACK_WOOL)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.BLACK_SEAT)));
    }
}
