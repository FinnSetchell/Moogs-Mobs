package com.finndog.moogsmobs.block.entity;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.block.ModBlocks;
import com.finndog.moogsmobs.block.entity.custom.KegBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MoogsMobs.MODID);

//    public static final RegistryObject<BlockEntityType<AnimatedJarBlockEntity>> ANIMATED_JAR_BLOCK_ENTITY =
//            BLOCK_ENTITIES.register("animated_glowbug_jar_block", () ->
//                    BlockEntityType.Builder.of(AnimatedJarBlockEntity::new,
//                            ModBlocks.ANIMATED_JAR_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<JarEntity>> JAR_ENTITY =
            BLOCK_ENTITIES.register("jar_entity",
                    () -> BlockEntityType.Builder.of(JarEntity::new, ModBlocks.JAR.get()).build(null));

        public static final RegistryObject<BlockEntityType<GlowbugJarEntity>> GLOWBUG_JAR_ENTITY =
            BLOCK_ENTITIES.register("glowbug_ar_entity",
                    () -> BlockEntityType.Builder.of(GlowbugJarEntity::new, ModBlocks.GLOWBUG_JAR.get()).build(null));

    public static final RegistryObject<BlockEntityType<KegBlockEntity>> KEG_ENTITY =
            BLOCK_ENTITIES.register("keg_entity",
                    () -> BlockEntityType.Builder.of(KegBlockEntity::new, ModBlocks.KEG.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
