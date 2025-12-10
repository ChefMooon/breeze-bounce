package com.chefmooon.breezebounce.client.gui;

import com.chefmooon.breezebounce.common.block.entity.container.InflationMachineMenu;
import com.chefmooon.breezebounce.common.util.TextUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

import java.awt.*;

public class InflationMachineScreen extends AbstractContainerScreen<InflationMachineMenu> {
    private static final Identifier BACKGROUND_TEXTURE = TextUtil.res("textures/gui/inflation_machine.png");
    private static final Rectangle INFLATION_ICON = new Rectangle(80,21,16,16);
    public InflationMachineScreen(InflationMachineMenu abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        if (this.minecraft == null) return;

        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND_TEXTURE, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);

        if (this.menu.isInflate()) {
            int l = Mth.ceil(this.menu.getInflateProgress() * 15.0F) + 1;
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND_TEXTURE, this.leftPos + INFLATION_ICON.x, this.topPos + INFLATION_ICON.y + (17 - l), 176, 17 - l, INFLATION_ICON.width, l, 256, 256);
        }
    }
}
