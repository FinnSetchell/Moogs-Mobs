package com.finndog.moogsmobs.entity.goals;

import com.finndog.moogsmobs.entity.custom.DeathCaplingEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class DeathCaplingExplodeGoal extends Goal {
    private final DeathCaplingEntity deathCapling;
    @Nullable
    private LivingEntity target;

    public DeathCaplingExplodeGoal(DeathCaplingEntity capling) {
        this.deathCapling = capling;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    public boolean canUse() {
        LivingEntity livingentity = this.deathCapling.getTarget();
        return this.deathCapling.getSwellDir() > 0 || livingentity != null && this.deathCapling.distanceToSqr(livingentity) < 9.0D;
    }

    public void start() {
        this.deathCapling.getNavigation().stop();
        this.target = this.deathCapling.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target == null) {
            this.deathCapling.setSwellDir(-1);
        } else if (this.deathCapling.distanceToSqr(this.target) > 49.0D) {
            this.deathCapling.setSwellDir(-1);
        } else if (!this.deathCapling.getSensing().hasLineOfSight(this.target)) {
            this.deathCapling.setSwellDir(-1);
        } else {
            this.deathCapling.setSwellDir(1);
        }
    }
}
