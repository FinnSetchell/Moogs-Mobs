package com.finndog.moogsmobs.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class DwarfEntity extends PathfinderMob {
//    They spawn in communities within caves and have their own underground towns or cities
//    They drink lots of ale
//    Miners will wander around. If you give them ale, they will throw random ores at you
//    Smiths will trade special weapons and tools. They can be found in blacksmith buildings in the cities
//    Dwarfs are grumpy so dont get in their way while they are mining or youll get a good smack with their high level pickaxes

    protected DwarfEntity(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 24.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2f)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .build();
    }
}
