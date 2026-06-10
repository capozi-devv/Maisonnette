package net.capozi.maisonnette.common.block.entity.client;

import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.common.block.entity.HangingFlowerPotBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HangingFlowerPotBlockEntityRenderer implements BlockEntityRenderer<HangingFlowerPotBlockEntity> {
    private static final Identifier TEXTURE = Maisonnette.identifier("textures/block/hanging_flower_pot.png");
    private static final Element[] POT_ELEMENTS = new Element[] {
            new Element(7, 6, 4, 9, 17, 4, 8, 6, 4, 15, 0, 0, new FaceUv(8, 5, 6, 16), new FaceUv(1, 0, 1, 10), new FaceUv(8, 5, 6, 16), new FaceUv(1, 0, 1, 10), new FaceUv(2, 1, 0, 1), new FaceUv(2, 1, 0, 1)),
            new Element(3, 6, 8, 5, 17, 8, 4, 6, 8, 0, -90, -15, new FaceUv(8, 5, 6, 16), new FaceUv(1, 0, 1, 10), new FaceUv(8, 5, 6, 16), new FaceUv(1, 0, 1, 10), new FaceUv(2, 1, 0, 1), new FaceUv(2, 1, 0, 1)),
            new Element(4, 0, 5, 5, 6, 11, -1, 0, 0, 0, 0, 0, new FaceUv(5, 10, 6, 16), new FaceUv(0, 10, 6, 16), new FaceUv(0, 10, 1, 16), new FaceUv(0, 10, 6, 16), new FaceUv(0, 5, 1, 11), new FaceUv(0, 5, 1, 11)),
            new Element(11, 0, 5, 12, 6, 11, 1, 0, 0, 0, 0, 0, new FaceUv(0, 10, 1, 16), new FaceUv(0, 10, 6, 16), new FaceUv(5, 10, 6, 16), new FaceUv(0, 10, 6, 16), new FaceUv(5, 5, 6, 11), new FaceUv(5, 5, 6, 11)),
            new Element(7, 0, 1, 8, 6, 7, 8, 0, 4, 0, 90, 0, new FaceUv(0, 10, 1, 16), new FaceUv(0, 10, 6, 16), new FaceUv(5, 10, 6, 16), new FaceUv(0, 10, 6, 16), new FaceUv(5, 5, 6, 11), new FaceUv(5, 5, 6, 11)),
            new Element(7, 0, 9, 8, 6, 15, 8, 0, 12, 0, -90, 0, new FaceUv(0, 10, 1, 16), new FaceUv(0, 10, 6, 16), new FaceUv(5, 10, 6, 16), new FaceUv(0, 10, 6, 16), new FaceUv(5, 5, 6, 11), new FaceUv(5, 5, 6, 11)),
            new Element(5, 0, 5, 11, 4, 11, 0, 0, 0, 0, 0, 0, new FaceUv(0, 0, 0, 0), new FaceUv(0, 0, 0, 0), new FaceUv(0, 0, 0, 0), new FaceUv(0, 0, 0, 0), new FaceUv(10, 0, 16, 6), new FaceUv(0, 10, 6, 16)),
            new Element(11, 6, 8, 13, 17, 8, 12, 6, 8, 0, 90, 15, new FaceUv(6, 5, 8, 16), new FaceUv(1, 0, 1, 10), new FaceUv(6, 5, 8, 16), new FaceUv(1, 0, 1, 10), new FaceUv(0, 1, 2, 1), new FaceUv(0, 1, 2, 1)),
            new Element(7, 6, 12, 9, 17, 12, 8, 6, 12, -15, 0, 0, new FaceUv(6, 5, 8, 16), new FaceUv(1, 0, 1, 10), new FaceUv(6, 5, 8, 16), new FaceUv(1, 0, 1, 10), new FaceUv(0, 1, 2, 1), new FaceUv(0, 1, 2, 1))
    };

    public HangingFlowerPotBlockEntityRenderer(BlockEntityRendererFactory.Context context) {}

    @Override
    public void render(HangingFlowerPotBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        VertexConsumer potVertices = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(TEXTURE));
        for (Element element : POT_ELEMENTS) {
            renderElement(element, matrices, potVertices, light, overlay);
        }

        if (entity.getPottedBlock() != Blocks.AIR) {
            renderPlant(entity.getPottedBlock().getDefaultState(), matrices, vertexConsumers, light, overlay);
        }
    }

    private static void renderElement(Element element, MatrixStack matrices, VertexConsumer vertices, int light, int overlay) {
        matrices.push();
        matrices.translate(element.originX / 16.0, element.originY / 16.0, element.originZ / 16.0);
        // Blockbench stores these as XYZ Euler rotations. MatrixStack post-multiplies,
        // so they must be submitted in reverse order to reproduce that transform exactly.
        if (element.rotationZ != 0) {
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(element.rotationZ));
        }
        if (element.rotationY != 0) {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(element.rotationY));
        }
        if (element.rotationX != 0) {
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(element.rotationX));
        }
        matrices.translate(-element.originX / 16.0, -element.originY / 16.0, -element.originZ / 16.0);

        float minX = element.fromX / 16.0F;
        float minY = element.fromY / 16.0F;
        float minZ = element.fromZ / 16.0F;
        float maxX = element.toX / 16.0F;
        float maxY = element.toY / 16.0F;
        float maxZ = element.toZ / 16.0F;

        renderFace(matrices, vertices, Direction.NORTH, element.north, minX, minY, minZ, maxX, maxY, maxZ, light, overlay);
        renderFace(matrices, vertices, Direction.EAST, element.east, minX, minY, minZ, maxX, maxY, maxZ, light, overlay);
        renderFace(matrices, vertices, Direction.SOUTH, element.south, minX, minY, minZ, maxX, maxY, maxZ, light, overlay);
        renderFace(matrices, vertices, Direction.WEST, element.west, minX, minY, minZ, maxX, maxY, maxZ, light, overlay);
        renderFace(matrices, vertices, Direction.UP, element.up, minX, minY, minZ, maxX, maxY, maxZ, light, overlay);
        renderFace(matrices, vertices, Direction.DOWN, element.down, minX, minY, minZ, maxX, maxY, maxZ, light, overlay);
        matrices.pop();
    }

    private static void renderFace(MatrixStack matrices, VertexConsumer vertices, Direction direction, FaceUv uv, float minX, float minY, float minZ, float maxX, float maxY, float maxZ, int light, int overlay) {
        if (uv.isEmpty()) {
            return;
        }

        float u1 = uv.u1 / 16.0F;
        float v1 = uv.v1 / 16.0F;
        float u2 = uv.u2 / 16.0F;
        float v2 = uv.v2 / 16.0F;

        switch (direction) {
            case NORTH -> {
                vertex(matrices, vertices, maxX, minY, minZ, u1, v2, 0, 0, -1, light, overlay);
                vertex(matrices, vertices, minX, minY, minZ, u2, v2, 0, 0, -1, light, overlay);
                vertex(matrices, vertices, minX, maxY, minZ, u2, v1, 0, 0, -1, light, overlay);
                vertex(matrices, vertices, maxX, maxY, minZ, u1, v1, 0, 0, -1, light, overlay);
            }
            case EAST -> {
                vertex(matrices, vertices, maxX, minY, maxZ, u1, v2, 1, 0, 0, light, overlay);
                vertex(matrices, vertices, maxX, minY, minZ, u2, v2, 1, 0, 0, light, overlay);
                vertex(matrices, vertices, maxX, maxY, minZ, u2, v1, 1, 0, 0, light, overlay);
                vertex(matrices, vertices, maxX, maxY, maxZ, u1, v1, 1, 0, 0, light, overlay);
            }
            case SOUTH -> {
                vertex(matrices, vertices, minX, minY, maxZ, u1, v2, 0, 0, 1, light, overlay);
                vertex(matrices, vertices, maxX, minY, maxZ, u2, v2, 0, 0, 1, light, overlay);
                vertex(matrices, vertices, maxX, maxY, maxZ, u2, v1, 0, 0, 1, light, overlay);
                vertex(matrices, vertices, minX, maxY, maxZ, u1, v1, 0, 0, 1, light, overlay);
            }
            case WEST -> {
                vertex(matrices, vertices, minX, minY, minZ, u1, v2, -1, 0, 0, light, overlay);
                vertex(matrices, vertices, minX, minY, maxZ, u2, v2, -1, 0, 0, light, overlay);
                vertex(matrices, vertices, minX, maxY, maxZ, u2, v1, -1, 0, 0, light, overlay);
                vertex(matrices, vertices, minX, maxY, minZ, u1, v1, -1, 0, 0, light, overlay);
            }
            case UP -> {
                vertex(matrices, vertices, minX, maxY, maxZ, u1, v2, 0, 1, 0, light, overlay);
                vertex(matrices, vertices, maxX, maxY, maxZ, u2, v2, 0, 1, 0, light, overlay);
                vertex(matrices, vertices, maxX, maxY, minZ, u2, v1, 0, 1, 0, light, overlay);
                vertex(matrices, vertices, minX, maxY, minZ, u1, v1, 0, 1, 0, light, overlay);
            }
            case DOWN -> {
                vertex(matrices, vertices, minX, minY, minZ, u1, v2, 0, -1, 0, light, overlay);
                vertex(matrices, vertices, maxX, minY, minZ, u2, v2, 0, -1, 0, light, overlay);
                vertex(matrices, vertices, maxX, minY, maxZ, u2, v1, 0, -1, 0, light, overlay);
                vertex(matrices, vertices, minX, minY, maxZ, u1, v1, 0, -1, 0, light, overlay);
            }
        }
    }

    private static void vertex(MatrixStack matrices, VertexConsumer vertices, float x, float y, float z, float u, float v, float normalX, float normalY, float normalZ, int light, int overlay) {
        MatrixStack.Entry entry = matrices.peek();
        vertices.vertex(entry.getPositionMatrix(), x, y, z)
                .color(255, 255, 255, 255)
                .texture(u, v)
                .overlay(overlay)
                .light(light)
                .normal(entry.getNormalMatrix(), normalX, normalY, normalZ)
                .next();
    }

    private static void renderPlant(BlockState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockRenderManager manager = MinecraftClient.getInstance().getBlockRenderManager();
        BakedModel pottedModel = manager.getModel(state);
        BakedModel emptyPotModel = manager.getModel(Blocks.FLOWER_POT.getDefaultState());
        BakedModel plantOnlyModel = new PlantOnlyBakedModel(pottedModel, emptyPotModel);
        VertexConsumer vertices = vertexConsumers.getBuffer(RenderLayers.getBlockLayer(state));
        manager.getModelRenderer().render(matrices.peek(), vertices, state, plantOnlyModel, 1.0F, 1.0F, 1.0F, light, overlay);
    }

    private record FaceUv(float u1, float v1, float u2, float v2) {
        private boolean isEmpty() {
            return u1 == u2 && v1 == v2;
        }
    }

    private record Element(float fromX, float fromY, float fromZ, float toX, float toY, float toZ,
                           float originX, float originY, float originZ,
                           float rotationX, float rotationY, float rotationZ,
                           FaceUv north, FaceUv east, FaceUv south, FaceUv west, FaceUv up, FaceUv down) {}

    private static class PlantOnlyBakedModel implements BakedModel {
        private final BakedModel pottedModel;
        private final BakedModel emptyPotModel;

        private PlantOnlyBakedModel(BakedModel pottedModel, BakedModel emptyPotModel) {
            this.pottedModel = pottedModel;
            this.emptyPotModel = emptyPotModel;
        }

        @Override
        public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random) {
            List<BakedQuad> pottedQuads = pottedModel.getQuads(state, face, random);
            List<BakedQuad> potQuads = emptyPotModel.getQuads(Blocks.FLOWER_POT.getDefaultState(), face, Random.create(0));
            List<BakedQuad> result = new ArrayList<>(pottedQuads.size());
            for (BakedQuad quad : pottedQuads) {
                if (!containsMatchingQuad(potQuads, quad)) {
                    result.add(quad);
                }
            }
            return result;
        }

        private static boolean containsMatchingQuad(List<BakedQuad> quads, BakedQuad candidate) {
            for (BakedQuad quad : quads) {
                if (quad.getSprite() == candidate.getSprite() && Arrays.equals(quad.getVertexData(), candidate.getVertexData())) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean useAmbientOcclusion() {
            return pottedModel.useAmbientOcclusion();
        }

        @Override
        public boolean hasDepth() {
            return pottedModel.hasDepth();
        }

        @Override
        public boolean isSideLit() {
            return pottedModel.isSideLit();
        }

        @Override
        public boolean isBuiltin() {
            return pottedModel.isBuiltin();
        }

        @Override
        public Sprite getParticleSprite() {
            return pottedModel.getParticleSprite();
        }

        @Override
        public ModelTransformation getTransformation() {
            return pottedModel.getTransformation();
        }

        @Override
        public ModelOverrideList getOverrides() {
            return pottedModel.getOverrides();
        }
    }
}
