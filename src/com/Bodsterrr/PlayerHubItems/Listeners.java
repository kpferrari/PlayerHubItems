package com.Bodsterrr.PlayerHubItems;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (player.getItemInHand().getItemMeta().getItemFlags() != null && player.getItemInHand().getItemMeta().getItemFlags().contains(ItemFlag.HIDE_UNBREAKABLE)) {
				if (Config.headCfg.getBoolean("Console-Command") == true) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Config.headCfg.getString("Command").replaceAll("%player%", player.getName()));
				}
				else {
					Bukkit.dispatchCommand(player, Config.headCfg.getString("Command").replaceAll("%player%", player.getName()));
				}
				player.playSound(player.getLocation(), Sound.valueOf(Config.headCfg.getString("Sound")), 1, 1);
			}
			
			else if (player.getItemInHand().getItemMeta().getDisplayName().equals(Config.bookCfg.getString("Name").replaceAll("&", "§")
					.replaceAll("%player%", player.getName()))) {
				player.playSound(player.getLocation(), Sound.valueOf(Config.bookCfg.getString("Sound")), 1, 1);
			}
			
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
		if (player.hasPermission("playerhubitems.book.join") || player.isOp()) {
			if (Config.bookCfg.getBoolean("World-Specific") == true && Config.bookCfg.getString("World-Name") == player.getWorld().getName()) {
				Book.giveBook(player);
			}
			else if (Config.headCfg.getBoolean("World-Specific") == false) {
				Book.giveBook(player);
			}
			
		}
		
	}
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		
		if (Config.headCfg.getBoolean("Give-On-Respawn") && event.getPlayer().hasPermission("playerhubitems.head.respawn")) {
			Head.giveHead(event.getPlayer());
		}
		if (Config.bookCfg.getBoolean("Give-On-Respawn") && event.getPlayer().hasPermission("playerhubitems.book.respawn")) {
			Book.giveBook(event.getPlayer());
		}
		
	}
	
	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent event) {
		
		Player player = event.getPlayer();
		if (event.getItemDrop().getItemStack().getItemMeta().getItemFlags() != null) {
			if (Config.headCfg.getBoolean("No-Drop") && event.getItemDrop().getItemStack().getItemMeta().getItemFlags().contains(ItemFlag.HIDE_UNBREAKABLE)) {
				event.setCancelled(true);
			}
			
		}
		
		if (Config.bookCfg.getBoolean("No-Drop") && event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(Config.bookCfg.getString("Name").replaceAll("&", "§")
					.replaceAll("%player%", player.getName()))) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		
		try {
			Player player = (Player) event.getWhoClicked();
			if (event.getClick() != null && event.getClick() != ClickType.UNKNOWN) {
				if (event.getCurrentItem().getItemMeta().getItemFlags() != null && event.getCurrentItem().getItemMeta().getItemFlags().contains(ItemFlag.HIDE_UNBREAKABLE) && Config.headCfg.getBoolean("No-Click")) {
					event.setCancelled(true);
				}
				if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Config.bookCfg.getString("Name").replaceAll("&", "§")
					.replaceAll("%player%", player.getName())) && Config.bookCfg.getBoolean("No-Click")) {
					event.setCancelled(true);
				}
			}
		} catch (Exception e) {
			
		}
		
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
	
		Player player = event.getEntity();
		for (ItemStack i : event.getDrops()) {
			if (i.getItemMeta().getItemFlags() != null && i.getItemMeta().getItemFlags().contains(ItemFlag.HIDE_UNBREAKABLE) && Config.bookCfg.getBoolean("No-Drop-On-Death")) {
				event.getDrops().remove(i);
			}
			if (i.getItemMeta().getDisplayName().equals(Config.bookCfg.getString("Name").replaceAll("&", "§").replaceAll("%player%", player.getName())) && Config.bookCfg.getBoolean("No-Drop-On-Death")) {
				event.getDrops().remove(i);
			}
			
		}
		
	}

}
