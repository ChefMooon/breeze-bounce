package com.chefmooon.breezebounce.common.effect.neoforge;

import com.chefmooon.breezebounce.common.network.VelcroS2CPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.network.PacketDistributor;

public class VelcroEffectImpl {
    public static void sendVelcroNoFallPacketToClient(Entity entity, VelcroS2CPayload payload) {
        if (entity instanceof ServerPlayer serverPlayer) {
            PacketDistributor.sendToPlayer(serverPlayer, payload);
        }
    }
}
