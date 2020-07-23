package com.bazcal.keybinds;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds
{
    public static KeyBinding openMenu;
    public static KeyBinding openLocationEdit;
    public static KeyBinding toggleDrawnItems;
 
    public static void register()
    {
        openMenu = new KeyBinding("key.menu",181,"key.categories.bazcal" );

        openLocationEdit = new KeyBinding("key.location",55,"key.categories.bazcal" );
        
        toggleDrawnItems = new KeyBinding("key.drawnItems",74,"key.categories.bazcal" );
        
        ClientRegistry.registerKeyBinding(openMenu);
        ClientRegistry.registerKeyBinding(openLocationEdit);
        ClientRegistry.registerKeyBinding(toggleDrawnItems);
       
    }
}