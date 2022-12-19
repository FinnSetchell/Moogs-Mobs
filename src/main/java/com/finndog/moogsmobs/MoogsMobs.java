package com.finndog.moogsmobs;

import com.finndog.moogsmobs.block.ModBlocks;
import com.finndog.moogsmobs.block.custom.copper.DeepslateCopper;
import com.finndog.moogsmobs.block.entity.BlockEntities;
import com.finndog.moogsmobs.effects.ModEffects;
import com.finndog.moogsmobs.entity.ModEntityTypes;
import com.finndog.moogsmobs.entity.client.CaplingRenderer;
import com.finndog.moogsmobs.entity.client.DeathCapRenderer;
import com.finndog.moogsmobs.entity.client.DeathCaplingRenderer;
import com.finndog.moogsmobs.entity.client.DwarfMinerRenderer;
import com.finndog.moogsmobs.entity.client.GlowBugRenderer;
import com.finndog.moogsmobs.entity.custom.CaplingEntity;
import com.finndog.moogsmobs.entity.custom.DeathCapEntity;
import com.finndog.moogsmobs.entity.custom.DeathCaplingEntity;
import com.finndog.moogsmobs.entity.custom.GlowBugEntity;
import com.finndog.moogsmobs.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoogsMobs.MODID)
public class MoogsMobs
{
    public static final String MODID = "moogsmobs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MoogsMobs()
    {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        BlockEntities.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModEffects.register(eventBus);

        DeepslateCopper.inject();

        GeckoLib.initialize();

        eventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntityTypes.GLOWBUG.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    GlowBugEntity::checkGlowbugSpawnRules);

            SpawnPlacements.register(ModEntityTypes.CAPLING.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    CaplingEntity::checkCaplingSpawnRules);

            SpawnPlacements.register(ModEntityTypes.DEATH_CAPLING.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    DeathCaplingEntity::checkDeathCaplingSpawnRules);

            SpawnPlacements.register(ModEntityTypes.DEATH_CAP.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    DeathCapEntity::checkDeathCapSpawnRules);
        });
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.GLOWBUG.get(), GlowBugRenderer::new);
            EntityRenderers.register(ModEntityTypes.CAPLING.get(), CaplingRenderer::new);
            EntityRenderers.register(ModEntityTypes.DEATH_CAPLING.get(), DeathCaplingRenderer::new);
            EntityRenderers.register(ModEntityTypes.DWARF_MINER.get(), DwarfMinerRenderer::new);
            EntityRenderers.register(ModEntityTypes.DEATH_CAP.get(), DeathCapRenderer::new);
        }
    }
}
