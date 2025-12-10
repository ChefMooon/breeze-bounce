package com.chefmooon.breezebounce.common.registry.fabric;

import com.google.common.base.Suppliers;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import java.util.function.Supplier;

public class ModParticleTypesImpl {
    public static Supplier<SimpleParticleType> registerParticleType(Identifier location) {
        return Suppliers.memoize(() -> Registry.register(BuiltInRegistries.PARTICLE_TYPE, location, FabricParticleTypes.simple(true)));
    }

    public static void register() {

    }
}
