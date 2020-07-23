package com.bazcal.gui;

import net.minecraft.client.Minecraft;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiPageButtonList.GuiResponder;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.GuiSlider.FormatHelper;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ChatComponentText;

import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;


import org.lwjgl.opengl.GL11;

import com.bazcal.bazcalmodmain.BazcalMainMod;
import com.bazcal.handler.sound.SoundHandler;
import com.bazcal.network.ApiGet;

import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;


@SideOnly(Side.CLIENT)
public class LocationGui extends GuiScreen {
	
	
	public static float guiS = (float) BazcalMainMod.guiS;
	public static int guiX = BazcalMainMod.guiX;
	public static int guiY = BazcalMainMod.guiY;
	public static int guiH = BazcalMainMod.guiH;
    public static float xSize;
    public static float ySize;
    public static float guiLeft;
    public static float guiTop;
    public static float guiRight;
    public static float guiBottom;
	public static boolean guiB = (boolean) BazcalMainMod.guiB;
	public static String guiC = BazcalMainMod.guiC;
	public static String displayedItem1 = "ExampleTop";
	public static String displayedItem2 = "Example";
	public static String displayedItem3 = "Example";
	public static String displayedItem4 = "Example";
	public static String displayedItem5 = "Example";
	public static String displayedItem6 = "ExampleBottom";
	private TextureButton drag;
	private GuiSlider scaleSlider;
	private GuiSlider heightSlider;

	//public static int size = ApiGet.itemNames.size(); // allows me to check if the api request failed
	//public static int endLength; // lets me run the max value once per gui request instead of every frame
	
	

	//public static int length[] = { displayedItem1.length() , displayedItem2.length() , displayedItem3.length() , displayedItem4.length() , displayedItem5.length() , displayedItem6.length() };
	
	
	
	
	
			
	 @Override
	    public void initGui() {
		 
		 ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
		 int y = scaledResolution.getScaledHeight()/2;
		 int x = scaledResolution.getScaledWidth()/2;
		 xSize=width-10;
		 ySize=height-10;
		 guiLeft=(width-xSize)/2;
		 guiTop=(height-ySize)/2;
		 guiRight=(width-xSize)*2;
		 guiBottom=(height-ySize)*2;

		// System.out.println(guiX);
		 scaleSlider = new ScaleSlider(new GuiResponder()
				 {
			 		@Override
			 		public void onTick(int id, float value)
			 		{
			 			guiS = value;
			 			BazcalMainMod.guiS = value;
			 		}
			 		
			 		@Override
			 		public void func_175321_a(int p_175321_1_, boolean p_175321_2_)
			 		{
			 			
			 		}
			 			 		
			 		
			 		
			 		@Override
			 		public void func_175319_a(int p_175319_1_, String p_175319_2_)
			 		{
			 			
			 		}
				 }, 1, this.width / 2 , this.height / 2 + 50, "Scale" , 0.1F , 3F , guiS , new FormatHelper()
				 {
					 @Override
					 public String getText(int id, String Name, float value)
					 {
						 return Name + ": " + value;
					 }
				 });
		 
		 heightSlider = new ScaleSlider(new GuiResponder()
		 {
	 		@Override
	 		public void onTick(int id, float value)
	 		{
	 			guiH = (int) value;
	 			BazcalMainMod.guiH = (int) value;
	 		}
	 		
	 		@Override
	 		public void func_175321_a(int p_175321_1_, boolean p_175321_2_)
	 		{
	 			
	 		}
	 			 		
	 		
	 		
	 		@Override
	 		public void func_175319_a(int p_175319_1_, String p_175319_2_)
	 		{
	 			
	 		}
		 }, 1, this.width / 2 , this.height / 2 + 80, "Height" , 1F , 80F , guiH , new FormatHelper()
		 {
			 @Override
			 public String getText(int id, String Name, float value)
			 {
				 return Name + ": " + value;
			 }
		 });
 
		 
			
		 this.buttonList.add(this.drag = new TextureButton(0,  (int) ((guiX) * (1 * guiS)) ,  (int) ((guiY ) * (1 * guiS)  - (guiH * 4.5 * guiS)), (int) (150 * guiS ) , (int) (guiS * (guiH * 5)), null));
		 this.buttonList.add(this.scaleSlider); //GuiSlider(scaleUpdate(), 1, this.width / 2 - 100, this.height / 2 + 50, "Scale Slider", 0.1F, 3F, 0.5F, null));
		 this.buttonList.add(this.heightSlider);
				 /*
				  * GuiSlider(GuiResponder guiResponder, int idIn, int x, int y, String name, float min, float max, float defaultValue, FormatHelper formatter)
				  */
		 }
		// this.buttonList.add(this.drag = new TextureButton(0, (int) (guiX ) , (int) (guiY - (guiH * 3) * guiS) , (int) (50 * guiS), (int) 48 * guiH / guiH , null));
		 //this.buttonList.add(this.drag = new TextureButton(0, (int) (guiX / 2 * scale) , (int) ((guiY / 4) - (guiH * 3.1) * scale), (int) ((int) (this.width * scale) / 8.7), (int) ((int) (this.height * scale)  / (guiH * 0.15)), null));
		// this.buttonList.add(this.test = new GuiButton(0, this.width / 2 - 100, this.height / 2 + 50, this.width, this.height, null));
	 
	
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		//this.drawDefaultBackground(); // Draws the gray
		GL11.glPushMatrix(); // Enables the OPENGL matrix
		GL11.glScalef((float) guiS, (float) guiS, (float) guiS);

