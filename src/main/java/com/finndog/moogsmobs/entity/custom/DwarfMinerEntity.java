package com.finndog.moogsmobs.entity.custom;

import com.finndog.moogsmobs.entity.variant.DwarfMinerVariant;
import com.finndog.moogsmobs.item.ModItems;
import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DwarfMinerEntity extends DwarfEntity implements IAnimatable {
//    Dwarfs are grumpy so dont get in their way while they are mining or youll get a good smack with their high level pickaxes
//    Dwarfs are grumpy so dont get in their way while they are mining or youll get a good smack with their high level pickaxes

    private AnimationFactory factory = new AnimationFactory(this);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(DwarfMinerEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_TRADE_COOLDOWN = SynchedEntityData.defineId(AbstractVillager.class, EntityDataSerializers.INT);
    public DwarfMinerEntity(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
    }
    @Nullable
    private Player tradingPlayer;
    private int cooldownCounter;
    private byte tradeCounter;

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1f, 10));
    }

    // ANIMATION STUFF
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dwarfminer.walk", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dwarfminer.idle", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller",
                1, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }


    // DATA
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);

        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);

        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        DwarfMinerVariant variant = Util.getRandom(DwarfMinerVariant.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    public void tick() {
        if (this.getCooldownCounter() < 0) {
            this.setCooldownCounter(getCooldownCounter()-1);
        }

    }


    /** TRADE STUFF */
    // IF CLICK ON MINER WITH ALE, WILL TRADE (THROW ORES AT YOU), AFTER 3 TRADES, TRADES WILL BE UNSUCCESSFUL FOR 5-10 MINS
    // IF CLICK ON MINER WITH !ALE, TRADE WILL BE UNSUCCESSFUL
    // IF TRADE UNSUCCESSFUL, MINER WILL ATTACK ONCE WITH PICK

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pInteractionHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pInteractionHand);
        if (this.getTradeCooldown() >= this.getCooldownCounter()) {
            if (getTradeCounter() > 3) {
                setCooldownCounter(getTradeCooldown());
            } else {
                if (itemstack.is(ModItems.HONEYBREW.get()) || itemstack.is(ModItems.ALE.get()) || itemstack.is(ModItems.IRON_GROG.get())) {
                    incrementTradeCounter();
                    // REMOVE AN itemstack.get() FROM PLAYER INV
                    if (!pPlayer.isCreative()) {itemstack.shrink(1);}
                    // THROW RANDOM ORE
                    for (int i = 0; i > random.nextInt()+20; i++) {
                        BehaviorUtils.throwItem(this, getItemToThrow(this), this.position());
                    }






                } else {
                    // ATTACK
                }
            }



        }

//        InteractionResult interactionresult = itemstack.interactLivingEntity(p_30713_, this, p_30714_);
//        if (interactionresult.consumesAction()) {
//            return interactionresult;
//        }
    }

    private ItemStack getItemToThrow(DwarfMinerEntity pDwarvenMiner) {
        LootTable loottable = ;
        LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerLevel)pDwarvenMiner.level)).withParameter(LootContextParams.ORIGIN, pDwarvenMiner.position()).withParameter(LootContextParams.THIS_ENTITY, pDwarvenMiner).withRandom(pDwarvenMiner.getRandom());
        return loottable.getRandomItems(lootcontext$builder.create(LootContextParamSets.get("dwarven_miner_throwables")));
    }


    protected void addParticlesAroundSelf(ParticleOptions particle) { // WHEN COMPLETE TRADE, SUMMON PARTICLES
        for(int i = 0; i < 5; ++i) {
            double d0 = this.random.nextGaussian() * 0.02D;
            double d1 = this.random.nextGaussian() * 0.02D;
            double d2 = this.random.nextGaussian() * 0.02D;
            this.level.addParticle(particle, this.getRandomX(1.0D), this.getRandomY() + 1.0D, this.getRandomZ(1.0D), d0, d1, d2);
        }
    }

    public void playCelebrateSound() {
        this.playSound(SoundEvents.PILLAGER_CELEBRATE, this.getSoundVolume(), this.getVoicePitch());
    }






    // GETTERS AND SETTERS

    protected SoundEvent getTradeUpdatedSound(boolean successfulTrade) {
        return successfulTrade ? SoundEvents.VILLAGER_YES : SoundEvents.VILLAGER_NO;
    }

    public void setTradingPlayer(@Nullable Player p_35314_) {this.tradingPlayer = p_35314_;}

    @Nullable
    public Player getTradingPlayer() {return this.tradingPlayer;}

    public int getTradeCooldown() {return this.entityData.get(DATA_TRADE_COOLDOWN);}

    public byte getTradeCounter() {return this.tradeCounter;}
    public void incrementTradeCounter() {this.tradeCounter++;}
    public int getCooldownCounter() {return this.cooldownCounter;}
    public void setCooldownCounter(int value) {this.cooldownCounter = value;}

    public DwarfMinerVariant getVariant() {
        return DwarfMinerVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(DwarfMinerVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
}
