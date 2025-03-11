package com.chefmooon.breezebounce.common.tag;

import com.chefmooon.breezebounce.common.util.TextUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class BreezeBounceTags {

    public static final TagKey<Item> BOUNCE_BLOCKS = getBreezeBounceItemTag("bounce_blocks");
    public static final TagKey<Item> BOUNCE_STAIRS = getBreezeBounceItemTag("bounce_stairs");
    public static final TagKey<Item> BOUNCE_SLABS = getBreezeBounceItemTag("bounce_slabs");
    public static final TagKey<Item> BOUNCE_WALLS = getBreezeBounceItemTag("bounce_walls");
    private static TagKey<Item> getBreezeBounceItemTag(String path) {
        return TagKey.create(Registries.ITEM, TextUtil.res(path));
    }
}
