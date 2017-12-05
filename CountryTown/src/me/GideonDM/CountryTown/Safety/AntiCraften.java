package me.GideonDM.CountryTown.Safety;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class AntiCraften implements Listener{
	
	public static String prefix = ChatColor.translateAlternateColorCodes('&', "&4&lAntiCraften >> &f&c");
	
	@EventHandler
	
	public void antiCraft(PlayerInteractEvent e){
		
		Block block = e.getClickedBlock();
		
		if(e.getClickedBlock() != null){
		if(e.getClickedBlock().getType() == Material.AIR){
			Player p = e.getPlayer();
			
			if(!p.isOp()){
			
		
				
				p.sendMessage(prefix + "Je hebt hier geen permissie voor!");
				e.setCancelled(true);
				p.closeInventory();
				
			}
		
		}
		}
		
	}

}
