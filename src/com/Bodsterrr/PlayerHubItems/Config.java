package com.Bodsterrr.PlayerHubItems;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	private static final Config head = new Config("head");
	private static final Config book = new Config("book");
	
	private File file;
	private static FileConfiguration filecfg;
	
	private Config(String fileName) {
		
		if (!Main.getPlugin().getDataFolder().exists()) {
			Main.getPlugin().getDataFolder().mkdir();
		}
		
		file = new File(Main.getPlugin().getDataFolder(), fileName + ".yml");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		filecfg = YamlConfiguration.loadConfiguration(file);
	}
	
	public static Config getHeadCfg() {
		return head;
	}
	
	public static Config getBookCfg() {
		return book;
	}
	
	public String getString(String path) {
		return filecfg.getString(path);
	}
	
	public List<String> getList(String path) {
		return filecfg.getStringList(path);
	}
	
	public Set<String> getKeys() {
		return filecfg.getKeys(false);
	}
	
	public ConfigurationSection getSection(String path) {
		return filecfg.getConfigurationSection(path);
	}
	
	public void save() {
		
		try {
			filecfg.save(file);
		} catch (IOException e) {
			
		}
		
	}
	
	public void load() {
		
		filecfg = YamlConfiguration.loadConfiguration(file);
		
	}

}
