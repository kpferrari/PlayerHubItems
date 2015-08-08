package com.Bodsterrr.PlayerHubItems;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		//
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Head.giveHead(event.getPlayer());
		
	}

}
