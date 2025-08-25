package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.common.block.BookStackBlock;
import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static net.capozi.maisonnette.Maisonnette.MOD_ID;

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
        BlockStateModelGenerator.BlockTexturePool dioritePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.DIORITE);
        dioritePool.button(BlockInit.DIORITE_BUTTON);
        BlockStateModelGenerator.BlockTexturePool tuffPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.TUFF);
        tuffPool.button(BlockInit.TUFF_BUTTON);
        tuffPool.wall(BlockInit.TUFF_WALL);
        tuffPool.slab(BlockInit.TUFF_SLAB);
        tuffPool.stairs(BlockInit.TUFF_STAIRS);
        generateBookStacks(blockStateModelGenerator);
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        
    }
    public static final TextureKey BOOK = TextureKey.of("book");
    private void generateBookStacks(BlockStateModelGenerator generator) {
        List<VariantSettings.Rotation> rots = List.of(VariantSettings.Rotation.R0, VariantSettings.Rotation.R90, VariantSettings.Rotation.R180, VariantSettings.Rotation.R270);
        MultipartBlockStateSupplier multipartBlockStateSupplier = MultipartBlockStateSupplier.create(BlockInit.BOOK_STACK);
        for (int height = 0; height <= 3; height++) {
            ArrayList<Identifier> models = new ArrayList<>();
            for (int i = 0; i <= 6; i++) {
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
    private void generateMosaics(BlockStateModelGenerator generator) {
        MultipartBlockStateSupplier multipartBlockStateSupplier = MultipartBlockStateSupplier.create(BlockInit.BOOK_STACK);
        for (int height = 1; height <= 4; height++) {
            ArrayList<Identifier> models = new ArrayList<>();
            for (int i = 0; i <= 6; i++) {
                for (int rotation = 0; rotation <= 5; rotation++) {
                    String parentModel = "block/template_mosaic_template_" + height + "_" + rotation;
                    Identifier modelId = new Identifier(MOD_ID, "block/template_mosaic_template_" + i + "_" + height + "_r" + rotation);
                    Identifier texture = new Identifier(MOD_ID, "block/mosaic_" + i);
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
            for (Identifier i : models) {
                BlockStateVariant blockStateVariant = BlockStateVariant.create();
                blockStateVariant.put(VariantSettings.MODEL, i);
                blockStateVariants.add(blockStateVariant);
            }
            Collections.shuffle(blockStateVariants);
            for (int i = height+1; i <= 4; i++) {
                multipartBlockStateSupplier.with(When.create().set(BookStackBlock.BOOKS, i), blockStateVariants);
            }
        }
        generator.blockStateCollector.accept(multipartBlockStateSupplier);
    }
}
