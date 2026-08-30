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
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class RecipeProvider extends FabricRecipeProvider {
    private static final TagKey<Item> GLASS_BLOCKS = TagKey.of(RegistryKeys.ITEM, new Identifier(Maisonnette.MOD_ID, "glass_blocks"));
    public RecipeProvider(FabricDataOutput dataOutput) { super(dataOutput); }
    private final Ingredient willowIngredient = Ingredient.ofItems(BlockInit.WILLOW_PLANKS);
    private final Ingredient charredIngredient = Ingredient.ofItems(BlockInit.CHARRED_PLANKS);
    private final Ingredient wisteriaIngredient = Ingredient.ofItems(BlockInit.WISTERIA_PLANKS);
    private void offerSeat(Consumer<RecipeJsonProvider> exporter, Block seat, Block wool) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, seat, 1)
                .pattern(" N ")
                .pattern(" W ")
                .pattern(" P ")
                .input('P', ItemTags.PLANKS)
                .input('N', Items.GOLD_NUGGET)
                .input('W', wool)
                .criterion(hasItem(wool), conditionsFromItem(wool))
                .offerTo(exporter, new Identifier(getRecipeName(seat)));
    }
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.GREENHOUSE_GLASS, 1)
                .pattern(" D ")
                .pattern("DGD")
                .pattern(" D ")
                .input('D', Items.WHITE_DYE)
                .input('G', GLASS_BLOCKS)
                .criterion(hasItem(Items.GLASS), conditionsFromTag(GLASS_BLOCKS))
                .offerTo(exporter, new Identifier(Maisonnette.MOD_ID, "greenhouse_glass"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.WIRED_GREENHOUSE_GLASS, 1)
                .pattern(" N ")
                .pattern("NGN")
                .pattern(" N ")
                .input('N', Items.IRON_NUGGET)
                .input('G', BlockInit.GREENHOUSE_GLASS)
                .criterion(hasItem(BlockInit.GREENHOUSE_GLASS), conditionsFromItem(BlockInit.GREENHOUSE_GLASS))
                .offerTo(exporter, new Identifier(Maisonnette.MOD_ID, "wired_greenhouse_glass"));
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
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.PLANKS), RecipeCategory.DECORATIONS, BlockInit.CHARRED_PLANKS, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_PLANKS), conditionsFromItem(BlockInit.CHARRED_PLANKS)).offerTo(exporter, new Identifier(getRecipeName(BlockInit.CHARRED_PLANKS) + "_campfire"));
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.LOGS_THAT_BURN), RecipeCategory.DECORATIONS, BlockInit.CHARRED_LOG, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_PLANKS), conditionsFromItem(BlockInit.CHARRED_PLANKS)).offerTo(exporter,new Identifier(getRecipeName(BlockInit.CHARRED_LOG) + "_campfire"));
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_PRESSURE_PLATES), RecipeCategory.DECORATIONS, BlockInit.CHARRED_PRESSURE_PLATE, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_PRESSURE_PLATE), conditionsFromItem(BlockInit.CHARRED_PRESSURE_PLATE)).offerTo(exporter, new Identifier(getRecipeName(BlockInit.CHARRED_PRESSURE_PLATE) + "_campfire"));
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_BUTTONS), RecipeCategory.DECORATIONS, BlockInit.CHARRED_BUTTON, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_BUTTON), conditionsFromItem(BlockInit.CHARRED_BUTTON)).offerTo(exporter, new Identifier(getRecipeName(BlockInit.CHARRED_BUTTON) + "_campfire"));
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_DOORS), RecipeCategory.DECORATIONS, BlockInit.CHARRED_DOOR, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_DOOR), conditionsFromItem(BlockInit.CHARRED_DOOR)).offerTo(exporter, new Identifier(getRecipeName(BlockInit.CHARRED_DOOR) + "_campfire"));
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_TRAPDOORS), RecipeCategory.DECORATIONS, BlockInit.CHARRED_TRAPDOOR, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_TRAPDOOR), conditionsFromItem(BlockInit.CHARRED_TRAPDOOR)).offerTo(exporter, new Identifier(getRecipeName(BlockInit.CHARRED_TRAPDOOR) + "_campfire"));
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_SLABS), RecipeCategory.DECORATIONS, BlockInit.CHARRED_SLAB, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_SLAB), conditionsFromItem(BlockInit.CHARRED_SLAB)).offerTo(exporter, new Identifier(getRecipeName(BlockInit.CHARRED_SLAB) + "_campfire"));
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_STAIRS), RecipeCategory.DECORATIONS, BlockInit.CHARRED_STAIRS, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_STAIRS), conditionsFromItem(BlockInit.CHARRED_STAIRS)).offerTo(exporter, new Identifier(getRecipeName(BlockInit.CHARRED_STAIRS) + "_campfire"));
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.WOODEN_FENCES), RecipeCategory.DECORATIONS, BlockInit.CHARRED_FENCE, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_FENCE), conditionsFromItem(BlockInit.CHARRED_FENCE)).offerTo(exporter, new Identifier(getRecipeName(BlockInit.CHARRED_FENCE) + "_campfire"));
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.fromTag(ItemTags.FENCE_GATES), RecipeCategory.DECORATIONS, BlockInit.CHARRED_FENCE_GATE, 0.35f, 600).criterion(hasItem(BlockInit.CHARRED_FENCE_GATE), conditionsFromItem(BlockInit.CHARRED_FENCE_GATE)).offerTo(exporter, new Identifier(getRecipeName(BlockInit.CHARRED_FENCE_GATE) + "_campfire"));
        RecipeUtils.offerWoodSet(exporter, Maisonnette.MOD_ID, willowIngredient, BlockInit.WILLOW_PLANKS, (SlabBlock) BlockInit.WILLOW_SLAB, (PressurePlateBlock) BlockInit.WILLOW_PRESSURE_PLATE, (ButtonBlock) BlockInit.WILLOW_BUTTON, (DoorBlock) BlockInit.WILLOW_DOOR, (FenceBlock) BlockInit.WILLOW_FENCE, (FenceGateBlock) BlockInit.WILLOW_FENCE_GATE, (StairsBlock) BlockInit.WILLOW_STAIRS, (TrapdoorBlock) BlockInit.WILLOW_TRAPDOOR);
        RecipeUtils.offerWoodSet(exporter, Maisonnette.MOD_ID, charredIngredient, BlockInit.CHARRED_PLANKS, (SlabBlock) BlockInit.CHARRED_SLAB, (PressurePlateBlock) BlockInit.CHARRED_PRESSURE_PLATE, (ButtonBlock) BlockInit.CHARRED_BUTTON, (DoorBlock) BlockInit.CHARRED_DOOR, (FenceBlock) BlockInit.CHARRED_FENCE, (FenceGateBlock) BlockInit.CHARRED_FENCE_GATE, (StairsBlock) BlockInit.CHARRED_STAIRS, (TrapdoorBlock) BlockInit.CHARRED_TRAPDOOR);
        RecipeUtils.offerWoodSet(exporter, Maisonnette.MOD_ID, wisteriaIngredient, BlockInit.WISTERIA_PLANKS, (SlabBlock) BlockInit.WISTERIA_SLAB, (PressurePlateBlock) BlockInit.WISTERIA_PRESSURE_PLATE, (ButtonBlock) BlockInit.WISTERIA_BUTTON, (DoorBlock) BlockInit.WISTERIA_DOOR, (FenceBlock) BlockInit.WISTERIA_FENCE, (FenceGateBlock) BlockInit.WISTERIA_FENCE_GATE, (StairsBlock) BlockInit.WISTERIA_STAIRS, (TrapdoorBlock) BlockInit.WISTERIA_TRAPDOOR);
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
        offerSeat(exporter, BlockInit.WHITE_SEAT, Blocks.WHITE_WOOL);
        offerSeat(exporter, BlockInit.ORANGE_SEAT, Blocks.ORANGE_WOOL);
        offerSeat(exporter, BlockInit.MAGENTA_SEAT, Blocks.MAGENTA_WOOL);
        offerSeat(exporter, BlockInit.LIGHT_BLUE_SEAT, Blocks.LIGHT_BLUE_WOOL);
        offerSeat(exporter, BlockInit.YELLOW_SEAT, Blocks.YELLOW_WOOL);
        offerSeat(exporter, BlockInit.LIME_SEAT, Blocks.LIME_WOOL);
        offerSeat(exporter, BlockInit.PINK_SEAT, Blocks.PINK_WOOL);
        offerSeat(exporter, BlockInit.GRAY_SEAT, Blocks.GRAY_WOOL);
        offerSeat(exporter, BlockInit.LIGHT_GRAY_SEAT, Blocks.LIGHT_GRAY_WOOL);
        offerSeat(exporter, BlockInit.CYAN_SEAT, Blocks.CYAN_WOOL);
        offerSeat(exporter, BlockInit.PURPLE_SEAT, Blocks.PURPLE_WOOL);
        offerSeat(exporter, BlockInit.BLUE_SEAT, Blocks.BLUE_WOOL);
        offerSeat(exporter, BlockInit.BROWN_SEAT, Blocks.BROWN_WOOL);
        offerSeat(exporter, BlockInit.GREEN_SEAT, Blocks.GREEN_WOOL);
        offerSeat(exporter, BlockInit.RED_SEAT, Blocks.RED_WOOL);
        offerSeat(exporter, BlockInit.BLACK_SEAT, Blocks.BLACK_WOOL);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.WROUGHT_IRON_BARS, 1)
                .pattern(" N ")
                .pattern("N N")
                .pattern("III")
                .input('N', Items.IRON_NUGGET)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.WROUGHT_IRON_BARS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.WROUGHT_IRON_GATE, 1)
                .pattern("N N")
                .pattern("NIN")
                .pattern("I I")
                .input('N', Items.IRON_NUGGET)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(BlockInit.WROUGHT_IRON_GATE)));
        offerDyeableRecipes(exporter,
                List.of(
                        Items.ORANGE_DYE,
                        Items.MAGENTA_DYE,
                        Items.LIGHT_BLUE_DYE,
                        Items.YELLOW_DYE,
                        Items.LIME_DYE,
                        Items.PINK_DYE,
                        Items.GRAY_DYE,
                        Items.LIGHT_GRAY_DYE,
                        Items.CYAN_DYE,
                        Items.PURPLE_DYE,
                        Items.BLUE_DYE,
                        Items.BROWN_DYE,
                        Items.GREEN_DYE,
                        Items.RED_DYE,
                        Items.BLACK_DYE
                ),
                List.of(
                        BlockInit.ORANGE_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.MAGENTA_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.LIGHT_BLUE_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.YELLOW_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.LIME_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.PINK_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.GRAY_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.LIGHT_GRAY_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.CYAN_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.PURPLE_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.BLUE_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.BROWN_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.GREEN_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.RED_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.BLACK_STAINED_GREENHOUSE_GLASS.asItem(),
                        BlockInit.GREENHOUSE_GLASS.asItem()
                ),
                "greenhouse_glass"
        );
    }
}
