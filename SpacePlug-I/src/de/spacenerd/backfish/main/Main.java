package de.spacenerd.backfish.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.spacenerd.backfish.listeners.JoinListeners;
import de.spacenerd.backfish.shop.VillagerHandler;
import de.spacenerd.backfish.util.Navigator;
import de.spacenerd.backfish.util.RecipeLoader;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		new RecipeLoader().registerRecipes();
		VillagerHandler villagerHandler = new VillagerHandler();
		
		getCommand("shop").setExecutor(villagerHandler);
		
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new JoinListeners(), this);
		pluginManager.registerEvents(new Navigator(), this);
		pluginManager.registerEvents(villagerHandler, this);

	}
	
	public static Main getPlugin() {
		return plugin;
	}
	

}
