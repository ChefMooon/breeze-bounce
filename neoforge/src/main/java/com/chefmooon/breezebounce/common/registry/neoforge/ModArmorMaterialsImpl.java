package com.chefmooon.breezebounce.common.registry.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorMaterial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModArmorMaterialsImpl {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIAL = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, BreezeBounce.MOD_ID);

    public static Holder<ArmorMaterial> registerMaterial(String id, ArmorMaterial armorMaterial) {
        return ARMOR_MATERIAL.register(id, () -> armorMaterial);
    }
    public static Holder<SoundEvent> getEquipSound() {
        return ModSoundsImpl.ITEM_VELCRO_ARMOUR_EQUIP;
    }

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIAL.register(eventBus);
    }
}
