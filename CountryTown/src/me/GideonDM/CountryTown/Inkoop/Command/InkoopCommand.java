package me.GideonDM.CountryTown.Inkoop.Command;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.GideonDM.CountryTown.Inkoop.InkoopInventory;
import me.GideonDM.CountryTown.Inkoop.Algemeen.AlgemeenEnum;
import me.GideonDM.CountryTown.Main.Main;
import me.GideonDM.CountryTown.Telefoon.Event.KrijgTelefoon;

public class InkoopCommand implements CommandExecutor {

	public static String prefix = ChatColor.translateAlternateColorCodes('&', "&4&lInkoop >> &f&c");
	public static String permissie = ChatColor.translateAlternateColorCodes('&', "&f&4Je hebt hier geen permissie voor!");
	
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player){
			
			Player p = (Player) sender;
		
			
				
			
		if(args.length == 0){
			
			InkoopInventory.openInKoopHoofdMenu(p);
			
		}
			
		if(args.length == 1){
			
			if(args[0].equalsIgnoreCase("help")){
			
				sendHelp(p);
			}
			
			
		}
		
			if(args.length == 2){
				
				if(args[0].equalsIgnoreCase("open")){
						
					if(Bukkit.getPlayer(args[1]) != null){
						
						Player target = (Player) Bukkit.getPlayer(args[1]);
						InkoopInventory.openInKoopHoofdMenu(target);
						
						
					}else{
						
						p.sendMessage(prefix + "Deze speler is niet online!");
					}
				
				
				
				}
				
			}
			
			
			if(args.length == 3){
				
				if(args[0].equalsIgnoreCase("geef")){
					
					if(Bukkit.getPlayer(args[1]) != null){
						
						Player target = Bukkit.getPlayer(args[1]);
						
						
						
						if(args[2].equalsIgnoreCase("kleding")){
							
							ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
							String command = "pex user " + target.getName() + " add inkoop.kleding";
							Bukkit.dispatchCommand(console, command);
							
							p.sendMessage(prefix + "Je hebt " + target.getName() + " toestemming gegeven om de kleding inkoop te gebruiken.");
							
						}else if(args[2].equalsIgnoreCase("hats")){
							
							ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
							String command = "pex user " + target.getName() + " add inkoop.hats";
							Bukkit.dispatchCommand(console, command);
							
							p.sendMessage(prefix + "Je hebt " + target.getName() + " toestemming gegeven om de hoofdekels inkoop te gebruiken.");
							
						}else if(args[2].equalsIgnoreCase("food")){
							
							ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
							String command = "pex user " + target.getName() + " add inkoop.food";
							Bukkit.dispatchCommand(console, command);
							
							p.sendMessage(prefix + "Je hebt " + target.getName() + " toestemming gegeven om de food inkoop te gebruiken.");
							
						}else if(args[2].equalsIgnoreCase("vitamines")){
							
							ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
							String command = "pex user " + target.getName() + " add inkoop.vitamines";
							Bukkit.dispatchCommand(console, command);
							
							p.sendMessage(prefix + "Je hebt " + target.getName() + " toestemming gegeven om de vitamine inkoop te gebruiken."); 
							
						}else{
							
							p.sendMessage(prefix + "Gebruik /inkoop help");
						}
					
					
					}else{
						
						p.sendMessage(prefix + "Deze speler is niet online!"); 
					}
					
					
					
					
				}else if(args[0].equalsIgnoreCase("verwijder")){
					
					if(Bukkit.getPlayer(args[1]) != null){
						
						Player target = Bukkit.getPlayer(args[1]);
						
						
						
						if(args[2].equalsIgnoreCase("kleding")){
							
							ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
							String command = "pex user " + target.getName() + " remove inkoop.kleding";
							Bukkit.dispatchCommand(console, command);
							
							p.sendMessage(prefix + "Je hebt " + target.getName() + " geen toestemming meer gegeven om de kleding inkoop te gebruiken."); 
							
					
							
						}else if(args[2].equalsIgnoreCase("food")){
							
							ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
							String command = "pex user " + target.getName() + " remove inkoop.food";
							Bukkit.dispatchCommand(console, command);
							
							p.sendMessage(prefix + "Je hebt " + target.getName() + " geen toestemming meer gegeven om de food inkoop te gebruiken."); 
							
							
								
						}else if(args[2].equalsIgnoreCase("hats")){
							
							ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
							String command = "pex user " + target.getName() + " remove inkoop.hats";
							Bukkit.dispatchCommand(console, command);
							
							p.sendMessage(prefix + "Je hebt " + target.getName() + " geen toestemming meer gegeven om de heads inkoop te gebruiken."); 
							
							
							
						}else if(args[2].equalsIgnoreCase("vitamines")){
							
							ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
							String command = "pex user " + target.getName() + " remove inkoop.vitamines";
							Bukkit.dispatchCommand(console, command);
							
							p.sendMessage(prefix + "Je hebt " + target.getName() + " geen toestemming meer gegeven om de vitamine inkoop te gebruiken."); 
							
						}else{
							
							p.sendMessage(prefix + "Gebruik /inkoop help");
						}
						
					}else{
						
						p.sendMessage(prefix + "Deze speler is niet online!");
						
					}
				}
			}
		
			
			
			
			
		}else{
			sender.sendMessage(prefix + permissie);
			
		}
		
		

		
		return false;
	}


	private void sendHelp(Player p) {
		
		p.sendMessage(ChatColor.RED + "-=-=-=-= Inkoop systeem =-=-=-=-" );
		p.sendMessage(ChatColor.RED + "/inkoop open (Speler) - Open het Inkoop menu voor de speler." );
		p.sendMessage(ChatColor.RED + "/inkoop help - Krijg een chatbericht met alle commands!" );
		p.sendMessage(ChatColor.RED + "/inkoop geef (Speler) (vitamines/food/hats/kleding) - Geef de speler permissions voor de inkoop!");
		p.sendMessage(ChatColor.RED + "/inkoop verwijder (Speler) (vitamines/food/hats/kleding) - Verwijder de inkoop permissions van deze speler!");
		p.sendMessage(ChatColor.RED + "-=-=-=-= Inkoop systeem =-=-=-=-" );
		
	}

}
