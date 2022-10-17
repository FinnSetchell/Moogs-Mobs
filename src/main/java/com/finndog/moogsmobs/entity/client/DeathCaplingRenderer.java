package com.finndog.moogsmobs.entity.client;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.CaplingEntity;
import com.finndog.moogsmobs.entity.custom.DeathCaplingEntity;
import com.finndog.moogsmobs.entity.variant.CaplingVariant;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class DeathCaplingRenderer extends GeoEntityRenderer<DeathCaplingEntity> {

    public DeathCaplingRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeathCaplingModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(DeathCaplingEntity instance) {
        return new ResourceLocation(MoogsMobs.MODID, "textures/entity/death_capling.png");
    }

    @Override
    public RenderType getRenderType(DeathCaplingEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
            stack.scale(1F, 1F, 1F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
