package com.Bodsterrr.PlayerHubItems;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Book {
	
	public static void giveBook(Player p) {
		
		String BookName = Config.bookCfg.getString("Name");
		
		ItemStack Book = Config.bookCfg.getItemStack("Book");
		BookMeta BookM = (BookMeta) Book.getItemMeta();
		for (int i=0;i<=BookM.getPageCount();i++) {
			BookM.setPage(i, BookM.getPage(i).replaceAll("&", "§").replaceAll("%player%", p.getName()));
		}
		BookM.setDisplayName(BookName.replaceAll("&", "§"));
	}

}
