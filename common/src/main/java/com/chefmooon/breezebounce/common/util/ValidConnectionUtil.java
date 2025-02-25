package com.chefmooon.breezebounce.common.util;

import com.chefmooon.breezebounce.common.block.BreezeBounceSlabBlock;
import com.chefmooon.breezebounce.common.block.BreezeBounceStairBlock;
import com.chefmooon.breezebounce.common.block.BreezeBounceWallBlock;
import com.chefmooon.breezebounce.common.block.SimpleBreezeBounceBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.properties.StairsShape;

import java.util.*;

public class ValidConnectionUtil {

    public static Set<BlockPos> findDoubleJumpBlocks(Level level, BlockPos startPos, int radius) {
        return findConnectedBlocks(level, startPos, Direction.Axis.Y, 0, radius);
    }

    public static Set<BlockPos> findConnectedBlocks(Level level, BlockPos startPos, Direction.Axis axis, int height, int radius) {
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();
        queue.add(startPos);

        while (!queue.isEmpty()) {
            BlockPos current = queue.poll();
            if (visited.contains(current) || !isWithinSquareRadius(startPos, current, axis, height, radius)) continue;

            visited.add(current);

            BlockState blockState = level.getBlockState(current);
            Block block = blockState.getBlock();
            Set<Direction> directions = new HashSet<>();
            if (block instanceof BreezeBounceWallBlock) {
                if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.X) {
                    directions.addAll(Arrays.asList(Direction.EAST, Direction.WEST));
                } else if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.Z) {
                    directions.addAll(Arrays.asList(Direction.NORTH, Direction.SOUTH));
                } else if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.Y) {
                    directions.addAll(Arrays.asList(Direction.UP, Direction.DOWN));
                }
            } else if (block instanceof BreezeBounceSlabBlock) {
                directions.addAll(Arrays.asList(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST));
                if (blockState.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.BOTTOM) {
                    directions.add(Direction.DOWN);
                } else if (blockState.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.TOP) {
                    directions.add(Direction.UP);
                } else if (blockState.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.DOUBLE) {
                    directions.addAll(Arrays.asList(Direction.UP, Direction.DOWN));
                }
            } else {
                directions.addAll(Arrays.asList(Direction.values()));
            }
            for (Direction direction : directions) {
                BlockPos neighbor = current.relative(direction);
                if (isValidConnection(level, blockState, neighbor, direction)) {
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    private static boolean isWithinSquareRadius(BlockPos start, BlockPos current, Direction.Axis axis, int height, int radius) {
        return Math.abs(current.getX() - start.getX()) <= (axis == Direction.Axis.X ? height : radius) &&
                Math.abs(current.getY() - start.getY()) <= (axis == Direction.Axis.Y ? height : radius) &&
                Math.abs(current.getZ() - start.getZ()) <= (axis == Direction.Axis.Z ? height : radius);
    }

    private static boolean isValidConnection(Level level, BlockState sourceBlockState, BlockPos pos, Direction direction) {
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();
        Block sourceBlock = sourceBlockState.getBlock();

        return switch (block) {
            case BreezeBounceWallBlock ignored ->
                    isValidWallConnection(direction, state);
            case BreezeBounceSlabBlock ignored ->
                    isValidSlabConnection(direction, state, sourceBlock, sourceBlockState);
            case BreezeBounceStairBlock ignored ->
                    isValidStairConnection(block, sourceBlock, sourceBlockState, state, direction);
            default -> block instanceof SimpleBreezeBounceBlock;
        };
    }

    private static boolean isValidWallConnection(Direction direction, BlockState blockState) {
        if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.Y && (direction == Direction.UP || direction == Direction.DOWN)) {
            return true;
        } else if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.X && (direction == Direction.EAST || direction == Direction.WEST)) {
            return true;
        } else if (blockState.getValue(BreezeBounceWallBlock.AXIS) == Direction.Axis.Z && (direction == Direction.NORTH || direction == Direction.SOUTH)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValidSlabConnection(Direction direction, BlockState state, Block sourceBlock, BlockState sourceBlockState) {
        if (direction == Direction.UP || direction == Direction.DOWN) {
            if (direction == Direction.UP && !(state.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.TOP)) {
                return true;
            } else if (direction == Direction.DOWN && !(state.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.BOTTOM)) {
                return true;
            } else {
                return false;
            }
        } else if (sourceBlock instanceof BreezeBounceSlabBlock) {
            if (sourceBlockState.getValue(BreezeBounceSlabBlock.TYPE) == state.getValue(BreezeBounceSlabBlock.TYPE)) {
                return true;
            } else if (sourceBlockState.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.DOUBLE || state.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.DOUBLE) {
                return true;
            } else {
                return false;
            }
        } else if (sourceBlock instanceof BreezeBounceStairBlock) {
            SlabType type = state.getValue(BreezeBounceSlabBlock.TYPE);
            Half half = sourceBlockState.getValue(BreezeBounceStairBlock.HALF);
            if (type == SlabType.DOUBLE || (type == SlabType.BOTTOM && half == Half.BOTTOM) || (type == SlabType.TOP && half == Half.TOP)) {
                return true;
            } else {
                Direction sourceFacing = sourceBlockState.getValue(BreezeBounceStairBlock.FACING);
                StairsShape sourceShape = sourceBlockState.getValue(BreezeBounceStairBlock.SHAPE);
                if (sourceFacing == direction) {
                    return true;
                } else if (sourceFacing == direction.getClockWise()) {
                    return sourceShape != StairsShape.OUTER_RIGHT;
                } else if (sourceFacing == direction.getCounterClockWise()) {
                    return sourceShape != StairsShape.OUTER_LEFT;
                } else {
                    return sourceShape == StairsShape.INNER_LEFT || sourceShape == StairsShape.INNER_RIGHT;
                }
            }
        }
        return true;
    }

    private static boolean isValidStairConnection(Block block, Block sourceBlock, BlockState sourceBlockState, BlockState state, Direction direction) {
        if (sourceBlock instanceof BreezeBounceSlabBlock) {
            if (sourceBlockState.getValue(BreezeBounceSlabBlock.TYPE) == SlabType.DOUBLE) {
                return true;
            } else {
                Direction facing = state.getValue(BreezeBounceStairBlock.FACING);
                StairsShape shape = state.getValue(BreezeBounceStairBlock.SHAPE);
                SlabType slabType = sourceBlockState.getValue(BreezeBounceSlabBlock.TYPE);
                Half stairHalf = state.getValue(BreezeBounceStairBlock.HALF);
                if ((slabType == SlabType.BOTTOM && stairHalf == Half.BOTTOM) || (slabType == SlabType.TOP && stairHalf == Half.TOP)) {
                    return true;
                } else {
                    if (facing == direction) {
                        return shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT;
                    } else {
                        if (facing == direction.getClockWise()) {
                            if (shape == StairsShape.OUTER_LEFT) {
                                return false;
                            }
                        } else if (facing == direction.getCounterClockWise()) {
                            if (shape == StairsShape.OUTER_RIGHT) {
                                return false;
                            }
                        } else {
                            return true;
                        }
                    }
                }
            }
        } else if (sourceBlock instanceof BreezeBounceStairBlock) {
            Half sourceHalf = sourceBlockState.getValue(BreezeBounceStairBlock.HALF);
            Half half = state.getValue(BreezeBounceStairBlock.HALF);
            Direction sourceFacing = sourceBlockState.getValue(BreezeBounceStairBlock.FACING);
            Direction facing = state.getValue(BreezeBounceStairBlock.FACING);
            StairsShape sourceShape = sourceBlockState.getValue(BreezeBounceStairBlock.SHAPE);
            StairsShape shape = state.getValue(BreezeBounceStairBlock.SHAPE);

            boolean innerConner = shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT || sourceShape == StairsShape.INNER_LEFT || sourceShape == StairsShape.INNER_RIGHT;

            if (direction == Direction.DOWN) {
                if (sourceHalf == Half.BOTTOM && half == Half.TOP) {
                    return true;
                }
                if (facing == sourceFacing.getOpposite()) {
                    if (sourceShape == StairsShape.OUTER_RIGHT && shape != StairsShape.INNER_LEFT) return false;
                    if (sourceShape == StairsShape.OUTER_LEFT && shape != StairsShape.INNER_RIGHT) return false;
                    return innerConner;
                } else if (facing == sourceFacing.getClockWise()) {
                    if (sourceShape == StairsShape.OUTER_LEFT ) {
                        return shape == StairsShape.INNER_LEFT;
                    } else {
                        return true;
                    }
                } else if (facing == sourceFacing.getCounterClockWise()) {
                    if (sourceShape == StairsShape.OUTER_RIGHT) {
                        return shape == StairsShape.INNER_RIGHT;
                    } else {
                        return true;
                    }
                }
            } else if (direction == Direction.UP) {
                if (sourceHalf == Half.TOP && half == Half.BOTTOM) {
                    return true;
                }
                if (facing == sourceFacing.getOpposite()) {
                    if (sourceShape == StairsShape.INNER_LEFT && shape == StairsShape.OUTER_LEFT) return false;
                    if (sourceShape == StairsShape.INNER_RIGHT && shape == StairsShape.OUTER_RIGHT) return false;
                    return innerConner;
                } else if (facing == sourceFacing.getClockWise()) {
                    if (sourceShape == StairsShape.INNER_LEFT ) {
                        return shape == StairsShape.OUTER_LEFT;
                    } else {
                        return true;
                    }
                } else if (facing == sourceFacing.getCounterClockWise()) {
                    if (sourceShape == StairsShape.INNER_RIGHT) {
                        return shape == StairsShape.OUTER_RIGHT;
                    } else {
                        return true;
                    }
                }
            } else {
                if (half == sourceHalf) {
                    return true;
                } else {
                    if (facing == sourceFacing.getOpposite()) {
                        return (direction == sourceFacing) || innerConner;
                    } else if (facing == sourceFacing.getClockWise()) {
                        if (sourceShape == StairsShape.OUTER_LEFT || shape == StairsShape.OUTER_RIGHT) {
                            return false;
                        }
                    } else if (facing == sourceFacing.getCounterClockWise()) {
                        if (sourceShape == StairsShape.OUTER_RIGHT || shape == StairsShape.OUTER_LEFT) {
                            return false;
                        }
                    } else {
                        return true;
                    }
                }
            }
        }
        return block instanceof SimpleBreezeBounceBlock;
    }
}
