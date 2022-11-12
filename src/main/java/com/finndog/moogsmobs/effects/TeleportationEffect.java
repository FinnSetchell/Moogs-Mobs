/** THANKS TO hadrus FOR THE MOD Alcocraft: Beer & Stuff FOR THIS EFFECTS. (uses MIT license)*/
package com.finndog.moogsmobs.effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;

import java.util.Random;

public class TeleportationEffect extends MobEffect {

    protected TeleportationEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Random random = new Random();

        double x = pLivingEntity.getX();
        double y = pLivingEntity.getY();
        double z = pLivingEntity.getZ();

        pLivingEntity.teleportTo(x + random.nextDouble()+8-4, y + random.nextDouble()+8-4, z + random.nextDouble()+8-4);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
