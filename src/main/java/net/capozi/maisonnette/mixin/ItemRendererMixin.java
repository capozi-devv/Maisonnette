package net.capozi.maisonnette.mixin;

import net.minecraft.client.render.item.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
//    private static final ModelIdentifier SPIRIT_ORB;
//    @Shadow @Final private ItemModels models;
//    @Shadow public abstract BakedModel getModel(ItemStack stack, @Nullable World world, @Nullable LivingEntity entity, int seed);
//    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At("HEAD"), argsOnly = true)
//    public BakedModel onRenderItem(BakedModel value, ItemStack stack, ModelTransformationMode mode) {
//        if(stack.isOf(ItemInit.SPIRIT_ORB) && !mode.equals(ModelTransformationMode.GUI)) {
//            return models.getModelManager().getModel(SPIRIT_ORB);
//        }
//        return value;
//    }
//    static {
//        SPIRIT_ORB = new ModelIdentifier(Maisonnette.identifier("spirit_orb_active"), "inventory");
//    }
}
