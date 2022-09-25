package com.finndog.moogsmobs.entity;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.ChomperEntity;
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

    public static final RegistryObject<EntityType<ChomperEntity>> CHOMPER =
            ENTITY_TYPES. register("chomper",
                    ( ) -> EntityType.Builder.of(ChomperEntity:: new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(MoogsMobs.MODID, "chomper") .toString()));
    public static final RegistryObject<EntityType<GlowBugEntity>> GLOWBUG =
            ENTITY_TYPES. register("glowbug",
                    ( ) -> EntityType.Builder.of(GlowBugEntity:: new, MobCategory.AMBIENT)
                            .sized(0.4f, 0.2f)
                            .build(new ResourceLocation(MoogsMobs.MODID, "glowbug") .toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
