/** THANKS TO hadrus FOR THE MOD Alcocraft: Beer & Stuff FOR THIS EFFECTS. (uses MIT license)*/
package com.finndog.moogsmobs.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class InvisibleMobEffect extends MobEffect {

    protected InvisibleMobEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Level level = pLivingEntity.level;

        for(Entity e : level.getEntities(pLivingEntity, new AABB(pLivingEntity.blockPosition()).inflate(50))){
            if (e instanceof LivingEntity entity) {
                if (entity.getLastHurtByMob() == pLivingEntity) {
                    entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 40, 10));
                    entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 5, 1));
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
