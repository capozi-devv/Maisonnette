package net.capozi.maisonnette;

import net.capozi.maisonnette.server.worldgen.ExpandedJigsawStructure;
import net.capozi.maisonnette.foundation.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.capozi.maisonnette.common.block.BookStackBlock;
import net.fabricmc.api.ModInitializer;

public class Maisonnette implements ModInitializer {
	public static final String MOD_ID = "maisonnette";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static Identifier identifier(String name) { return new Identifier(Maisonnette.MOD_ID, name); }
    public static final StructureType<ExpandedJigsawStructure> EXPANDED_JIGSAW = Registry.register(Registries.STRUCTURE_TYPE, new Identifier(MOD_ID, "expanded_jigsaw"), () -> ExpandedJigsawStructure.CODEC);
	@Override
    public void onInitialize() {
		BlockInit.init();
		EntityInit.init();
		ItemGroups.init();
		SoundInit.init();
        WorldgenInit.init();
		BookStackBlock.registerBookUseCallback();
		OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockInit.COPPER_TORCHBULB, BlockInit.EXPOSED_COPPER_TORCHBULB);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockInit.EXPOSED_COPPER_TORCHBULB, BlockInit.WEATHERED_COPPER_TORCHBULB);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockInit.WEATHERED_COPPER_TORCHBULB, BlockInit.OXIDIZED_COPPER_TORCHBULB);
		OxidizableBlocksRegistry.registerWaxableBlockPair(BlockInit.COPPER_TORCHBULB, BlockInit.WAXED_COPPER_TORCHBULB);
		OxidizableBlocksRegistry.registerWaxableBlockPair(BlockInit.EXPOSED_COPPER_TORCHBULB, BlockInit.WAXED_EXPOSED_COPPER_TORCHBULB);
		OxidizableBlocksRegistry.registerWaxableBlockPair(BlockInit.WEATHERED_COPPER_TORCHBULB, BlockInit.WAXED_WEATHERED_COPPER_TORCHBULB);
		OxidizableBlocksRegistry.registerWaxableBlockPair(BlockInit.OXIDIZED_COPPER_TORCHBULB, BlockInit.WAXED_OXIDIZED_COPPER_TORCHBULB);
        StrippableBlockRegistry.register(BlockInit.WILLOW_LOG, BlockInit.STRIPPED_WILLOW_LOG);
        StrippableBlockRegistry.register(BlockInit.WILLOW_WOOD, BlockInit.STRIPPED_WILLOW_WOOD);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.BOOK_STACK, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.WILLOW_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.WILLOW_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.STRIPPED_WILLOW_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.STRIPPED_WILLOW_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.WILLOW_PLANKS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.WILLOW_STAIRS, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.WILLOW_SLAB, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.WILLOW_FENCE, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.WILLOW_FENCE_GATE, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.WILLOW_PRESSURE_PLATE, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.WILLOW_BUTTON, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.WILLOW_DOOR, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.WILLOW_TRAPDOOR, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.RED_WILLOW_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.ORANGE_WILLOW_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BlockInit.YELLOW_WILLOW_LEAVES, 30, 60);
	}
}
