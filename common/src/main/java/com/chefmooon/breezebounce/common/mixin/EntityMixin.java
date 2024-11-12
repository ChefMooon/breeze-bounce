package com.chefmooon.breezebounce.common.mixin;

import com.chefmooon.breezebounce.common.block.SimpleBreezeBounceBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

    // note - is this the best option for collision detection? Similar to block.updateEntityAfterFallOn(), Might rework
    @Inject(method = "move(Lnet/minecraft/world/entity/MoverType;Lnet/minecraft/world/phys/Vec3;)V", at = @At("TAIL"))
    public void bounceBack(MoverType moverType, Vec3 vec3, CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        Level level = entity.level();

        if (!entity.noPhysics && !entity.isRemoved()) {
            // Horizontal Collision
            if (entity.horizontalCollision) {
                BlockPos onPos = entity.getOnPos();
                Direction direction = Direction.getApproximateNearest(vec3);
                BlockPos upperBlockPos = new BlockPos(onPos.getX(), (int) Math.floor(entity.getEyeY() + 0.17), onPos.getZ()).relative(direction);
                if (direction != Direction.DOWN && direction != Direction.UP) {
                    BlockState upperBlockState = level.getBlockState(upperBlockPos);
                    Block upperBlock = level.getBlockState(upperBlockPos).getBlock();
                    if (upperBlock instanceof SimpleBreezeBounceBlock upperBreezeBounceBlock) {
                        validSideCollision(level, upperBreezeBounceBlock, upperBlockState, upperBlockPos, entity, vec3);
                    }  else if (isStanding(entity)){
                        double entityY = (entity.getY() > 0 ? entity.getY() : entity.getOnPos().getY());
                        if (entity.onGround() && entity.getY() <= 0) entityY += 0.1;
                        BlockPos lowerBlockPos = new BlockPos(onPos.getX(), (int) entityY, onPos.getZ()).relative(direction);
                        if (upperBlockPos.getY() <= 0 && upperBlockPos.getY() == lowerBlockPos.getY()) {
                            lowerBlockPos = lowerBlockPos.below();
                        }
                        BlockState lowerBlockState = level.getBlockState(lowerBlockPos);
                        Block lowerBlock = level.getBlockState(lowerBlockPos).getBlock();
                        if (lowerBlock instanceof SimpleBreezeBounceBlock lowerBreezeBounceBlock) {
                            validSideCollision(level, lowerBreezeBounceBlock, lowerBlockState, lowerBlockPos, entity, vec3);
                        } else {
                            BlockPos middleBlockPos = upperBlockPos.below();
                            if (middleBlockPos.getY() != lowerBlockPos.getY()) {
                                BlockState middleBlockState = level.getBlockState(middleBlockPos);
                                Block middleBlock = level.getBlockState(middleBlockPos).getBlock();
                                if (middleBlock instanceof SimpleBreezeBounceBlock middleBreezeBounceBlock) {
                                    validSideCollision(level, middleBreezeBounceBlock, middleBlockState, middleBlockPos, entity, vec3);
                                }
                            }
                        }
                    }
                }
            }

            // Vertical Above Collision
            if (!entity.onGround() && ((entity.verticalCollision && !entity.verticalCollisionBelow) || (entity.verticalCollision && !isStanding(entity)))) {
                BlockPos blockPos = entity.getOnPos();
                if (isStanding(entity)) {
                    blockPos = blockPos.above(2);
                } else {
                    blockPos = blockPos.above();
                }
                Direction direction = Direction.getApproximateNearest(vec3);
                BlockState blockState = level.getBlockState(blockPos);
                Block block = level.getBlockState(blockPos).getBlock();
                if (direction == Direction.UP) {
                    if (block instanceof SimpleBreezeBounceBlock windBounceBlock) {
                        windBounceBlock.updateEntityAfterFlyUp(level, blockState, blockPos, entity, vec3);
                    }
                }
            }
        }
    }

    @Unique
    private void validSideCollision(Level level, SimpleBreezeBounceBlock block, BlockState blockState, BlockPos blockPos, Entity entity, Vec3 vec3) {
        block.updateEntityAfterSideCollision(level, blockState, blockPos, entity, vec3);
    }

    @Unique
    private boolean isStanding(Entity entity) {
        return entity.getEyeHeight() > 0.5f;
    }
}
