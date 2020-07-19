package com.bazcal.bazcalmodmain.commands;

import net.minecraft.client.Minecraft;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.bazcal.handler.sound.SoundHandler;
import com.bazcal.bazcalmodmain.BazcalMainMod;


@SideOnly(Side.CLIENT)
public class OverlaySettings extends CommandBase {
	
	@Override
	public String getCommandName() { // Ignore
		return "overlaysettings";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] params) throws CommandException {
		
		if (params != null && params.length > 5) {
			SoundHandler.bazaarRing(Minecraft.getMinecraft().thePlayer); 
			BazcalMainMod.guiX = parseInt(params[0]); // Sets the gui X and Y respectively
			BazcalMainMod.guiY = parseInt(params[1]);
			BazcalMainMod.guiS = parseDouble(params[2]);
			BazcalMainMod.guiC = params[3];
			BazcalMainMod.guiH = parseInt(params[4]);
			BazcalMainMod.guiB = parseBoolean(params[5]);
			BazcalMainMod.refreshConfig();
		    }
		else
		{
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Usage: /overlaysettings [x] [y] <scale> <colorhex> [height] <displayBackground> "));

			SoundHandler.errorNoise(Minecraft.getMinecraft().thePlayer);
		}
	}

	/*
	  public void activateGui(World world, int x, int y, int z, EntityPlayer player, int side, float offsetX, float offsetY, float offsetZ)
	{
		player.openGui(BazcalMainMod.instance, 0, world, x, y, z);
	}
	 */

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    
    
   




 
}