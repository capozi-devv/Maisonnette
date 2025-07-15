package net.capozi.maisonnette.common.entity.client;

import net.capozi.maisonnette.Maisonnette;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
	public static final EntityModelLayer SPECTER =
		new EntityModelLayer(new Identifier(Maisonnette.MOD_ID,"specter"),"main");
}
