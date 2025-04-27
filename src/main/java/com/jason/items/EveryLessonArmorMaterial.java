package com.jason.items;

import com.jason.EveryLesson;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class EveryLessonArmorMaterial {
    public static void initialize() {
    }

    public static final RegistryEntry<ArmorMaterial> END = registerMaterial("end",
            new EnumMap<>(Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3
            )),
            5, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.CHORUS_FLOWER), false);

    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of(EveryLesson.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defense, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance);
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(EveryLesson.MOD_ID, id), material);
        return RegistryEntry.of(material);
    }
}