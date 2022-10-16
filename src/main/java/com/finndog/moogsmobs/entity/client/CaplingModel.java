package com.finndog.moogsmobs.entity.client;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.CaplingEntity;
import com.finndog.moogsmobs.entity.custom.GlowBugEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CaplingModel extends AnimatedGeoModel<CaplingEntity> {
    @Override
    public ResourceLocation getModelResource(CaplingEntity object) {
        return new ResourceLocation(MoogsMobs.MODID, "geo/capling.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CaplingEntity object) {
        return new ResourceLocation(MoogsMobs.MODID, "textures/entity/capling_brown.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CaplingEntity animatable) {
        return new ResourceLocation(MoogsMobs.MODID, "animations/capling.animation.json");
    }
}
