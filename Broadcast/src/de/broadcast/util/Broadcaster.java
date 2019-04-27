package de.broadcast.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import de.broadcast.main.Broadcast;
import net.md_5.bungee.api.ChatColor;

public class Broadcaster {
	
	private final long MESSAGE_DELAY = 120*20;
	private final String ROOT = "BroadcastMessages";
	
	private Broadcast plugin;
	private FileConfiguration config;
	
	public Broadcaster(Broadcast plugin) {
		this.plugin = plugin;
		config = plugin.getConfig();
		
		createDefaults();
	}
	
	public void startBroadcast() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', pickMessage()));
				
			}
		}, 0, MESSAGE_DELAY);
	}
	
	private void createDefaults() {
		if(config.contains(ROOT)) return;
		List<String> defaults = new ArrayList<>();
		for(int i = 0; i < 20; i++)
			defaults.add("&6Testnachricht Nr. " + i);
		config.set(ROOT, defaults);
		plugin.saveConfig();
		
	}
	
	private String pickMessage() {
		List<String> messages = config.getStringList(ROOT);
		int random = new Random().nextInt(messages.size());
		return messages.get(random);
	}
	
}

