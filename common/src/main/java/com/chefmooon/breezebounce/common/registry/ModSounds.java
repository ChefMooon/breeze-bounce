package com.chefmooon.breezebounce.common.registry;

import com.chefmooon.breezebounce.common.util.TextUtil;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class ModSounds {
    public static final Supplier<SoundEvent> BOUNCE_BLOCK_INFLATE = registerSound("bounce_block_inflate");
    public static final Supplier<SoundEvent> BOUNCE_BLOCK_DEFLATE = registerSound("bounce_block_deflate");
    public static final Supplier<SoundEvent> BOUNCE_BLOCK_BOUNCE = registerSound("bounce_block_bounce");
    public static final Supplier<SoundEvent> BOUNCE_BLOCK_STEP = registerSound("bounce_block_step");

    public static final Supplier<SoundEvent> BLOCK_INFLATION_MACHINE_STARTUP = registerSound("block.inflation_machine.startup");
    public static final Supplier<SoundEvent> BLOCK_INFLATION_MACHINE_SHUTDOWN = registerSound("block.inflation_machine.shutdown");
    public static final Supplier<SoundEvent> BLOCK_INFLATION_MACHINE_INFLATE = registerSound("block.inflation_machine.inflate");

    private static Supplier<SoundEvent> registerSound(String string) {
        return registerSound(TextUtil.res(string), () -> SoundEvent.createVariableRangeEvent(TextUtil.res(string)));
    }

    @ExpectPlatform
    public static <T extends SoundEvent> Supplier<T> registerSound(ResourceLocation id, Supplier<T> supplier) {
        throw new AssertionError();
    }

    public static void init() {

    }
}
