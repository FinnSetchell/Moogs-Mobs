package com.finndog.moogsmobs.entity.client;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.CaplingEntity;
import com.finndog.moogsmobs.entity.custom.DeathCaplingEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DeathCaplingModel extends AnimatedGeoModel<DeathCaplingEntity> {
    @Override
    public ResourceLocation getModelResource(DeathCaplingEntity object) {
        return new ResourceLocation(MoogsMobs.MODID, "geo/capling.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DeathCaplingEntity object) {
        return new ResourceLocation(MoogsMobs.MODID, "textures/entity/death_capling.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DeathCaplingEntity animatable) {
        return new ResourceLocation(MoogsMobs.MODID, "animations/capling.animation.json");
    }
}
