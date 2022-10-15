package com.finndog.moogsmobs.block.entity.custom;

import com.finndog.moogsmobs.block.entity.BlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class AnimatedJarBlockEntity extends BlockEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public AnimatedJarBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(BlockEntities.ANIMATED_JAR_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<AnimatedJarBlockEntity>
                (this, "controller", 0, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));

        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
