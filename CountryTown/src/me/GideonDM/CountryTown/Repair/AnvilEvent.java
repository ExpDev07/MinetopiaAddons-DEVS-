package me.GideonDM.CountryTown.Repair;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class AnvilEvent implements Listener {

	public static String prefix = ChatColor.translateAlternateColorCodes('&', "&4&lRepair >> &f&c");


	@SuppressWarnings("deprecation")
	@EventHandler

	public void AnvilClick(PlayerInteractEvent e) {

		Block block = e.getClickedBlock();

		if (e.getClickedBlock() != null) {
			if (e.getClickedBlock().getType() == Material.ANVIL) {

				Player p = e.getPlayer();

				if (p.isOp() || p.hasPermission("ct.repair")) {


					if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {


						e.setCancelled(true);

						if (p.getItemInHand().getType() != Material.AIR) {


							ItemStack item = p.getItemInHand();


							if (item.getDurability() != 0) {

								item.setDurability((short) 0);


								p.sendMessage(prefix + "Item is succescol gerepareerd!");

							} else {

								p.sendMessage(prefix + "Dit item heeft geen schade!");
							}

						} else {
							p.sendMessage(prefix + "Doe het item die je wilt repareren in je hand!");

						}
					}

				} else {
					e.setCancelled(true);
					p.sendMessage(prefix + "Jij hebt hier geen permissie voor!");

				}
			}


		}
	}

}
