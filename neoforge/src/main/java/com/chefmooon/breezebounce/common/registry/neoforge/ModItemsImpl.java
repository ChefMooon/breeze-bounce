package com.chefmooon.breezebounce.common.registry.neoforge;

import com.chefmooon.breezebounce.BreezeBounce;
import com.chefmooon.breezebounce.common.item.VelcroArmorItem;
import com.chefmooon.breezebounce.common.registry.ModArmorMaterials;
import com.chefmooon.breezebounce.common.registry.ModItems;
import com.google.common.collect.Sets;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

import static com.chefmooon.breezebounce.common.registry.ModItems.basicItemProperties;

public class ModItemsImpl {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, BreezeBounce.MOD_ID);
    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

    public static final Supplier<Item> VELCRO_HELMET = registerItem(ModItems.VELCRO_HELMET, () -> new VelcroArmorItem(ModArmorMaterials.VELCRO, ArmorItem.Type.HELMET, (basicItemProperties().durability(ArmorItem.Type.HELMET.getDurability(5)))));
    public static final Supplier<Item> VELCRO_CHESTPLATE = registerItem(ModItems.VELCRO_CHESTPLATE, () -> new VelcroArmorItem(ModArmorMaterials.VELCRO, ArmorItem.Type.CHESTPLATE, (basicItemProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(5)))));
    public static final Supplier<Item> VELCRO_LEGGINGS = registerItem(ModItems.VELCRO_LEGGINGS, () -> new VelcroArmorItem(ModArmorMaterials.VELCRO, ArmorItem.Type.LEGGINGS, (basicItemProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(5)))));
    public static final Supplier<Item> VELCRO_BOOTS = registerItem(ModItems.VELCRO_BOOTS, () -> new VelcroArmorItem(ModArmorMaterials.VELCRO, ArmorItem.Type.BOOTS, (basicItemProperties().durability(ArmorItem.Type.BOOTS.getDurability(5)))));

    public static final Supplier<Item> INFLATION_MACHINE = registerItem(ModItems.INFLATION_MACHINE, () -> new BlockItem(ModBlocksImpl.INFLATION_MACHINE.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE = registerItem(ModItems.BASIC_BOUNCE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WHITE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_WHITE = registerItem(ModItems.BASIC_BOUNCE_STAIR_WHITE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_WHITE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_WHITE = registerItem(ModItems.BASIC_BOUNCE_SLAB_WHITE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_WHITE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL = registerItem(ModItems.BASIC_BOUNCE_WALL, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_WHITE.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_LIGHT_GRAY, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_LIGHT_GRAY.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_STAIR_LIGHT_GRAY, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_LIGHT_GRAY.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_SLAB_LIGHT_GRAY, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_LIGHT_GRAY.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_LIGHT_GRAY = registerItem(ModItems.BASIC_BOUNCE_WALL_LIGHT_GRAY, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_LIGHT_GRAY.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_GRAY = registerItem(ModItems.BASIC_BOUNCE_GRAY, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_GRAY.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_GRAY = registerItem(ModItems.BASIC_BOUNCE_STAIR_GRAY, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_GRAY.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_GRAY = registerItem(ModItems.BASIC_BOUNCE_SLAB_GRAY, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_GRAY.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_GRAY = registerItem(ModItems.BASIC_BOUNCE_WALL_GRAY, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_GRAY.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_BLACK = registerItem(ModItems.BASIC_BOUNCE_BLACK, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_BLACK.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_BLACK = registerItem(ModItems.BASIC_BOUNCE_STAIR_BLACK, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_BLACK.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_BLACK = registerItem(ModItems.BASIC_BOUNCE_SLAB_BLACK, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_BLACK.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_BLACK = registerItem(ModItems.BASIC_BOUNCE_WALL_BLACK, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_BLACK.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_BROWN = registerItem(ModItems.BASIC_BOUNCE_BROWN, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_BROWN.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_BROWN = registerItem(ModItems.BASIC_BOUNCE_STAIR_BROWN, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_BROWN.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_BROWN = registerItem(ModItems.BASIC_BOUNCE_SLAB_BROWN, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_BROWN.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_BROWN = registerItem(ModItems.BASIC_BOUNCE_WALL_BROWN, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_BROWN.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_RED = registerItem(ModItems.BASIC_BOUNCE_RED, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_RED.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_RED = registerItem(ModItems.BASIC_BOUNCE_STAIR_RED, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_RED.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_RED = registerItem(ModItems.BASIC_BOUNCE_SLAB_RED, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_RED.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_RED = registerItem(ModItems.BASIC_BOUNCE_WALL_RED, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_RED.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_ORANGE = registerItem(ModItems.BASIC_BOUNCE_ORANGE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_ORANGE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_ORANGE = registerItem(ModItems.BASIC_BOUNCE_STAIR_ORANGE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_ORANGE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_ORANGE = registerItem(ModItems.BASIC_BOUNCE_SLAB_ORANGE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_ORANGE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_ORANGE = registerItem(ModItems.BASIC_BOUNCE_WALL_ORANGE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_ORANGE.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_YELLOW = registerItem(ModItems.BASIC_BOUNCE_YELLOW, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_YELLOW.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_YELLOW = registerItem(ModItems.BASIC_BOUNCE_STAIR_YELLOW, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_YELLOW.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_YELLOW = registerItem(ModItems.BASIC_BOUNCE_SLAB_YELLOW, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_YELLOW.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_YELLOW = registerItem(ModItems.BASIC_BOUNCE_WALL_YELLOW, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_YELLOW.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_LIME = registerItem(ModItems.BASIC_BOUNCE_LIME, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_LIME.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_LIME = registerItem(ModItems.BASIC_BOUNCE_STAIR_LIME, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_LIME.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_LIME = registerItem(ModItems.BASIC_BOUNCE_SLAB_LIME, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_LIME.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_LIME = registerItem(ModItems.BASIC_BOUNCE_WALL_LIME, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_LIME.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_GREEN = registerItem(ModItems.BASIC_BOUNCE_GREEN, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_GREEN.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_GREEN = registerItem(ModItems.BASIC_BOUNCE_STAIR_GREEN, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_GREEN.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_GREEN = registerItem(ModItems.BASIC_BOUNCE_SLAB_GREEN, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_GREEN.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_GREEN = registerItem(ModItems.BASIC_BOUNCE_WALL_GREEN, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_GREEN.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_CYAN = registerItem(ModItems.BASIC_BOUNCE_CYAN, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_CYAN.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_CYAN = registerItem(ModItems.BASIC_BOUNCE_STAIR_CYAN, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_CYAN.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_CYAN = registerItem(ModItems.BASIC_BOUNCE_SLAB_CYAN, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_CYAN.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_CYAN = registerItem(ModItems.BASIC_BOUNCE_WALL_CYAN, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_CYAN.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_LIGHT_BLUE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_LIGHT_BLUE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_STAIR_LIGHT_BLUE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_LIGHT_BLUE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_SLAB_LIGHT_BLUE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_LIGHT_BLUE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_LIGHT_BLUE = registerItem(ModItems.BASIC_BOUNCE_WALL_LIGHT_BLUE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_LIGHT_BLUE.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_BLUE = registerItem(ModItems.BASIC_BOUNCE_BLUE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_BLUE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_BLUE = registerItem(ModItems.BASIC_BOUNCE_STAIR_BLUE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_BLUE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_BLUE = registerItem(ModItems.BASIC_BOUNCE_SLAB_BLUE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_BLUE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_BLUE = registerItem(ModItems.BASIC_BOUNCE_WALL_BLUE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_BLUE.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_PURPLE = registerItem(ModItems.BASIC_BOUNCE_PURPLE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_PURPLE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_PURPLE = registerItem(ModItems.BASIC_BOUNCE_STAIR_PURPLE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_PURPLE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_PURPLE = registerItem(ModItems.BASIC_BOUNCE_SLAB_PURPLE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_PURPLE.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_PURPLE = registerItem(ModItems.BASIC_BOUNCE_WALL_PURPLE, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_PURPLE.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_MAGENTA, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_MAGENTA.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_STAIR_MAGENTA, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_MAGENTA.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_SLAB_MAGENTA, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_MAGENTA.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_MAGENTA = registerItem(ModItems.BASIC_BOUNCE_WALL_MAGENTA, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_MAGENTA.get(), basicItemProperties()));

    public static final Supplier<Item> BASIC_BOUNCE_PINK = registerItem(ModItems.BASIC_BOUNCE_PINK, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_PINK.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_STAIR_PINK = registerItem(ModItems.BASIC_BOUNCE_STAIR_PINK, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_STAIR_PINK.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_SLAB_PINK = registerItem(ModItems.BASIC_BOUNCE_SLAB_PINK, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_SLAB_PINK.get(), basicItemProperties()));
    public static final Supplier<Item> BASIC_BOUNCE_WALL_PINK = registerItem(ModItems.BASIC_BOUNCE_WALL_PINK, () -> new BlockItem(ModBlocksImpl.BASIC_BOUNCE_WALL_PINK.get(), basicItemProperties()));

    public static Supplier<Item> registerItem(final ResourceLocation location, final Supplier<Item> supplier) {
        Supplier<Item> item = ITEMS.register(location.getPath(), supplier);
        CREATIVE_TAB_ITEMS.add(item);
        return item;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
