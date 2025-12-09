package com.chefmooon.breezebounce.common.util;

import com.chefmooon.breezebounce.common.network.VelcroS2CPayload;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.Entity;

public class PayloadUtil {
    @ExpectPlatform
    public static void sendDoubleBouncePacketToClient(Entity entity, VelcroS2CPayload payload) {
        throw new AssertionError();
    }
}
