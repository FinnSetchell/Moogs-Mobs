package com.finndog.moogsmobs.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class FluoLanternBlock extends LanternBlock {
  public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
  protected static final VoxelShape AABB = makeAABB();
  protected static final VoxelShape HANGING_AABB = makeHangingAABB();

  private static VoxelShape makeAABB() {
    VoxelShape shape = Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.125, 0.6875);
    shape = Shapes.join(shape, Shapes.box(0.375, 0.125, 0.375, 0.625, 0.375, 0.625), BooleanOp.OR);
    shape = Shapes.join(shape, Shapes.box(0.3125, 0.375, 0.3125, 0.6875, 0.5, 0.6875), BooleanOp.OR);
    shape = Shapes.join(shape, Shapes.box(0.375, 0.5, 0.375, 0.625, 0.5625, 0.625), BooleanOp.OR);
    shape = Shapes.join(shape, Shapes.box(0.40625, 0.5625, 0.5, 0.59375, 0.6875, 0.5), BooleanOp.OR);
    shape = Shapes.join(shape, Shapes.box(0.40625, 0.5625, 0.5, 0.59375, 0.6875, 0.5), BooleanOp.OR);
    shape = Shapes.join(shape, Shapes.box(0.25, 0.0625, 0.5, 0.3125, 0.4375, 0.5), BooleanOp.OR);
    shape = Shapes.join(shape, Shapes.box(0.6875, 0.0625, 0.5, 0.75, 0.4375, 0.5), BooleanOp.OR);
    return shape;
  }

  private static VoxelShape makeHangingAABB() {
    VoxelShape shape = Shapes.box(0.3125, 0.3125, 0.3125, 0.6875, 0.4375, 0.6875);
  	shape = Shapes.join(shape, Shapes.box(0.375, 0.4375, 0.375, 0.625, 0.6875, 0.625), BooleanOp.OR);
  	shape = Shapes.join(shape, Shapes.box(0.3125, 0.6875, 0.3125, 0.6875, 0.8125, 0.6875), BooleanOp.OR);
  	shape = Shapes.join(shape, Shapes.box(0.375, 0.8125, 0.375, 0.625, 0.875, 0.625), BooleanOp.OR);
  	shape = Shapes.join(shape, Shapes.box(0.40625, 0.875, 0.5, 0.59375, 1, 0.5), BooleanOp.OR);
  	shape = Shapes.join(shape, Shapes.box(0.40625, 0.875, 0.5, 0.59375, 1, 0.5), BooleanOp.OR);
  	shape = Shapes.join(shape, Shapes.box(0.25, 0.375, 0.5, 0.3125, 0.75, 0.5), BooleanOp.OR);
  	shape = Shapes.join(shape, Shapes.box(0.6875, 0.375, 0.5, 0.75, 0.75, 0.5), BooleanOp.OR);
    return shape;
  }

  public FluoLanternBlock(Properties props) {
    super(props);
    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos bpos, CollisionContext cc) {
    return state.getValue(HANGING) ? HANGING_AABB : AABB;
  }

  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
    BlockState supState = super.getStateForPlacement(placeContext);
    if (supState == null) return null;
    return supState.setValue(FACING, placeContext.getHorizontalDirection().getOpposite());
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
    super.createBlockStateDefinition(stateBuilder);
    stateBuilder.add(FACING);
  }
}
