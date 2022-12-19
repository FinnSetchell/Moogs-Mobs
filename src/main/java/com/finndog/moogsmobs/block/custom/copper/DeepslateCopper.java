package com.finndog.moogsmobs.block.custom.copper;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.block.ModBlocks;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;

import java.lang.reflect.Field;
import java.util.function.Supplier;

public class DeepslateCopper {
//    private static final BiMap<Supplier<Block>, Supplier<Block>> WEATHERING = HashBiMap.create();
//    private static final BiMap<Supplier<Block>, Supplier<Block>> WAXABLE = HashBiMap.create();

    public static final Supplier<BiMap<Block, Block>> WAXABLE = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder().put(ModBlocks.WAXED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WAXED_EXPOSED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WAXED_WEATHERED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WAXED_OXIDIZED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.OXIDIZED_COPPER_DEEPSLATE_TILES.get()).build();
    });
    public static final Supplier<BiMap<Block, Block>> WEATHERING = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder().put(ModBlocks.COPPER_DEEPSLATE_TILES.get(), ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.OXIDIZED_COPPER_DEEPSLATE_TILES.get()).build();
    });

    private static boolean injected;
    private static boolean weatheringMemoized;
    private static boolean waxableMemoized;

    public static void inject() {
//        if (injected) {
//            throw new IllegalStateException("Cannot inject DeepslateCopper twice!");
//        }
//        injected = true;
//
//        Supplier<BiMap<Block, Block>> originalWaxableMapSupplier = HoneycombItem.WAXABLES;
//        Supplier<BiMap<Block, Block>> waxableMapSupplier = Suppliers.memoize(() -> {
//            waxableMemoized = true;
//            ImmutableBiMap.Builder<Block, Block> builder = ImmutableBiMap.builder();
//            builder.putAll(originalWaxableMapSupplier.get());
//            WAXABLE.forEach((original, waxed) -> {
//                builder.put(original.get(), waxed.get());
//            });
//            return builder.build();
//        });
//
//        HoneycombItem.WAXABLES = waxableMapSupplier;
    }
}
