package me.GideonDM.CountryTown.Computer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import wouter.is.cool.DataType;

import java.util.ArrayList;
import java.util.UUID;

public class LeningProgamma implements Listener {


    public static Inventory computerh;
    public static String leningprogamma = ChatColor.translateAlternateColorCodes('&', "&cLening progamma");
    public static String lening = ChatColor.translateAlternateColorCodes('&', "&cJe hebt een lening van:");
    public static String geenlening = ChatColor.translateAlternateColorCodes('&', "&cJe hebt geen lening!");
    public static String leninglore = ChatColor.translateAlternateColorCodes('&', "&cKlik hier om het lening progamma te openen!");
    public static String geenpermissie = ChatColor.translateAlternateColorCodes('&', "&f&4Jij hebt deze KVK niet, vraag jouw gemeente om hulp!");


    public static void openComputerMenu(Player p) {


        Inventory computerh = Bukkit.createInventory(null, 27, leningprogamma);

        lening(Material.REDSTONE, 0, 1, computerh, 13, getLening(p));


        p.openInventory(computerh);


    }


    public static int getLening(Player p) {

        FileConfiguration api = wouter.is.cool.API.getFile(DataType.PLAYER);
        UUID uuid = p.getUniqueId();
        int lening = api.getInt(uuid + ".Geleend");

        return lening;

    }

    public static void lening(Material mat, int data, int amn, Inventory inv, int slot, int leningeuro) {
        ItemStack item = new ItemStack(mat, amn, (short) data);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> Lore = new ArrayList<String>();

        if (leningeuro == 0) {

            meta.setDisplayName(geenlening);

        } else {

            meta.setDisplayName(lening);
            Lore.add(ChatColor.translateAlternateColorCodes('&', "&c" + leningeuro + " euro"));
        }

        meta.setLore(Lore);
        item.setItemMeta(meta);
        inv.setItem(slot, item);
    }

    @EventHandler

    public void clickInventory(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if (e.getClickedInventory().getName().equalsIgnoreCase(leningprogamma)) {

            e.setCancelled(true);

        }
    }
}



