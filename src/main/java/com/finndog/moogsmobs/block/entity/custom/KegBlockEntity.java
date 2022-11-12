package com.finndog.moogsmobs.block.entity.custom;

import com.finndog.moogsmobs.block.entity.BlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class KegBlockEntity extends BlockEntity {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    public int aleLevel = 0;
    public int aleType = 0;

    public KegBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntities.KEG_ENTITY.get(), blockPos, blockState);

        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 1: return KegBlockEntity.this.aleLevel;
                    case 2: return KegBlockEntity.this.aleType;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 1: KegBlockEntity.this.aleLevel = value; break;
                    case 2: KegBlockEntity.this.aleType = value; break;
                }
            }

            public int getCount() {
                return 5;
            }
        };
    }


    @Override
    public void onLoad() { // CALLED WHEN BLOCK FIRST PLACED
        super.onLoad();
        //IF GAMEMODE CREATIVE, PLACE FULL KEG
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();

        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.putInt("beer", aleLevel);
        tag.putInt("aleType", aleType);

        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        aleLevel = tag.getInt("beer");
        aleType = tag.getInt("aleType");
    }


    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, KegBlockEntity pBlockEntity) {
        RandomSource random = pLevel.random;
        if (random.nextFloat() < 0.005f) {
            pLevel.playSound(null, pPos, SoundEvents.LAVA_AMBIENT, SoundSource.BLOCKS, 0.1f, 0.5f);
        }
    }


    private static boolean hasBeer(KegBlockEntity entity) {
        if (entity.aleLevel != 0) {
            return true;
        } else
        {
            return false;
        }
    }

}
