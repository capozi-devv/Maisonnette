package net.capozi.maisonnette.common.entity.client;

import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.common.entity.custom.SpecterEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SpecterRenderer extends MobEntityRenderer<SpecterEntity,SpecterModel<SpecterEntity>> {
    private static final Identifier TEXTURE = new Identifier(Maisonnette.MOD_ID,"textures/entity/specter_hostile.png");
    public SpecterRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SpecterModel<>(ctx.getPart(ModModelLayers.SPECTER)), 0.6f);
    }
    @Override
    public Identifier getTexture(SpecterEntity entity) {
        return TEXTURE;
    }
}
