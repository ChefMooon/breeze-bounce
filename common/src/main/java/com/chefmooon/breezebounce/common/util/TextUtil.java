package com.chefmooon.breezebounce.common.util;

import com.chefmooon.breezebounce.BreezeBounce;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

public class TextUtil {
    public static MutableComponent getTranslatable(String string, Object... args) {
        return Component.translatable(BreezeBounce.MOD_ID + "." + string, args);
    }
    public static ResourceLocation res(String string) {
        return ResourceLocation.tryBuild(BreezeBounce.MOD_ID, string);
    }
}
