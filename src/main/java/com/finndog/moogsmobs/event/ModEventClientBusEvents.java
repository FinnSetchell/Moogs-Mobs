package com.finndog.moogsmobs.event;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.block.entity.BlockEntities;
import com.finndog.moogsmobs.block.entity.client.AnimatedJarBlockRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoogsMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntities.ANIMATED_JAR_BLOCK_ENTITY.get(), AnimatedJarBlockRenderer::new);
    }
}
