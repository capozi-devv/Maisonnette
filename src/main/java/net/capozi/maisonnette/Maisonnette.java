package net.capozi.maisonnette;

import net.capozi.maisonnette.common.worldgen.ExpandedJigsawStructure;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.capozi.maisonnette.common.block.BookStackBlock;
import net.capozi.maisonnette.common.entity.object.SpecterEntity;
import net.capozi.maisonnette.foundation.BlockInit;
import net.capozi.maisonnette.foundation.EntityInit;
import net.capozi.maisonnette.foundation.ItemGroups;
import net.capozi.maisonnette.foundation.SoundInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

// NOTE: main
public class Maisonnette implements ModInitializer {
	public static final String MOD_ID = "maisonnette";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final StructureType<ExpandedJigsawStructure> EXPANDED_JIGSAW =
            Registry.register(
                    Registries.STRUCTURE_TYPE,
                    new Identifier(MOD_ID, "expanded_jigsaw"),
                    () -> ExpandedJigsawStructure.CODEC
            );
	@Override
	public void onInitialize() {
		BlockInit.init();
		EntityInit.init();
		ItemGroups.init();
		SoundInit.init();
		BookStackBlock.registerBookUseCallback();
		FabricDefaultAttributeRegistry.register(EntityInit.SPECTER, SpecterEntity.createSpecterAttributes());
		OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockInit.COPPER_TORCHBULB, BlockInit.EXPOSED_COPPER_TORCHBULB);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockInit.EXPOSED_COPPER_TORCHBULB, BlockInit.WEATHERED_COPPER_TORCHBULB);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockInit.WEATHERED_COPPER_TORCHBULB, BlockInit.OXIDIZED_COPPER_TORCHBULB);
		OxidizableBlocksRegistry.registerWaxableBlockPair(BlockInit.COPPER_TORCHBULB, BlockInit.WAXED_COPPER_TORCHBULB);
		OxidizableBlocksRegistry.registerWaxableBlockPair(BlockInit.EXPOSED_COPPER_TORCHBULB, BlockInit.WAXED_EXPOSED_COPPER_TORCHBULB);
		OxidizableBlocksRegistry.registerWaxableBlockPair(BlockInit.WEATHERED_COPPER_TORCHBULB, BlockInit.WAXED_WEATHERED_COPPER_TORCHBULB);
		OxidizableBlocksRegistry.registerWaxableBlockPair(BlockInit.OXIDIZED_COPPER_TORCHBULB, BlockInit.WAXED_OXIDIZED_COPPER_TORCHBULB);
	}
}
