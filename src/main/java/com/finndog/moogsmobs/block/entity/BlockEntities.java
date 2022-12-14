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

    public static final RegistryObject<BlockEntityType<KegBlockEntity>> KEG_ENTITY =
            BLOCK_ENTITIES.register("keg_entity",
                    () -> BlockEntityType.Builder.of(KegBlockEntity::new, ModBlocks.KEG.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
