package com.chefmooon.breezebounce.common.registry;

import com.chefmooon.breezebounce.common.util.TextUtil;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static Holder<ArmorMaterial> VELCRO = registerMaterial("velcro", Map.of(
            ArmorItem.Type.HELMET, 1,
            ArmorItem.Type.CHESTPLATE, 3,
            ArmorItem.Type.LEGGINGS, 2,
            ArmorItem.Type.BOOTS, 1
            ), 15,
            getEquipSound(),
            () -> Ingredient.of(Items.LEATHER), 0.0f, 0.0f);

    public static Holder<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, Holder<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance) {
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(TextUtil.res(id), "", true), new ArmorMaterial.Layer(TextUtil.res(id), "_overlay", false));
        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        return registerMaterial(id, material);
    }

    @ExpectPlatform
    public static Holder<ArmorMaterial> registerMaterial(String id, ArmorMaterial armorMaterial) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Holder<SoundEvent> getEquipSound() {
        throw new AssertionError();
    }

    public static void init() {
    }
}
