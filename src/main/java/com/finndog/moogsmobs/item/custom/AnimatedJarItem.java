package com.finndog.moogsmobs.item.custom;

import com.finndog.moogsmobs.item.client.AnimatedJarBlockItemRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.function.Consumer;

public class AnimatedJarItem extends Item implements IAnimatable {
    public AnimationFactory factory = new AnimationFactory(this);

    public AnimatedJarItem(Properties pProperties) {
        super(pProperties);
    }

//    @Override
//    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
//        super.initializeClient(consumer);
//        consumer.accept(new IItemRenderProperties() {
//            private final BlockEntityWithoutLevelRenderer renderer = new AnimatedJarBlockItemRenderer();
//
//            @Override
//            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
//                return renderer;
//            }
//        });
//    }
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(new IClientItemExtensions() {
            private final BlockEntityWithoutLevelRenderer renderer = new AnimatedJarBlockItemRenderer();

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
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
