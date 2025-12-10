package com.chefmooon.breezebounce.common.network;

import com.chefmooon.breezebounce.BreezeBounce;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record VelcroS2CPayload(int entityId, double x, double y, double z) implements CustomPacketPayload {
    public static final ResourceLocation VELCRO_PAYLOAD_ID = ResourceLocation.fromNamespaceAndPath(BreezeBounce.MOD_ID, "velcro");
    public static final Type<VelcroS2CPayload> ID = new Type<>(VELCRO_PAYLOAD_ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, VelcroS2CPayload> CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, VelcroS2CPayload::entityId,
            ByteBufCodecs.DOUBLE, VelcroS2CPayload::x,
            ByteBufCodecs.DOUBLE, VelcroS2CPayload::y,
            ByteBufCodecs.DOUBLE, VelcroS2CPayload::z,
            VelcroS2CPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
