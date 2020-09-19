package de.spacenerd.tutorial.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player= (Player) sender;
			if(player.hasPermission("tutorial.kit")) {
				if(args.length == 0) {
					
					Inventory inventory = Bukkit.createInventory(null, 9*3, "§6§lKit-Inventar");
					
					ItemStack item = new ItemStack(Material.BOW);
					ItemMeta itemMeta = item.getItemMeta();
					itemMeta.setDisplayName("§6Heiliger Meteor Bogen");
					itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
					item.setItemMeta(itemMeta);
					
					inventory.addItem(item);
					item.setAmount(9);
					inventory.setItem(14, item);
					player.openInventory(inventory);
					player.sendMessage("§aDas Kit Menu ist jetzt offen");
					
				} else
					player.sendMessage("§cBitte benutzte $6/kit§c!");
			} else
				player.sendMessage("§cDazu hast du nicht die nötigen Rechte");
		}
		
		return false;
	}
		
	
	
}
