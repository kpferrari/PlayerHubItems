package com.Bodsterrr.PlayerHubItems;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Book {
	
	public static void giveBook(Player p) {
		
		ItemStack Book = Config.getBookCfg().getItemStack("Book");
		BookMeta BookM = (BookMeta) Book.getItemMeta();
		
	}

}
