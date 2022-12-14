package com.finndog.moogsmobs.datagen;

import com.finndog.moogsmobs.MoogsMobs;
import com.finndog.moogsmobs.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MoogsMobs.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BRASS_INGOT.get());
    }

    private ItemModelBuilder simpleItem(Item item) {
        String itemName = ForgeRegistries.ITEMS.getKey(item).getPath();

        return withExistingParent(itemName,
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MoogsMobs.MODID,"item/" + itemName));
    }

}