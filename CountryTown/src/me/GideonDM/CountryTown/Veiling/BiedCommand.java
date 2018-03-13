package me.GideonDM.CountryTown.Veiling;

import me.GideonDM.CountryTown.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BiedCommand implements CommandExecutor {


	public static String prefix = ChatColor.translateAlternateColorCodes('&', "&4&lVeiling >> &f&c");

	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (VeilingCommand.veilingStarted) {

				if (args.length == 0 || args.length > 1) {

					p.sendMessage(prefix + "Je moet /bied (bod) doen.");
				}

				if (args.length == 1) {
					if (isInt(args[0])) {

						int bod = Integer.parseInt(args[0]);
						int minimaalbod = VeilingCommand.geboden + VeilingCommand.minimaaloverbieden;

						if (bod >= minimaalbod) {

							if (Main.getMoney(p) >= bod) {

								int echtebod = Integer.parseInt(args[0]);

								VeilingCommand.gewonnen = p;
								VeilingCommand.geboden = echtebod;

								Bukkit.broadcastMessage(prefix + "Speler " + p.getName() + " heeft " + echtebod + " geboden!");

							} else {

								p.sendMessage(prefix + "Je hebt te weinig geld voor dit bod!");
							}

						} else {


							p.sendMessage(prefix + "Je moet een bod uitbrengen van " + minimaalbod + " of hoger!");
						}

					} else {

						p.sendMessage(prefix + "Je moet wel een getal bieden.");
					}


				}

			} else {
				p.sendMessage(prefix + "Er is geen veiling bezig!");
			}

		}


		return false;
	}

}
