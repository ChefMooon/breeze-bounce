package com.chefmooon.breezebounce.common.mixin;

import com.chefmooon.breezebounce.common.block.SimpleBreezeBounceBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "jumpFromGround()V", at = @At("TAIL"))
    public void breezeBounceJump(CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        if (livingEntity instanceof Player player) {
            Level level = livingEntity.level();
            BlockPos blockPos = player.getOnPos();
            Block block = level.getBlockState(blockPos).getBlock();
            if (block instanceof SimpleBreezeBounceBlock simpleBreezeBounceBlock) {
                level.playSound(player, blockPos, simpleBreezeBounceBlock.getBounceSound(), SoundSource.BLOCKS, 0.7F, 0.5F);
            }
        }
    }
}
