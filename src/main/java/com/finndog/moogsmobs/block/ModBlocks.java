package com.finndog.moogsmobs.block;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.block.custom.KegBlock;
import com.finndog.moogsmobs.block.custom.drinks.AleBottleBlock;
import com.finndog.moogsmobs.block.custom.drinks.BottleBlock;
import com.finndog.moogsmobs.block.custom.drinks.HoneybrewBottleBlock;
import com.finndog.moogsmobs.block.custom.drinks.IronGrogBlock;
import com.finndog.moogsmobs.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MoogsMobs.MODID);

    // GENERAL NON BLOCKS
    public static RegistryObject<Block> FLUORESCENT_LANTERN = registerBlock("fluorescent_lantern", () -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1.5F).sound(SoundType.LANTERN).lightLevel((p_187433_) -> {return 10;})), CreativeModeTab.TAB_DECORATIONS);

    // BOTTLES
    public static final RegistryObject<Block> EMPTY_BOTTLE_BLOCK = registerBlockWithoutBlockItem("empty_bottle_block", () -> new BottleBlock(BlockBehaviour.Properties.copy(Blocks.BARREL).noOcclusion()));
    public static final RegistryObject<Block> IRON_GROG = registerBlockWithoutBlockItem("iron_grog_block", () -> new IronGrogBlock(BlockBehaviour.Properties.copy(Blocks.BARREL).noOcclusion()));
    public static final RegistryObject<Block> ALE = registerBlockWithoutBlockItem("ale_block", () -> new AleBottleBlock(BlockBehaviour.Properties.copy(Blocks.BARREL).noOcclusion()));
    public static final RegistryObject<Block> HONEYBREW = registerBlockWithoutBlockItem("honeybrew_block", () -> new HoneybrewBottleBlock(BlockBehaviour.Properties.copy(Blocks.BARREL).noOcclusion()));
    public static final RegistryObject<Block> KEG = registerBlock("keg", () -> new KegBlock(BlockBehaviour.Properties.copy(Blocks.BARREL).noOcclusion()), CreativeModeTab.TAB_FOOD);

    // GENERAL BLOCKS
    public static final RegistryObject<Block> DWARVEN_PILLAR = registerBlock("dwarven_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CUT_DWARVEN_PILLAR = registerBlock("cut_dwarven_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CUT_DWARVEN_STONE = registerBlock("cut_dwarven_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> POLISHED_COPPER_DEEPSLATE = registerBlock("polished_copper_deepslate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_EXPOSED_COPPER_DEEPSLATE = registerBlock("polished_exposed_copper_deepslate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_WEATHERED_COPPER_DEEPSLATE = registerBlock("polished_weathered_copper_deepslate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_OXIDIZED_COPPER_DEEPSLATE = registerBlock("polished_oxidized_copper_deepslate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GILDED_POLISHED_DEEPSLATE = registerBlock("gilded_polished_deepslate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BRASS_POLISHED_DEEPSLATE = registerBlock("brass_polished_deepslate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> COPPER_DEESPLATE_PILLAR = registerBlock("copper_deepslate_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> EXPOSED_COPPER_DEEPSLATE_PILLAR = registerBlock("exposed_copper_deepslate_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> WEATHERED_COPPER_DEEPSLATE_PILLAR = registerBlock("weathered_copper_deepslate_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> OXIDIZED_COPPER_DEEPSLATE_PILLAR = registerBlock("oxidized_copper_deepslate_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GILDED_DEEPSLATE_PILLAR = registerBlock("gilded_deepslate_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> RUNIC_GILDED_DEEPSLATE_PILLAR = registerBlock("runic_gilded_deepslate_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BRASS_DEEPSLATE_PILLAR = registerBlock("brass_deepslate_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> COPPER_DEEPSLATE_TILES = registerBlock("copper_deepslate_tiles", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> EXPOSED_COPPER_DEEPSLATE_TILES = registerBlock("exposed_copper_deepslate_tiles", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> WEATHERED_COPPER_DEEPSLATE_TILES = registerBlock("weathered_copper_deepslate_tiles", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> OXIDIZED_COPPER_DEEPSLATE_TILES = registerBlock("oxidized_copper_deepslate_tiles", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GILDED_DEEPSLATE_TILES = registerBlock("gilded_deepslate_tiles", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BRASS_DEEPSLATE_TILES = registerBlock("brass_deepslate_tiles", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
