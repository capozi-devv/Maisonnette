package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.common.block.BookStackBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock.OffsetType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockInit {
	public static void init() {
	}

	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, new Identifier(Maisonnette.MOD_ID, name),
				new BlockItem(block, new FabricItemSettings()));
	}

	private static Block registerBlock(String name, Block block, boolean registerBlockItem) {
		if (registerBlockItem) {
			registerBlockItem(name, block);
		}
		return Registry.register(Registries.BLOCK, new Identifier(Maisonnette.MOD_ID, name), block);
	}

	public static final Block BOOK_STACK = registerBlock(
			"book_stack", new BookStackBlock(FabricBlockSettings.copyOf(Blocks.BAMBOO)
					.sounds(SoundInit.BOOK_STACK_SOUNDS).nonOpaque().offset(OffsetType.NONE)),
			false);
	public static final Block CALCITE_STAIRS = registerBlock("calcite_stairs", new StairsBlock(
			Blocks.CALCITE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.GRANITE_STAIRS)), true);
	public static final Block CALCITE_SLAB = registerBlock("calcite_slab",
			new SlabBlock(FabricBlockSettings.copyOf(Blocks.GRANITE_SLAB)), true);
	public static final Block CALCITE_WALL = registerBlock("calcite_wall",
			new WallBlock(FabricBlockSettings.copyOf(Blocks.GRANITE_WALL)), true);
	public static final Block CALCITE_BUTTON = registerBlock("calcite_button",
			new ButtonBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BUTTON),
					BlockSetType.STONE, 10, false),
			true);
	public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks",
			new Block(FabricBlockSettings.copyOf(Blocks.CALCITE)), true);
	public static final Block CHISELED_CALCITE = registerBlock("chiseled_calcite",
			new Block(FabricBlockSettings.copyOf(Blocks.CALCITE)), true);
	public static final Block GRANITE_BUTTON = registerBlock("granite_button",
			new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON), BlockSetType.STONE, 10, false),
			true);
	public static final Block DIORITE_BUTTON = registerBlock("diorite_button",
			new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON), BlockSetType.STONE, 10, false),
			true);
	public static final Block TUFF_STAIRS = registerBlock("tuff_stairs",
			new StairsBlock(Blocks.TUFF.getDefaultState(), FabricBlockSettings.copyOf(Blocks.TUFF)), true);
	public static final Block TUFF_SLAB = registerBlock("tuff_slab",
			new SlabBlock(FabricBlockSettings.copyOf(Blocks.TUFF)), true);
	public static final Block TUFF_WALL = registerBlock("tuff_wall",
			new WallBlock(FabricBlockSettings.copyOf(Blocks.TUFF)), true);
	public static final Block TUFF_BUTTON = registerBlock("tuff_button",
			new ButtonBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BUTTON),
					BlockSetType.STONE, 10, false),
			true);
	public static final Block TUFF_BRICKS = registerBlock("tuff_bricks",
			new Block(FabricBlockSettings.copyOf(Blocks.TUFF)), true);
	public static final Block CHISELED_TUFF = registerBlock("chiseled_tuff",
			new Block(FabricBlockSettings.copyOf(Blocks.TUFF)), true);
}
