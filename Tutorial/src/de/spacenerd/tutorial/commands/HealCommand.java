package de.spacenerd.tutorial.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("tutorial.heal")) {
				if(args.length == 0) {
					player.setHealth(20);
					player.setFoodLevel(20);
					player.sendMessage("§aDu bist jetzt geheilt");
				} else if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						target.setHealth(20);
						target.setFoodLevel(20);
						target.sendMessage("§aDu bist jetzt geheilt");
						player.sendMessage("§aDu hast den Spieler §6" + target.getName() + "§ageheilt!");
					} else
						player.sendMessage("§cDer Spieler §6" + args[0] + " §cist nicht auf dem Server!");
				} else
					player.sendMessage("§cBitte benutzte §6/heal <SPIELER> §c!");
					
			} else
				player.sendMessage("§cDazu hast du nicht die nötigen rechte");
		} else
			sender.sendMessage("!Dieses Kommando darfst du nur als spieler benutzten!");
		
		return false;
	}

}
 