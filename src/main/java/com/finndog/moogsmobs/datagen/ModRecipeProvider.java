package com.finndog.moogsmobs.datagen;

import com.finndog.moogsmobs.block.ModBlocks;
import com.finndog.moogsmobs.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SmithingTableBlock;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        smithingRecipe(Blocks.POLISHED_DEEPSLATE.asItem(), Items.COPPER_INGOT, ModBlocks.POLISHED_COPPER_DEEPSLATE.get().asItem())
                .unlocks("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(pFinishedRecipeConsumer, getItemName(ModBlocks.POLISHED_COPPER_DEEPSLATE.get().asItem()) + "_smithing");
        smithingRecipe(Blocks.POLISHED_DEEPSLATE.asItem(), Items.GOLD_INGOT, ModBlocks.GILDED_POLISHED_DEEPSLATE.get().asItem())
                .unlocks("has_copper_ingot", has(Items.GOLD_INGOT))
                .save(pFinishedRecipeConsumer, getItemName(ModBlocks.GILDED_POLISHED_DEEPSLATE.get().asItem()) + "_smithing");
        smithingRecipe(Blocks.POLISHED_DEEPSLATE.asItem(), ModItems.BRASS_INGOT.get(), ModBlocks.BRASS_POLISHED_DEEPSLATE.get().asItem())
                .unlocks("has_copper_ingot", has(ModItems.BRASS_INGOT.get()))
                .save(pFinishedRecipeConsumer, getItemName(ModBlocks.BRASS_POLISHED_DEEPSLATE.get().asItem()) + "_smithing");

        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.COPPER_DEESPLATE_PILLAR.get(), ModBlocks.POLISHED_COPPER_DEEPSLATE.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.EXPOSED_COPPER_DEEPSLATE_PILLAR.get(), ModBlocks.POLISHED_EXPOSED_COPPER_DEEPSLATE.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.WEATHERED_COPPER_DEEPSLATE_PILLAR.get(), ModBlocks.POLISHED_WEATHERED_COPPER_DEEPSLATE.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.OXIDIZED_COPPER_DEEPSLATE_PILLAR.get(), ModBlocks.POLISHED_OXIDIZED_COPPER_DEEPSLATE.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.GILDED_DEEPSLATE_PILLAR.get(), ModBlocks.GILDED_POLISHED_DEEPSLATE.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.RUNIC_GILDED_DEEPSLATE_PILLAR.get(), ModBlocks.GILDED_POLISHED_DEEPSLATE.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRASS_DEEPSLATE_PILLAR.get(), ModBlocks.BRASS_POLISHED_DEEPSLATE.get());

        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.COPPER_DEEPSLATE_TILES.get(), ModBlocks.POLISHED_COPPER_DEEPSLATE.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.EXPOSED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.POLISHED_EXPOSED_COPPER_DEEPSLATE.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.WEATHERED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.POLISHED_WEATHERED_COPPER_DEEPSLATE.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.OXIDIZED_COPPER_DEEPSLATE_TILES.get(), ModBlocks.POLISHED_OXIDIZED_COPPER_DEEPSLATE.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.GILDED_DEEPSLATE_TILES.get(), ModBlocks.GILDED_POLISHED_DEEPSLATE.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRASS_DEEPSLATE_TILES.get(), ModBlocks.BRASS_POLISHED_DEEPSLATE.get());

        // ADD ALL COPPER VARIANTS WITH HONEY COMB | SHAPELESS

    }

    private UpgradeRecipeBuilder smithingRecipe(Item item1, Item item2, Item result) {
        return UpgradeRecipeBuilder.smithing(Ingredient.of(item1), Ingredient.of(item2), result);
    }
}
