package me.GideonDM.CountryTown.Inkoop.Kleding.Schoenen;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import me.GideonDM.CountryTown.Inkoop.Kleding.ChestPants.KledingEnum;
import me.GideonDM.CountryTown.Main.Main;

public class SchoenenInventory implements Listener{

	
	
	
	
	public static Inventory schoenmenu;
	public static String schoeninkoop = ChatColor.translateAlternateColorCodes('&', "&4&lSchoenen inkoop");
	
	
	
	
	
	public static void openSchoenenMenu(Player p) {
		
		Inventory schoenmenu = Bukkit.createInventory(null, 9, schoeninkoop);
		
		Schoenen(schoenmenu, 1, KledingEnum.RANGEREDSCHOENEN);
		Schoenen(schoenmenu, 3, KledingEnum.BOSSBLUESCHOENEN);
		Schoenen(schoenmenu, 5, KledingEnum.EARLYGREYSCHOENEN);
		Schoenen(schoenmenu, 7, KledingEnum.CASSSCHOENEN);
		
		
		p.openInventory(schoenmenu);
		
		
	}
	
	
	public static void Schoenen(Inventory inv, int slot, KledingEnum schoenen)
	  {
	    inv.setItem(slot, schoenen.getItemStackInventory());
	  }
	
	@EventHandler
	public void inventoryClick(InventoryClickEvent e){
		
		if(e.getInventory().getName().equals(schoeninkoop)){
			
			Player p = (Player) e.getWhoClicked();
			
			e.setCancelled(true);
			
		if(e.getSlot() == 1){
			
			Main.KoopKleding(p, KledingEnum.RANGEREDSCHOENEN);
		}
		
		if(e.getSlot() == 3){
			
			Main.KoopKleding(p, KledingEnum.BOSSBLUESCHOENEN);
			
		}
		
		if(e.getSlot() == 5){
			
			Main.KoopKleding(p, KledingEnum.EARLYGREYSCHOENEN);
			
		}
		
		if(e.getSlot() == 7){
			
			Main.KoopKleding(p, KledingEnum.CASSSCHOENEN);
			
		}
		
		}
	}
}
	




