package com.chefmooon.breezebounce.common.item;

import com.chefmooon.breezebounce.common.registry.ModSounds;
import com.chefmooon.breezebounce.common.util.TextUtil;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class VelcroArmorMaterial {
    public static final int BASE_DURABILITY = 5;
    public static final ResourceKey<EquipmentAsset> VELCRO_ARMOR_MATERIAL_KEY =  ResourceKey.create(EquipmentAssets.ROOT_ID, TextUtil.res("velcro"));
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 1,
                    ArmorType.CHESTPLATE, 3,
                    ArmorType.LEGGINGS, 2,
                    ArmorType.BOOTS, 1
            ),
            15,
            Holder.direct(ModSounds.ITEM_VELCRO_ARMOUR_EQUIP.get()), // TODO: fix sound
            0.0F,
            0.0F,
            ItemTags.REPAIRS_LEATHER_ARMOR,
            VELCRO_ARMOR_MATERIAL_KEY
    );
}
