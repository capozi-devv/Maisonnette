package net.capozi.maisonnette.common.datagen;

import devv.capozi.zip.common.datagen.RecipeUtils;
import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.*;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput dataOutput) { super(dataOutput); }
    private Ingredient willowIngredient = Ingredient.ofItems(BlockInit.WILLOW_PLANKS);
    private Ingredient charredIngredient = Ingredient.ofItems(BlockInit.CHARRED_PLANKS);
    public static void offerWoodSet(Consumer<RecipeJsonProvider> consumer, String modid, Ingredient woodIngredient, Block planks, SlabBlock slab, PressurePlateBlock pressurePlateBlock, ButtonBlock buttonBlock, DoorBlock doorBlock, FenceBlock fenceBlock, FenceGateBlock fenceGateBlock, StairsBlock stairsBlock, TrapdoorBlock trapdoorBlock) {
        offerSlabRecipe(consumer, RecipeCategory.DECORATIONS, slab, planks);
        offerPressurePlateRecipe(consumer, pressurePlateBlock, planks);
        offerShapelessRecipe(consumer, buttonBlock, planks, modid, 1);
        createDoorRecipe(doorBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.WOODEN_DOORS)).offerTo(consumer);
        createFenceRecipe(fenceBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.WOODEN_FENCES)).offerTo(consumer);
        createFenceGateRecipe(fenceGateBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.FENCE_GATES)).offerTo(consumer);
        createStairsRecipe(stairsBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.WOODEN_STAIRS)).offerTo(consumer);
        createTrapdoorRecipe(trapdoorBlock, woodIngredient).criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.WOODEN_TRAPDOORS)).offerTo(consumer);
    }
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.CALCITE_SLAB, Blocks.CALCITE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.CALCITE_STAIRS, Blocks.CALCITE, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.CALCITE_WALL, Blocks.CALCITE, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.CALCITE_BUTTON, Blocks.CALCITE, 3);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.TUFF_SLAB, Blocks.TUFF, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.TUFF_STAIRS, Blocks.TUFF, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.TUFF_BUTTON, Blocks.TUFF, 3);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.TUFF_WALL, Blocks.TUFF, 1);
        offerShapelessRecipe(exporter, BlockInit.WILLOW_PLANKS, BlockInit.WILLOW_LOG, Maisonnette.MOD_ID, 4);
        offerShapelessRecipe(exporter, BlockInit.CHARRED_PLANKS, BlockInit.CHARRED_LOG, Maisonnette.MOD_ID, 4);
        offerShapelessRecipe(exporter, BlockInit.CHARRED_PLANKS, BlockInit.STRIPPED_CHARRED_LOG, Maisonnette.MOD_ID, 4);
        offerShapelessRecipe(exporter, BlockInit.WILLOW_PLANKS, BlockInit.STRIPPED_WILLOW_LOG, Maisonnette.MOD_ID, 4);
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.PLANKS), RecipeCategory.FOOD, BlockInit.CHARRED_PLANKS, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_PLANKS), conditionsFromItem(BlockInit.CHARRED_PLANKS)).offerTo(exporter);
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_PRESSURE_PLATES), RecipeCategory.FOOD, BlockInit.CHARRED_PRESSURE_PLATE, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_PRESSURE_PLATE), conditionsFromItem(BlockInit.CHARRED_PRESSURE_PLATE)).offerTo(exporter);
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_BUTTONS), RecipeCategory.FOOD, BlockInit.CHARRED_BUTTON, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_BUTTON), conditionsFromItem(BlockInit.CHARRED_BUTTON)).offerTo(exporter);
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_DOORS), RecipeCategory.FOOD, BlockInit.CHARRED_DOOR, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_DOOR), conditionsFromItem(BlockInit.CHARRED_DOOR)).offerTo(exporter);
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_TRAPDOORS), RecipeCategory.FOOD, BlockInit.CHARRED_TRAPDOOR, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_TRAPDOOR), conditionsFromItem(BlockInit.CHARRED_TRAPDOOR)).offerTo(exporter);
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_SLABS), RecipeCategory.FOOD, BlockInit.CHARRED_SLAB, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_SLAB), conditionsFromItem(BlockInit.CHARRED_SLAB)).offerTo(exporter);
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_STAIRS), RecipeCategory.FOOD, BlockInit.CHARRED_STAIRS, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_STAIRS), conditionsFromItem(BlockInit.CHARRED_STAIRS)).offerTo(exporter);
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_FENCES), RecipeCategory.FOOD, BlockInit.CHARRED_FENCE, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_FENCE), conditionsFromItem(BlockInit.CHARRED_FENCE)).offerTo(exporter);
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.FENCE_GATES), RecipeCategory.FOOD, BlockInit.CHARRED_FENCE_GATE, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_FENCE_GATE), conditionsFromItem(BlockInit.CHARRED_FENCE_GATE)).offerTo(exporter);
        offerWoodSet(exporter, Maisonnette.MOD_ID, charredIngredient, BlockInit.CHARRED_PLANKS, (SlabBlock)BlockInit.CHARRED_SLAB, (PressurePlateBlock)BlockInit.CHARRED_PRESSURE_PLATE, (ButtonBlock) BlockInit.CHARRED_BUTTON, (DoorBlock) BlockInit.CHARRED_DOOR, (FenceBlock) BlockInit.CHARRED_FENCE, (FenceGateBlock) BlockInit.CHARRED_FENCE_GATE, (StairsBlock) BlockInit.CHARRED_STAIRS, (TrapdoorBlock) BlockInit.CHARRED_TRAPDOOR);
        offerSlabRecipe(exporter, RecipeCategory.DECORATIONS, BlockInit.WILLOW_SLAB, BlockInit.WILLOW_PLANKS);
        offerPressurePlateRecipe(exporter, BlockInit.WILLOW_PRESSURE_PLATE, BlockInit.WILLOW_PLANKS);
        offerShapelessRecipe(exporter, BlockInit.WILLOW_BUTTON, BlockInit.WILLOW_PLANKS, Maisonnette.MOD_ID, 1);
        createDoorRecipe(BlockInit.WILLOW_DOOR, willowIngredient);
        createFenceRecipe(BlockInit.WILLOW_FENCE, willowIngredient);
        createFenceGateRecipe(BlockInit.WILLOW_FENCE_GATE, willowIngredient);
        createStairsRecipe(BlockInit.WILLOW_STAIRS, willowIngredient);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.COPPER_TORCHBULB, 1)
                .pattern("CGC")
                .pattern("RFR")
                .pattern("CRC")
                .input('C', Items.COPPER_INGOT)
                .input('R', Items.REDSTONE)
                .input('F', Items.CAMPFIRE)
                .input('G', Items.GLASS_PANE)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.COPPER_TORCHBULB)));
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
