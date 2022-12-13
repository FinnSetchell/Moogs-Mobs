package com.finndog.moogsmobs.datagen;

import com.finndog.moogsmobs.block.ModBlocks;
import com.finndog.moogsmobs.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.block.SmithingTableBlock;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

//        ShapedRecipeBuilder.shaped(ModBlocks.EBONY_DOOR.get())
//                .define('E', ModBlocks.EBONY_PLANKS.get())
//                .pattern("EE")
//                .pattern("EE")
//                .pattern("EE")
//                .unlockedBy("has_ebony_planks", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.EBONY_PLANKS.get()).build()))
//                .save(pFinishedRecipeConsumer);
//
//        ShapelessRecipeBuilder.shapeless(ModItems.CITRINE.get())
//                .requires(ModBlocks.CITRINE_BLOCK.get())
//                .unlockedBy("has_citrine_block", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.CITRINE_BLOCK.get()).build()))
//                .save(pFinishedRecipeConsumer);

    }
}