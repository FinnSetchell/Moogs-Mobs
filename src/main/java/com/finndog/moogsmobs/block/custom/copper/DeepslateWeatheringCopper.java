package com.finndog.moogsmobs.block.custom.copper;

import com.finndog.moogsmobs.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class DeepslateWeatheringCopper extends Block implements ModWeatheringCopper {
    private final ModWeatheringCopper.ModWeatherState ModWeatherState;

    @Override
    public InteractionResult use(BlockState blockState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult blockHitResult) {
        if (!pLevel.isClientSide()) {
            ItemStack itemStack = pPlayer.getItemInHand(pHand);

            if (itemStack.is(ModItems.EMPTY_BOTTLE.get())) {

            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
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