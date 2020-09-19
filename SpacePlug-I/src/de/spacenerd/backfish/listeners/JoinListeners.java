package de.spacenerd.backfish.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.spacenerd.backfish.util.ItemBuilder;

public class JoinListeners implements Listener{
	
	@EventHandler
	public void handlePlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		player.getInventory().addItem(new ItemBuilder(Material.GOLD_AXE).setName("§6Axt des Todes").setLore("§aLore 1", "§cLore 2").build());
		player.getInventory().addItem(new ItemBuilder(Material.WOOL, (short)6).setLore("§6Testlore").setAmont(42).build());
		
	}

}
