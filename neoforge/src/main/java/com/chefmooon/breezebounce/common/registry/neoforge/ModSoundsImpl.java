package com.chefmooon.breezebounce.common.registry.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.common.registry.ModSounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSoundsImpl {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, BreezeBounce.MOD_ID);

    // Using the sound for the armor equip sound, requires a DeferredHolder to be used in ArmorMaterial in NeoForge
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_VELCRO_ARMOUR_EQUIP = SOUND_EVENTS.register("item.velcro_armour.equip", () -> SoundEvent.createVariableRangeEvent(ModSounds.ITEM_VELCRO_ARMOUR_EQUIP_ID));

    public static <T extends SoundEvent> Supplier<T> registerSound(ResourceLocation id, Supplier<T> supplier) {
        return SOUND_EVENTS.register(id.getPath(), supplier);
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
