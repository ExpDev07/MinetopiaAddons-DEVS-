package me.GideonDM.CountryTown.EventTime;



import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.NilsPMC.SDB.SDBApi;

import net.md_5.bungee.api.ChatColor;

public class EventTimeEvents implements Listener{

	
	@EventHandler
	public void death(PlayerDeathEvent e){
		
		Player p = e.getEntity();
		
		
		if(EventTimeUtil.EventTime){
		if(!EventTimeUtil.EventTimeDropsConfrim){
			
			e.setKeepInventory(false);
			e.setKeepLevel(false);
			SDBApi.setFitheid(p, +20);
			
			
			e.setDeathMessage(ChatColor.DARK_RED + p.getName() + ChatColor.RED + " is doodgegaan tijdens het event!");
		
		}else if(EventTimeUtil.EventTimeDropsConfrim){
			
			e.setKeepInventory(false);
			e.setKeepLevel(false);
			SDBApi.setFitheid(p, +20);
			
		}
		
		
		e.setDeathMessage(ChatColor.DARK_RED + p.getName() + ChatColor.RED + " is doodgegaan tijdens het event!");
		
		
		}else if(EventTimeUtil.EventTime){ 
			
			e.setKeepInventory(true);
			e.setKeepLevel(true);
			SDBApi.setFitheid(p, +20);
		}
		
		
	}
	
	
	@EventHandler
	public void join(PlayerJoinEvent e){
	
	Player p = e.getPlayer();
	

	new BukkitRunnable(){
        public void run(){
            
        	if(EventTimeUtil.EventTime){
        		if(EventTimeUtil.EventTimeDrops){
        		p.sendMessage(ChatColor.DARK_RED + "EVENTTIME >> " + ChatColor.RED + "Er is een event bezig! Let op je kan GEEN spullen verliezen!");
        		
        		}else{
        		
        		p.sendMessage(ChatColor.DARK_RED + "EVENTTIME >> " + ChatColor.RED + "Er is een event bezig! Let op je kan WEL spullen verliezen!");
        		
        		}
        	}else{
        		return;
        	}
        		
        	
        	
        }
    }.runTaskLater(me.GideonDM.CountryTown.Main.Main.plugin, 200);

	

	}
	
	@EventHandler
	public void EventTimeInventoryClick(InventoryClickEvent e){
		
		
		if(e.getWhoClicked() instanceof Player){
			
			Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "EventTime beheer")){
			
			
			if(e.getSlot() == 0){
				e.setCancelled(true);
				p.closeInventory();
			
			}
			
			
			
			if(e.getSlot() == 4){
				if(EventTimeUtil.EventTime){
					
					p.sendMessage(ChatColor.DARK_RED + "EVENTTIME >> " + ChatColor.RED + "Er is al een event bezig! Stop het event door EventTime Beheer scherm te openen!");
				}else{
				EventTimeInventory.openEventTimeCreateStap1(p);
				
				}
				e.setCancelled(true);
			}
			
			if(e.getSlot() == 8){
				
				EventTimeUtil.stopEvent(p);
				e.setCancelled(true);
				p.closeInventory();
			}
			
			
			
			
			
			
			
			
		   } 
		
		if(e.getInventory().getName().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Maak Event stap 1/2")){
			   
			   if(e.getSlot() == 0){
				   
				   EventTimeUtil.EventTimeDrops = false;
				   e.setCancelled(true);
				   EventTimeInventory.openEventTimeCreateStap2(p);
			   }
			   
			   if(e.getSlot() == 8){
				   
				   EventTimeUtil.EventTimeDrops = true;
				   e.setCancelled(true);
				   EventTimeInventory.openEventTimeCreateStap2(p);
			   }
			   
			   e.setCancelled(true);
		   }
		
		if(e.getInventory().getName().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Maak Event stap 2/2")){
			
			if(e.getSlot() == 0){
				   
					EventTimeUtil.EventTime(p);
				   e.setCancelled(true);
				   p.closeInventory();
			   }
			   
			   if(e.getSlot() == 8){
				   
				   EventTimeUtil.EventTime = false;
				   EventTimeUtil.EventTimeDrops = false;
				   
				   e.setCancelled(true);
				   p.closeInventory();
			   }
			   
			   e.setCancelled(true);
		   
		}
		
		}
	}
}
