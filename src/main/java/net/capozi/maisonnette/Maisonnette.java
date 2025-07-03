package net.capozi.maisonnette;

import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Maisonnette implements ModInitializer {
	public static final String MOD_ID = "maisonnette";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		BlockInit.blockInit();
	}
}