package de.broadcast.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.broadcast.util.Broadcaster;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	
	public void onEnable() {
		
		new Broadcaster(this).startBroadcast();
		
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
	

}
