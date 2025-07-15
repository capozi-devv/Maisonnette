package net.capozi.maisonnette;

import net.capozi.maisonnette.common.entity.client.ModModelLayers;
import net.capozi.maisonnette.common.entity.client.SpecterModel;
import net.capozi.maisonnette.common.entity.client.SpecterRenderer;
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
        EntityRendererRegistry.register(EntityInit.SPECTER, SpecterRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SPECTER, SpecterModel::getTexturedModelData);
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.BOOK_STACK, RenderLayer.getCutout());
    }
}
