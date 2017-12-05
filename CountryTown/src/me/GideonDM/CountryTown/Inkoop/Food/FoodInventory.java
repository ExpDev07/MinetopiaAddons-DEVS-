package me.GideonDM.CountryTown.Inkoop.Food;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.GideonDM.CountryTown.Main.Main;

public class FoodInventory implements Listener{
	
	public static Inventory foodmenu;
	public static String foodm = ChatColor.translateAlternateColorCodes('&', "&4&lVoedsel inkoop menu");
	public static String prijs = ChatColor.RED + "Prijs:";
	
	public static void openFoodMenu(Player p){
		
		Inventory foodmenu = Bukkit.createInventory(null, 18, foodm);
		
		foodItem(FoodEnum.CARROT.getMaterial(), 0, foodmenu, 0, FoodEnum.CARROT.getName(), FoodEnum.CARROT.getPrijs());
		foodItem(FoodEnum.APPEL.getMaterial(), 0, foodmenu, 1, FoodEnum.APPEL.getName(), FoodEnum.APPEL.getPrijs());
		foodItem(FoodEnum.BROOD.getMaterial(), 0, foodmenu, 2, FoodEnum.BROOD.getName(), FoodEnum.BROOD.getPrijs());
		foodItem(FoodEnum.RABBIT.getMaterial(), 0, foodmenu, 3, FoodEnum.RABBIT.getName(), FoodEnum.RABBIT.getPrijs());
		foodItem(FoodEnum.PORKCHOP.getMaterial(), 0, foodmenu, 4, FoodEnum.PORKCHOP.getName(), FoodEnum.PORKCHOP.getPrijs());
		foodItem(FoodEnum.POTATO.getMaterial(), 0, foodmenu, 5, FoodEnum.POTATO.getName(), FoodEnum.POTATO.getPrijs());
		foodItem(FoodEnum.FISH.getMaterial(), 0, foodmenu, 6, FoodEnum.FISH.getName(), FoodEnum.FISH.getPrijs());
		foodItem(FoodEnum.FISH1.getMaterial(), 1, foodmenu, 7, FoodEnum.FISH.getName(), FoodEnum.FISH1.getPrijs());
		foodItem(FoodEnum.MUTTON.getMaterial(), 0, foodmenu, 8, FoodEnum.MUTTON.getName(), FoodEnum.MUTTON.getPrijs());
		foodItem(FoodEnum.MELON.getMaterial(), 0, foodmenu, 9, FoodEnum.MELON.getName(), FoodEnum.MELON.getPrijs());
		foodItem(FoodEnum.STEAK.getMaterial(), 0, foodmenu, 10, FoodEnum.STEAK.getName(), FoodEnum.STEAK.getPrijs());
		foodItem(FoodEnum.CHICKEN.getMaterial(), 0, foodmenu, 11, FoodEnum.CHICKEN.getName(), FoodEnum.CHICKEN.getPrijs());
		
		p.openInventory(foodmenu);
		
	}

	@EventHandler
	
	public void clickInventory(InventoryClickEvent e){
		
		if(e.getInventory().getName().equals(foodm)){
			
			Player p = (Player) e.getWhoClicked();
			
			if(e.getSlot() == 0){
				
				Main.Koopfood(p, FoodEnum.CARROT);
			
			}
			
			if(e.getSlot() == 1){
				
				Main.Koopfood(p, FoodEnum.APPEL);
			
			}
			
			if(e.getSlot() == 2){
				
				Main.Koopfood(p, FoodEnum.BROOD);
			
			}
			
			if(e.getSlot() == 3){
				
				Main.Koopfood(p, FoodEnum.RABBIT);
			
			}
			
			if(e.getSlot() == 4){
				
				Main.Koopfood(p, FoodEnum.PORKCHOP);
			
			}
			
			if(e.getSlot() == 5){
				
				Main.Koopfood(p, FoodEnum.POTATO);
			
			}
			
			if(e.getSlot() == 6){
				
				Main.Koopfood(p, FoodEnum.FISH);
			
			}
			
			if(e.getSlot() == 7){
				
				Main.Koopfood(p, FoodEnum.FISH1);
			
			}
			
			if(e.getSlot() == 8){
				
				Main.Koopfood(p, FoodEnum.MUTTON);
			
			}
			
			if(e.getSlot() == 9){
				
				Main.Koopfood(p, FoodEnum.MELON);
			
			}
			
			if(e.getSlot() == 10){
				
				Main.Koopfood(p, FoodEnum.STEAK);
			
			}
			
			if(e.getSlot() == 11){
				
				Main.Koopfood(p, FoodEnum.CHICKEN);
			
			}
			e.setCancelled(true);
			
		}
		
		
	}
	
	
	
	  public static void foodItem(Material mat, int data, Inventory inv, int slot, String name, String Prijs)
	  {
	    ItemStack item = new ItemStack(mat, 64, (short)data);
	    ItemMeta meta = item.getItemMeta();
	    meta.setDisplayName(name);
	    ArrayList<String> Lore = new ArrayList<String>();
	    Lore.add(prijs);
	    Lore.add(Prijs);
	   
	    
	    meta.setLore(Lore);
	    item.setItemMeta(meta);
	    inv.setItem(slot, item);
	  }
	
	
	
}
