package com.jason.items;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.Objects;
import java.util.function.Supplier;
public enum EveryLessonToolMaterial implements ToolMaterial {
    TITANIUM_REINFORCED_DIAMOND_PICKAXE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,2031,27,3.0F,22,Ingredient.ofItems(ModItems.Titanium_Ingot));

//    NETHERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, () -> {
//        return Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT});
//    });

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairIngredient;

    private EveryLessonToolMaterial(final TagKey inverseTag, final int itemDurability, final float miningSpeed, final float attackDamage, final int enchantability, final Ingredient repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = repairIngredient;
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    public int getEnchantability() {
        return 1;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient;
    }
}
