package com.bazcal.handler.gui;

import com.bazcal.gui.GuiDisplay;
import com.bazcal.gui.GuiResult;
import com.bazcal.gui.LocationGui;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import com.bazcal.bazcalmodmain.BazcalMainMod;


public class GuiHandler implements IGuiHandler {

	
	public static final int MAIN_GUI = 0;
	public static final int LOCATION_GUI = 1;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	    return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { // Lets the client open the GUI
	    if (ID == MAIN_GUI)  
	    {
	    	System.out.println("MAIN GUI BEING LOADED");
	        return new GuiDisplay();
	    }
	    if (ID == LOCATION_GUI)  
	    {
	    	System.out.println("LOCATION GUI BEING LOADED");
	        return new LocationGui();
	    }
	    
	    
	    return null;
	}

	
	
}
