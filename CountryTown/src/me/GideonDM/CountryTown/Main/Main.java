package me.GideonDM.CountryTown.Main;

import me.GideonDM.CountryTown.Computer.ComputerInventory;
import me.GideonDM.CountryTown.Computer.LeningProgamma;
import me.GideonDM.CountryTown.EventTime.EventTimeCommand;
import me.GideonDM.CountryTown.EventTime.EventTimeEvents;
import me.GideonDM.CountryTown.Inkoop.Algemeen.AlgemeenEnum;
import me.GideonDM.CountryTown.Inkoop.Algemeen.AlgemeenMenu;
import me.GideonDM.CountryTown.Inkoop.Command.InkoopCommand;
import me.GideonDM.CountryTown.Inkoop.Events.openMenuEvent;
import me.GideonDM.CountryTown.Inkoop.Food.FoodEnum;
import me.GideonDM.CountryTown.Inkoop.Food.FoodInventory;
import me.GideonDM.CountryTown.Inkoop.InkoopInventory;
import me.GideonDM.CountryTown.Inkoop.Kleding.ChestPants.KledingEnum;
import me.GideonDM.CountryTown.Inkoop.Kleding.ChestPants.KledingInventory;
import me.GideonDM.CountryTown.Inkoop.Kleding.Hats.HatsInventory;
import me.GideonDM.CountryTown.Inkoop.Kleding.Schoenen.SchoenenInventory;
import me.GideonDM.CountryTown.Inkoop.VitamineMenu;
import me.GideonDM.CountryTown.KoopSigns.PickageSigns;
import me.GideonDM.CountryTown.Mine.MineSigns;
import me.GideonDM.CountryTown.Repair.AnvilEvent;
import me.GideonDM.CountryTown.Safety.AntiCraften;
import me.GideonDM.CountryTown.Safety.IpCheckCommand;
import me.GideonDM.CountryTown.Safety.SafetyJoin;
import me.GideonDM.CountryTown.Veiling.BiedCommand;
import me.GideonDM.CountryTown.Veiling.VeilingCommand;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin implements Listener {

	public static Plugin plugin;

	private static Economy econ = null;

    public static Economy getEconomy() {
        return econ;
    }

	public static void Koopfood(Player p, FoodEnum food) {

		if (econ.getBalance(p) >= food.getPrijsInt()) {

			econ.withdrawPlayer(p, (double) food.getPrijsInt());
			p.sendMessage(InkoopCommand.prefix + "Je hebt " + food.getRawName() + "(64x) gekocht! Voor " + food.getPrijsInt() + " euro!");

			ItemStack item = new ItemStack(food.getMaterial(), 64, (short) food.getID());
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(food.getName());
			item.setItemMeta(meta);

			p.getInventory().addItem(item);


		} else {

			p.sendMessage(InkoopCommand.prefix + "Je hebt te weinig geld!");
		}
	}

	public static void KoopKleding(Player p, KledingEnum kleding) {

		if (econ.getBalance(p) >= kleding.getPrijs()) {

			econ.withdrawPlayer(p, (double) kleding.getPrijs());
			p.sendMessage(InkoopCommand.prefix + "Je hebt " + kleding.getRawName() + " gekocht! Voor " + kleding.getPrijs() + " euro!");


			ItemStack lhelmet = new ItemStack(kleding.getMaterial(), 1);
			LeatherArmorMeta lam = (LeatherArmorMeta) lhelmet.getItemMeta();
			lam.setColor(Color.fromRGB(kleding.getRed(), kleding.getGreen(), kleding.getBlue()));
			lam.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			lam.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			lam.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

			if (kleding.isEnchant()) {
				lam.addEnchant(Enchantment.PROTECTION_FIRE, 1, true);

			}

			lam.setDisplayName(kleding.getChatColor() + "" + ChatColor.ITALIC + kleding.getRawName());


			ArrayList<String> Lore = new ArrayList<String>();

			Lore.add("Seizoen " + kleding.getSeizoen());

			lam.setLore(Lore);

			lhelmet.setItemMeta(lam);


			p.getInventory().addItem(lhelmet);


		} else {

			p.sendMessage(InkoopCommand.prefix + "Je hebt te weinig geld!");
		}


	}

	public static void KoopVitamine(Player p, String AB, int prijs) {

		if (econ.getBalance(p) >= prijs) {

			econ.withdrawPlayer(p, (double) prijs);
			p.sendMessage(InkoopCommand.prefix + "Je hebt vitamine " + AB + " gekocht! Voor " + prijs + " euro!");

			ItemStack item = new ItemStack(Material.RABBIT_STEW, 1, (short) 0);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("Vitamine " + AB);
			item.setItemMeta(meta);

			p.getInventory().addItem(item);


		} else {

			p.sendMessage(InkoopCommand.prefix + "Je hebt te weinig geld!");
		}
	}

	public static void KoopAlgemeen(Player p, AlgemeenEnum food) {

		if (econ.getBalance(p) >= food.getPrijs()) {

			econ.withdrawPlayer(p, (double) food.getPrijs());
			p.sendMessage(InkoopCommand.prefix + "Je hebt " + food.getName() + "(64x) gekocht! Voor " + food.getPrijs() + " euro!");

			ItemStack item = new ItemStack(food.getMaterial(), 64, (short) 0);
			ItemMeta meta = item.getItemMeta();

			item.setItemMeta(meta);


			p.getInventory().addItem(item);


		} else {

			p.sendMessage(InkoopCommand.prefix + "Je hebt te weinig geld!");
		}
	}

	public static void KoopHeads(Player p, KledingEnum kleding) {

		if (econ.getBalance(p) >= kleding.getPrijs()) {

			econ.withdrawPlayer(p, (double) kleding.getPrijs());
			p.sendMessage(InkoopCommand.prefix + "Je hebt " + kleding.getName() + " gekocht! Voor " + kleding.getPrijs() + " euro!");

			ItemStack item = new ItemStack(kleding.getMaterial(), 1, (short) 0);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.WHITE + kleding.getRawName());
			item.setItemMeta(meta);

			p.getInventory().addItem(item);


		} else {

			p.sendMessage(InkoopCommand.prefix + "Je hebt te weinig geld!");
		}
	}

	public static int getMoney(Player p) {

		return (int) econ.getBalance(p);
	}

	public static void removeMoney(Player p, int bod) {

		econ.withdrawPlayer(p, bod);
	}

	public static void addMoney(Player veilingsMeester, int bod) {

		econ.depositPlayer(veilingsMeester, +bod);


	}

	@Override
	public void onEnable() {


		registerEvents();
		registerCommands();
		setupEconomy();


		plugin = this;
	}

	private void registerCommands() {

		getCommand("eventtime").setExecutor(new EventTimeCommand());
		getCommand("inkoop").setExecutor(new InkoopCommand());
		getCommand("veiling").setExecutor(new VeilingCommand());
		getCommand("bied").setExecutor(new BiedCommand());
		getCommand("ipcheck").setExecutor(new IpCheckCommand());
	}

	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new EventTimeEvents(), this);
		pm.registerEvents(new InkoopInventory(), this);
		pm.registerEvents(new FoodInventory(), this);
		pm.registerEvents(new KledingInventory(), this);
		pm.registerEvents(new VitamineMenu(), this);
		pm.registerEvents(new AlgemeenMenu(), this);
		pm.registerEvents(new openMenuEvent(), this);
		pm.registerEvents(new ComputerInventory(), this);
		pm.registerEvents(new HatsInventory(), this);
		pm.registerEvents(new SafetyJoin(), this);
		pm.registerEvents(new LeningProgamma(), this);
		pm.registerEvents(new AntiCraften(), this);
		pm.registerEvents(new AnvilEvent(), this);
		pm.registerEvents(new MineSigns(), this);
		pm.registerEvents(new SchoenenInventory(), this);
		pm.registerEvents(new PickageSigns(), this);


	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}
}
