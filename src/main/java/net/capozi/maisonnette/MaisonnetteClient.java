package net.capozi.maisonnette;

import net.capozi.maisonnette.common.entity.client.EmptyRenderer;
import net.capozi.maisonnette.common.entity.client.ModModelLayers;
import net.capozi.maisonnette.foundation.BlockInit;
import net.capozi.maisonnette.foundation.EntityInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class MaisonnetteClient implements ClientModInitializer {
	@Override
    public void onInitializeClient() {
		EntityRendererRegistry.register(EntityInit.SEAT, (ctx) -> new EmptyRenderer<>(ctx));
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.RED_WILLOW_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.ORANGE_WILLOW_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.YELLOW_WILLOW_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.WILLOW_DOOR, RenderLayer.getCutout());
	}
}
