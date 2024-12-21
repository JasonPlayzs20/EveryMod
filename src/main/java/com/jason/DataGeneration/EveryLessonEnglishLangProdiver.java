package com.jason.DataGeneration;

import com.jason.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class EveryLessonEnglishLangProdiver extends FabricLanguageProvider {
    public EveryLessonEnglishLangProdiver(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.Titanium_Ingot, "Titanium Ingot");
        translationBuilder.add(ModItems.KFC_Bucket, "KFC Bucket");
        translationBuilder.add(ModItems.Chunk_Of_Titanium, "Chunk Of Titanium");
        translationBuilder.add(ModItems.TITANIUM_REINFORCED_DIAMOND_PICKAXE, "Titanium Reinforced Diamond Pickaxe");
        // Load an existing language file.
//        try {
//            Path existingFilePath = dataOutput.getModContainer().findPath("/src/main/resources/assets/everylesson/lang/en_us.json").get();
//            translationBuilder.add(existingFilePath);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to add existing r5language file!", e.getCause());
//        }
    }
}
