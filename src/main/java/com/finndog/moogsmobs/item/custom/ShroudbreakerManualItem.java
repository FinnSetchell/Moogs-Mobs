package com.finndog.moogsmobs.item.custom;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ShroudbreakerManualItem extends Item {
    public ShroudbreakerManualItem() {
        super(new Properties()
                .tab(CreativeModeTab.TAB_MISC)
                .stacksTo(1)
                .rarity(Rarity.RARE)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer() != null) {
            context.getLevel().playSound(context.getPlayer(), context.getPlayer(),
                    SoundEvents.BOOK_PAGE_TURN, SoundSource.NEUTRAL, 1.0F, 1.0F);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.FAIL;
    }
}