package net.capozi.maisonnette;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.capozi.maisonnette.common.block.BookStackBlock;
import net.capozi.maisonnette.common.entity.custom.SpecterEntity;
import net.capozi.maisonnette.foundation.BlockInit;
import net.capozi.maisonnette.foundation.EntityInit;
import net.capozi.maisonnette.foundation.ItemGroups;
import net.capozi.maisonnette.foundation.SoundInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.ScaffoldingBlock;

// NOTE: main
public class Maisonnette implements ModInitializer {
	public static final String MOD_ID = "maisonnette";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		BlockInit.init();
		EntityInit.init();
		ItemGroups.init();
		SoundInit.init();
		BookStackBlock.registerBookUseCallback();
		FabricDefaultAttributeRegistry.register(EntityInit.SPECTER, SpecterEntity.createSpecterAttributes());
	}
}
