package me.GideonDM.CountryTown.Veiling;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.GideonDM.CountryTown.Main.Main;
import net.md_5.bungee.api.ChatColor;

public class VeilingCommand implements CommandExecutor {

	
	public static boolean veilingStarted = false;
	public static int geboden = 0;
	public static int minimaaloverbieden = 0;
	public static int minimaalbieden = 0;
	public static Player veilingsMeester = null;
	public static Player gewonnen = null;
	public static String prefix = ChatColor.translateAlternateColorCodes('&', "&4&lVeiling >> &f&c");
	public static ItemStack veilingsItem = null;
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player){
			
			Player p = (Player) sender;
			
			if(p.hasPermission("ct.veiling")){
				
				if(args.length == 0){
					
					sendIndex(p);
					
				}
				
				if(args.length == 3){
					
					if(args[0].equalsIgnoreCase("start")){
						
				
						if(!veilingStarted){
							if(p.getItemInHand().getType() != Material.AIR){
							
							
							int durability = p.getItemInHand().getDurability();
							int maxdurability = p.getItemInHand().getType().getMaxDurability();
							int durabilitytotaal = maxdurability - durability;
							int hoeveelheid = p.getItemInHand().getAmount();
							Material item = p.getItemInHand().getType();
							ItemStack itemStack = p.getItemInHand();
							String name = p.getItemInHand().getItemMeta().getDisplayName();
							
							
							
							
							
							
							
							Bukkit.broadcastMessage(prefix + "-=-=- Country VeilingsSysteem -=-=-");
							
							Bukkit.broadcastMessage(prefix + "De veilingsmeester is: " + p.getName());
							
							if(p.getItemInHand().hasItemMeta()){
								Bukkit.broadcastMessage(prefix + "Het item wat geveild wordt is: " + name + " (" + item + ")(" + hoeveelheid + "x)");
							}else{
							
							Bukkit.broadcastMessage(prefix + "Het item wat geveild wordt is: " + item + "(" + hoeveelheid + "x)");
							}
							
							if(durability == 0){
								
								Bukkit.broadcastMessage(prefix + "Het item heeft geen schade!");
								
							}else{
							
							Bukkit.broadcastMessage(prefix + "De durability van dit item is " + durabilitytotaal + "/" + maxdurability);
							}
							
							if(BiedCommand.isInt(args[1])){
								
								int bod = Integer.parseInt(args[1]);
								minimaalbieden = bod;
								geboden = minimaalbieden;
								Bukkit.broadcastMessage(prefix + "Het minimale bod begint bij: " + minimaalbieden);
								 
							}
							
							if(BiedCommand.isInt(args[2])){
								
								int bod = Integer.parseInt(args[2]);
								minimaaloverbieden = bod;
								Bukkit.broadcastMessage(prefix + "Minimaal met " + minimaaloverbieden + " overbieden");
								
							}
							
							veilingsItem = itemStack;
							p.getInventory().remove(itemStack);
							
							
							veilingsMeester = p;
							veilingStarted = true;
							
						
						}else{
							
							p.sendMessage(prefix + "Je moet een item in je handen hebben om te veilen!");
							
						}
						
						}else{
							
							p.sendMessage(prefix + "De veiling is al gestart!");
						
						}
						
					}
					
					return false;
					
				}
				
			}
						
						
					if(args[0].equalsIgnoreCase("stop") && args.length == 1){
						if(veilingStarted){
							
							veilingStarted = false;
							
							sendAfsluiting(gewonnen);
						
						
						}else{
							
							p.sendMessage(prefix + "Er is geen veiling bezig!!");
						}
			
			
			
				
			}else{
					sendIndex(p);
			}
		}
		
		
		return false;
	}



	private void sendAfsluiting(Player gewonnen2) {
		
		if(gewonnen2 == null){
		
		
		Bukkit.broadcastMessage(prefix + "Er heeft GEEN speler gewonnen!");
		veilingsMeester.getInventory().addItem(veilingsItem);
		
		resetall();
		
		}else{
			
			
			Main.removeMoney(gewonnen, geboden);
			Main.addMoney(veilingsMeester, geboden);
			veilingsMeester.sendMessage(prefix + "Het geld is succesvol gestort!");
			Bukkit.broadcastMessage(prefix + "De speler " + gewonnen2.getName() + " heeft gewonnen, met het bod " + geboden + " euro!");
			gewonnen2.getInventory().addItem(veilingsItem);
			gewonnen2.sendMessage(prefix + "Je hebt de veiling gewonnen met je bod van " + geboden);
			
			resetall();
		}
	}



	private void resetall() {
		
		
		veilingStarted = false;
		geboden = 0;
		veilingsMeester = null;
		gewonnen = null;
		veilingsItem = null;
		minimaaloverbieden = 0;
		
	}



	private void sendIndex(Player p) {
		
		
		p.sendMessage(ChatColor.RED + "-=-=- Country VeilingsSysteem -=-=-");
		p.sendMessage("/veiling - Hiermee krijg je de command list");
		p.sendMessage("/veiling start (Minimale bod) (Overbieden met) - Start hiermee de veiling, als er niks voor staat zet er 0 neer!");
		p.sendMessage("/veiling stop - Stop de veiling!");
		p.sendMessage("/bied (Je bod) - Hiermee plaatst je een bod als de veiling is gestart!");
	}
	
	
	

}
