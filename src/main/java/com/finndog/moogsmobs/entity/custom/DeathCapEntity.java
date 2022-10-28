package com.finndog.moogsmobs.entity.custom;

import com.finndog.moogsmobs.entity.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.util.SpawnUtil;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.ZombieEvent;
import net.minecraftforge.network.PlayMessages;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Collection;

public class DeathCapEntity extends Monster implements IAnimatable {
    public boolean hibernating;
    private AnimationFactory factory = new AnimationFactory(this);

    public DeathCapEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 80.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2f)
                .add(Attributes.ARMOR, 12f)
                .add(Attributes.ATTACK_DAMAGE, 10f)
                .add(Attributes.ATTACK_KNOCKBACK, 3f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 7f)
                .add(Attributes.ATTACK_SPEED, 1f)
                .build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));

        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.death_cap.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.death_cap.idlesleep", true));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.death_cap.bite", false));
            this.swinging = false;
        }

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                1, this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController",
                0, this::attackPredicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.STEM_STEP, 0.15f, 1.0f);
    }

    public static boolean checkDeathCapSpawnRules(EntityType<DeathCapEntity> entityType, LevelAccessor level, MobSpawnType type, BlockPos pos, RandomSource random) {
        return checkMobSpawnRules(entityType, level, type, pos, random);
    }

    protected SoundEvent getAmbientSound() { return SoundEvents.TROPICAL_FISH_AMBIENT; }
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.COD_HURT;}
    protected SoundEvent getDeathSound() {return SoundEvents.DOLPHIN_DEATH;}
    protected float getSoundVolume() {return 0.1f;}

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    public void tick() {
        double chance = Math.random() * 100;
        if (this.isAlive()) {
            if (hibernating) {
                //heal when hibernating
                if (chance >= 0.08) {
                    setHealth(getHealth() + 1);
                }
            }

            if (!hibernating) {
                if (chance < 0.45) {
                    if (!this.level.isClientSide) {
                        spawnMinions(((ServerLevel) level), blockPosition(), 10, 5, 6);
                    }
                }
            }
        }

        super.tick();
    }

    public void spawnMinions(ServerLevel serverLevel, BlockPos pos, int a, int b, int c) {
        SpawnUtil.trySpawnMob(EntityType.CHICKEN, MobSpawnType.REINFORCEMENT, serverLevel, pos, a, b, c, SpawnUtil.Strategy.ON_TOP_OF_COLLIDER);
    }


    public void setTarget(@javax.annotation.Nullable LivingEntity entity) {
        if (!(entity instanceof Goat)) {
            super.setTarget(entity);
        }
    }

    public boolean doHurtTarget(Entity entity) {
        return true;
    }

}
