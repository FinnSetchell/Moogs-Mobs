package com.finndog.moogsmobs.item;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.block.ModBlocks;
import com.finndog.moogsmobs.entity.ModEntityTypes;
import com.finndog.moogsmobs.item.custom.AleBottleItem;
import com.finndog.moogsmobs.item.properties.ModFoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoogsMobs.MODID);

    // SPAWN EGGS
    public static final RegistryObject<Item> GLOWBUG_SPAWN_EGG = ITEMS.register("glowbug_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityTypes.GLOWBUG, 0x72f3a4, 0xabcdef, new Item.Properties().tab(ModCreativeModeTab.MOOGS_MOBS_TAB)));
    public static final RegistryObject<Item> DWARF_MINER_SPAWN_EGG = ITEMS.register("dwarf_miner_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityTypes.DWARF_MINER, 0xbd845b, 0xb64103, new Item.Properties().tab(ModCreativeModeTab.MOOGS_MOBS_TAB)));
    public static final RegistryObject<Item> CAPLING_SPAWN_EGG = ITEMS.register("capling_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityTypes.CAPLING, 0xc7c1b4, 0x977251, new Item.Properties().tab(ModCreativeModeTab.MOOGS_MOBS_TAB)));
    public static final RegistryObject<Item> DEATH_CAPLING_SPAWN_EGG = ITEMS.register("death_capling_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityTypes.DEATH_CAPLING, 0x444341, 0x1a1a1a, new Item.Properties().tab(ModCreativeModeTab.MOOGS_MOBS_TAB)));
    public static final RegistryObject<Item> DEATH_CAP_SPAWN_EGG = ITEMS.register("death_cap_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityTypes.DEATH_CAP, 0x477371, 0x1a1a1a, new Item.Properties().tab(ModCreativeModeTab.MOOGS_MOBS_TAB)));

    // ITEMS
    public static final RegistryObject<Item> GLOW_GLOOP = ITEMS.register("glow_gloop", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MOOGS_MOBS_TAB)));
    public static final RegistryObject<Item> SHROUDBREAKER_MANUAL = ITEMS.register("shroudbreaker_manual", () -> new Item(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.MOOGS_MOBS_TAB)));
    public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MOOGS_MOBS_TAB)));

    // DRINKS
    public static final RegistryObject<Item> EMPTY_BOTTLE = ITEMS.register("empty_bottle", () -> new AleBottleItem(ModBlocks.EMPTY_BOTTLE_BLOCK.get(),new Item.Properties().tab(ModCreativeModeTab.MOOGS_MOBS_TAB)));
    public static final RegistryObject<Item> IRON_GROG = ITEMS.register("iron_grog", () -> new AleBottleItem(ModBlocks.IRON_GROG.get(),new Item.Properties().food(ModFoodProperties.IRON_GROG).stacksTo(16).tab(ModCreativeModeTab.MOOGS_MOBS_TAB)));
    public static final RegistryObject<Item> ALE = ITEMS.register("ale", () -> new AleBottleItem(ModBlocks.ALE.get(),new Item.Properties().food(ModFoodProperties.ALE).stacksTo(16).tab(ModCreativeModeTab.MOOGS_MOBS_TAB)));
    public static final RegistryObject<Item> HONEYBREW = ITEMS.register("honeybrew", () -> new AleBottleItem(ModBlocks.HONEYBREW.get(),new Item.Properties().food(ModFoodProperties.HONEYBREW).stacksTo(16).tab(ModCreativeModeTab.MOOGS_MOBS_TAB)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
