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
    public static final Supplier<Map<Block, Block>> WAXABLES = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder().put(ModBlocks.WAXED_POLISHED_COPPER_DEEPSLATE.get(), ModBlocks.POLISHED_COPPER_DEEPSLATE.get()).put(ModBlocks.WAXED_POLISHED_EXPOSED_COPPER_DEEPSLATE.get(), ModBlocks.POLISHED_EXPOSED_COPPER_DEEPSLATE.get()).put(ModBlocks.WAXED_POLISHED_WEATHERED_COPPER_DEEPSLATE.get(), ModBlocks.POLISHED_WEATHERED_COPPER_DEEPSLATE.get()).put(ModBlocks.WAXED_POLISHED_OXIDIZED_COPPER_DEEPSLATE.get(), ModBlocks.POLISHED_OXIDIZED_COPPER_DEEPSLATE.get()).put(ModBlocks.WAXED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WAXED_EXPOSED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WAXED_WEATHERED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WAXED_OXIDIZED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.OXIDIZED_COPPER_DEEPSLATE_TILES.get()).put(ModBlocks.WAXED_COPPER_DEESPLATE_PILLAR.get(), ModBlocks.COPPER_DEESPLATE_PILLAR.get()).put(ModBlocks.WAXED_EXPOSED_COPPER_DEEPSLATE_PILLAR.get(), ModBlocks.EXPOSED_COPPER_DEEPSLATE_PILLAR.get()).put(ModBlocks.WAXED_WEATHERED_COPPER_DEEPSLATE_PILLAR.get(), ModBlocks.WEATHERED_COPPER_DEEPSLATE_PILLAR.get()).put(ModBlocks.WAXED_OXIDIZED_COPPER_DEEPSLATE_PILLAR.get(), ModBlocks.OXIDIZED_COPPER_DEEPSLATE_PILLAR.get()).build();
    });

    private final ModWeatheringCopper.ModWeatherState ModWeatherState;

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState blockState, UseOnContext context, ToolAction toolAction, boolean simulate) {
        Level level = context.getLevel();

        if (getWaxOff(blockState) == null) {
            return super.getToolModifiedState(blockState, context, toolAction, simulate);
        }
        //check what tool action performed, returns blockstate to transform into
        return ToolActions.AXE_WAX_OFF.equals(toolAction) ? getWaxOff(blockState) : null;
    }



    public static BlockState getWaxOff(BlockState originalState) {
//        return WAX_OFF_BY_BLOCK.get().get(originalState.getBlock());

        Block block = WAXABLES.get().get(originalState.getBlock());
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