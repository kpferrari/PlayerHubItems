package com.Bodsterrr.PlayerHubItems;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		
		getCommand("playerhubitems").setExecutor(new Commands());
		getCommand("phi").setExecutor(new Commands());
		
	}
	
	public void onDisable () {
		
		
		
	}

}
