package net.capozi.maisonnette.common.entity.client;

import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class EmptyRenderer <T extends Entity> extends EntityRenderer<T> {
    public EmptyRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }
    @Override
    public Identifier getTexture(T entity) {
        return null;
    }
    @Override
    public boolean shouldRender(T entity, Frustum frustum, double x, double y, double z) {
        return false;
    }
}
