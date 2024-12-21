package com.jason.DataGeneration;

import com.jason.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;


public class EveryLessonRecipiesProvider extends FabricRecipeProvider {
    public EveryLessonRecipiesProvider(FabricDataOutput generator, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(generator, registriesFuture);
    }
    public static final java.util.List<ItemConvertible> Chicken = Util.make(new ArrayList<>(), list -> {list.add(Items.COOKED_CHICKEN);
    });

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Titanium_Ingot,1).input('I',ModItems.Chunk_Of_Titanium).pattern("II").pattern("II")
                .criterion(hasItem(ModItems.Chunk_Of_Titanium),conditionsFromItem(ModItems.Chunk_Of_Titanium)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.KFC_Bucket,2).input(ModItems.KFC_Bucket,5).criterion(hasItem(ModItems.KFC_Bucket),conditionsFromItem(ModItems.KFC_Bucket)).offerTo(exporter);
        RecipeProvider.offerSmelting(exporter,Chicken ,RecipeCategory.FOOD,ModItems.KFC_Bucket,0.45F,30,"idk");
    }
}
