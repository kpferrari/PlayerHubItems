package com.Bodsterrr.PlayerHubItems;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Plugin getPlugin() {
		return Bukkit.getServer().getPluginManager().getPlugin("PlayerHubItems");
	}
	
	public void onEnable() {
		
		getCommand("playerhubitems").setExecutor(new Commands());
		getCommand("phi").setExecutor(new Commands());
		
	}
	
	public void onDisable () {
		
		
		
	}

}
