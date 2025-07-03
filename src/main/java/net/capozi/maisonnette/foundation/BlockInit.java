package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.Maisonnette;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockInit {
    public static void blockInit() {}
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Maisonnette.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Maisonnette.MOD_ID, name), block);
    }
    public static final Block CALCITE_STAIRS = registerBlock("calcite_stairs", new StairsBlock(Blocks.CALCITE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.GRANITE_STAIRS)));
    public static final Block CALCITE_SLAB = registerBlock("calcite_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.GRANITE_SLAB)));
    public static final Block CALCITE_WALL = registerBlock("calcite_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.GRANITE_WALL)));
    public static final Block CALCITE_BUTTON = registerBlock("calcite_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BUTTON), BlockSetType.STONE, 10, false));
    public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks", new Block(FabricBlockSettings.copyOf(Blocks.CALCITE)));
    public static final Block CHISELED_CALCITE = registerBlock("chiseled_calcite", new Block(FabricBlockSettings.copyOf(Blocks.CALCITE)));
    public static final Block SMOOTH_CALCITE_STAIRS = registerBlock("smooth_calcite_stairs", new StairsBlock(Blocks.CALCITE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.GRANITE_STAIRS)));
    public static final Block SMOOTH_CALCITE_SLAB = registerBlock("smooth_calcite_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.GRANITE_SLAB)));
    public static final Block SMOOTH_CALCITE_WALL = registerBlock("smooth_calcite_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.GRANITE_WALL)));
    public static final Block SMOOTH_CALCITE_BUTTON = registerBlock("smooth_calcite_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BUTTON), BlockSetType.STONE, 10, false));
    public static final Block SMOOTH_CALCITE_BRICKS = registerBlock("smooth_calcite_bricks", new Block(FabricBlockSettings.copyOf(Blocks.CALCITE)));
}