package com.finndog.moogsmobs.item.properties;

import com.finndog.moogsmobs.effects.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties IRON_GROG = (new FoodProperties.Builder())
            .nutrition(5)
            .saturationMod(0.6f)
            .alwaysEat()
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 3600, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 1.0F)
            .build();

    public static final FoodProperties ALE = (new FoodProperties.Builder())
            .nutrition(5)
            .saturationMod(0.6f)
            .alwaysEat()
            .effect(() -> new MobEffectInstance(ModEffects.FREEZE.get(), 260,0), 1.0f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 0), -2f)
            .effect(new MobEffectInstance(MobEffects.BLINDNESS, 180, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 0.7F)
            .build();

    public static final FoodProperties HONEYBREW = (new FoodProperties.Builder())
            .nutrition(5)
            .saturationMod(0.6f)
            .alwaysEat()
            .effect(() -> new MobEffectInstance(ModEffects.PHANTOM.get(), 3000,0), 1.0f)
            .effect(new MobEffectInstance(ModEffects.ATTRACT.get(), 3000, 0), 1f)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 700, 0), 0.7F)
            .build();


}
