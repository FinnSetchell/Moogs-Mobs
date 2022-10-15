package com.finndog.moogsmobs.block;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.block.custom.AnimatedGlowBugJarBlock;
import com.finndog.moogsmobs.block.custom.JarBlock;
import com.finndog.moogsmobs.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SoundType;
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

//    public static RegistryObject<Block> JAR_BLOCK = registerBlock("jar_block",
//            () -> new Block(BlockBehaviour.Properties
//                    .of(Material.GLASS)
//                    .sound(SoundType.GLASS)),
//            CreativeModeTab.TAB_DECORATIONS);

    public static RegistryObject<Block> JAR = registerBlock("jar_block",
            () -> new JarBlock(BlockBehaviour.Properties
                    .of(Material.GLASS)
                    .strength(0.5f, 1f)
                    .sound(SoundType.GLASS)),
            CreativeModeTab.TAB_DECORATIONS);

    public static RegistryObject<Block> FLUORESCENT_LANTERN = registerBlock("fluorescent_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties
                    .of(Material.METAL)
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightLevel((p_187433_) -> {return 10;})),
            CreativeModeTab.TAB_DECORATIONS);



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    public static final RegistryObject<Block> ANIMATED_JAR_BLOCK = registerBlockWithoutBlockItem("animated_glowbug_jar_block",
            () -> new AnimatedGlowBugJarBlock(BlockBehaviour.Properties.of(Material.GLASS).noOcclusion()));

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
