package com.chefmooon.breezebounce.data.model;

import com.chefmooon.breezebounce.BreezeBounce;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class ModModelTemplates {

    public static final ModelTemplate TEMPLATE_BOUNCE_WALL = create("template_basic_bounce_wall", TextureSlot.ALL);

    private static ModelTemplate create(String string, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.ofNullable(ResourceLocation.tryBuild(BreezeBounce.MOD_ID, "block/" + string)), Optional.empty(), textureSlots);
    }
}
