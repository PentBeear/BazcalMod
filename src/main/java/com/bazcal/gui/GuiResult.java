package com.bazcal.gui;




import org.lwjgl.opengl.GL11;

import com.bazcal.bazcalmodmain.BazcalMainMod;
import com.bazcal.network.ApiGet;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;


@SideOnly(Side.CLIENT)
public class GuiResult extends Gui {
	
	float scale = (float) BazcalMainMod.guiS;
	public int guiX = BazcalMainMod.guiX;
	public int guiY = BazcalMainMod.guiY;
	public int guiH = BazcalMainMod.guiH;
	public boolean guiB = (boolean) BazcalMainMod.guiB;
	public String guiC = BazcalMainMod.guiC;
	public static String displayedItem1 = "null";
	public static String displayedItem2 = "null";
	public static String displayedItem3 = "null";
	public static String displayedItem4 = "null";
	public static String displayedItem5 = "null";
	public static String displayedItem6 = "null";
	public static int size = ApiGet.itemNames.size(); // allows me to check if the api request failed
	public static int endLength; // lets me run the max value once per gui request instead of every frame
	
	

	public static int length[] = { displayedItem1.length() , displayedItem2.length() , displayedItem3.length() , displayedItem4.length() , displayedItem5.length() , displayedItem6.length() };
	
	
			

	
	
	public GuiResult(Minecraft mc)
	{
		GL11.glPushMatrix(); // Enables the OPENGL matrix
		GL11.glScalef(scale, scale, scale);
		if (guiB == true)
		{
		Gui.drawRect(guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 0.1) * scale),   (int) (guiX / 2 + endLength * 5.5) , (int) ((guiY / 2) - 4 - (guiH * 7.2) * scale), 1255255255);
		}
		drawString(mc.fontRendererObj, displayedItem1, guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 1) * scale), Integer.parseInt(guiC, 16)); // Block of text to draw (jesus help me)
		drawString(mc.fontRendererObj, displayedItem2, guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 2) * scale) , Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem3, guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 3) * scale), Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem4, guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 4) * scale), Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem5, guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 5) * scale), Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem6, guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 6) * scale), Integer.parseInt(guiC, 16));
		
		GL11.glPopMatrix(); // Disables the matrix
	}
	
	
}