package net.capozi.maisonnette;

import net.capozi.maisonnette.common.entity.client.EmptyRenderer;
import net.capozi.maisonnette.common.entity.client.ModModelLayers;
import net.capozi.maisonnette.common.entity.client.SpecterRenderer;
import net.capozi.maisonnette.common.entity.client.SpecterModel;
import net.capozi.maisonnette.foundation.EntityInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MaisonnetteClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(EntityInit.SPECTER, SpecterRenderer::new);
		EntityRendererRegistry.register(EntityInit.SEAT, (ctx) -> new EmptyRenderer<>(ctx));
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SPECTER, SpecterModel::getTexturedModelData);
	}
}
