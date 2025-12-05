package com.chefmooon.breezebounce.common.effect;

import com.chefmooon.breezebounce.common.block.SimpleBreezeBounceBlock;
import com.chefmooon.breezebounce.common.network.VelcroS2CPayload;
import com.chefmooon.breezebounce.common.registry.ModSounds;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class VelcroEffect extends MobEffect {
    public VelcroEffect() {
        super(MobEffectCategory.NEUTRAL, 0x202020);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity livingEntity, int amplifier) {
        BlockPos belowPos = livingEntity.getBlockPosBelowThatAffectsMyMovement();

        boolean verticalSound = false;
        if (serverLevel.getBlockState(belowPos).getBlock() instanceof SimpleBreezeBounceBlock) {
            verticalSound = playVelcroSound(serverLevel, belowPos, livingEntity);
        }

        if (isTouchingHorizontalSide(livingEntity, serverLevel)) { // TODO: improve make sound on initial contact and fall off
            if (!verticalSound) playVelcroSound(serverLevel, belowPos, livingEntity);
            if (livingEntity.isCrouching()) {
                Entity serverEntity = serverLevel.getEntity(livingEntity.getUUID());
                if (serverEntity != null) {
                    setEntityVerticalMotionToZero(serverEntity, livingEntity);
                    sendVelcroNoFallPacketToClient(serverEntity, new VelcroS2CPayload(serverEntity.getUUID(), getVelcroMotionVector(livingEntity)));
                }
            }
        }

        return true;
    }

    @ExpectPlatform
    public static void sendVelcroNoFallPacketToClient(Entity entity, VelcroS2CPayload payload) {
        throw new AssertionError();
    }

    private void setEntityVerticalMotionToZero(Entity entity, LivingEntity livingEntity) {
        entity.setDeltaMovement(getVelcroMotionVector(livingEntity));
        entity.resetFallDistance();
    }

    private Vec3 getVelcroMotionVector(LivingEntity livingEntity) {
        float headRot = livingEntity.getViewXRot(1.0F);
        double dx = livingEntity.getKnownMovement().x;
        double dz = livingEntity.getKnownMovement().z;
        double verticalSpeedThreshold = 0.002;
        if (Math.abs(dx) > verticalSpeedThreshold || Math.abs(dz) > verticalSpeedThreshold) {
            double dy = (-headRot / 8) * 0.005;
            return new Vec3(dx * 0.8, dy, dz * 0.8);
        } else {
            boolean notMoving = Math.abs(dx) < verticalSpeedThreshold || Math.abs(dz) < verticalSpeedThreshold;
            if (notMoving && headRot > 75.0F) {
                return new Vec3(dx * 0.8, -0.03, dz * 0.8);
            } else if (notMoving && headRot < -75.0F) {
                return new Vec3(dx * 0.8, 0.03, dz * 0.8);
            } else {
                return new Vec3(dx * 0.8, 0.0, dz * 0.8);
            }
        }
    }

    private boolean isTouchingHorizontalSide(LivingEntity entity, Level level) {
        AABB bb = entity.getBoundingBox();
        double eps = 1e-6;

        double minX = bb.minX - eps;
        double maxX = bb.maxX + eps;
        double minY = bb.minY - eps;
        double maxY = bb.maxY + eps;
        double minZ = bb.minZ - eps;
        double maxZ = bb.maxZ + eps;

        int startX = (int) Math.floor(minX);
        int endX   = (int) Math.ceil(maxX) - 1;
        int startY = (int) Math.floor(minY);
        int endY   = (int) Math.ceil(maxY) - 1;
        int startZ = (int) Math.floor(minZ);
        int endZ   = (int) Math.ceil(maxZ) - 1;

        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                for (int z = startZ; z <= endZ; z++) {
                    BlockPos pos = new BlockPos(x, y, z);
                    if (!isBounceBlock(level, pos)) continue;
                    if (isBlockSideTouching(bb, pos, eps)) return true;
                }
            }
        }

        return false;
    }

    private boolean isBounceBlock(Level level, BlockPos pos) {
        if (!level.isLoaded(pos)) return false;
        return level.getBlockState(pos).getBlock() instanceof SimpleBreezeBounceBlock;
    }

    private boolean isBlockSideTouching(AABB entityBB, BlockPos pos, double eps) {
        AABB blockBB = new AABB(
            pos.getX() - eps, pos.getY() - eps, pos.getZ() - eps,
            pos.getX() + 1.0 + eps, pos.getY() + 1.0 + eps, pos.getZ() + 1.0 + eps
        );

        if (!entityBB.intersects(blockBB)) return false;

        double overlapX = Math.min(entityBB.maxX, blockBB.maxX) - Math.max(entityBB.minX, blockBB.minX);
        double overlapY = Math.min(entityBB.maxY, blockBB.maxY) - Math.max(entityBB.minY, blockBB.minY);
        double overlapZ = Math.min(entityBB.maxZ, blockBB.maxZ) - Math.max(entityBB.minZ, blockBB.minZ);

        double minOverlap = Math.min(overlapX, Math.min(overlapY, overlapZ));

        return (minOverlap < overlapY - 1e-6) && (minOverlap > 0.0);
    }

    private boolean playVelcroSound(ServerLevel serverLevel, BlockPos blockPos, LivingEntity livingEntity) {
        Vec3 deltaMovement = livingEntity.getKnownMovement();
        double dx = deltaMovement.x;
        double dy = deltaMovement.y;
        double dz = deltaMovement.z;

        double horizontal = Math.sqrt(dx * dx + dz * dz);
        double speed = Math.sqrt(dx * dx + dy * dy + dz * dz);

        final double MIN_SPEED = 0.079;
        if (speed <= MIN_SPEED) return false;

        double chance = Math.min(0.2, 0.02 + speed * 0.2);

        if (Math.random() >= chance) return false;

        float volume = Math.max(0.15f, Math.min(1.0f, 0.25f + (float)horizontal * 0.6f));

        float pitch;
        if (livingEntity.isCrouching()) {
            pitch = 0.3f + (float)horizontal * 0.25f;
        } else {
            pitch = 0.7f + (float)(Math.abs(dy) * 0.4 + horizontal * 0.3);
        }

        pitch = Math.max(0.4f, Math.min(2.0f, pitch));

        int xPos = blockPos.getX();
        int yPos = blockPos.getY();
        int zPos = blockPos.getZ();
        SoundEvent sound = ModSounds.ITEM_VELCRO_ARMOUR_TEAR.get();

        if (!serverLevel.isClientSide()) {
            serverLevel.playSound(null, xPos, yPos, zPos, sound, SoundSource.PLAYERS, volume, pitch);
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
