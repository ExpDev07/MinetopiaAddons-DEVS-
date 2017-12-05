package me.GideonDM.CountryTown.Telefoon.Event;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import wouter.is.cool.DataType;

public class KrijgTelefoon implements Listener{
	

	public static ItemStack telefoon(){
		
		
	    ItemStack item = new ItemStack(Material.BLAZE_POWDER, 1, (short)0);
	    ItemMeta meta = item.getItemMeta();
	    meta.setDisplayName("Mobiel");
	    item.setItemMeta(meta);
		
		return item;
	}
	
	

}
