package com.finndog.moogsmobs.entity.client;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.GlowBugEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GlowBugRenderer extends GeoEntityRenderer<GlowBugEntity> {
    public GlowBugRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GlowBugModel());
        this.shadowRadius = 0.1f;
        this.addLayer(new GlowBugLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(GlowBugEntity instance) {
        return new ResourceLocation(MoogsMobs.MODID, "textures/entity/glowbug.png");
    }

    @Override
    public RenderType getRenderType(GlowBugEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
