package com.Bodsterrr.PlayerHubItems;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Head {
	
	public static void giveHead(Player p) {
		
		//Retrieve values
		String ItemName = Config.headCfg.getString("Name").replaceAll("%player%", p.getName()).replaceAll("&", "§");
		ArrayList<String> Lore = new ArrayList<String>();
		for (String s : Config.headCfg.getStringList("Lore")) {
			Lore.add(s.replaceAll("&", "§").replaceAll("%player%", p.getName()));
		}
		Integer Amount = Config.headCfg.getInt("Amount");
		Integer Slot = Config.headCfg.getInt("Slot")-1;
		
		//Create ItemStack
		ItemStack PlayerHead = new ItemStack(Material.SKULL_ITEM);
		PlayerHead.setDurability((short) 3);
		PlayerHead.setAmount(Amount);
		SkullMeta PlayerHeadMeta = (SkullMeta) PlayerHead.getItemMeta();
		
		PlayerHeadMeta.setDisplayName(ItemName);
		PlayerHeadMeta.setLore(Lore);
		PlayerHeadMeta.setOwner(p.getName());
		
		/*for (String s : Config.headCfg.getStringList("Enchantments")) {
			String[] EnchantmentSplit = s.split(":");
			Integer EnchantmentID = Integer.valueOf(EnchantmentSplit[0]);
			Integer EnchantmentLevel = Integer.valueOf(EnchantmentSplit[1]);
			Enchantment AddEnchantment = Enchantment.getById(EnchantmentID);
			PlayerHead.addUnsafeEnchantment(AddEnchantment, EnchantmentLevel);
		}*/
		
		PlayerHeadMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		PlayerHead.setItemMeta(PlayerHeadMeta);
		p.getInventory().setItem(Slot, PlayerHead);
		
	}

}
