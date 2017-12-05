package me.GideonDM.CountryTown.Mine;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.GideonDM.CountryTown.Main.Main;


public class MineSigns implements Listener{
	
	
	public static String signplace0 = "[MINE]";
	public static String signplace1 = "COBBLESTONE";
	
	public static String signgeplaatst0 = ChatColor.translateAlternateColorCodes('&', "&4[TransCoal]");
	public static String signgeplaatst1 = ChatColor.translateAlternateColorCodes('&', "Verscheep jouw");
	public static String signgeplaatst3 = ChatColor.translateAlternateColorCodes('&', "&5(Klik hier)");
	
	public static String prefix = ChatColor.translateAlternateColorCodes('&', "&4&lTransCoal >> &f&c");
	
	
	@EventHandler
	
	public void placeSign(SignChangeEvent e){
		Player p = (Player) e.getPlayer();
		
		Block block = e.getBlock();
		
		if(p.isOp()){
			
			if(e.getLine(0).equalsIgnoreCase(signplace0)){
				if(e.getLine(1) != null){
					if(Material.getMaterial(e.getLine(1)) != null){
						
						String material = e.getLine(1);
						
						e.setLine(0, signgeplaatst0);
						e.setLine(1, signgeplaatst1);
						e.setLine(2, material);
						e.setLine(3, signgeplaatst3);
					
					}else{
						
						block.setType(Material.AIR);
						p.sendMessage(prefix + "Je moet wel een material opgeven!");
					}
					
				}else{
					
					block.setType(Material.AIR);
					p.sendMessage(prefix + "Je moet wel een material opgeven!");
				
				}
		
				
			}
			
		}
	
		
	}
	
	
	@EventHandler
	public void interact(PlayerInteractEvent e){
		
	
		if(e.getClickedBlock() != null){
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK ){
		if(e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN_POST){
			
			
				Block block = (Block) e.getClickedBlock();
				Sign sign = (Sign) block.getState();
				Player p = e.getPlayer();
				Inventory inv = p.getInventory();
				
			if(sign.getLine(0).equalsIgnoreCase(signgeplaatst0) && sign.getLine(3).equalsIgnoreCase(signgeplaatst3)){
				
		     
				int quantityFound = 0;
				Material sellingMaterial = Material.getMaterial(sign.getLine(2));
				for (ItemStack is : p.getInventory())
				{
					if (is != null)
					{
						if (is.getType() == sellingMaterial)
							quantityFound += is.getAmount();
					}
				}
				
				if(quantityFound < 1){
							
					p.sendMessage(prefix + "Je hebt geen " + sellingMaterial + " in jouw inventory!");	
					
					return;
				}
				
				int prijs = quantityFound * getPrijs(sellingMaterial);
				
				p.getInventory().remove(sellingMaterial);
				p.sendMessage(prefix + "Je hebt " + quantityFound + " " + sellingMaterial + " verscheept! Je hebt hier " + prijs + " euro voor gevangen!");
				
				Main.addMoney(p, prijs);
				
				
			}
			}
		
		}else{
			return;
		}
		}
			
	}
	
	public int getPrijs(Material m){
		
		if(m == Material.COBBLESTONE){
			
			return 2;
		}
		
		if(m == Material.COAL_BLOCK)
		
		return 4;
		return 0;
	}
	
}
