package com.finndog.moogsmobs.entity.goals;

import com.finndog.moogsmobs.entity.custom.DwarfMinerEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class DwarfAttackGoal extends MeleeAttackGoal {
    private final DwarfMinerEntity dwarf;
    private int raiseArmTicks;

    public DwarfAttackGoal(DwarfMinerEntity p_26019_, double p_26020_, boolean p_26021_) {
        super(p_26019_, p_26020_, p_26021_);
        this.dwarf = p_26019_;
    }

    public void start() {
        super.start();
        this.raiseArmTicks = 0;
    }

    public void stop() {
        super.stop();
        this.dwarf.setAggressive(false);
    }

    public void tick() {
        super.tick();
        ++this.raiseArmTicks;
        if (this.raiseArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2) {
            this.dwarf.setAggressive(true);
        } else {
            this.dwarf.setAggressive(false);
        }

    }
}