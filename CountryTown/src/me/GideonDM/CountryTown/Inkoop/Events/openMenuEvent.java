package me.GideonDM.CountryTown.Inkoop.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.GideonDM.CountryTown.Computer.ComputerInventory;

public class openMenuEvent implements Listener {

	
	@EventHandler
	public void interact(PlayerInteractEvent e){
		
		
		Block block = e.getClickedBlock();
		
		
		if(e.getClickedBlock() != null){
		if(e.getClickedBlock().getType() == Material.NETHER_BRICK_STAIRS){
				if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
		
					
					ComputerInventory.openComputerMenu(e.getPlayer());
					
					e.setCancelled(true);
					
					
				
				
			
		

		
		
				
		}
		}
		}
	}
}
