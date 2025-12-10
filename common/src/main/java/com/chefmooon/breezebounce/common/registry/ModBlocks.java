package com.chefmooon.breezebounce.common.registry;

import com.chefmooon.breezebounce.common.util.TextUtil;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {
    public static BlockBehaviour.Properties basicBounce() {
        return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.GUITAR).strength(1.6F).ignitedByLava();
    }

    public static BlockBehaviour.Properties basicBounceWhite() {
        return basicBounce().mapColor(MapColor.SNOW);
    }

    public static BlockBehaviour.Properties basicBounceLightGray() {
        return basicBounce().mapColor(MapColor.COLOR_LIGHT_GRAY);
    }

    public static BlockBehaviour.Properties basicBounceGray() {
        return basicBounce().mapColor(MapColor.COLOR_GRAY);
    }

    public static BlockBehaviour.Properties basicBounceBlack() {
        return basicBounce().mapColor(MapColor.COLOR_BLACK);
    }

    public static BlockBehaviour.Properties basicBounceBrown() {
        return basicBounce().mapColor(MapColor.COLOR_BROWN);
    }

    public static BlockBehaviour.Properties basicBounceRed() {
        return basicBounce().mapColor(MapColor.COLOR_RED);
    }

    public static BlockBehaviour.Properties basicBounceOrange() {
        return basicBounce().mapColor(MapColor.COLOR_ORANGE);
    }

    public static BlockBehaviour.Properties basicBounceYellow() {
        return basicBounce().mapColor(MapColor.COLOR_YELLOW);
    }

    public static BlockBehaviour.Properties basicBounceLime() {
        return basicBounce().mapColor(MapColor.COLOR_LIGHT_GREEN);
    }

    public static BlockBehaviour.Properties basicBounceGreen() {
        return basicBounce().mapColor(MapColor.COLOR_GREEN);
    }

    public static BlockBehaviour.Properties basicBounceCyan() {
        return basicBounce().mapColor(MapColor.COLOR_CYAN);
    }

    public static BlockBehaviour.Properties basicBounceLightBlue() {
        return basicBounce().mapColor(MapColor.COLOR_LIGHT_BLUE);
    }

    public static BlockBehaviour.Properties basicBounceBlue() {
        return basicBounce().mapColor(MapColor.COLOR_BLUE);
    }

    public static BlockBehaviour.Properties basicBouncePurple() {
        return basicBounce().mapColor(MapColor.COLOR_PURPLE);
    }

    public static BlockBehaviour.Properties basicBounceMagenta() {
        return basicBounce().mapColor(MapColor.COLOR_MAGENTA);
    }

    public static BlockBehaviour.Properties basicBouncePink() {
        return basicBounce().mapColor(MapColor.COLOR_PINK);
    }

    public static final Identifier INFLATION_MACHINE = block("inflation_machine");

    public static final Identifier BASIC_BOUNCE_WHITE = block("basic_bounce_white");
    public static final Identifier BASIC_BOUNCE_LIGHT_GRAY = block("basic_bounce_light_gray");
    public static final Identifier BASIC_BOUNCE_GRAY = block("basic_bounce_gray");
    public static final Identifier BASIC_BOUNCE_BLACK = block("basic_bounce_black");
    public static final Identifier BASIC_BOUNCE_BROWN = block("basic_bounce_brown");
    public static final Identifier BASIC_BOUNCE_RED = block("basic_bounce_red");
    public static final Identifier BASIC_BOUNCE_ORANGE = block("basic_bounce_orange");
    public static final Identifier BASIC_BOUNCE_YELLOW = block("basic_bounce_yellow");
    public static final Identifier BASIC_BOUNCE_LIME = block("basic_bounce_lime");
    public static final Identifier BASIC_BOUNCE_GREEN = block("basic_bounce_green");
    public static final Identifier BASIC_BOUNCE_CYAN = block("basic_bounce_cyan");
    public static final Identifier BASIC_BOUNCE_LIGHT_BLUE = block("basic_bounce_light_blue");
    public static final Identifier BASIC_BOUNCE_BLUE = block("basic_bounce_blue");
    public static final Identifier BASIC_BOUNCE_PURPLE = block("basic_bounce_purple");
    public static final Identifier BASIC_BOUNCE_MAGENTA = block("basic_bounce_magenta");
    public static final Identifier BASIC_BOUNCE_PINK = block("basic_bounce_pink");

    public static final Identifier BASIC_BOUNCE_SLAB_WHITE = block("basic_bounce_slab_white");
    public static final Identifier BASIC_BOUNCE_SLAB_LIGHT_GRAY = block("basic_bounce_slab_light_gray");
    public static final Identifier BASIC_BOUNCE_SLAB_GRAY = block("basic_bounce_slab_gray");
    public static final Identifier BASIC_BOUNCE_SLAB_BLACK = block("basic_bounce_slab_black");
    public static final Identifier BASIC_BOUNCE_SLAB_BROWN = block("basic_bounce_slab_brown");
    public static final Identifier BASIC_BOUNCE_SLAB_RED = block("basic_bounce_slab_red");
    public static final Identifier BASIC_BOUNCE_SLAB_ORANGE = block("basic_bounce_slab_orange");
    public static final Identifier BASIC_BOUNCE_SLAB_YELLOW = block("basic_bounce_slab_yellow");
    public static final Identifier BASIC_BOUNCE_SLAB_LIME = block("basic_bounce_slab_lime");
    public static final Identifier BASIC_BOUNCE_SLAB_GREEN = block("basic_bounce_slab_green");
    public static final Identifier BASIC_BOUNCE_SLAB_CYAN = block("basic_bounce_slab_cyan");
    public static final Identifier BASIC_BOUNCE_SLAB_LIGHT_BLUE = block("basic_bounce_slab_light_blue");
    public static final Identifier BASIC_BOUNCE_SLAB_BLUE = block("basic_bounce_slab_blue");
    public static final Identifier BASIC_BOUNCE_SLAB_PURPLE = block("basic_bounce_slab_purple");
    public static final Identifier BASIC_BOUNCE_SLAB_MAGENTA = block("basic_bounce_slab_magenta");
    public static final Identifier BASIC_BOUNCE_SLAB_PINK = block("basic_bounce_slab_pink");

    public static final Identifier BASIC_BOUNCE_STAIR_WHITE = block("basic_bounce_stair_white");
    public static final Identifier BASIC_BOUNCE_STAIR_LIGHT_GRAY = block("basic_bounce_stair_light_gray");
    public static final Identifier BASIC_BOUNCE_STAIR_GRAY = block("basic_bounce_stair_gray");
    public static final Identifier BASIC_BOUNCE_STAIR_BLACK = block("basic_bounce_stair_black");
    public static final Identifier BASIC_BOUNCE_STAIR_BROWN = block("basic_bounce_stair_brown");
    public static final Identifier BASIC_BOUNCE_STAIR_RED = block("basic_bounce_stair_red");
    public static final Identifier BASIC_BOUNCE_STAIR_ORANGE = block("basic_bounce_stair_orange");
    public static final Identifier BASIC_BOUNCE_STAIR_YELLOW = block("basic_bounce_stair_yellow");
    public static final Identifier BASIC_BOUNCE_STAIR_LIME = block("basic_bounce_stair_lime");
    public static final Identifier BASIC_BOUNCE_STAIR_GREEN = block("basic_bounce_stair_green");
    public static final Identifier BASIC_BOUNCE_STAIR_CYAN = block("basic_bounce_stair_cyan");
    public static final Identifier BASIC_BOUNCE_STAIR_LIGHT_BLUE = block("basic_bounce_stair_light_blue");
    public static final Identifier BASIC_BOUNCE_STAIR_BLUE = block("basic_bounce_stair_blue");
    public static final Identifier BASIC_BOUNCE_STAIR_PURPLE = block("basic_bounce_stair_purple");
    public static final Identifier BASIC_BOUNCE_STAIR_MAGENTA = block("basic_bounce_stair_magenta");
    public static final Identifier BASIC_BOUNCE_STAIR_PINK = block("basic_bounce_stair_pink");

    public static final Identifier BASIC_BOUNCE_WALL_WHITE = block("basic_bounce_wall_white");
    public static final Identifier BASIC_BOUNCE_WALL_LIGHT_GRAY = block("basic_bounce_wall_light_gray");
    public static final Identifier BASIC_BOUNCE_WALL_GRAY = block("basic_bounce_wall_gray");
    public static final Identifier BASIC_BOUNCE_WALL_BLACK = block("basic_bounce_wall_black");
    public static final Identifier BASIC_BOUNCE_WALL_BROWN = block("basic_bounce_wall_brown");
    public static final Identifier BASIC_BOUNCE_WALL_RED = block("basic_bounce_wall_red");
    public static final Identifier BASIC_BOUNCE_WALL_ORANGE = block("basic_bounce_wall_orange");
    public static final Identifier BASIC_BOUNCE_WALL_YELLOW = block("basic_bounce_wall_yellow");
    public static final Identifier BASIC_BOUNCE_WALL_LIME = block("basic_bounce_wall_lime");
    public static final Identifier BASIC_BOUNCE_WALL_GREEN = block("basic_bounce_wall_green");
    public static final Identifier BASIC_BOUNCE_WALL_CYAN = block("basic_bounce_wall_cyan");
    public static final Identifier BASIC_BOUNCE_WALL_LIGHT_BLUE = block("basic_bounce_wall_light_blue");
    public static final Identifier BASIC_BOUNCE_WALL_BLUE = block("basic_bounce_wall_blue");
    public static final Identifier BASIC_BOUNCE_WALL_PURPLE = block("basic_bounce_wall_purple");
    public static final Identifier BASIC_BOUNCE_WALL_MAGENTA = block("basic_bounce_wall_magenta");
    public static final Identifier BASIC_BOUNCE_WALL_PINK = block("basic_bounce_wall_pink");

    private static Identifier block(String location) {
        return TextUtil.res(location);
    }
}
