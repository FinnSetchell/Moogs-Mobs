package com.finndog.moogsmobs.event;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.ModEntityTypes;
import com.finndog.moogsmobs.entity.custom.CaplingEntity;
import com.finndog.moogsmobs.entity.custom.DwarfMinerEntity;
import com.finndog.moogsmobs.entity.custom.GlowBugEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = MoogsMobs.MODID)
    public static class ForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = MoogsMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.GLOWBUG.get(), GlowBugEntity.setAttributes());
            event.put(ModEntityTypes.CAPLING.get(), CaplingEntity.setAttributes());
            event.put(ModEntityTypes.DWARF_MINER.get(), DwarfMinerEntity.setAttributes());
        }
    }
}
