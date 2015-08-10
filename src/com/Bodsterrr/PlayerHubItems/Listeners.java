package com.Bodsterrr.PlayerHubItems;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		if (player.getItemInHand().getItemMeta().getDisplayName().contains(player.getName())) {
			if (Config.headCfg.getBoolean("Console-Command") == true) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Config.headCfg.getString("Command").replaceAll("%player%", player.getName()));
			}
			else {
				Bukkit.dispatchCommand(player, Config.headCfg.getString("Command").replaceAll("%player%", player.getName()));
			}
			player.playSound(player.getLocation(), Sound.valueOf(Config.headCfg.getString("Sound")), 1, 1);
		}
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		if (player.hasPermission("playerhubitems.head.join") || player.isOp()) {
			if (Config.headCfg.getBoolean("World-Specific") == true && Config.headCfg.getString("World-Name") == player.getWorld().getName()) {
				Head.giveHead(player);
			}
			else if (Config.headCfg.getBoolean("World-Specific") == false) {
				Head.giveHead(player);
			}
			
		}
		
	}

}
