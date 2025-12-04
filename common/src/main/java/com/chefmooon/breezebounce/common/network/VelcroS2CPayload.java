package com.chefmooon.breezebounce.common.network;

import com.chefmooon.breezebounce.BreezeBounce;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

import java.util.UUID;

public record VelcroS2CPayload(UUID entityId, Vec3 vec) implements CustomPacketPayload {
    public static final ResourceLocation VELCRO_PAYLOAD_ID = ResourceLocation.fromNamespaceAndPath(BreezeBounce.MOD_ID, "velcro");
    public static final CustomPacketPayload.Type<VelcroS2CPayload> ID = new CustomPacketPayload.Type<>(VELCRO_PAYLOAD_ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, VelcroS2CPayload> CODEC = StreamCodec.composite(
            UUIDUtil.STREAM_CODEC, VelcroS2CPayload::entityId,
            Vec3.STREAM_CODEC, VelcroS2CPayload::vec,
            VelcroS2CPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
