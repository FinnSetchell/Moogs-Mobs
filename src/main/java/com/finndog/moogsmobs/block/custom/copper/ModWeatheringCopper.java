package com.finndog.moogsmobs.block.custom.copper;

import com.finndog.moogsmobs.block.ModBlocks;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.function.Supplier;

public interface ModWeatheringCopper extends ChangeOverTimeBlock<ModWeatheringCopper.ModWeatherState> {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder().put(ModBlocks.POLISHED_COPPER_DEEPSLATE.get(), ModBlocks.POLISHED_EXPOSED_COPPER_DEEPSLATE.get()).put(ModBlocks.POLISHED_EXPOSED_COPPER_DEEPSLATE.get(), ModBlocks.POLISHED_WEATHERED_COPPER_DEEPSLATE.get()).put(ModBlocks.POLISHED_WEATHERED_COPPER_DEEPSLATE.get(), ModBlocks.POLISHED_OXIDIZED_COPPER_DEEPSLATE.get()).put(ModBlocks.COPPER_DEEPSLATE_TILES.get(), ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.OXIDIZED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.COPPER_DEESPLATE_PILLAR.get(), ModBlocks.EXPOSED_COPPER_DEEPSLATE_PILLAR.get()).put(ModBlocks.EXPOSED_COPPER_DEEPSLATE_PILLAR.get(), ModBlocks.WEATHERED_COPPER_DEEPSLATE_PILLAR.get()).put(ModBlocks.WEATHERED_COPPER_DEEPSLATE_PILLAR.get(), ModBlocks.OXIDIZED_COPPER_DEEPSLATE_PILLAR.get()).build();
    });
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> {
        return NEXT_BY_BLOCK.get().inverse();
    });

    static Optional<Block> getPrevious(Block p_154891_) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(p_154891_));
    }

    static Block getFirst(Block p_154898_) {
        Block block = p_154898_;

        for(Block block1 = PREVIOUS_BY_BLOCK.get().get(p_154898_); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
            block = block1;
        }

        return block;
    }

    static Optional<BlockState> getPrevious(BlockState p_154900_) {
        return getPrevious(p_154900_.getBlock()).map((p_154903_) -> {
            return p_154903_.withPropertiesOf(p_154900_);
        });
    }

    static Optional<Block> getNext(Block p_154905_) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(p_154905_));
    }

    static BlockState getFirst(BlockState p_154907_) {
        return getFirst(p_154907_.getBlock()).withPropertiesOf(p_154907_);
    }

    default Optional<BlockState> getNext(BlockState p_154893_) {
        return getNext(p_154893_.getBlock()).map((p_154896_) -> {
            return p_154896_.withPropertiesOf(p_154893_);
        });
    }

    default float getChanceModifier() {
        return this.getAge() == ModWeatheringCopper.ModWeatherState.UNAFFECTED ? 0.75F : 1.0F;
    }

    public static enum ModWeatherState {
        UNAFFECTED,
        EXPOSED,
        WEATHERED,
        OXIDIZED;
    }
}