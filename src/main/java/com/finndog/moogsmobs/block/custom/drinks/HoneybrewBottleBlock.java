package com.finndog.moogsmobs.block.custom.drinks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HoneybrewBottleBlock extends BottleBlock {

    public HoneybrewBottleBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState p_220827_, Level p_220828_, BlockPos p_220829_, RandomSource p_220830_) {
        if (p_220830_.nextFloat() < 0.4f) {
            double d0 = (double)p_220829_.getX() + 0.4D + p_220830_.nextDouble() * 0.2D;
            double d1 = (double)p_220829_.getY() + 0.2D + p_220830_.nextDouble() * (0.2D - 0.02D);
            double d2 = (double)p_220829_.getZ() + 0.4D + p_220830_.nextDouble() * 0.2D;
            p_220828_.addParticle(ParticleTypes.DRIPPING_HONEY, d0, d1, d2, 0.0D, p_220830_.nextDouble() * 0.1D, 0.0D);
        }
    }
}
