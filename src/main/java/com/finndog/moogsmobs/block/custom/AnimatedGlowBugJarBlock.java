package com.finndog.moogsmobs.block.custom;

import com.finndog.moogsmobs.block.entity.BlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class AnimatedGlowBugJarBlock extends BaseEntityBlock {
    public AnimatedGlowBugJarBlock(Properties properties) {
        super(properties);
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return BlockEntities.ANIMATED_JAR_BLOCK_ENTITY.get().create(pPos, pState);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Block.box(3, 0, 3, 13, 12, 13);
    }
}
