package com.jason.items;

import com.google.common.base.Suppliers;
import com.jason.EveryLesson;
import net.minecraft.block.Block;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import javax.tools.Tool;
import java.util.Objects;
import java.util.function.Supplier;
public enum EveryLessonToolMaterial implements ToolMaterial {
    TITANIUM_REINFORCED_DIAMOND_PICKAXE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,2031,10.0F,3.0F,17,() -> {
        return Ingredient.ofItems(new ItemConvertible[]{ModItems.Titanium_Ingot});
    });

//    NETHERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, () -> {
//        return Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT});
//    });

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private EveryLessonToolMaterial(final TagKey inverseTag, final int itemDurability, final float miningSpeed, final float attackDamage, final int enchantability, final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
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
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
