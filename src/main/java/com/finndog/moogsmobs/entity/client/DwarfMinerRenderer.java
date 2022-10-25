package com.finndog.moogsmobs.entity.client;

import com.finndog.moogsmobs.entity.custom.DwarfMinerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DwarfMinerRenderer extends GeoEntityRenderer<DwarfMinerEntity> {
    public DwarfMinerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DwarfMinerModel());
    }
}
