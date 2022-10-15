package com.finndog.moogsmobs.item.client;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.item.custom.AnimatedJarBlockItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedJarBlockItemModel extends AnimatedGeoModel<AnimatedJarBlockItem> {
    @Override
    public ResourceLocation getModelResource(AnimatedJarBlockItem object) {
        return new ResourceLocation(MoogsMobs.MODID, "geo/glowbug_jar.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedJarBlockItem object) {
        return new ResourceLocation(MoogsMobs.MODID, "textures/block/glowbug_jar.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedJarBlockItem animatable) {
        return new ResourceLocation(MoogsMobs.MODID, "animations/glowbug_jar.animation.json");
    }
}