package com.finndog.moogsmobs.block.custom.copper;

import com.finndog.moogsmobs.block.ModBlocks;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Supplier;

public class DeepslateWeatheringCopper extends Block implements ModWeatheringCopper {
    public static final Supplier<BiMap<Block, Block>> WAXABLES = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder().put(ModBlocks.WAXED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WAXED_EXPOSED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WAXED_WEATHERED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WAXED_OXIDIZED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.OXIDIZED_COPPER_DEEPSLATE_TILES.get()).build();
    });
    public static final Supplier<BiMap<Block, Block>> SCRAPE = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder().put(ModBlocks.COPPER_DEEPSLATE_TILES.get(), ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.OXIDIZED_COPPER_DEEPSLATE_TILES.get()).build();
    });

    private final ModWeatheringCopper.ModWeatherState ModWeatherState;

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState blockState, UseOnContext context, ToolAction toolAction, boolean simulate) {

        return ToolActions.AXE_WAX_OFF.equals(toolAction) ?
                getWaxOff(blockState) : ToolActions.AXE_SCRAPE.equals(toolAction) ?
                getScrapedBlock(blockState) : null;
    }

    public static BlockState getWaxed(BlockState originalState) {
        Block block = WAXABLES.get().inverse().get(originalState.getBlock());
        return block!=null ? block.defaultBlockState() : null;
    }
    public static BlockState getWaxOff(BlockState originalState) {
        Block block = WAXABLES.get().get(originalState.getBlock());
        return block!=null ? block.defaultBlockState() : null;
    }
    public static BlockState getScrapedBlock(BlockState originalState) {
        Block block = SCRAPE.get().inverse().get(originalState.getBlock());
        return block!=null ? block.defaultBlockState() : null;
    }


    public DeepslateWeatheringCopper(ModWeatheringCopper.ModWeatherState p_154925_, BlockBehaviour.Properties p_154926_) {
        super(p_154926_);
        this.ModWeatherState = p_154925_;
    }

    public void randomTick(BlockState p_222665_, ServerLevel p_222666_, BlockPos p_222667_, RandomSource p_222668_) {
        this.onRandomTick(p_222665_, p_222666_, p_222667_, p_222668_);
    }

    public boolean isRandomlyTicking(BlockState p_154935_) {
        return ModWeatheringCopper.getNext(p_154935_.getBlock()).isPresent();
    }

    public ModWeatheringCopper.ModWeatherState getAge() {
        return this.ModWeatherState;
    }
}