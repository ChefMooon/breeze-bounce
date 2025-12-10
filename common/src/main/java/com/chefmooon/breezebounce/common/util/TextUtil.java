package com.chefmooon.breezebounce.common.util;

import com.chefmooon.breezebounce.BreezeBounce;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;

public class TextUtil {
    public static MutableComponent getTranslatable(String string, Object... args) {
        return Component.translatable(BreezeBounce.MOD_ID + "." + string, args);
    }
    public static Identifier res(String string) {
        return Identifier.tryBuild(BreezeBounce.MOD_ID, string);
    }
}
