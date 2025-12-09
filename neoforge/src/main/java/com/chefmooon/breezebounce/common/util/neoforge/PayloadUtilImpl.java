package com.chefmooon.breezebounce.common.util.neoforge;

import com.chefmooon.breezebounce.common.network.VelcroS2CPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.network.PacketDistributor;

public class PayloadUtilImpl {
    public static void sendDoubleBouncePacketToClient(Entity entity, VelcroS2CPayload payload) {
        if (entity instanceof ServerPlayer serverPlayer) {
            PacketDistributor.sendToPlayer(serverPlayer, payload);
        }
    }
}
