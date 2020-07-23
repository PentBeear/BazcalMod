package com.bazcal.bazcalmodmain;


import java.io.File;

import com.bazcal.bazcalmodmain.commands.CancelBazcal;
import com.bazcal.bazcalmodmain.commands.OverlaySettings;
import com.bazcal.bazcalmodmain.commands.StartBazcal;
import com.bazcal.handler.gui.GuiHandler;
import com.bazcal.handler.gui.GuiOverlayHandler;
import com.bazcal.keybinds.Keybinds;
import com.bazcal.listeners.KeyInputHandler;

import net.minecraft.init.Blocks;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;




@Mod(modid = BazcalMainMod.MODID, version = BazcalMainMod.VERSION, acceptedMinecraftVersions = BazcalMainMod.VERSION, clientSideOnly = true)
@SideOnly(Side.CLIENT)
public class BazcalMainMod
{
    public static final String MODID = "bazcalmod";
    public static final String VERSION = "1.1";
    public static int guiX;
    public static int guiY;
    public static int guiH;
    public static boolean guiB;
    public static boolean renderOverlay = false;
    public static double guiS;
    public static String guiC;
   
    
    @Instance(BazcalMainMod.MODID)
    public static BazcalMainMod instance; 
    
    
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        Keybinds.register();
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler()); // Registers the keybinds
        
       

    }
    
    @SideOnly(Side.CLIENT)
    @EventHandler
    public static void init(FMLInitializationEvent event)
    {	
    	ClientCommandHandler.instance.registerCommand(new OverlaySettings()); // Registers the commands and the gui's
    	ClientCommandHandler.instance.registerCommand(new StartBazcal());
    	ClientCommandHandler.instance.registerCommand(new CancelBazcal());
    	NetworkRegistry.INSTANCE.registerGuiHandler(BazcalMainMod.instance, new GuiHandler());
    	MinecraftForge.EVENT_BUS.register(new GuiOverlayHandler());
    	
    	//File configFile = new File(Loader.instance().getConfigDir(), "config/Main.cfg"); // Loads the config
        Configuration config = new Configuration(new File("config/Main.cfg"));

        config.load();
        guiX = config.get("gui", "guiX", 50).getInt();
        guiY = config.get("gui", "guiY", 50).getInt();
        guiH = config.get("gui", "guiH", 24).getInt();
        guiB = config.get("gui", "guiB", true).getBoolean();
        guiS = config.get("gui", "guiS", 0.5).getDouble();
        guiC = config.get("gui", "guiC", "FFAA00").getString();
        if(config.hasChanged())
            config.save();
    }
    
    public static void refreshConfig()
    {
    	
    	Configuration config = new Configuration(new File("config/Main.cfg"));
        config.load();
        config.get("gui", "guiX", new int[] {0}).set(guiX);
        config.get("gui", "guiY", new int[] {0}).set(guiY);
        config.get("gui", "guiH", new int[] {0}).set(guiH);
        config.get("gui", "guiB", new boolean[] {true}).set(guiB);
        config.get("gui", "guiS", new double[] {0}).set(guiS);
        config.get("gui", "guiC", new String[] {"null"}).set(guiC);
        config.save();
    }
    
    @EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(instance); // Registers the instance to be called
    }
    

    public static BazcalMainMod getInstance() {
        return instance;
    }
    

    
    
}
