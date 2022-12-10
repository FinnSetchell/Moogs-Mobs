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
    public static final RegistryObject<Block> DWARVEN_PILLAR = registerBlock("dwarven_pillar",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CUT_DWARVEN_PILLAR = registerBlock("cut_dwarven_pillar",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DWARVEN_PILLAR_TOP = registerBlock("dwarven_pillar_top",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CUT_DWARVEN_STONE = registerBlock("cut_dwarven_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

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
