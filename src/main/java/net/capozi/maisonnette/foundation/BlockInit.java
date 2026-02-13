package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.common.block.BookStackBlock;
import net.capozi.maisonnette.common.block.BulbBlock;
import net.capozi.maisonnette.common.block.MosaicBlock;
import net.capozi.maisonnette.common.block.SeatBlock;
import net.capozi.maisonnette.common.datagen.ConfiguredFeaturesProvider;
import net.capozi.maisonnette.common.item.MosaicTileItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock.OffsetType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.Optional;

import static net.capozi.maisonnette.common.block.BulbBlock.LIT;

public class BlockInit {
	public static void init() {}
    public static final BlockSetType WILLOW_SET_TYPE = new BlockSetType("willow");
    public static final WoodType WILLOW_WOOD_TYPE = new WoodType("willow", WILLOW_SET_TYPE);
	private static Item registerBlockItem(String name, BlockItem blockItem) {
		return Registry.register(Registries.ITEM, Identifier.of(Maisonnette.MOD_ID, name), blockItem);
	}
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(Maisonnette.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }
	private static Block registerBlock(String name, Block block, boolean registerBlockItem, boolean tile) {
		if (tile) {
			registerBlockItem(name, new MosaicTileItem(block, new Item.Settings()));
		}
		return Registry.register(Registries.BLOCK, Identifier.of(Maisonnette.MOD_ID, name), block);
	}
    private static Block registerBlock(String name, Block block, boolean registerBlockItem) {
        if (registerBlockItem) {
            registerBlockItem(name, block);
        }
        return Registry.register(Registries.BLOCK, Identifier.of(Maisonnette.MOD_ID, name), block);
    }
    public static final Block MOSAIC = registerBlock("mosaic_tiles", new MosaicBlock(FabricBlockSettings.copyOf(Blocks.BRICKS)), true,true);
	public static final Block BOOK_STACK = registerBlock("book_stack", new BookStackBlock(FabricBlockSettings.copyOf(Blocks.BAMBOO).sounds(SoundInit.BOOK_STACK_SOUNDS).nonOpaque().offset(OffsetType.NONE).burnable()), false);
	public static final Block CALCITE_STAIRS = registerBlock("calcite_stairs", new StairsBlock(Blocks.CALCITE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.GRANITE_STAIRS)), true);
	public static final Block CALCITE_SLAB = registerBlock("calcite_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.GRANITE_SLAB)), true);
	public static final Block CALCITE_WALL = registerBlock("calcite_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.GRANITE_WALL)), true);
	public static final Block CALCITE_BUTTON = registerBlock("calcite_button", new ButtonBlock(BlockSetType.STONE, 10, FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BUTTON)), true);
	public static final Block TUFF_STAIRS = registerBlock("tuff_stairs", new StairsBlock(Blocks.TUFF.getDefaultState(), FabricBlockSettings.copyOf(Blocks.TUFF)), true);
	public static final Block TUFF_SLAB = registerBlock("tuff_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.TUFF)), true);
	public static final Block TUFF_WALL = registerBlock("tuff_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.TUFF)), true);
	public static final Block TUFF_BUTTON = registerBlock("tuff_button", new ButtonBlock(BlockSetType.STONE, 10, FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BUTTON)), true);
	public static final Block COPPER_TORCHBULB = registerBlock("copper_torchbulb", new BulbBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).luminance(state -> state.get(LIT) ? 15 : 0)), true);
	public static final Block EXPOSED_COPPER_TORCHBULB = registerBlock("exposed_copper_torchbulb", new BulbBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).luminance(state -> state.get(LIT) ? 12 : 0)), true);
	public static final Block WEATHERED_COPPER_TORCHBULB = registerBlock("weathered_copper_torchbulb", new BulbBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).luminance(state -> state.get(LIT) ? 8 : 0)), true);
	public static final Block OXIDIZED_COPPER_TORCHBULB = registerBlock("oxidized_copper_torchbulb", new BulbBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).luminance(state -> state.get(LIT) ? 4 : 0)), true);
	public static final Block WAXED_COPPER_TORCHBULB = registerBlock("waxed_copper_torchbulb", new BulbBlock(Oxidizable.OxidationLevel.UNAFFECTED,FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).luminance(state -> state.get(LIT) ? 15 : 0)), true);
	public static final Block WAXED_EXPOSED_COPPER_TORCHBULB = registerBlock("waxed_exposed_copper_torchbulb", new BulbBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).luminance(state -> state.get(LIT) ? 12 : 0)), true);
	public static final Block WAXED_WEATHERED_COPPER_TORCHBULB = registerBlock("waxed_weathered_copper_torchbulb", new BulbBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).luminance(state -> state.get(LIT) ? 8 : 0)), true);
	public static final Block WAXED_OXIDIZED_COPPER_TORCHBULB = registerBlock("waxed_oxidized_copper_torchbulb", new BulbBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).luminance(state -> state.get(LIT) ? 4 : 0)), true);
	public static final Block WHITE_SEAT = registerBlock("white_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block ORANGE_SEAT = registerBlock("orange_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block LIGHT_BLUE_SEAT = registerBlock("light_blue_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block YELLOW_SEAT = registerBlock("yellow_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block LIME_SEAT = registerBlock("lime_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block PINK_SEAT = registerBlock("pink_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block GRAY_SEAT = registerBlock("gray_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block LIGHT_GRAY_SEAT = registerBlock("light_gray_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block CYAN_SEAT = registerBlock("cyan_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block BLUE_SEAT = registerBlock("blue_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block PURPLE_SEAT = registerBlock("purple_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block BROWN_SEAT = registerBlock("brown_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block GREEN_SEAT = registerBlock("green_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block RED_SEAT = registerBlock("red_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block BLACK_SEAT = registerBlock("black_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
	public static final Block MAGENTA_SEAT = registerBlock("magenta_seat", new SeatBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)), true);
    public static final Block WILLOW_LOG = registerBlock("willow_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)), true);
    public static final Block STRIPPED_WILLOW_LOG = registerBlock("stripped_willow_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4f)), true);
    public static final Block WILLOW_WOOD = registerBlock("willow_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)), true);
    public static final Block STRIPPED_WILLOW_WOOD = registerBlock("stripped_willow_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)), true);
    public static final Block WILLOW_PLANKS = registerBlock("willow_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)), true);
    public static final Block RED_WILLOW_LEAVES = registerBlock("red_willow_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()), true);
    public static final Block ORANGE_WILLOW_LEAVES = registerBlock("orange_willow_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()), true);
    public static final Block YELLOW_WILLOW_LEAVES = registerBlock("yellow_willow_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()), true);
    public static final Block RED_WILLOW_SAPLING = registerBlock("red_willow_sapling", new SaplingBlock(new SaplingGenerator("red_willow", null, Optional.of(ConfiguredFeaturesProvider.RED_WILLOW_KEY), null), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), true);
    public static final Block ORANGE_WILLOW_SAPLING = registerBlock("orange_willow_sapling", new SaplingBlock(new SaplingGenerator("orange_willow", null, Optional.of(ConfiguredFeaturesProvider.ORANGE_WILLOW_KEY), null), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), true);
    public static final Block YELLOW_WILLOW_SAPLING = registerBlock("yellow_willow_sapling", new SaplingBlock(new SaplingGenerator("yellow_willow", null, Optional.of(ConfiguredFeaturesProvider.YELLOW_WILLOW_KEY), null), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), true);
    public static final Block WILLOW_SLAB = registerBlock("willow_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)), true);
    public static final Block WILLOW_STAIRS = registerBlock("willow_stairs", new StairsBlock(Blocks.OAK_STAIRS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)), true);
    public static final Block WILLOW_FENCE = registerBlock("willow_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)), true);
    public static final Block WILLOW_FENCE_GATE = registerBlock("willow_fence_gate", new FenceGateBlock(WILLOW_WOOD_TYPE, FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)), true);
    public static final Block WILLOW_BUTTON = registerBlock("willow_button", new ButtonBlock(WILLOW_SET_TYPE, 10, FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BUTTON)), true);
    public static final Block WILLOW_PRESSURE_PLATE = registerBlock("willow_pressure_plate", new PressurePlateBlock(WILLOW_SET_TYPE, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE)), true);
    public static final Block WILLOW_DOOR = registerBlock("willow_door", new DoorBlock( WILLOW_SET_TYPE, FabricBlockSettings.copyOf(Blocks.OAK_DOOR)), true);
    public static final Block WILLOW_TRAPDOOR = registerBlock("willow_trapdoor", new TrapdoorBlock(WILLOW_SET_TYPE, FabricBlockSettings.copyOf(Blocks.OAK_DOOR)), true);
    public static final Block CHARRED_LOG = registerBlock("charred_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)), true);
    public static final Block STRIPPED_CHARRED_LOG = registerBlock("stripped_charred_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4f)), true);
    public static final Block CHARRED_WOOD = registerBlock("charred_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)), true);
    public static final Block STRIPPED_CHARRED_WOOD = registerBlock("stripped_charred_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)), true);
    public static final Block CHARRED_PLANKS = registerBlock("charred_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)), true);
    public static final Block CHARRED_SLAB = registerBlock("charred_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)), true);
    public static final Block CHARRED_STAIRS = registerBlock("charred_stairs", new StairsBlock(Blocks.OAK_STAIRS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)), true);
    public static final Block CHARRED_FENCE = registerBlock("charred_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)), true);
    public static final Block CHARRED_FENCE_GATE = registerBlock("charred_fence_gate", new FenceGateBlock(WILLOW_WOOD_TYPE, FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)), true);
    public static final Block CHARRED_BUTTON = registerBlock("charred_button", new ButtonBlock(WILLOW_SET_TYPE, 10, FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BUTTON)), true);
    public static final Block CHARRED_PRESSURE_PLATE = registerBlock("charred_pressure_plate", new PressurePlateBlock(WILLOW_SET_TYPE, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE)), true);
    public static final Block CHARRED_DOOR = registerBlock("charred_door", new DoorBlock(WILLOW_SET_TYPE, FabricBlockSettings.copyOf(Blocks.OAK_DOOR)), true);
    public static final Block CHARRED_TRAPDOOR = registerBlock("charred_trapdoor", new TrapdoorBlock(WILLOW_SET_TYPE, FabricBlockSettings.copyOf(Blocks.OAK_DOOR)), true);
}