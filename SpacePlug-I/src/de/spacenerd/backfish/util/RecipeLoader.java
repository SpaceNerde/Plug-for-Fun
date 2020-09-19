package de.spacenerd.backfish.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeLoader {

	public void registerRecipes() {
		ItemStack fruit = new ItemStack(Material.APPLE);
		ItemMeta fruitMeta = fruit.getItemMeta();
		fruitMeta.setDisplayName("§6§lSpace Frucht");
		fruit.setItemMeta(fruitMeta);
		ShapelessRecipe fruitRecipe = new ShapelessRecipe(fruit);
		fruitRecipe.addIngredient(Material.GOLDEN_APPLE);
		fruitRecipe.addIngredient(Material.GOLDEN_CARROT);
		fruitRecipe.addIngredient(Material.MELON);
		
		ItemStack spaceBurger = new ItemStack(Material.BREAD);
		ItemMeta spaceBurgerMeta = spaceBurger.getItemMeta();
		spaceBurgerMeta.setDisplayName("§6§lSpace Burger");
		spaceBurger.setItemMeta(spaceBurgerMeta);
		ShapedRecipe spaceBurgerRecipe = new ShapedRecipe(spaceBurger);
		spaceBurgerRecipe.shape("QBQ", "QFQ", "QBQ");
		spaceBurgerRecipe.setIngredient('B', Material.BREAD);
		spaceBurgerRecipe.setIngredient('F', Material.COOKED_BEEF);
		
		Bukkit.addRecipe(fruitRecipe);
		Bukkit.addRecipe(spaceBurgerRecipe);
	}
	
}
