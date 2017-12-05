package me.GideonDM.CountryTown.EventTime;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class EventTimeInventory {

	
	
	public Inventory home;
	public Inventory stap1;
	
	
	public static void openEventTimeInventory(Player p){
		
		Inventory home = Bukkit.createInventory(null, 9, ChatColor.DARK_RED + "" + ChatColor.BOLD + "EventTime beheer");
			
		Statusitem(EventStatusBlock(), 0, 1, home, 0, ChatColor.GRAY + "EventTime staat:", " ", EventTimeStatus(), EventTimeDrops());
		
		menuItem1(Material.COMPASS, 0, 1, home, 4, ChatColor.GRAY + "Maak een nieuw Event", "");
		
		
		if(EventTimeUtil.EventTime){
		
		menuItem1(Material.STAINED_CLAY, 14, 1, home, 8, ChatColor.GRAY + "Stop het Event!", "");
		
		}else if(!EventTimeUtil.EventTime){
		
		menuItem1(Material.BOOK, 0, 1, home, 8, ChatColor.GRAY + "Geen event bezig!", "");
		}
		p.openInventory(home);
	}
	
	public static void openEventTimeCreateStap1(Player p){
		
		Inventory stap1 = Bukkit.createInventory(null, 9, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Maak Event stap 1/2");
			
		menuItem1(Material.COMPASS, 0, 1, stap1, 4, ChatColor.GRAY + "Moeten spelers hun spullen verliezen?", "");
		
		menuItem1(Material.STAINED_CLAY, 13, 1, stap1, 0, ChatColor.GREEN + "JA", ChatColor.GRAY + "LET OP!! De spelers kunnen hun spullen verliezen!");
		
		menuItem1(Material.STAINED_CLAY, 14, 1, stap1, 8, ChatColor.RED + "NEE", ChatColor.GRAY + "LET OP!! De spelers kunnen hun spullen NIET verliezen!");
		
		p.openInventory(stap1);
	}
	
	public static void openEventTimeCreateStap2(Player p){
		
		Inventory stap2 = Bukkit.createInventory(null, 9, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Maak Event stap 2/2");
			
		menuItem2(Material.COMPASS, 0, 1, stap2, 4, ChatColor.GRAY + "Wil je het event beginnen!?", ChatColor.GRAY + "Drops:", EventTimeDrops());
	
		menuItem1(Material.STAINED_CLAY, 13, 1, stap2, 0, ChatColor.GREEN + "JA", ChatColor.GRAY + "LET OP!! Het event begint per direct");
		
		menuItem1(Material.STAINED_CLAY, 14, 1, stap2, 8, ChatColor.RED + "NEE", ChatColor.GRAY + "LET OP!! Je settings gaan meteen weg!");
		
		p.openInventory(stap2);
	}
	
	
	
	public static String EventTimeStatus(){
		
		if(EventTimeUtil.EventTime){
			
			return ChatColor.GREEN + "AAN";
			
		}else if(!EventTimeUtil.EventTime){
			
			return ChatColor.RED + "UIT";
		}
		
		return "Onbekend";
		
		
	}
	
public static String EventTimeDrops(){
		
		if(!EventTimeUtil.EventTimeDropsConfrim){
			
			return ChatColor.GREEN + "AAN";
			
		}else if(EventTimeUtil.EventTimeDropsConfrim){
			
			return ChatColor.RED + "UIT";
		}
		
		return "Onbekend";
		
		
	}
	
	public static ItemStack EventStatusBlock(){
		
		if(EventTimeUtil.EventTime){
			
			
			   @SuppressWarnings("deprecation")
			ItemStack item = new ItemStack(351, 1, (short)10);
			  
			  
			
			
			return item;
		}
		
		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(351, 1, (short)8);
		
		return item;
		
		
	}
	
	
	
	// API STUFF //
	
	
	
	 public static void menuItem1(Material mat, int data, int amn, Inventory inv, int slot, String name, String lore)
	  {
	    ItemStack item = new ItemStack(mat, amn, (short)data);
	    ItemMeta meta = item.getItemMeta();
	    meta.setDisplayName(name);
	    ArrayList<String> Lore = new ArrayList<String>();
	    Lore.add(lore);
	    
	    
	    meta.setLore(Lore);
	    item.setItemMeta(meta);
	    inv.setItem(slot, item);
	  }
	 
	 public static void menuItem2(Material mat, int data, int amn, Inventory inv, int slot, String name, String lore, String lore2)
	  {
	    ItemStack item = new ItemStack(mat, amn, (short)data);
	    ItemMeta meta = item.getItemMeta();
	    meta.setDisplayName(name);
	    ArrayList<String> Lore = new ArrayList<String>();
	    Lore.add(lore);
	    Lore.add(lore2);
	    
	    meta.setLore(Lore);
	    item.setItemMeta(meta);
	    inv.setItem(slot, item);
	  }
	 
	  public static void menuItem3(Material mat, int data, int amn, Inventory inv, int slot, String name, String lore, String lore2, String lore3)
	  {
	    ItemStack item = new ItemStack(mat, amn, (short)data);
	    ItemMeta meta = item.getItemMeta();
	    meta.setDisplayName(name);
	    ArrayList<String> Lore = new ArrayList<String>();
	    Lore.add(lore);
	    Lore.add(lore2);
	    Lore.add(lore3);
	    
	    meta.setLore(Lore);
	    item.setItemMeta(meta);
	    inv.setItem(slot, item);
	  }
	  
	  public static void Statusitem(ItemStack item, int data, int amn, Inventory inv, int slot, String name, String lore, String lore2, String items)
	  {
	    ItemMeta meta = item.getItemMeta();
	    meta.setDisplayName(name);
	    ArrayList<String> Lore = new ArrayList<String>();
	    Lore.add(lore); // SPATIE
	    Lore.add(lore2); //STATUS
	    Lore.add(lore); // SPATIE
	    Lore.add(ChatColor.GRAY + "Dead drops:"); // ITEMS AAN/UIT
	    Lore.add(lore); // SPATIE
	    Lore.add(items); // STATUS
	 
	    meta.setLore(Lore);
	    item.setItemMeta(meta);
	    inv.setItem(slot, item);
	  }
}
