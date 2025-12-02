package com.chefmooon.breezebounce.common.registry.fabric;

import com.chefmooon.breezebounce.common.util.TextUtil;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorMaterial;

public class ModArmorMaterialsImpl {
    public static Holder<ArmorMaterial> registerMaterial(String id, ArmorMaterial armorMaterial) {
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, TextUtil.res(id), armorMaterial);
    }
    public static Holder<SoundEvent> getEquipSound() {
        return Holder.direct(ModSoundsImpl.ITEM_VELCRO_ARMOUR_EQUIP.get());
    }

    public static void register() {
    }
}
