package com.finndog.moogsmobs.datagen;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.block.ModBlocks;
import net.minecraft.client.resources.model.ModelResourceLocation;
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
        axisBlockWithItem((RotatedPillarBlock) ModBlocks.POLISHED_COPPER_DEEPSLATE.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/polished_copper_deepslate"),
                new ResourceLocation("minecraft", "block/polished_deepslate"));
        axisBlockWithItem((RotatedPillarBlock) ModBlocks.POLISHED_EXPOSED_COPPER_DEEPSLATE.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/polished_exposed_copper_deepslate"),
                new ResourceLocation("minecraft", "block/polished_deepslate"));
        axisBlockWithItem((RotatedPillarBlock) ModBlocks.POLISHED_WEATHERED_COPPER_DEEPSLATE.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/polished_weathered_copper_deepslate"),
                new ResourceLocation("minecraft", "block/polished_deepslate"));
        axisBlockWithItem((RotatedPillarBlock) ModBlocks.POLISHED_OXIDIZED_COPPER_DEEPSLATE.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/polished_oxidized_copper_deepslate"),
                new ResourceLocation("minecraft", "block/polished_deepslate"));
        axisBlockWithItem((RotatedPillarBlock) ModBlocks.GILDED_POLISHED_DEEPSLATE.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/gilded_polished_deepslate"),
                new ResourceLocation("minecraft", "block/polished_deepslate"));
        axisBlockWithItem((RotatedPillarBlock) ModBlocks.BRASS_POLISHED_DEEPSLATE.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/brass_polished_deepslate"),
                new ResourceLocation("minecraft", "block/polished_deepslate"));

        axisBlockWithItem((RotatedPillarBlock) ModBlocks.COPPER_DEESPLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/copper_deepslate_pillar_side"),
                new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/copper_deepslate_pillar_top"));
        axisBlockWithItem((RotatedPillarBlock) ModBlocks.EXPOSED_COPPER_DEEPSLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/exposed_copper_deepslate_pillar_side"),
                new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/exposed_copper_deepslate_pillar_top"));
        axisBlockWithItem((RotatedPillarBlock) ModBlocks.WEATHERED_COPPER_DEEPSLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/weathered_copper_deepslate_pillar_side"),
                new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/weathered_copper_deepslate_pillar_top"));
        axisBlockWithItem((RotatedPillarBlock) ModBlocks.OXIDIZED_COPPER_DEEPSLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/oxidized_copper_deepslate_pillar_side"),
                new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/oxidized_copper_deepslate_pillar_top"));
        axisBlockWithItem((RotatedPillarBlock) ModBlocks.GILDED_DEEPSLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/gilded_deepslate_pillar_side"),
                new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/gilded_deepslate_pillar_top"));
        axisBlockWithItem((RotatedPillarBlock) ModBlocks.RUNIC_GILDED_DEEPSLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/runic_gilded_deepslate_pillar_side"),
                new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/gilded_deepslate_pillar_top"));
        axisBlockWithItem((RotatedPillarBlock) ModBlocks.BRASS_DEEPSLATE_PILLAR.get(), new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/brass_deepslate_pillar_side"),
                new ResourceLocation(MoogsMobs.MODID, "block/deepslate/pillars/brass_deepslate_pillar_top"));

        tileBlockWithItem(ModBlocks.COPPER_DEEPSLATE_TILES.get());
        tileBlockWithItem(ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get());
        tileBlockWithItem(ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get());
        tileBlockWithItem(ModBlocks.OXIDIZED_COPPER_DEEPSLATE_TILES.get());
        tileBlockWithItem(ModBlocks.GILDED_DEEPSLATE_TILES.get());
        tileBlockWithItem(ModBlocks.BRASS_DEEPSLATE_TILES.get());


    }

    private void tileBlockWithItem(Block block) {
        String blockName = ForgeRegistries.BLOCKS.getKey(block).getPath();

        simpleBlock(block, models().cube(blockName,
                new ResourceLocation(MoogsMobs.MODID, "block/tiled/" + blockName),
                new ResourceLocation(MoogsMobs.MODID, "block/tiled/" + blockName),
                new ResourceLocation(MoogsMobs.MODID, "block/tiled/" + blockName + "_flipped"),
                new ResourceLocation(MoogsMobs.MODID, "block/tiled/" + blockName + "_flipped"),
                new ResourceLocation(MoogsMobs.MODID, "block/tiled/" + blockName),
                new ResourceLocation(MoogsMobs.MODID, "block/tiled/" + blockName)));
        itemModels().withExistingParent(blockName, new ResourceLocation(MoogsMobs.MODID, "block/" + blockName));

    }

    private void axisBlockWithItem(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end) {
        String blockName = ForgeRegistries.BLOCKS.getKey(block).getPath();

        axisBlock(block, side, end);
        itemModels().withExistingParent(blockName, new ResourceLocation(MoogsMobs.MODID, "block/" + blockName));

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