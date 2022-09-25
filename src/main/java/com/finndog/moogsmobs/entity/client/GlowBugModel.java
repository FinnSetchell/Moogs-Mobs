package com.finndog.moogsmobs.entity.client;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.GlowBugEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GlowBugModel extends AnimatedGeoModel<GlowBugEntity> {
    @Override
    public ResourceLocation getModelResource(GlowBugEntity object) {
        return new ResourceLocation(MoogsMobs.MODID, "geo/glowbug.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GlowBugEntity object) {
        return new ResourceLocation(MoogsMobs.MODID, "textures/entity/glowbug.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GlowBugEntity animatable) {
        return new ResourceLocation(MoogsMobs.MODID, "animations/glowbug.animation.json");
    }
}
