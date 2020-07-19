package com.bazcal.keybinds;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds
{
    public static KeyBinding openMenu;
 
    public static void register()
    {
        openMenu = new KeyBinding("key.menu",181,"key.categories.bazcal" );
 
        ClientRegistry.registerKeyBinding(openMenu);
    }
}