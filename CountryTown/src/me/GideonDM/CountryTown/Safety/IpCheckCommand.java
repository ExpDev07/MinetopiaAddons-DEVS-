package me.GideonDM.CountryTown.Safety;

import java.net.InetAddress;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IpCheckCommand implements CommandExecutor{

	
	
	public static String prefix = ChatColor.translateAlternateColorCodes('&', "&4&lIpCheck >> &f&c");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if(sender.isOp()){
		if(args.length == 0){
			
			sendIndex(sender);
		}
		
		if(args.length == 1){
			
			if(Bukkit.getPlayer(args[0]) != null){
				
				Player p = (Player) Bukkit.getPlayer(args[0]);
				
				InetAddress ip = p.getAddress().getAddress();
				String ipecht = ip + "";
				String ipzonder = ipecht.replaceAll("/", "");
				
				sender.sendMessage(prefix + "Het ip van deze speler is " + ipzonder +  ".");
				
				
			}else{
				sender.sendMessage("Deze speler is niet online!");
			}
			
		}else{
			
			sender.sendMessage("/ipcheck (player)");
		}
	}
		
		return false;
	}

	private void sendIndex(CommandSender sender) {
		
		sender.sendMessage("/ipcheck (player)");
		
		
	}

}
