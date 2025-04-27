package com.jason;

import com.jason.DataGeneration.EveryLessonModelProvider;
import com.jason.items.EveryLessonArmorMaterial;
import com.jason.items.EveryLessonToolMaterial;
import com.jason.items.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EveryLesson implements ModInitializer {
    public static final String MOD_ID = "everylesson";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");
        ModItems.registerItems();
        EveryLessonArmorMaterial.initialize();
        EnchantDet.EVENT.register((player -> {
            player.sendMessage(Text.of(player.getInventory().getStack(0).getName().toString()));
            return ActionResult.PASS;
        }));

    }

    public interface EnchantDet {
        Event<EnchantDet> EVENT = EventFactory.createArrayBacked(EnchantDet.class,
                (listeners) -> (player) -> {
                    for (EnchantDet listener : listeners) {
                        ActionResult result = listener.interact(player);

                        if (result != ActionResult.PASS) {
                            return result;
                        }
                    }

                    return ActionResult.PASS;
                });

        ActionResult interact(PlayerEntity player);
    }
}