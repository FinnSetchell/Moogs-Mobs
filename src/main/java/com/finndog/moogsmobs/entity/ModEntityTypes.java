package com.finndog.moogsmobs.entity;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.CaplingEntity;
import com.finndog.moogsmobs.entity.custom.DeathCapEntity;
import com.finndog.moogsmobs.entity.custom.DeathCaplingEntity;
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

    public static final RegistryObject<EntityType<DeathCaplingEntity>> DEATH_CAPLING =
            ENTITY_TYPES.register("death_capling",
                    () -> EntityType.Builder.of(DeathCaplingEntity::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.6f)
                            .build(new ResourceLocation(MoogsMobs.MODID, "death_capling").toString()));

    public static final RegistryObject<EntityType<DeathCapEntity>> DEATH_CAP =
            ENTITY_TYPES.register("death_cap",
                    () -> EntityType.Builder.of(DeathCapEntity::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.6f)
                            .build(new ResourceLocation(MoogsMobs.MODID, "death_cap").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
