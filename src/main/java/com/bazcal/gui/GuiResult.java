package com.bazcal.gui;




import org.lwjgl.opengl.GL11;

import com.bazcal.bazcalmodmain.BazcalMainMod;
import com.bazcal.listeners.KeyInputHandler;
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
	public static String[] displayedItem1 = {"null","null"};
	public static String[] displayedItem2 = {"null","null"};
	public static String[] displayedItem3 = {"null","null"};
	public static String[] displayedItem4 = {"null","null"};
	public static String[] displayedItem5 = {"null","null"};
	public static String[] displayedItem6 = {"null","null"};
	private int drawnItemsParsed = (KeyInputHandler.drawnItems) ? 1 : 0;
	public static int size = ApiGet.itemNames.size(); // allows me to check if the api request failed
	public static int endLength; // lets me run the max value once per gui request instead of every frame
	
	
	
	public static int length[] = { displayedItem1[0].length() , displayedItem2[0].length() , displayedItem3[0].length() , displayedItem4[0].length() , displayedItem5[0].length() , displayedItem6[0].length() };
	
	
			

	
	
	public GuiResult(Minecraft mc)
	{

		GL11.glPushMatrix(); // Enables the OPENGL matrix
		drawnItemsParsed = (KeyInputHandler.drawnItems) ? 1 : 0;
		GL11.glScalef(scale, scale, scale);
		if (guiB == true)
		{
		Gui.drawRect(guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 0.1) * scale),   (int) (guiX / 2 + endLength * 5.5) , (int) ((guiY / 2) - 4 - (guiH * 7.2) * scale), 1255255255);
		}

		drawString(mc.fontRendererObj, displayedItem6[drawnItemsParsed], (int)  (guiX) , (int) ((int) (guiY ) ), Integer.parseInt(guiC, 16)); // Block of text to draw (jesus help me)
		drawString(mc.fontRendererObj, displayedItem5[drawnItemsParsed], (int)  (guiX) , (int) ((int) (guiY   ) - (guiH * 1)), Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem4[drawnItemsParsed], (int)  (guiX) , (int) ((int) (guiY  ) - (guiH * 2)), Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem3[drawnItemsParsed], (int) (guiX) , (int) ((int) (guiY ) - (guiH * 3)), Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem2[drawnItemsParsed], (int) (guiX) , (int) ((int) (guiY   ) - (guiH * 4)), Integer.parseInt(guiC, 16));	
		drawString(mc.fontRendererObj, displayedItem1[drawnItemsParsed], (int)  (guiX) , (int) ((int) (guiY  ) - (guiH * 5)), Integer.parseInt(guiC, 16));
		
		GL11.glPopMatrix(); // Disables the matrix
	}
	
	
}