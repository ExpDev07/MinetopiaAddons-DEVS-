package me.GideonDM.CountryTown.KoopSigns;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class PickageSigns implements Listener{
	
	
	public static String signplace0 = "[Koop]";
	public static String signplace1 = "";
	
	public static String signgeplaatst0 = ChatColor.translateAlternateColorCodes('&', "&4Koop nu jouw");
	public static String signgeplaatst1 = ChatColor.translateAlternateColorCodes('&', "");
	public static String signgeplaatst3 = ChatColor.translateAlternateColorCodes('&', "&4(Klik hier)");
	
	public static String prefix = ChatColor.translateAlternateColorCodes('&', "&4&lTransCoal >> &f&c");
	
	@EventHandler
	
	public void changeSign(SignChangeEvent e){

		if(e.getLine(0).equalsIgnoreCase(signplace0)){
			
			if(e.getLine(1) != null){
			
				if(Material.getMaterial(e.getLine(1)) != null){
					
					String material = e.getLine(1);
					Material material1 = Material.getMaterial(e.getLine(1));
					
					e.setLine(0, signgeplaatst0);
					e.setLine(1, material);
					e.setLine(2, getPrijs(material1));
					e.setLine(3, signgeplaatst3);
				
					
				}
			}
			
		}
		
	}
	
	public String getPrijs(Material material){
		
		if(material == Material.WOOD_PICKAXE){
			
			return 100 + "";
		}
		
		if(material == Material.STONE_PICKAXE){
			
			return 215 + "";
		}
		
		
		return 0 + "";
	}

}
