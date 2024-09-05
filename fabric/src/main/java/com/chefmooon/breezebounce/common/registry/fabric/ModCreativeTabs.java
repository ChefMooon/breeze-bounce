package com.chefmooon.breezebounce.common.registry.fabric;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.fabric.BreezeBounceImpl;
import com.chefmooon.breezebounce.common.util.TextUtil;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {
    public static final ResourceKey<CreativeModeTab> ITEM_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB, TextUtil.res(BreezeBounce.MOD_ID));

    public static void register() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ITEM_GROUP, FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + BreezeBounce.MOD_ID))
                .icon(() -> new ItemStack(ModItemsImpl.BASIC_BOUNCE))
                .build());
    }
}
