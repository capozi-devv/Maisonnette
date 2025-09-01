package net.capozi.maisonnette.common.entity.client;

import net.capozi.maisonnette.common.entity.object.SpecterEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SpecterModel<T extends SpecterEntity> extends EntityModel<T> {
	private final ModelPart Specter;
	private final ModelPart body;
	private final ModelPart ribs;
	private final ModelPart left_rib;
	private final ModelPart right_rib;
	private final ModelPart arms;
	private final ModelPart arm_left;
	private final ModelPart arm_right;
	private final ModelPart head;
	private final ModelPart left_ear;
	private final ModelPart right_ear;
	private final ModelPart whiskers;
	private final ModelPart extras;
	private final ModelPart birthday_hat;
	private final ModelPart sticky_note;
	private final ModelPart note_flap;
	private final ModelPart halo;
	private final ModelPart crown;
	public SpecterModel(ModelPart root) {
		this.Specter = root.getChild("Specter");
		this.body = this.Specter.getChild("body");
		this.ribs = this.body.getChild("ribs");
		this.left_rib = this.ribs.getChild("left_rib");
		this.right_rib = this.ribs.getChild("right_rib");
		this.arms = this.body.getChild("arms");
		this.arm_left = this.arms.getChild("arm_left");
		this.arm_right = this.arms.getChild("arm_right");
		this.head = this.Specter.getChild("head");
		this.left_ear = this.head.getChild("left_ear");
		this.right_ear = this.head.getChild("right_ear");
		this.whiskers = this.head.getChild("whiskers");
		this.extras = this.head.getChild("extras");
		this.birthday_hat = this.extras.getChild("birthday_hat");
		this.sticky_note = this.extras.getChild("sticky_note");
		this.note_flap = this.sticky_note.getChild("note_flap");
		this.halo = this.extras.getChild("halo");
		this.crown = this.extras.getChild("crown");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Specter = modelPartData.addChild("Specter", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 10.0F, 0.0F));

		ModelPartData body = Specter.addChild("body", ModelPartBuilder.create().uv(0, 46).cuboid(-3.0F, 0.0F, -2.0F, 6.0F, 16.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 0.0F));

		ModelPartData ribs = body.addChild("ribs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.0F, -2.0F));

		ModelPartData left_rib = ribs.addChild("left_rib", ModelPartBuilder.create().uv(30, 46).cuboid(-3.0F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 0.0F, -0.1F));

		ModelPartData right_rib = ribs.addChild("right_rib", ModelPartBuilder.create().uv(30, 54).cuboid(0.0F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 0.0F, -0.1F));

		ModelPartData arms = body.addChild("arms", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.0F, 0.0F));

		ModelPartData arm_left = arms.addChild("arm_left", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = arm_left.addChild("cube_r1", ModelPartBuilder.create().uv(38, 20).cuboid(-2.0F, -2.0F, -15.0F, 3.0F, 4.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 23).cuboid(-2.0F, -2.0F, -15.0F, 3.0F, 7.0F, 16.0F, new Dilation(0.2F)), ModelTransform.of(2.0F, -1.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData arm_right = arms.addChild("arm_right", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, 0.0F, 0.0F));

		ModelPartData cube_r2 = arm_right.addChild("cube_r2", ModelPartBuilder.create().uv(38, 0).cuboid(-2.0F, -2.0F, -15.0F, 3.0F, 4.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-2.0F, -2.0F, -15.0F, 3.0F, 7.0F, 16.0F, new Dilation(0.2F)), ModelTransform.of(-1.0F, -1.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData head = Specter.addChild("head", ModelPartBuilder.create().uv(38, 40).cuboid(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 0.0F));

		ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create().uv(20, 54).cuboid(0.0F, -3.0F, 0.0F, 5.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -5.0F, -1.0F));

		ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create().uv(20, 46).cuboid(-5.0F, -3.0F, 0.0F, 5.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -5.0F, -1.0F));

		ModelPartData whiskers = head.addChild("whiskers", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -3.0F));

		ModelPartData cube_r3 = whiskers.addChild("cube_r3", ModelPartBuilder.create().uv(36, 55).cuboid(-3.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

		ModelPartData cube_r4 = whiskers.addChild("cube_r4", ModelPartBuilder.create().uv(42, 55).cuboid(-3.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, 1.0F, 0.0F, 0.3491F, 0.0F));

		ModelPartData cube_r5 = whiskers.addChild("cube_r5", ModelPartBuilder.create().uv(48, 55).cuboid(0.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, 1.0F, 0.0F, -0.3491F, 0.0F));

		ModelPartData cube_r6 = whiskers.addChild("cube_r6", ModelPartBuilder.create().uv(54, 55).cuboid(0.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

		ModelPartData extras = head.addChild("extras", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData birthday_hat = extras.addChild("birthday_hat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -5.0F, 0.0F));

		ModelPartData cube_r7 = birthday_hat.addChild("cube_r7", ModelPartBuilder.create().uv(0, 2).cuboid(-3.0F, -3.5F, 0.0F, 6.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r8 = birthday_hat.addChild("cube_r8", ModelPartBuilder.create().uv(0, 2).cuboid(-3.0F, -3.5F, 0.0F, 6.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData sticky_note = extras.addChild("sticky_note", ModelPartBuilder.create().uv(-1, 2).cuboid(-4.0F, -1.0F, 0.0F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, -4.1F));

		ModelPartData note_flap = sticky_note.addChild("note_flap", ModelPartBuilder.create().uv(-1, 2).cuboid(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 0.0F));

		ModelPartData halo = extras.addChild("halo", ModelPartBuilder.create().uv(-14, 114).cuboid(-7.0F, 0.0F, -7.0F, 14.0F, 0.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -13.0F, 0.0F));

		ModelPartData crown = extras.addChild("crown", ModelPartBuilder.create().uv(112, 0).cuboid(-2.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(3.8F, -6.0F, -1.0F, 0.0F, 0.0F, 0.2182F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Specter.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}