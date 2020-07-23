package com.bazcal.listeners;

import com.bazcal.bazcalmodmain.BazcalMainMod;
import com.bazcal.keybinds.Keybinds;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyInputHandler
{
	public static boolean drawnItems = false;
    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event)
    {
        if (Keybinds.openMenu.isPressed())
        {
        	Minecraft.getMinecraft().thePlayer.openGui(BazcalMainMod.getInstance(), 0,  Minecraft.getMinecraft().theWorld, (int) Minecraft.getMinecraft().thePlayer.posX, (int) Minecraft.getMinecraft().thePlayer.posY, (int) Minecraft.getMinecraft().thePlayer.posZ);
        }
        
        if (Keybinds.openLocationEdit.isPressed())
        {
        	Minecraft.getMinecraft().thePlayer.openGui(BazcalMainMod.getInstance(), 1,  Minecraft.getMinecraft().theWorld, (int) Minecraft.getMinecraft().thePlayer.posX, (int) Minecraft.getMinecraft().thePlayer.posY, (int) Minecraft.getMinecraft().thePlayer.posZ);
        }
        
        if (Keybinds.toggleDrawnItems.isPressed())
        {
        	if (drawnItems == false) // Simple toggle switch
        	{
        		drawnItems = true;
        	}
        	else
        	{
        		drawnItems = false;
        	}
        	
        }
        
        
    }
}