package com.finndog.moogsmobs.entity;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.entity.custom.CaplingEntity;
import com.finndog.moogsmobs.entity.custom.DwarfMinerEntity;
import com.finndog.moogsmobs.entity.custom.DeathCapEntity;
import com.finndog.moogsmobs.entity.custom.DeathCaplingEntity;
import com.finndog.moogsmobs.entity.custom.GlowBugEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.UUID;

public class ModEntityTypes {
//    private final EntityType.EntityFactory<EntityType> factory;

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MoogsMobs.MODID);

    public static final RegistryObject<EntityType<GlowBugEntity>> GLOWBUG =
            ENTITY_TYPES.register("glowbug",
                    ( ) -> EntityType.Builder.of(GlowBugEntity:: new, MobCategory.AMBIENT)
                            .sized(0.4f, 0.2f)
                            .build(new ResourceLocation(MoogsMobs.MODID, "glowbug") .toString()));

    public static final RegistryObject<EntityType<CaplingEntity>> CAPLING =
            ENTITY_TYPES.register("capling",
                    () -> EntityType.Builder.of(CaplingEntity::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.6f)
                            .build(new ResourceLocation(MoogsMobs.MODID, "capling").toString()));

    public static final RegistryObject<EntityType<DwarfMinerEntity>> DWARF_MINER =
            ENTITY_TYPES.register("dwarf_miner",
                    () -> EntityType.Builder.of(DwarfMinerEntity::new, MobCategory.CREATURE)
                            .sized(0.8f, 1.3f)
                            .build(new ResourceLocation(MoogsMobs.MODID, "dwarf_miner").toString()));

    public static final RegistryObject<EntityType<DeathCaplingEntity>> DEATH_CAPLING =
            ENTITY_TYPES.register("death_capling",
                    () -> EntityType.Builder.of(DeathCaplingEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 0.6f)
                            .build(new ResourceLocation(MoogsMobs.MODID, "death_capling").toString()));

    public static final RegistryObject<EntityType<DeathCapEntity>> DEATH_CAP =
            ENTITY_TYPES.register("death_cap",
                    () -> EntityType.Builder.of(DeathCapEntity::new, MobCategory.MONSTER)
                            .sized(2.1f, 3f)
                            .build(new ResourceLocation(MoogsMobs.MODID, "death_cap").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

//    @Nullable
//    public Entity create(ServerLevel serverLevel, @Nullable CompoundTag p_20657_, @Nullable Component p_20658_, @Nullable Player p_20659_, BlockPos p_20660_, MobSpawnType p_20661_, boolean p_20662_, boolean p_20663_) {
//        Entity t = this.create(serverLevel);
//        if (t == null) {
//            return (Entity)null;
//        } else {
//            double d0;
//            if (p_20662_) {
//                t.setPos((double)p_20660_.getX() + 0.5D, (double)(p_20660_.getY() + 1), (double)p_20660_.getZ() + 0.5D);
//                d0 = getYOffset(serverLevel, p_20660_, p_20663_, t.getBoundingBox());
//            } else {
//                d0 = 0.0D;
//            }
//
//            t.moveTo((double)p_20660_.getX() + 0.5D, (double)p_20660_.getY() + d0, (double)p_20660_.getZ() + 0.5D, Mth.wrapDegrees(serverLevel.random.nextFloat() * 360.0F), 0.0F);
//            if (t instanceof Mob) {
//                Mob mob = (Mob)t;
//                mob.yHeadRot = mob.getYRot();
//                mob.yBodyRot = mob.getYRot();
//                mob.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(mob.blockPosition()), p_20661_, (SpawnGroupData)null, p_20657_);
//                mob.playAmbientSound();
//            }
//
//            if (p_20658_ != null && t instanceof LivingEntity) {
//                t.setCustomName(p_20658_);
//            }
//
//            updateCustomEntityTag(serverLevel, p_20659_, t, p_20657_);
//            return t;
//        }
//    }

//    @Nullable
//    public Entity create(Level p_20616_) {
//        return this.factory.create(this, p_20616_);
//    }
//
//    protected static double getYOffset(LevelReader p_20626_, BlockPos p_20627_, boolean p_20628_, AABB p_20629_) {
//        AABB aabb = new AABB(p_20627_);
//        if (p_20628_) {
//            aabb = aabb.expandTowards(0.0D, -1.0D, 0.0D);
//        }
//
//        Iterable<VoxelShape> iterable = p_20626_.getCollisions((Entity)null, aabb);
//        return 1.0D + Shapes.collide(Direction.Axis.Y, p_20629_, iterable, p_20628_ ? -2.0D : -1.0D);
//    }

//    public static void updateCustomEntityTag(Level p_20621_, @Nullable Player p_20622_, @Nullable Entity p_20623_, @Nullable CompoundTag p_20624_) {
//        if (p_20624_ != null && p_20624_.contains("EntityTag", 10)) {
//            MinecraftServer minecraftserver = p_20621_.getServer();
//            if (minecraftserver != null && p_20623_ != null) {
//                if (p_20621_.isClientSide || !p_20623_.onlyOpCanSetNbt() || p_20622_ != null && minecraftserver.getPlayerList().isOp(p_20622_.getGameProfile())) {
//                    CompoundTag compoundtag = p_20623_.saveWithoutId(new CompoundTag());
//                    UUID uuid = p_20623_.getUUID();
//                    compoundtag.merge(p_20624_.getCompound("EntityTag"));
//                    p_20623_.setUUID(uuid);
//                    p_20623_.load(compoundtag);
//                }
//            }
//        }
//    }
}
