package de.spacenerd.tutorial.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
	
	@EventHandler
	public void handlePlayerJoin(PlayerJoinEvent event) {
		event.setJoinMessage("§aDer Spieler §6" + event.getPlayer().getName() + "§a hat den Server betreten.");
	}
	
}
