package com.jason;

import com.jason.DataGeneration.EveryLessonEnglishLangProdiver;
import com.jason.DataGeneration.EveryLessonModelProvider;
import com.jason.DataGeneration.EveryLessonRecipiesProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class EveryLessonDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        fabricDataGenerator.createPack().addProvider(EveryLessonRecipiesProvider::new);
        pack.addProvider(EveryLessonEnglishLangProdiver::new);
        fabricDataGenerator.createPack().addProvider(EveryLessonModelProvider::new);

    }
}
