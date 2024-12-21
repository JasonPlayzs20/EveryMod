package com.jason.DataGeneration;

import com.jason.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class EveryLessonRecipiesProvider extends FabricRecipeProvider {
    public EveryLessonRecipiesProvider(FabricDataOutput generator, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(generator, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Titanium_Ingot,1).input('I',ModItems.Chunk_Of_Titanium).pattern("II").pattern("II")
                .criterion(hasItem(ModItems.Chunk_Of_Titanium),conditionsFromItem(ModItems.Chunk_Of_Titanium)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.KFC_Bucket,2).input(ModItems.KFC_Bucket,5).criterion(hasItem(ModItems.KFC_Bucket),conditionsFromItem(ModItems.KFC_Bucket)).offerTo(exporter);
    }
}
