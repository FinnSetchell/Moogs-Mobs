package com.finndog.moogsmobs.block.entity.client;

import com.finndog.moogsmobs.block.entity.custom.AnimatedJarBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class AnimatedJarBlockRenderer extends GeoBlockRenderer<AnimatedJarBlockEntity> {
    public AnimatedJarBlockRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        super(rendererDispatcherIn, new AnimatedJarBlockModel());
    }

    @Override
    public RenderType getRenderType(AnimatedJarBlockEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder,
                                    int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}
