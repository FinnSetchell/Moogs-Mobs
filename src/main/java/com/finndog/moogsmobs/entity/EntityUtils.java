package com.finndog.moogsmobs.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.SpawnUtil;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class EntityUtils {
    /*public static <T extends Mob> Optional<T> trySpawnModdedMob(ModEntityTypes entityTypes, MobSpawnType mobSpawnType, ServerLevel level, BlockPos pos, int p_216408_, int p_216409_, int p_216410_, SpawnUtil.Strategy strategy) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

        for(int i = 0; i < p_216408_; ++i) {
            int j = Mth.randomBetweenInclusive(level.random, -p_216409_, p_216409_);
            int k = Mth.randomBetweenInclusive(level.random, -p_216409_, p_216409_);
            blockpos$mutableblockpos.setWithOffset(pos, j, p_216410_, k);
            if (level.getWorldBorder().isWithinBounds(blockpos$mutableblockpos) && moveToPossibleSpawnPosition(level, p_216410_, blockpos$mutableblockpos, strategy)) {
                T t = entityTypes.create(level, (CompoundTag)null, (Component)null, (Player)null, blockpos$mutableblockpos, mobSpawnType, false, false);
                if (t != null) {
                    if (t.checkSpawnRules(level, mobSpawnType) && t.checkSpawnObstruction(level)) {
                        level.addFreshEntityWithPassengers(t);
                        return Optional.of(t);
                    }

                    t.discard();
                }
            }
        }

        return Optional.empty();
    }

    private static boolean moveToPossibleSpawnPosition(ServerLevel p_216399_, int p_216400_, BlockPos.MutableBlockPos p_216401_, SpawnUtil.Strategy p_216402_) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = (new BlockPos.MutableBlockPos()).set(p_216401_);
        BlockState blockstate = p_216399_.getBlockState(blockpos$mutableblockpos);

        for(int i = p_216400_; i >= -p_216400_; --i) {
            p_216401_.move(Direction.DOWN);
            blockpos$mutableblockpos.setWithOffset(p_216401_, Direction.UP);
            BlockState blockstate1 = p_216399_.getBlockState(p_216401_);
            if (p_216402_.canSpawnOn(p_216399_, p_216401_, blockstate1, blockpos$mutableblockpos, blockstate)) {
                p_216401_.move(Direction.UP);
                return true;
            }

            blockstate = blockstate1;
        }

        return false;
    }

    public interface Strategy {
        SpawnUtil.Strategy LEGACY_IRON_GOLEM = (serverLevel, blockPos, blockState, pos, state) -> {
            return (state.isAir() || state.getMaterial().isLiquid()) && blockState.getMaterial().isSolidBlocking();
        };
        SpawnUtil.Strategy ON_TOP_OF_COLLIDER = (serverLevel, blockPos, blockState, pos, state) -> {
            return state.getCollisionShape(serverLevel, pos).isEmpty() && Block.isFaceFull(blockState.getCollisionShape(serverLevel, blockPos), Direction.UP);
        };

        boolean canSpawnOn(ServerLevel p_216428_, BlockPos p_216429_, BlockState p_216430_, BlockPos p_216431_, BlockState p_216432_);
    }*/
}
