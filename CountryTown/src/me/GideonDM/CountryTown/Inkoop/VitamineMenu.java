package me.GideonDM.CountryTown.Inkoop;

import me.GideonDM.CountryTown.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class VitamineMenu implements Listener {


    public static Inventory vitam;

    public static String vitaminenaam = ChatColor.translateAlternateColorCodes('&', "&4&lVitamine inkoop menu");
    public static String vitaminea = ChatColor.translateAlternateColorCodes('&', "&cVitamine A");
    public static String vitamineb = ChatColor.translateAlternateColorCodes('&', "&cVitamine B");
    public static String vitaminelore = ChatColor.translateAlternateColorCodes('&', "&cPrijs:");
    public static String vitamineaprijs = ChatColor.GRAY + "2500";
    public static String vitaminebprijs = ChatColor.GRAY + "5000";

    public static void openVitamineMenu(Player p) {

        Inventory vitam = Bukkit.createInventory(null, 27, vitaminenaam);

        menuItem2(Material.RABBIT_STEW, 0, 1, vitam, 12, vitaminea, vitaminelore, vitamineaprijs);
        menuItem2(Material.RABBIT_STEW, 0, 1, vitam, 14, vitamineb, vitaminelore, vitaminebprijs);

        p.openInventory(vitam);
    }

    public static void menuItem0(Material mat, int data, int amn, Inventory inv, int slot, String name) {
        ItemStack item = new ItemStack(mat, amn, (short) data);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);


        item.setItemMeta(meta);
        inv.setItem(slot, item);
    }


    //API SHIT//

    public static void menuItem1(Material mat, int data, int amn, Inventory inv, int slot, String name, String lore) {
        ItemStack item = new ItemStack(mat, amn, (short) data);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(lore);


        meta.setLore(Lore);
        item.setItemMeta(meta);
        inv.setItem(slot, item);
    }

    public static void menuItem2(Material mat, int data, int amn, Inventory inv, int slot, String name, String lore, String lore2) {
        ItemStack item = new ItemStack(mat, amn, (short) data);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(lore);
        Lore.add(lore2);

        meta.setLore(Lore);
        item.setItemMeta(meta);
        inv.setItem(slot, item);
    }

    public static void menuItem3(Material mat, int data, int amn, Inventory inv, int slot, String name, String lore, String lore2, String lore3) {
        ItemStack item = new ItemStack(mat, amn, (short) data);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(lore);
        Lore.add(lore2);
        Lore.add(lore3);

        meta.setLore(Lore);
        item.setItemMeta(meta);
        inv.setItem(slot, item);
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent e) {

        if (e.getInventory().getName().equals(vitaminenaam)) {

            Player p = (Player) e.getWhoClicked();

            e.setCancelled(true);

            if (e.getSlot() == 12) {

                Main.KoopVitamine(p, "A", 2500);

            }

            if (e.getSlot() == 14) {
                Main.KoopVitamine(p, "B", 5000);


            }

        }

    }


}
