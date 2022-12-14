package com.finndog.moogsmobs.datagen.loot;

import com.finndog.moogsmobs.block.ModBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.FLUORESCENT_LANTERN.get());
        this.dropSelf(ModBlocks.ALE.get());
        this.dropSelf(ModBlocks.EMPTY_BOTTLE_BLOCK.get());
        this.dropSelf(ModBlocks.HONEYBREW.get());
        this.dropSelf(ModBlocks.IRON_GROG.get());
        this.dropSelf(ModBlocks.KEG.get());

        this.dropSelf(ModBlocks.DWARVEN_PILLAR.get());
        this.dropSelf(ModBlocks.CUT_DWARVEN_PILLAR.get());
        this.dropSelf(ModBlocks.CUT_DWARVEN_STONE.get());
        this.dropSelf(ModBlocks.POLISHED_COPPER_DEEPSLATE.get());
        this.dropSelf(ModBlocks.POLISHED_EXPOSED_COPPER_DEEPSLATE.get());
        this.dropSelf(ModBlocks.POLISHED_WEATHERED_COPPER_DEEPSLATE.get());
        this.dropSelf(ModBlocks.POLISHED_OXIDIZED_COPPER_DEEPSLATE.get());
        this.dropSelf(ModBlocks.GILDED_POLISHED_DEEPSLATE.get());
        this.dropSelf(ModBlocks.BRASS_POLISHED_DEEPSLATE.get());
        this.dropSelf(ModBlocks.COPPER_DEESPLATE_PILLAR.get());
        this.dropSelf(ModBlocks.EXPOSED_COPPER_DEEPSLATE_PILLAR.get());
        this.dropSelf(ModBlocks.WEATHERED_COPPER_DEEPSLATE_PILLAR.get());
        this.dropSelf(ModBlocks.OXIDIZED_COPPER_DEEPSLATE_PILLAR.get());
        this.dropSelf(ModBlocks.GILDED_DEEPSLATE_PILLAR.get());
        this.dropSelf(ModBlocks.RUNIC_GILDED_DEEPSLATE_PILLAR.get());
        this.dropSelf(ModBlocks.BRASS_DEEPSLATE_PILLAR.get());
        this.dropSelf(ModBlocks.COPPER_DEEPSLATE_TILES.get());
        this.dropSelf(ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get());
        this.dropSelf(ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get());
        this.dropSelf(ModBlocks.OXIDIZED_COPPER_DEEPSLATE_TILES.get());
        this.dropSelf(ModBlocks.GILDED_DEEPSLATE_TILES.get());
        this.dropSelf(ModBlocks.BRASS_DEEPSLATE_TILES.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
