package com.finndog.moogsmobs.entity.custom;

import com.finndog.moogsmobs.entity.variant.DwarfMinerVariant;
import com.finndog.moogsmobs.item.ModItems;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
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

import java.util.*;

public class DwarfMinerEntity extends DwarfEntity implements IAnimatable {
//    Dwarfs are grumpy so dont get in their way while they are mining or youll get a good smack with their high level pickaxes
//    Dwarfs are grumpy so dont get in their way while they are mining or youll get a good smack with their high level pickaxes

    private AnimationFactory factory = new AnimationFactory(this);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(DwarfMinerEntity.class, EntityDataSerializers.INT);
    public DwarfMinerEntity(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
    }
    private int DATA_TRADE_COOLDOWN;
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

    /** ANIMATION STUFF */
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
        this.tradeCounter = tag.getByte("tradeCounter");
        this.cooldownCounter = tag.getInt("cooldownCounter");
        this.DATA_TRADE_COOLDOWN = tag.getInt("DATA_TRADE_COOLDOWN");

        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putByte("tradeCounter", this.tradeCounter);
        tag.putInt("cooldownCounter", this.cooldownCounter);
        tag.putInt("DATA_TRADE_COOLDOWN", this.DATA_TRADE_COOLDOWN);


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
        RandomSource randomsource = p_146746_.getRandom();

        DwarfMinerVariant variant = Util.getRandom(DwarfMinerVariant.values(), this.random);
        setVariant(variant);
//        this.populateDefaultEquipmentEnchantments(randomsource, p_146747_);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    public void tick() {
        if (this.isAlive()) {
            if (this.getCooldownCounter() < 0) {
                this.setCooldownCounter(getCooldownCounter()-1);
            }
        }

        super.tick();
    }


    /** OTHER */

    /*protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        if (this.isAdult()) {
            this.maybeWearArmor(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET), random);
            this.maybeWearArmor(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE), random);
            this.maybeWearArmor(EquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS), random);
            this.maybeWearArmor(EquipmentSlot.FEET, new ItemStack(Items.GOLDEN_BOOTS), random);
        }
    }

    private void maybeWearArmor(EquipmentSlot slot, ItemStack itemStack, RandomSource random) {
        if (random.nextFloat() < 0.1F) {
            this.setItemSlot(slot, itemStack);
        }
    }*/



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
                        throwItems(this, getItemToThrow(this));
                    }
                }
            }
            // ATTACK

        }

        return InteractionResult.SUCCESS;
    }

    private static void throwItems(DwarfMinerEntity dwarfMinerEntity, List<ItemStack> itemStacks) {
        Optional<Player> optional = dwarfMinerEntity.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_PLAYER);
        if (optional.isPresent()) {
            throwItemsTowardPlayer(dwarfMinerEntity, optional.get(), itemStacks);
        } else {
            throwItemsTowardRandomPos(dwarfMinerEntity, itemStacks);
        }

    }

    private static void throwItemsTowardRandomPos(DwarfMinerEntity p_34913_, List<ItemStack> p_34914_) {
        throwItemsTowardPos(p_34913_, p_34914_, getRandomNearbyPos(p_34913_));
    }

    private static void throwItemsTowardPlayer(DwarfMinerEntity p_34851_, Player p_34852_, List<ItemStack> p_34853_) {
        throwItemsTowardPos(p_34851_, p_34853_, p_34852_.position());
    }

    private static void throwItemsTowardPos(DwarfMinerEntity p_34864_, List<ItemStack> p_34865_, Vec3 p_34866_) {
        if (!p_34865_.isEmpty()) {
            p_34864_.swing(InteractionHand.OFF_HAND);

            for(ItemStack itemstack : p_34865_) {
                BehaviorUtils.throwItem(p_34864_, itemstack, p_34866_.add(0.0D, 1.0D, 0.0D));
            }
        }
    }

    private static Vec3 getRandomNearbyPos(DwarfMinerEntity p_35017_) {
        Vec3 vec3 = LandRandomPos.getPos(p_35017_, 4, 2);
        return vec3 == null ? p_35017_.position() : vec3;
    }

    private static List<ItemStack> getItemToThrow(DwarfMinerEntity pDwarvenMiner) {
        LootTable loottable = Objects.requireNonNull(pDwarvenMiner.level.getServer()).getLootTables().get(BuiltInLootTables.PIGLIN_BARTERING);
        List<ItemStack> list = loottable.getRandomItems((new LootContext.Builder((ServerLevel)pDwarvenMiner.level)).withParameter(LootContextParams.THIS_ENTITY,
                pDwarvenMiner).withRandom(pDwarvenMiner.level.random).create(LootContextParamSets.PIGLIN_BARTER));
        return list;
    }





    /** GETTERS AND SETTERS */

    public int getTradeCooldown() {return this.DATA_TRADE_COOLDOWN;}

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
