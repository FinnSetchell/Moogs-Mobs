package com.finndog.moogsmobs.entity.goals;

import com.finndog.moogsmobs.entity.custom.CaplingEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class CaplingExplodeGoal extends Goal {
    private final CaplingEntity capling;
    @Nullable
    private LivingEntity target;

    public CaplingExplodeGoal(CaplingEntity capling) {
        this.capling = capling;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean canUse() {
        LivingEntity livingentity = this.capling.getTarget();
        return this.capling.getSwellDir() > 0 || livingentity != null && this.capling.distanceToSqr(livingentity) < 9.0D;
    }

    public void start() {
        this.capling.getNavigation().stop();
        this.target = this.capling.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target == null) {
            this.capling.setSwellDir(-1);
        } else if (this.capling.distanceToSqr(this.target) > 49.0D) {
            this.capling.setSwellDir(-1);
        } else if (!this.capling.getSensing().hasLineOfSight(this.target)) {
            this.capling.setSwellDir(-1);
        } else {
            this.capling.setSwellDir(1);
        }
    }
}
