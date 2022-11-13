/** THANKS TO hadrus FOR THE MOD Alcocraft: Beer & Stuff FOR SOME OF THESE EFFECTS. (uses MIT license)*/
package com.finndog.moogsmobs.effects;

import com.finndog.moogsmobs.MoogsMobs;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MoogsMobs.MODID);

    public static final RegistryObject<MobEffect> FREEZE = EFFECTS.register("freeze",
            () -> new FreezeEffect(MobEffectCategory.HARMFUL, rawColorFromRGB(143, 181, 246)));

    public static final RegistryObject<MobEffect> ATTRACT = EFFECTS.register("attract",
            () -> new AttractEffect(MobEffectCategory.BENEFICIAL, rawColorFromRGB(170, 14,1)));

        public static final RegistryObject<MobEffect> ANIMAL_FRIEND = EFFECTS.register("animal_friend",
            () -> new AttractEffect(MobEffectCategory.BENEFICIAL, rawColorFromRGB(170, 14,1)));

    public static final RegistryObject<MobEffect> INVISIBLE_MOB_EFFECT = EFFECTS.register("invisible_mob_effect",
            () -> new InvisibleMobEffect(MobEffectCategory.NEUTRAL, rawColorFromRGB(29, 5, 3)));

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }

    public static int rawColorFromRGB(int red, int green, int blue) {
        int rgb = Math.max(Math.min(0xFF, red), 0);
        rgb = (rgb << 8) + Math.max(Math.min(0xFF, green), 0);
        rgb = (rgb << 8) + Math.max(Math.min(0xFF, blue), 0);
        return rgb;
    }
}
