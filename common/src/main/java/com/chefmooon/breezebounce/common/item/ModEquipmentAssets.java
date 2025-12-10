package com.chefmooon.breezebounce.common.item;

import com.chefmooon.breezebounce.common.util.TextUtil;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class ModEquipmentAssets {
    public static final ResourceKey<EquipmentAsset> VELCRO = createId("velcro");
    static ResourceKey<EquipmentAsset> createId(String name) {
        return ResourceKey.create(ResourceKey.createRegistryKey(TextUtil.res("equipment_asset")), Identifier.withDefaultNamespace(name));
    }
}
