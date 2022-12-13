package com.finndog.moogsmobs.datagen;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;

public class ModBlocksStateProvider extends BlockStateProvider {
    public ModBlocksStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, MoogsMobs.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
//        simpleBlock(ModBlocks.CITRINE_BLOCK.get());
        axisBlock((RotatedPillarBlock) ModBlocks.DWARVEN_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/dwarven_pillar"),
                new ResourceLocation(MoogsMobs.MODID, "block/dwarven_pillar"));
        axisBlock((RotatedPillarBlock) ModBlocks.CUT_DWARVEN_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/cut_dwarven_pillar"),
                new ResourceLocation(MoogsMobs.MODID, "block/cut_dwarven_pillar"));
        axisBlock((RotatedPillarBlock) ModBlocks.CUT_DWARVEN_STONE.get(), new ResourceLocation(MoogsMobs.MODID, "block/cut_dwarven_stone"),
                new ResourceLocation(MoogsMobs.MODID, "block/cut_dwarven_stone"));

        axisBlock((RotatedPillarBlock) ModBlocks.POLISHED_COPPER_DEEPSLATE.get(), new ResourceLocation(MoogsMobs.MODID, "block/polished_copper_deepslate"),
                new ResourceLocation(MoogsMobs.MODID, "block/polished_copper_deepslate"));
        axisBlock((RotatedPillarBlock) ModBlocks.POLISHED_EXPOSED_COPPER_DEEPSLATE.get(), new ResourceLocation(MoogsMobs.MODID, "block/polished_exposed_copper_deepslate"),
                new ResourceLocation(MoogsMobs.MODID, "block/polished_exposed_copper_deepslate"));
        axisBlock((RotatedPillarBlock) ModBlocks.POLISHED_WEATHERED_COPPER_DEEPSLATE.get(), new ResourceLocation(MoogsMobs.MODID, "block/polished_weathered_copper_deepslate"),
                new ResourceLocation(MoogsMobs.MODID, "block/polished_weathered_copper_deepslate"));
        axisBlock((RotatedPillarBlock) ModBlocks.POLISHED_OXIDIZED_COPPER_DEEPSLATE.get(), new ResourceLocation(MoogsMobs.MODID, "block/polished_oxidized_copper_deepslate"),
                new ResourceLocation(MoogsMobs.MODID, "block/polished_oxidized_copper_deepslate"));
        axisBlock((RotatedPillarBlock) ModBlocks.GILDED_POLISHED_DEEPSLATE.get(), new ResourceLocation(MoogsMobs.MODID, "block/gilded_polished_deepslate"),
                new ResourceLocation(MoogsMobs.MODID, "block/gilded_polished_deepslate"));
        axisBlock((RotatedPillarBlock) ModBlocks.BRASS_POLISHED_DEEPSLATE.get(), new ResourceLocation(MoogsMobs.MODID, "block/brass_polished_deepslate"),
                new ResourceLocation(MoogsMobs.MODID, "block/brass_polished_deepslate"));

        axisBlock((RotatedPillarBlock) ModBlocks.COPPER_DEESPLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/copper_deepslate_pillar"),
                new ResourceLocation(MoogsMobs.MODID, "block/copper_deepslate_pillar"));
        axisBlock((RotatedPillarBlock) ModBlocks.EXPOSED_COPPER_DEEPSLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/exposed_copper_deepslate_pillar"),
                new ResourceLocation(MoogsMobs.MODID, "block/exposed_copper_deepslate_pillar"));
        axisBlock((RotatedPillarBlock) ModBlocks.WEATHERED_COPPER_DEEPSLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/weathered_copper_deepslate_pillar"),
                new ResourceLocation(MoogsMobs.MODID, "block/weathered_copper_deepslate_pillar"));
        axisBlock((RotatedPillarBlock) ModBlocks.OXIDIZED_COPPER_DEEPSLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/oxidized_copper_deepslate_pillar"),
                new ResourceLocation(MoogsMobs.MODID, "block/oxidized_copper_deepslate_pillar"));
        axisBlock((RotatedPillarBlock) ModBlocks.GILDED_DEEPSLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/gilded_deepslate_pillar"),
                new ResourceLocation(MoogsMobs.MODID, "block/gilded_deepslate_pillar"));
        axisBlock((RotatedPillarBlock) ModBlocks.RUNIC_GUILDED_DEEPSLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/runic_guilded_deepslate_pillar"),
                new ResourceLocation(MoogsMobs.MODID, "block/runic_guilded_deepslate_pillar"));
        axisBlock((RotatedPillarBlock) ModBlocks.BRASS_DEEPSLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/brass_deepslate_pillar"),
                new ResourceLocation(MoogsMobs.MODID, "block/brass_deepslate_pillar"));

        axisBlock((RotatedPillarBlock) ModBlocks.COPPER_DEEPSLATE_TILES.get(), new ResourceLocation(MoogsMobs.MODID, "block/copper_deepslate_tiles"),
                new ResourceLocation(MoogsMobs.MODID, "block/copper_deepslate_tiles"));
        axisBlock((RotatedPillarBlock) ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get(), new ResourceLocation(MoogsMobs.MODID, "block/exposed_copper_deepslate_tiles"),
                new ResourceLocation(MoogsMobs.MODID, "block/exposed_copper_deepslate_tiles"));
        axisBlock((RotatedPillarBlock) ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get(), new ResourceLocation(MoogsMobs.MODID, "block/weathered_copper_deepslate_tiles"),
                new ResourceLocation(MoogsMobs.MODID, "block/weathered_copper_deepslate_tiles"));
        axisBlock((RotatedPillarBlock) ModBlocks.OXIDIZED_COPPER_DEEPSLATE_TILES.get(), new ResourceLocation(MoogsMobs.MODID, "block/oxidized_copper_deepslate_tiles"),
                new ResourceLocation(MoogsMobs.MODID, "block/oxidized_copper_deepslate_tiles"));
        axisBlock((RotatedPillarBlock) ModBlocks.GILDED_DEEPSLATE_TILES.get(), new ResourceLocation(MoogsMobs.MODID, "block/gilded_deepslate_tiles"),
                new ResourceLocation(MoogsMobs.MODID, "block/gilded_deepslate_tiles"));
        axisBlock((RotatedPillarBlock) ModBlocks.BRASS_DEEPSLATE_TILES.get(), new ResourceLocation(MoogsMobs.MODID, "block/brass_deepslate_tiles"),
                new ResourceLocation(MoogsMobs.MODID, "block/brass_deepslate_tiles"));


    }

    private void simpleBlockWithItem(Block block) {
        String blockName = ForgeRegistries.BLOCKS.getKey(block).getPath();

        simpleBlock(block);
        itemModels().withExistingParent(blockName, new ResourceLocation(MoogsMobs.MODID, "block/" + blockName));
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(block.getAgeProperty()),
                new ResourceLocation(MoogsMobs.MODID, "block/" + textureName + state.getValue(block.getAgeProperty()))));

        return models;
    }
}