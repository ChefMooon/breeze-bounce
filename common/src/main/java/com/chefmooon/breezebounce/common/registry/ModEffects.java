package com.chefmooon.breezebounce.common.registry;

import com.chefmooon.breezebounce.common.effect.VelcroEffect;
import com.chefmooon.breezebounce.common.util.TextUtil;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class ModEffects {

    public static final Holder<MobEffect> VELCRO = mobEffect("velcro",VelcroEffect::new);

    private static Holder<MobEffect> mobEffect(String string, Supplier<MobEffect> supplier) {
        return registerEffect(TextUtil.res(string), supplier);
    }

    @ExpectPlatform
    public static Holder<MobEffect> registerEffect(ResourceLocation location, Supplier<MobEffect> supplier) {
        throw new AssertionError();
    }

    public static void init() {
    }
}
