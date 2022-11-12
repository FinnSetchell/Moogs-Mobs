package com.finndog.moogsmobs.block.custom;

import com.finndog.moogsmobs.block.entity.BlockEntities;
import com.finndog.moogsmobs.block.entity.custom.KegBlockEntity;
import com.finndog.moogsmobs.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class KegBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public KegBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE = Block.box(0,0,0,16,16,16);

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return this.defaultBlockState().setValue(FACING, placeContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(FACING);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new KegBlockEntity(blockPos, blockState);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState newState, boolean isMoving) {
        super.onRemove(blockState, level, blockPos, newState, isMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            ItemStack itemStack = pPlayer.getItemInHand(pHand);


            if (itemStack.is(ModItems.EMPTY_BOTTLE.get()) && ((KegBlockEntity) entity).aleLevel != 0) {
                if (!pPlayer.isCreative()) {
                    itemStack.shrink(1);
                }
                pLevel.playSound(null, pPos, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 0.3f, 0.7f);
                int ale = ((KegBlockEntity) entity).aleType;
                if (ale == 1) {
                    if (itemStack.isEmpty()) {
                        pPlayer.setItemInHand(pHand, new ItemStack(ModItems.ALE.get()));
                    } else if (!pPlayer.getInventory().add(new ItemStack(ModItems.ALE.get()))) {
                        pPlayer.drop(new ItemStack(ModItems.ALE.get()), false);
                    }
                } else if (ale == 2) {
                    if (itemStack.isEmpty()) {
                        pPlayer.setItemInHand(pHand, new ItemStack(ModItems.HONEYBREW.get()));
                    } else if (!pPlayer.getInventory().add(new ItemStack(ModItems.HONEYBREW.get()))) {
                        pPlayer.drop(new ItemStack(ModItems.HONEYBREW.get()), false);
                    }
                } else if (ale == 3) {
                    if (itemStack.isEmpty()) {
                        pPlayer.setItemInHand(pHand, new ItemStack(ModItems.IRON_GROG.get()));
                    } else if (!pPlayer.getInventory().add(new ItemStack(ModItems.IRON_GROG.get()))) {
                        pPlayer.drop(new ItemStack(ModItems.IRON_GROG.get()), false);
                    }
                }
                ((KegBlockEntity) entity).aleLevel = ((KegBlockEntity) entity).aleLevel - 1;
            } else if (((KegBlockEntity) entity).aleLevel < 16) {
                if (itemStack.is(ModItems.ALE.get()) && (((KegBlockEntity) entity).aleLevel == 0 || ((KegBlockEntity) entity).aleType == 1)) {
                    if (!pPlayer.isCreative()) {itemStack.shrink(1);}
                    pLevel.playSound(null, pPos, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 0.3f, 0.7f);
                    if (itemStack.isEmpty()) {
                        pPlayer.setItemInHand(pHand, new ItemStack(ModItems.EMPTY_BOTTLE.get()));
                    } else if (!pPlayer.getInventory().add(new ItemStack(ModItems.EMPTY_BOTTLE.get()))) {
                        pPlayer.drop(new ItemStack(ModItems.EMPTY_BOTTLE.get()), false);
                    }
                    ((KegBlockEntity) entity).aleType = 1;
                    ((KegBlockEntity) entity).aleLevel = ((KegBlockEntity) entity).aleLevel + 1;
                } else if (itemStack.is(ModItems.HONEYBREW.get()) && (((KegBlockEntity) entity).aleLevel == 0 || ((KegBlockEntity) entity).aleType == 2)) {
                    if (!pPlayer.isCreative()) {itemStack.shrink(1);}
                    pLevel.playSound(null, pPos, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 0.3f, 0.7f);
                    if (itemStack.isEmpty()) {
                        pPlayer.setItemInHand(pHand, new ItemStack(ModItems.EMPTY_BOTTLE.get()));
                    } else if (!pPlayer.getInventory().add(new ItemStack(ModItems.EMPTY_BOTTLE.get()))) {
                        pPlayer.drop(new ItemStack(ModItems.EMPTY_BOTTLE.get()), false);
                    }
                    ((KegBlockEntity) entity).aleType = 2;
                    ((KegBlockEntity) entity).aleLevel = ((KegBlockEntity) entity).aleLevel + 1;
                } else if (itemStack.is(ModItems.IRON_GROG.get()) && (((KegBlockEntity) entity).aleLevel == 0 || ((KegBlockEntity) entity).aleType == 3)) {
                    if (!pPlayer.isCreative()) {itemStack.shrink(1);}
                    pLevel.playSound(null, pPos, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 0.3f, 0.7f);
                    if (itemStack.isEmpty()) {
                        pPlayer.setItemInHand(pHand, new ItemStack(ModItems.EMPTY_BOTTLE.get()));
                    } else if (!pPlayer.getInventory().add(new ItemStack(ModItems.EMPTY_BOTTLE.get()))) {
                        pPlayer.drop(new ItemStack(ModItems.EMPTY_BOTTLE.get()), false);
                    }
                    ((KegBlockEntity) entity).aleType = 3;
                    ((KegBlockEntity) entity).aleLevel = ((KegBlockEntity) entity).aleLevel + 1;
                }
            } else {
                pLevel.playSound(null, pPos, SoundEvents.BAMBOO_BREAK, SoundSource.BLOCKS, 0.3f, 0.7f);
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, BlockEntities.KEG_ENTITY.get(),
                KegBlockEntity::tick);
    }
}
