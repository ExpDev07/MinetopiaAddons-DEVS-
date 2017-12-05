package me.GideonDM.CountryTown.EventTime;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class EventTimeUtil {
	
	
	
	public static boolean EventTime = false;
	public static boolean EventTimeDrops = false;
	public static boolean EventTimeDropsConfrim = false;
	
	
	public static void EventTime(Player p){
		
			 if(!EventTime){
				 
					if(EventTimeUtil.EventTimeDrops){	
						EventTimeUtil.EventTimeDropsConfrim = true;
						EventTime = true;
						
						
						Bukkit.broadcastMessage(ChatColor.DARK_RED + "EVENTTIME >> " + ChatColor.RED + "Er begint een event, wil je meedoen? Meld je dan bij het EventPlot! Je kan GEEN spullen verliezen!");
						
					}else if(!EventTimeUtil.EventTimeDrops){
						EventTimeUtil.EventTimeDropsConfrim = false;
						EventTimeUtil.EventTime = true;
						
						
						Bukkit.broadcastMessage(ChatColor.DARK_RED + "EVENTTIME >> " + ChatColor.RED + "Er begint een event, wil je meedoen? Meld je dan bij het EventPlot! Let op! Je kan spullen verliezen dus neem zo min mogelijk mee!");
					}
				
			
				
				
			}else{
				p.sendMessage(ChatColor.DARK_RED + "EVENTTIME >> " + ChatColor.RED + "Er is al een event bezig! Stop het event door EventTime Beheer scherm te openen!");
			}
		}

	
	public static void stopEvent(Player p){
		
		if(EventTime){
			
			EventTime = false;
			EventTimeDropsConfrim = false;
			
			Bukkit.broadcastMessage(ChatColor.DARK_RED + "EVENTTIME >> " + ChatColor.RED + "Het event is geeindigd door: " + p.getName() + "!");
			p.sendMessage(ChatColor.DARK_RED + "EVENTTIME >> " + ChatColor.RED + "Je hebt het event gestopt!");
		}
	}
}
