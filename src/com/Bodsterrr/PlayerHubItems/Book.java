package com.Bodsterrr.PlayerHubItems;

import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Book {
	
	public static void giveBook(Player p) {
		
		String BookName = Config.bookCfg.getString("Name").replaceAll("&", "§");
		String BookAuthor = Config.bookCfg.getString("Author").replaceAll("&", "§");
		ItemStack Book = Config.bookCfg.getItemStack("Book");
		BookMeta BookM = (BookMeta) Book.getItemMeta();
		for (int i = 1; i <= BookM.getPageCount(); i++) {
			String page = BookM.getPage(i);
		    page = page.replaceAll("&([a-z0-9])", "§$1").replaceAll("%player%", p.getName());
		    BookM.setPage(i, page);			
		}
		ArrayList<String> Lore = new ArrayList<String>();
		for (String s : Config.bookCfg.getStringList("Lore")) {
			Lore.add(s.replaceAll("&", "§").replaceAll("%player%", p.getName()));
		}
		BookM.setLore(Lore);
		Book.setAmount(Config.bookCfg.getInt("Amount"));
		BookM.setDisplayName(BookName);
		BookM.setAuthor(BookAuthor);
		BookM.setTitle(BookName);
		Book.setItemMeta(BookM);
		
		p.getInventory().setItem(Config.bookCfg.getInt("Slot")-1, Book);
		
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
