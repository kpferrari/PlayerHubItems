package com.Bodsterrr.PlayerHubItems;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class Config {
	
	public static File headFile;
	public static File bookFile;
	public static FileConfiguration headCfg;
	public static FileConfiguration bookCfg;
	
	public static void initCfg() {
		
		headFile = new File(Main.getPlugin().getDataFolder(), "head.yml");
		bookFile = new File(Main.getPlugin().getDataFolder(), "book.yml");
		
		if (!headFile.exists()) {
			Main.getPlugin().saveResource("head.yml", true);
		}
		if (!bookFile.exists()) {
			Main.getPlugin().saveResource("book.yml", true);
		}
		
		headCfg = YamlConfiguration.loadConfiguration(headFile);
		bookCfg = YamlConfiguration.loadConfiguration(bookFile);
		
	}

}
