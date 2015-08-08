package com.Bodsterrr.PlayerHubItems;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Head {
	
	public void giveHead(Player p) {
		
		ItemStack PlayerHead = new ItemStack(Material.SKULL_ITEM);
		PlayerHead.setDurability((short) 3);
		
	}

}
