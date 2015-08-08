package com.Bodsterrr.PlayerHubItems;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Head {
	
	public static void giveHead(Player p) {
		
		//Retrieve values
		String ItemName = Config.getHeadCfg().getString("Name").replaceAll("%player%", p.getName()).replaceAll("&", "§");
		List<String> Lore = Config.getHeadCfg().getList("Lore");
		List<String> ItemLore = null;
		for (String s : Lore) {
			ItemLore.add(s.replaceAll("%player%", p.getName()).replaceAll("&", "§"));
		}
		Integer Amount = Config.getHeadCfg().getInt("Amount");
		Integer Slot = Config.getHeadCfg().getInt("Slot")-1;
		
		//Create ItemStack
		ItemStack PlayerHead = new ItemStack(Material.SKULL_ITEM);
		PlayerHead.setDurability((short) 3);
		PlayerHead.setAmount(Amount);
		SkullMeta PlayerHeadMeta = (SkullMeta) PlayerHead.getItemMeta();
		
		PlayerHeadMeta.setDisplayName(ItemName);
		PlayerHeadMeta.setLore(ItemLore);
		PlayerHeadMeta.setOwner(p.getName());
		
		List<String> RawEnchantments = Config.getBookCfg().getList("Enchantments");
		List<String> Enchantments = null;
		for (String s : RawEnchantments) {
			String[] EnchantmentSplit = s.split(":");
			Integer EnchantmentID = Integer.valueOf(EnchantmentSplit[0]);
			Integer EnchantmentLevel = Integer.valueOf(EnchantmentSplit[1]);
			Enchantment AddEnchantment = Enchantment.getById(EnchantmentID);
			PlayerHead.addUnsafeEnchantment(AddEnchantment, EnchantmentLevel);
		}
		
		PlayerHead.setItemMeta(PlayerHeadMeta);
		
		p.getInventory().setItem(Slot, PlayerHead);
		
	}

}
