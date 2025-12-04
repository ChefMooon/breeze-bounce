package com.chefmooon.breezebounce.common.registry.fabric;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class ModEffectsImpl {

    public static Holder<MobEffect> registerEffect(ResourceLocation location, Supplier<MobEffect> supplier) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, location, supplier.get());
    }

    public static void register() {
    }
}
