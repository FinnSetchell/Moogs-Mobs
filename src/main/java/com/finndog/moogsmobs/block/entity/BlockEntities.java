package com.finndog.moogsmobs.block.entity;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.block.ModBlocks;
import com.finndog.moogsmobs.block.entity.custom.AnimatedJarBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MoogsMobs.MODID);

    public static final RegistryObject<BlockEntityType<AnimatedJarBlockEntity>> ANIMATED_JAR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("animated_glowbug_jar_block", () ->
                    BlockEntityType.Builder.of(AnimatedJarBlockEntity::new,
                            ModBlocks.ANIMATED_JAR_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
