package de.spacenerd.tutorial.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.spacenerd.tutorial.commands.HealCommand;
import de.spacenerd.tutorial.commands.KitCommand;
import de.spacenerd.tutorial.listeners.JoinListener;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("kit").setExecutor(new KitCommand());
		
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new JoinListener(), this);
	}
	
}
