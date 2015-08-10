package com.Bodsterrr.PlayerHubItems;

import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Book {
	
	public static void giveBook(Player p) {
		
		String BookName = Config.bookCfg.getString("Book.meta.title");
		String BookAuthor = Config.bookCfg.getString("Book.meta.author");
		ItemStack Book = Config.bookCfg.getItemStack("Book");
		BookMeta BookM = (BookMeta) Book.getItemMeta();
		for (int i=0;i<=BookM.getPageCount();i++) {
			BookM.setPage(i, BookM.getPage(i).replaceAll("&", "§").replaceAll("%player%", p.getName()));
		}
		BookM.setDisplayName(BookName.replaceAll("&", "§"));
		BookM.setAuthor(BookAuthor.replaceAll("&", "§"));
	}
	
	public static void saveBook(Player p) {
		
		if (p.getItemInHand() != null && p.getItemInHand().getType() == Material.WRITTEN_BOOK) {
			Config.bookCfg.set("Book", p.getItemInHand());
			try {
				Config.bookCfg.save(Config.bookFile);
			} catch (IOException e) {
				
			}
			
			p.sendMessage("§7# §3The book in your hand has been saved to §dbook.yml");
		}
		else {
			p.sendMessage("§7# §cThat is not a written book");
		}
		
	}

}
