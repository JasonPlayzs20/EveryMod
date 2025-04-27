package com.jason.items;

import com.jason.EveryLesson;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //food
    public static final FoodComponent KFC_Bucket_component = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(7)
            .build();
    public static final Item KFC_Bucket = register(new Item(new Item.Settings().food(KFC_Bucket_component)), "ofc_bucket");
    //items
    public static final Item Titanium_Ingot = register(new Item(new Item.Settings()), "titanium_ingot");
    public static final Item Chunk_Of_Titanium = register(new Item(new Item.Settings()), "chunk_of_titanium");
    //tools
    public static final PickaxeItem TITANIUM_REINFORCED_DIAMOND_PICKAXE = registerPic(new PickaxeItem(ToolMaterials.NETHERITE,
            (new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(EveryLessonToolMaterial.TITANIUM_REINFORCED_DIAMOND_PICKAXE,
                    EveryLessonToolMaterial.TITANIUM_REINFORCED_DIAMOND_PICKAXE.getAttackDamage(), -2.8F))), "titanium_reinforced_diamond_pickaxe");


    public static <T extends Item> T register(T item, String id) {
        Identifier ItemID = Identifier.of(EveryLesson.MOD_ID, id);
        return Registry.register(Registries.ITEM, ItemID, item);
    }

    public static PickaxeItem registerPic(PickaxeItem item, String id) {
        Identifier ItemID = Identifier.of(EveryLesson.MOD_ID, id);
        return Registry.register(Registries.ITEM, ItemID, item);
    }
//
//    public static <T extends Item> T register(String name, T item) {
//        return Registry.register(Registries.ITEM, TutorialMod.id(name), item);
//    }


    private static void addItemsToTab(FabricItemGroupEntries entries) {
        entries.add(Titanium_Ingot);
        entries.add(Chunk_Of_Titanium);
        entries.add(KFC_Bucket);
        entries.add(TITANIUM_REINFORCED_DIAMOND_PICKAXE);
    }

    public static void registerItems() {
        EveryLesson.LOGGER.info("Registering Mod Items");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToTab);
        FuelRegistry.INSTANCE.add(ModItems.Chunk_Of_Titanium, 1000);

        //custom add to tabs
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ModItems.TITANIUM_REINFORCED_DIAMOND_PICKAXE));
    }


}
