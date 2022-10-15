package com.finndog.moogsmobs.item.client;

import com.finndog.moogsmobs.item.custom.AnimatedJarBlockItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class AnimatedJarBlockItemRenderer extends GeoItemRenderer<AnimatedJarBlockItem> {
    public AnimatedJarBlockItemRenderer() {
        super(new AnimatedJarBlockItemModel());
    }
}
