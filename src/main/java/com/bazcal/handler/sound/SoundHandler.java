package com.bazcal.handler.sound;


import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.entity.EntityPlayerSP;

@SideOnly(Side.CLIENT)
public class SoundHandler {

	@SideOnly(Side.CLIENT)
	public static void bazaarRing(EntityPlayerSP player) // Just plays a sound idk
    {
        player.playSound("random.anvil_land", 0.5F, 1.5F);
    }
	
	@SideOnly(Side.CLIENT)
	public static void errorNoise(EntityPlayerSP player) // Just plays a sound idk
    {
        player.playSound("note.bass", 0.5F, 0.5F);
    }
}

