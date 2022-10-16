package com.finndog.moogsmobs.entity.client;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.CaplingEntity;
import com.finndog.moogsmobs.entity.custom.GlowBugEntity;
import com.finndog.moogsmobs.entity.variant.CaplingVariant;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class CaplingRenderer extends GeoEntityRenderer<CaplingEntity> {
    public static final Map<CaplingVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(CaplingVariant.class), (t) -> {
                t.put(CaplingVariant.DEFAULT,
                        new ResourceLocation(MoogsMobs.MODID, "textures/entity/capling_brown.png"));
                t.put(CaplingVariant.PINK,
                        new ResourceLocation(MoogsMobs.MODID, "textures/entity/capling_pink.png"));
                t.put(CaplingVariant.RED,
                        new ResourceLocation(MoogsMobs.MODID, "textures/entity/capling_red.png"));
                t.put(CaplingVariant.YELLOW,
                        new ResourceLocation(MoogsMobs.MODID, "textures/entity/capling_yellow.png"));
            });

    public CaplingRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CaplingModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(CaplingEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public RenderType getRenderType(CaplingEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
            stack.scale(1F, 1F, 1F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
