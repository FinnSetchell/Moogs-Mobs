package com.finndog.moogsmobs.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MOOGS_MOBS_TAB = new CreativeModeTab("moogs_mobs_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ALE.get());
        }
    };
}
