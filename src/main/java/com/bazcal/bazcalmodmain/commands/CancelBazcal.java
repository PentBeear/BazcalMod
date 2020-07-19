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
import com.bazcal.network.ApiGet;

import java.io.IOException;

import com.bazcal.bazcalmodmain.BazcalMainMod;


@SideOnly(Side.CLIENT)
public class CancelBazcal extends CommandBase {
	
	@Override
	public String getCommandName() { // Ignore
		return "cancelbazcal";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] params) throws CommandException {
		
		SoundHandler.errorNoise(Minecraft.getMinecraft().thePlayer);
    	BazcalMainMod.renderOverlay = false;
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