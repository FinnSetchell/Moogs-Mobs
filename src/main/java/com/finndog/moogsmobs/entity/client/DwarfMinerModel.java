package com.finndog.moogsmobs.entity.client;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.DwarfMinerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DwarfMinerModel extends AnimatedGeoModel<DwarfMinerEntity> {
    @Override
    public ResourceLocation getModelResource(DwarfMinerEntity object) {
        return new ResourceLocation(MoogsMobs.MODID, "geo/dwarfminer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DwarfMinerEntity object) {
        return new ResourceLocation(MoogsMobs.MODID, "textures/entity/dwarfminer_" + object.getVariant().getName() + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(DwarfMinerEntity animatable) {
        return new ResourceLocation(MoogsMobs.MODID, "animations/dwarfminer.animation.json");
    }
}
