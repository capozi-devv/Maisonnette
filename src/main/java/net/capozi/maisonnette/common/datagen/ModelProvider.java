package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.common.block.BookStackBlock;
import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static net.capozi.maisonnette.Maisonnette.MOD_ID;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) { super(output); }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool calcitePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CALCITE);
        calcitePool.stairs(BlockInit.CALCITE_STAIRS);
        calcitePool.slab(BlockInit.CALCITE_SLAB);
        calcitePool.wall(BlockInit.CALCITE_WALL);
        calcitePool.button(BlockInit.CALCITE_BUTTON);
        BlockStateModelGenerator.BlockTexturePool tuffPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.TUFF);
        tuffPool.button(BlockInit.TUFF_BUTTON);
        tuffPool.wall(BlockInit.TUFF_WALL);
        tuffPool.slab(BlockInit.TUFF_SLAB);
        tuffPool.stairs(BlockInit.TUFF_STAIRS);
        generateBookStacks(blockStateModelGenerator);
        blockStateModelGenerator.registerLog(BlockInit.WILLOW_LOG).log(BlockInit.WILLOW_LOG).wood(BlockInit.WILLOW_WOOD);
        blockStateModelGenerator.registerLog(BlockInit.STRIPPED_WILLOW_LOG).log(BlockInit.STRIPPED_WILLOW_LOG).wood(BlockInit.STRIPPED_WILLOW_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.RED_WILLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.ORANGE_WILLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.YELLOW_WILLOW_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.WISTERIA_LEAVES);