		// Gui.drawRect(guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 0.1) * scale),   (int) (guiX / 2 + endLength * 5.5) , (int) ((guiY / 2) - 4 - (guiH * 7.2) * scale), 1255255255);
		/*
		drawString(mc.fontRendererObj, displayedItem1, guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 1) * scale), Integer.parseInt(guiC, 16)); // Block of text to draw (jesus help me)
		drawString(mc.fontRendererObj, displayedItem2, guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 2) * scale) , Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem3, guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 3) * scale), Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem4, guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 4) * scale), Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem5, guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 5) * scale), Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem6, guiX / 2, (int) ((guiY / 2) - 4 - (guiH * 6) * scale), Integer.parseInt(guiC, 16));
		*/

		drawString(mc.fontRendererObj, displayedItem6, (int) ((int) (guiX) ), (int) ((int) (guiY ) ), Integer.parseInt(guiC, 16)); // Block of text to draw (jesus help me)
		drawString(mc.fontRendererObj, displayedItem5, (int) ((int) (guiX) ), (int) ((int) (guiY   ) - (guiH * 1)), Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem4, (int) ((int) (guiX) ), (int) ((int) (guiY  ) - (guiH * 2)), Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem3, (int) ((int) (guiX) ), (int) ((int) (guiY ) - (guiH * 3)), Integer.parseInt(guiC, 16));
		drawString(mc.fontRendererObj, displayedItem2, (int) ((int) (guiX) ), (int) ((int) (guiY   ) - (guiH * 4)), Integer.parseInt(guiC, 16));	
		drawString(mc.fontRendererObj, displayedItem1, (int) ((int) (guiX) ), (int) ((int) (guiY  ) - (guiH * 5)), Integer.parseInt(guiC, 16));
		
		GL11.glPopMatrix(); // Disables the matrix
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	
	@Override
    public void updateScreen() {	// Updates the Screen
        super.updateScreen();
    }
	
	@Override
	public boolean doesGuiPauseGame() {
	    return false;
	}
	
	static int percent(double guiS, double d)  // Shifts the coordinate plane by the value of guiS compared to 0.5 == 1
	{ 
	    float result = 0; 
	    result = (float) (((d - guiS) * 10) / guiS); 
	  
	    return (int)result; 
	} 
	  
	
	
	@Override
	protected void keyTyped(char par1, int par2) // Lets you type into the box
    {
		if (par2 == 1) // Lets you use the escape key
		{
			BazcalMainMod.refreshConfig();
			System.out.println("Closing GUI!"); 
	        this.mc.displayGuiScreen(null);
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
		}
	
    }
	
	
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException { // Handler for the buttons
		if (button == this.drag) {
	    	TextureButton.enableDrag = true;
	    }
		if (button == this.scaleSlider) {
	    	
	    
	    	
	    }

     }
	
	
	
	
}

