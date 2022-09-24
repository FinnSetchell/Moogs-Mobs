package com.finndog.moogsmobs.entity.client;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.GlowBugEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class GlowBugLayer<T extends GlowBugEntity> extends GeoLayerRenderer<T> {

    //private static final ResourceLocation GLOWBUG_GLOW = MoogsMobs.getInstance().resource("textures/entity/glow_bug_glow.png");

    protected static final ResourceLocation GLOWBUG_GLOW = new ResourceLocation(MoogsMobs.MODID, "textures/entity/glow_bug_glow.png");

    //private static final ResourceLocation GLOWBUG = MoogsMobs.getInstance().resource("geo/glow_bug.geo.json");
    protected static final ResourceLocation GLOWBUG = new ResourceLocation(MoogsMobs.MODID, "geo/glow_bug.geo.json");

    public GlowBugLayer(IGeoRenderer<T> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType glow = RenderType.eyes(GLOWBUG_GLOW);
        this.getRenderer().render(this.getEntityModel().getModel(GLOWBUG), entityLivingBaseIn, partialTicks, glow,
                matrixStackIn, bufferIn, bufferIn.getBuffer(glow), packedLightIn, OverlayTexture.NO_OVERLAY, 0f, 0.3f, 0.9f, 1f
        );
    }
}
