package com.bazcal.gui;



import java.io.IOException;

import org.lwjgl.opengl.GL11;
import com.bazcal.bazcalmodmain.BazcalMainMod;
import com.bazcal.network.ApiGet;
import com.bazcal.handler.sound.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;


@SideOnly(Side.CLIENT)
public class GuiDisplay extends GuiScreen {
	int guiWidth = 128;
    int guiHeight = 128;

   
    
	private static ResourceLocation LOGO_TEXTURE = new ResourceLocation("bazcalmod:textures/logo.png"); // Allows me to bind the textures
	private static ResourceLocation LOGO_TEXT = new ResourceLocation("bazcalmod:textures/bazcaltext.png");
	TextureManager textureManager = Minecraft.getMinecraft().getTextureManager(); // Its the texture manager
	private GuiButton submit;
	private GuiButton close;
	private GuiButton cancel;
	private GuiTextField input;
	@SuppressWarnings("unused")
	private GuiLabel bazcal_label;
	

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground(); // Draws the gray
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		GL11.glPushMatrix(); // Enables the OPENGL matrix
		GL11.glScalef(0.4F, 0.4F, 0.4F);
		textureManager.bindTexture(LOGO_TEXTURE);
		Gui.drawModalRectWithCustomSizedTexture(this.width + 105 / 2  , this.height - 390 / 2, 0, 0, guiWidth, guiHeight, 128, 128); // Draws the logo
		textureManager.bindTexture(LOGO_TEXT);
		Gui.drawModalRectWithCustomSizedTexture(this.width + 100 / 2  , this.height - 300 / 2, 0, 0, guiWidth, guiHeight, 128, 128); // Draws the label
		GL11.glPopMatrix(); // Disables the matrix
		this.input.drawTextBox(); // Do you really need this
        super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
	    return false;
	}

	
	@Override
	public void initGui() {
		System.out.println("Loading GUI!");
	    this.buttonList.add(this.submit = new GuiButton(0, this.width / 2 - 100, this.height / 2 + 50, "Start Flip")); // Adds the inputs/buttons
	    this.buttonList.add(this.cancel = new GuiButton(1, this.width / 2 - 100, this.height / 2 + 75, "Cancel Flip")); 
	    this.buttonList.add(this.close = new GuiButton(1, this.width / 2 + this.width / 10 , this.height / 2 + this.height / 3 + this.height / 11, "Close")); 
	    this.input = new GuiTextField(guiHeight, this.fontRendererObj, this.width / 2 - 68, this.height/2, 137, 20);
	    input.setMaxStringLength(40);
	    input.setText("Input Balance Here");
        this.input.setFocused(true);
	    this.allowUserInput = true;
	    
	}
	
	
	@Override
	protected void keyTyped(char par1, int par2) // Lets you type into the box
    {
		if (par2 == 1) // Lets you use the escape key
		{
			System.out.println("Closing GUI!"); 
	        this.mc.displayGuiScreen(null);
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
		}
		boolean selected = this.input.isFocused(); 
		if (selected == true )
		{
			String str = String.valueOf(par1); 
			if (Character.isDigit(str.charAt(0)) || par2 == 14)
			{
				this.input.textboxKeyTyped(par1, par2);   
			}
			System.out.println(par1);  
		}
    }
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException { // Handler for the buttons
		
	    if (button == this.submit) {
	    	if (input.getText().isEmpty() == true || input.getText() == "Input Balance Here") {
	    		SoundHandler.errorNoise(Minecraft.getMinecraft().thePlayer);
	    		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Input balance too low or not number!"));
	    		return;
	    	}
	    	SoundHandler.bazaarRing(Minecraft.getMinecraft().thePlayer);
	    	System.out.println("Closing GUI!");
	    	ApiGet.input = input.getText();
	    	ApiGet.MyGETRequest();
	    	this.mc.displayGuiScreen(null);
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
	    }
	    
	    if (button == this.close){

	    	System.out.println("Closing GUI!");
	        this.mc.displayGuiScreen(null);
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
	    }
	    
	    if (button == this.cancel){
	    	SoundHandler.errorNoise(Minecraft.getMinecraft().thePlayer);
	    	BazcalMainMod.renderOverlay = false;
	    	System.out.println("Closing GUI!");
	        this.mc.displayGuiScreen(null);
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
	    }
	    
	    
	
     }
	
	 @Override
	    public void updateScreen() {	// Updates the Screen
	        super.updateScreen();
	        this.input.updateCursorCounter();
	    }
	
	
}