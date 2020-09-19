package de.spacenerd.backfish.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Navigator implements Listener{
	
	private final String GUI_NAME = "§6§lTeleporter";
	
	public void openGUI(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 9*1, GUI_NAME);
		inventory.setItem(3, new ItemStack(Material.GOLDEN_APPLE));		
		inventory.setItem(5, new ItemStack(Material.DIAMOND_SWORD));
		player.openInventory(inventory);
	}
	
	@EventHandler
	public void handleNavigatorOpener(PlayerInteractEvent event) {
		if(event.getItem().getType() != Material.COMPASS) return;
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK);
			openGUI(event.getPlayer());
			
	}
	
	@EventHandler
	public void handleNavigatorGUIClick(InventoryClickEvent event) {
		if(!(event.getWhoClicked() instanceof Player)) return;
		Player player = (Player) event.getWhoClicked();
		if(event.getClickedInventory().getTitle().equals(GUI_NAME)) {
			event.setCancelled(true);
			switch(event.getCurrentItem().getType()) {
			
			case GOLDEN_APPLE:
				player.sendMessage("§6Das ist der Heilige Gold Apfel!");
				player.closeInventory();
				break;
				
			case DIAMOND_SWORD:
				player.sendMessage("§bNur ein Schwert...");
				player.closeInventory();
				break;
				
				default:
					player.sendMessage("§7Du hast einen leeren Slot angeklickt");
					break;
			}
		}
	}
	
}
