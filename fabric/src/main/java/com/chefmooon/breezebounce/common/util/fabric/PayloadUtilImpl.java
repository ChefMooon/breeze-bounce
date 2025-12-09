package com.chefmooon.breezebounce.common.util.fabric;

import com.chefmooon.breezebounce.common.network.VelcroS2CPayload;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class PayloadUtilImpl {
    public static void sendDoubleBouncePacketToClient(Entity entity, VelcroS2CPayload payload) {
        if (entity instanceof ServerPlayer serverPlayer) {
            ServerPlayNetworking.send(serverPlayer, payload);
        }
    }
}
