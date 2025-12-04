package com.chefmooon.breezebounce.common.item;

import com.chefmooon.breezebounce.common.registry.ModEffects;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.Equippable;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class VelcroArmorItem extends Item {
    private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(Holder.direct(VelcroArmorMaterial.INSTANCE),
                            List.of(new MobEffectInstance(ModEffects.VELCRO, 40, 0, false, false))).build();
    public VelcroArmorItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel serverLevel, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
        if(!serverLevel.isClientSide()) {
            if(entity instanceof Player player) {
                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(itemStack, serverLevel, entity, equipmentSlot);
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapStatusEffects = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffects);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, Holder<ArmorMaterial> mapArmorMaterial, List<MobEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(MobEffectInstance -> player.hasEffect(MobEffectInstance.getEffect()));

        if(!hasPlayerEffect) {
            for (MobEffectInstance instance : mapStatusEffect) {
                player.addEffect(new MobEffectInstance(instance.getEffect(),
                        instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.getParticleOptions().getType().getOverrideLimiter()));
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getItem(EquipmentSlot.FEET.getIndex(36));
        ItemStack leggings = player.getInventory().getItem(EquipmentSlot.LEGS.getIndex(36));
        ItemStack breastplate = player.getInventory().getItem(EquipmentSlot.CHEST.getIndex(36));
        ItemStack helmet = player.getInventory().getItem(EquipmentSlot.HEAD.getIndex(36));

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(Holder<ArmorMaterial> material, Player player) {
        List<Integer> armorIndices = List.of(
                EquipmentSlot.FEET.getIndex(36),
                EquipmentSlot.LEGS.getIndex(36),
                EquipmentSlot.CHEST.getIndex(36),
                EquipmentSlot.HEAD.getIndex(36)
        );
        for (int index : armorIndices) {
            ItemStack armorStack = player.getInventory().getItem(index);
            if (!(armorStack.getItem() instanceof VelcroArmorItem)) {
                return false;
            }
        }

        Equippable equippedBoots = player.getInventory().getItem(EquipmentSlot.FEET.getIndex(36)).get(DataComponents.EQUIPPABLE);
        Equippable equippedLeggings = player.getInventory().getItem(EquipmentSlot.LEGS.getIndex(36)).get(DataComponents.EQUIPPABLE);
        Equippable equippedBreastplate = player.getInventory().getItem(EquipmentSlot.CHEST.getIndex(36)).get(DataComponents.EQUIPPABLE);
        Equippable equippedHelmet = player.getInventory().getItem(EquipmentSlot.HEAD.getIndex(36)).get(DataComponents.EQUIPPABLE);

        boolean validBoots = equippedBoots != null && equippedBoots.assetId().isPresent() && equippedBoots.assetId().get().equals(VelcroArmorMaterial.VELCRO_ARMOR_MATERIAL_KEY);
        boolean validLeggings = equippedLeggings != null && equippedLeggings.assetId().isPresent() && equippedLeggings.assetId().get().equals(VelcroArmorMaterial.VELCRO_ARMOR_MATERIAL_KEY);
        boolean validBreastplate = equippedBreastplate != null && equippedBreastplate.assetId().isPresent() && equippedBreastplate.assetId().get().equals(VelcroArmorMaterial.VELCRO_ARMOR_MATERIAL_KEY);
        boolean validHelmet = equippedHelmet != null && equippedHelmet.assetId().isPresent() && equippedHelmet.assetId().get().equals(VelcroArmorMaterial.VELCRO_ARMOR_MATERIAL_KEY);

        return validBoots && validLeggings && validBreastplate && validHelmet;
    }
}
