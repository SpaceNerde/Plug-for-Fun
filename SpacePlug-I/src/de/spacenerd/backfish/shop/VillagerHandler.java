package de.spacenerd.backfish.shop;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VillagerHandler implements CommandExecutor, Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("space.shop")) {
				if(args.length == 0) {
					new ShopVillager(player.getLocation());
					player.sendMessage("§aDer Shop wurde erfolgreich erstellt.");
					
				}else
					player.sendMessage("§cBitte benutzte §6/shop§c!");
			}else
				player.sendMessage("§cServer sagt NEIN!");
		}
		return false;
	}
	
	@EventHandler
	public void handleShopInteract(PlayerInteractEntityEvent event) {
		if(!(event.getRightClicked() instanceof Villager)) return;
		Villager shop = (Villager) event.getRightClicked();
		
		if(shop.getCustomName().equals(ShopVillager.VILLAGER_NAME)) {
			event.setCancelled(true);
			Player player = event.getPlayer();
			player.sendMessage("§aDer Shop wird geöffnet.");
		}
	}
	
	@EventHandler
	public void handleShopDamage(EntityDamageByEntityEvent event) {
		if(!(event.getEntity() instanceof Villager)) return;
		Villager shop = (Villager) event.getEntity();
		if(!shop.getCustomName().equals(ShopVillager.VILLAGER_NAME)) return;
		
		event.setCancelled(true);
		if(!(event.getDamager() instanceof Player)) return;
		Player player = (Player) event.getDamager();
		if(player.hasPermission("space.shop.kill")) {
			if(player.getItemInHand().getType() == Material.LAVA_BUCKET) {
				shop.setHealth(0);
				player.sendMessage("§aDer Shop wurde erfolgreich entfernt.");
			}
		}
	}
	
}