//        blockStateModelGenerator.registerTintableCross(BlockInit.RED_WILLOW_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
//        blockStateModelGenerator.registerTintableCross(BlockInit.ORANGE_WILLOW_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
//        blockStateModelGenerator.registerTintableCross(BlockInit.YELLOW_WILLOW_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
//        blockStateModelGenerator.registerTintableCross(BlockInit.CARNATION, BlockStateModelGenerator.TintType.NOT_TINTED);
//        blockStateModelGenerator.registerTintableCross(BlockInit.COLOSSAL_HIBISCUS_BLOOMLING, BlockStateModelGenerator.TintType.NOT_TINTED);
//        blockStateModelGenerator.registerTintableCross(BlockInit.BLACK_STARLETTE, BlockStateModelGenerator.TintType.NOT_TINTED);
//        blockStateModelGenerator.registerTintableCross(BlockInit.ORANGE_STARLETTE, BlockStateModelGenerator.TintType.NOT_TINTED);
//        blockStateModelGenerator.registerTintableCross(BlockInit.YELLOW_STARLETTE, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(BlockInit.BLACK_STARLETTE, BlockInit.POTTED_BLACK_STARLETTE, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(BlockInit.ORANGE_STARLETTE, BlockInit.POTTED_ORANGE_STARLETTE, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(BlockInit.YELLOW_STARLETTE, BlockInit.POTTED_YELLOW_STARLETTE, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(BlockInit.CARNATION, BlockInit.POTTED_CARNATION, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(BlockInit.COLOSSAL_HIBISCUS_BLOOMLING, BlockInit.POTTED_COLOSSAL_HIBISCUS_BLOOMLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(BlockInit.RED_WILLOW_SAPLING, BlockInit.POTTED_RED_WILLOW_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(BlockInit.ORANGE_WILLOW_SAPLING, BlockInit.POTTED_ORANGE_WILLOW_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(BlockInit.YELLOW_WILLOW_SAPLING, BlockInit.POTTED_YELLOW_WILLOW_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(BlockInit.WISTERIA_SAPLING, BlockInit.POTTED_WISTERIA_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.WIRED_GREENHOUSE_GLASS);
        BlockStateModelGenerator.BlockTexturePool willowPool = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockInit.WILLOW_PLANKS);
        willowPool.button(BlockInit.WILLOW_BUTTON);
        willowPool.pressurePlate(BlockInit.WILLOW_PRESSURE_PLATE);
        willowPool.fence(BlockInit.WILLOW_FENCE);
        willowPool.fenceGate(BlockInit.WILLOW_FENCE_GATE);
        willowPool.slab(BlockInit.WILLOW_SLAB);
        willowPool.stairs(BlockInit.WILLOW_STAIRS);
        blockStateModelGenerator.registerDoor(BlockInit.WILLOW_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(BlockInit.WILLOW_TRAPDOOR);
        blockStateModelGenerator.registerLog(BlockInit.WISTERIA_LOG).log(BlockInit.WISTERIA_LOG).wood(BlockInit.WISTERIA_WOOD);
        blockStateModelGenerator.registerLog(BlockInit.STRIPPED_WISTERIA_LOG).log(BlockInit.STRIPPED_WISTERIA_LOG).wood(BlockInit.STRIPPED_WISTERIA_WOOD);
        BlockStateModelGenerator.BlockTexturePool wisteriaPool = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockInit.WISTERIA_PLANKS);
        wisteriaPool.button(BlockInit.WISTERIA_BUTTON);
        wisteriaPool.pressurePlate(BlockInit.WISTERIA_PRESSURE_PLATE);
        wisteriaPool.fence(BlockInit.WISTERIA_FENCE);
        wisteriaPool.fenceGate(BlockInit.WISTERIA_FENCE_GATE);
        wisteriaPool.slab(BlockInit.WISTERIA_SLAB);
        wisteriaPool.stairs(BlockInit.WISTERIA_STAIRS);
        blockStateModelGenerator.registerDoor(BlockInit.WISTERIA_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(BlockInit.WISTERIA_TRAPDOOR);
        BlockStateModelGenerator.BlockTexturePool charredPool = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockInit.CHARRED_PLANKS);
        charredPool.button(BlockInit.CHARRED_BUTTON);
        charredPool.pressurePlate(BlockInit.CHARRED_PRESSURE_PLATE);
        charredPool.fence(BlockInit.CHARRED_FENCE);
        charredPool.fenceGate(BlockInit.CHARRED_FENCE_GATE);
        charredPool.slab(BlockInit.CHARRED_SLAB);
        charredPool.stairs(BlockInit.CHARRED_STAIRS);
        blockStateModelGenerator.registerDoor(BlockInit.CHARRED_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(BlockInit.CHARRED_TRAPDOOR);
        blockStateModelGenerator.registerLog(BlockInit.CHARRED_LOG).log(BlockInit.CHARRED_LOG).wood(BlockInit.CHARRED_WOOD);
        blockStateModelGenerator.registerLog(BlockInit.STRIPPED_CHARRED_LOG).log(BlockInit.STRIPPED_CHARRED_LOG).wood(BlockInit.STRIPPED_CHARRED_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.ORANGE_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.MAGENTA_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.LIGHT_BLUE_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.YELLOW_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.LIME_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.PINK_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.GRAY_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.LIGHT_GRAY_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.CYAN_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.PURPLE_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.BLUE_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.BROWN_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.GREEN_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.RED_STAINED_GREENHOUSE_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.BLACK_STAINED_GREENHOUSE_GLASS);
    }
    @Override public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
    public static final TextureKey BOOK = TextureKey.of("book");
    private void generateBookStacks(BlockStateModelGenerator generator) {
        List<VariantSettings.Rotation> rots = List.of(VariantSettings.Rotation.R0, VariantSettings.Rotation.R90, VariantSettings.Rotation.R180, VariantSettings.Rotation.R270);
        MultipartBlockStateSupplier multipartBlockStateSupplier = MultipartBlockStateSupplier.create(BlockInit.BOOK_STACK);
        for (int height = 0; height <= 3; height++) {
            ArrayList<Identifier> models = new ArrayList<>();
            for (int i = 0; i <= 8; i++) { // change this value to adjust the number of styles
                for (int rotation = 0; rotation <= 3; rotation++) {
                    String parentModel = "block/template_book_stack_" + height + "_r" + rotation;
                    Identifier modelId = new Identifier(MOD_ID, "block/book_stack_" + i + "_" + height + "_r" + rotation);
                    Identifier texture = new Identifier(MOD_ID, "block/book_stack/book_" + i);
                    Model model = new Model(
                            Optional.of(new Identifier(MOD_ID, parentModel)),
                            Optional.empty(),
                            BOOK
                    );
                    model.upload(
                            modelId, // output model path
                            TextureMap.of(BOOK, texture),
                            generator.modelCollector // required for writing the file
                    );
                    models.add(modelId);
                }
            }
            ArrayList<BlockStateVariant> blockStateVariants = new ArrayList<>();
            for (VariantSettings.Rotation rot: rots) {
                for (Identifier i : models) {
                    BlockStateVariant blockStateVariant = BlockStateVariant.create();
                    blockStateVariant.put(VariantSettings.MODEL, i);
                    blockStateVariant.put(VariantSettings.Y,rot);
                    blockStateVariants.add(blockStateVariant);
                }
            }
            Collections.shuffle(blockStateVariants);
            for (int i = height+1; i <= 4; i++) {
                multipartBlockStateSupplier.with(When.create().set(BookStackBlock.BOOKS, i), blockStateVariants);
            }
        }
        generator.blockStateCollector.accept(multipartBlockStateSupplier);
    }
}
