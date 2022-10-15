package com.finndog.moogsmobs.block.entity.client;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.block.entity.custom.AnimatedJarBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedJarBlockModel extends AnimatedGeoModel<AnimatedJarBlockEntity> {
    @Override
    public ResourceLocation getModelResource(AnimatedJarBlockEntity object) {
        return new ResourceLocation(MoogsMobs.MODID, "geo/glowbug_jar.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedJarBlockEntity object) {
        return new ResourceLocation(MoogsMobs.MODID, "textures/block/glowbug_jar.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedJarBlockEntity animatable) {
        return new ResourceLocation(MoogsMobs.MODID, "animations/glowbug_jar.animation.json");
    }
}