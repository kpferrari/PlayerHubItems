package com.Bodsterrr.PlayerHubItems;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		//Make messages customisable
		
		if (args.length == 0) {
			
			if (sender.hasPermission("playerhubitems.command") || sender.isOp()) {
				sender.sendMessage("§7# §3Use §7(§d/phi head§7) §3for head commands");
				sender.sendMessage("§7# §3Use §7(§d/phi book§7) §3for book commands");
			}
			else {
				sender.sendMessage("§7# §3This server is using §dPlayerHubItems");
				sender.sendMessage("§7# §3Using version §d2.5 §3by §6Bodsterr");
			}
			
		}
		
		else if (args.length == 1) {
			
			if (args[0].equalsIgnoreCase("head")) {
				sender.sendMessage("§7# §3Use §7(§d/phi head get§7) §3to get your head");
			}
			else if (args[0].equalsIgnoreCase("book")) {
				sender.sendMessage("§7# §3Use §7(§d/phi book get§7) §3to get the book");
				sender.sendMessage("§7# §3Use §7(§d/phi book save§7) §3to save the book");
			}
			
		}
		
		else if (args.length == 2) {
			if (args[0].equalsIgnoreCase("head")) {
				if (args[1].equalsIgnoreCase("get")) {
					Player player = (Player) sender;
					Head.giveHead(player);
					sender.sendMessage("§7# §3You have been given your head");
				}
			}
			else if (args[0].equalsIgnoreCase("book")) {
				if (args[1].equalsIgnoreCase("get")) {
					Player player = (Player) sender;
					Book.giveBook(player);
					sender.sendMessage("§7# §3You have been give the book");
				}
				else if (args[1].equalsIgnoreCase("save")) {
					Player player = (Player) sender;
					Book.saveBook(player);
				}
				
			}
			
		}
		
		return false;
		
	}

}
