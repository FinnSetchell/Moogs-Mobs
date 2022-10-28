package com.finndog.moogsmobs.item;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.block.ModBlocks;
import com.finndog.moogsmobs.entity.ModEntityTypes;
import com.finndog.moogsmobs.item.custom.AnimatedJarBlockItem;
import com.finndog.moogsmobs.item.custom.AnimatedJarItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoogsMobs.MODID);

    public static final RegistryObject<Item> GLOWBUG_SPAWN_EGG = ITEMS.register("glowbug_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GLOWBUG, 0x72f3a4, 0xabcdef,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CAPLING_SPAWN_EGG = ITEMS.register("capling_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CAPLING, 0xc7c1b4, 0x977251,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> DEATH_CAPLING_SPAWN_EGG = ITEMS.register("death_capling_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DEATH_CAPLING, 0x444341, 0x1a1a1a,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> DEATH_CAP_SPAWN_EGG = ITEMS.register("death_cap_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DEATH_CAP, 0x477371, 0x1a1a1a,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> BIOLUMINESCENCE = ITEMS.register("bioluminescence",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> ANIMATED_JAR_ITEM = ITEMS.register("animated_glowbug_jar_item",
            () -> new AnimatedJarItem(new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Item> ANIMATED_JAR_BLOCK_ITEM = ITEMS.register("animated_glowbug_jar_block",
            () -> new AnimatedJarBlockItem(ModBlocks.ANIMATED_JAR_BLOCK.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Item> SHROUDBREAKER_MANUAL = ITEMS.register("shroudbreaker_manual",
            () -> new Item(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
