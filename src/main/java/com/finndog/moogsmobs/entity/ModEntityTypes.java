package com.finndog.moogsmobs.entity;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.CaplingEntity;
import com.finndog.moogsmobs.entity.custom.DwarfMinerEntity;
import com.finndog.moogsmobs.entity.custom.GlowBugEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MoogsMobs.MODID);

    public static final RegistryObject<EntityType<GlowBugEntity>> GLOWBUG =
            ENTITY_TYPES.register("glowbug",
                    ( ) -> EntityType.Builder.of(GlowBugEntity:: new, MobCategory.AMBIENT)
                            .sized(0.4f, 0.2f)
                            .build(new ResourceLocation(MoogsMobs.MODID, "glowbug") .toString()));

    public static final RegistryObject<EntityType<CaplingEntity>> CAPLING =
            ENTITY_TYPES.register("capling",
                    () -> EntityType.Builder.of(CaplingEntity::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.6f)
                            .build(new ResourceLocation(MoogsMobs.MODID, "capling").toString()));

    public static final RegistryObject<EntityType<DwarfMinerEntity>> DWARF_MINER =
            ENTITY_TYPES.register("dwarf_miner",
                    () -> EntityType.Builder.of(DwarfMinerEntity::new, MobCategory.CREATURE)
                            .sized(0.8f, 1.3f)
                            .build(new ResourceLocation(MoogsMobs.MODID, "dwarf_miner").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
