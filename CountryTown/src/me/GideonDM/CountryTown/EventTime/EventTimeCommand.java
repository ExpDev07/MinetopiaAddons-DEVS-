package me.GideonDM.CountryTown.EventTime;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EventTimeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player){
		
		Player p = (Player) sender;
		
		if(p.hasPermission("ct.eventtime")){
		if(args.length == 0){
			
			 //INVENTORY OPENEN//
			
			EventTimeInventory.openEventTimeInventory(p);
			
			
		}else{
			
			p.sendMessage(ChatColor.DARK_RED + "EVENTTIME >> " + ChatColor.RED + "Gebruik geen argumenten! Gebruik /eventtime");
			
		}
			
		}else{
			
			p.sendMessage(ChatColor.DARK_RED + "EVENTTIME >> " + ChatColor.RED + "Je hebt hier geen permissie voor!");
			
		}
		
		
		}else{
			sender.sendMessage("Ga voor deze command in-game!");
		}
		return false;
	}
	
	

}
