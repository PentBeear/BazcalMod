package com.bazcal.handler.gui;

import java.lang.annotation.ElementType;

import com.bazcal.gui.GuiResult;
import com.bazcal.bazcalmodmain.BazcalMainMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiOverlayHandler {
	@SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event)
    {
		if (BazcalMainMod.renderOverlay == false) return;
		new GuiResult(Minecraft.getMinecraft());
    }
}
