package de.broadcast.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.broadcast.util.Broadcaster;

public class Broadcast extends JavaPlugin {
	
	private static Broadcast plugin;
	
	public void onEnable() {
		
		new Broadcaster(this).startBroadcast();
		
	}
	
	public static Broadcast getPlugin() {
		return plugin;
	}
	
	

}