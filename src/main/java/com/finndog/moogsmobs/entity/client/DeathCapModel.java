package com.finndog.moogsmobs.entity.client;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.DeathCapEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DeathCapModel extends AnimatedGeoModel<DeathCapEntity> {
    @Override
    public ResourceLocation getModelResource(DeathCapEntity object) {
        return new ResourceLocation(MoogsMobs.MODID, "geo/death_cap.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DeathCapEntity object) {
        return new ResourceLocation(MoogsMobs.MODID, "textures/entity/death_cap.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DeathCapEntity animatable) {
        return new ResourceLocation(MoogsMobs.MODID, "animations/death_cap.animation.json");
    }
}
