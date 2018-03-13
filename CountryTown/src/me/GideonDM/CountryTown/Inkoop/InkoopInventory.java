package me.GideonDM.CountryTown.Inkoop;

import me.GideonDM.CountryTown.Inkoop.Algemeen.AlgemeenMenu;
import me.GideonDM.CountryTown.Inkoop.Food.FoodInventory;
import me.GideonDM.CountryTown.Inkoop.Kleding.ChestPants.KledingInventory;
import me.GideonDM.CountryTown.Inkoop.Kleding.Hats.HatsInventory;
import me.GideonDM.CountryTown.Inkoop.Kleding.Schoenen.SchoenenInventory;
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


public class InkoopInventory implements Listener {


    public static Inventory inkooph;
    public static String inkoopm = ChatColor.translateAlternateColorCodes('&', "&4&lInkoop menu");
    public static String algemeeninkoop = ChatColor.translateAlternateColorCodes('&', "&7Algemene inkoop");
    public static String kledinginkoop = ChatColor.translateAlternateColorCodes('&', "&7Kleding inkoop");
    public static String schoeneninkoop = ChatColor.translateAlternateColorCodes('&', "&7Schoenen inkoop");
    public static String foodinkoop = ChatColor.translateAlternateColorCodes('&', "&7Voedsel inkoop");
    public static String drankinkoop = ChatColor.translateAlternateColorCodes('&', "&7Drank inkoop");
    public static String vitainkoop = ChatColor.translateAlternateColorCodes('&', "&7Vitamines inkoop");
    public static String hatsinkoop = ChatColor.translateAlternateColorCodes('&', "&7Hoofddeksels inkoop");
    public static String prefix = ChatColor.translateAlternateColorCodes('&', "&4&lInkoop >> &f&c");
    public static String geenpermissie = ChatColor.translateAlternateColorCodes('&', "&f&4Jij hebt deze KVK niet, vraag jouw gemeente om hulp!");
    public static String binnenkort = ChatColor.translateAlternateColorCodes('&', "&f&4Deze catergorie komt binnenkort!");

    public static void openInKoopHoofdMenu(Player p) {

        Inventory inkooph = Bukkit.createInventory(null, 45, inkoopm);


        menuItem1(Material.BOOK_AND_QUILL, 0, 1, inkooph, 9, algemeeninkoop, ChatColor.RED + "Alleen voor de algemene inkopers!");
        menuItem1(Material.LEATHER_CHESTPLATE, 0, 1, inkooph, 11, kledinginkoop, ChatColor.RED + "Alleen voor de kleding inkopers!");
        menuItem1(Material.COOKED_BEEF, 0, 1, inkooph, 13, foodinkoop, ChatColor.RED + "Alleen voor de food inkopers!");
        menuItem1(Material.RABBIT_STEW, 0, 1, inkooph, 15, vitainkoop, ChatColor.RED + "Alleen voor de vitamines inkopers!");
        menuItem1(Material.SKULL_ITEM, 0, 1, inkooph, 17, hatsinkoop, ChatColor.RED + "Alleen voor de hoofddeksels inkopers!");
        menuItem1(Material.LEATHER_BOOTS, 0, 1, inkooph, 29, schoeneninkoop, ChatColor.RED + "Alleen voor de kleding inkopers!");
        menuItem1(Material.POTION, 0, 1, inkooph, 31, drankinkoop, ChatColor.RED + "Alleen voor de drank inkopers!");
        menuItem1(Material.BARRIER, 0, 1, inkooph, 33, binnenkort, ChatColor.RED + "");

        p.openInventory(inkooph);


    }

    //EVENTS//

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

    public void clickInventory(InventoryClickEvent e) {

        if (e.getClickedInventory().getName().equalsIgnoreCase(inkoopm)) {

            Player p = (Player) e.getWhoClicked();

            e.setCancelled(true);

            if (e.getSlot() == 11) {
                if (p.hasPermission("inkoop.kleding")) {

                    KledingInventory.openKledingMenu(p);

                } else {
                    p.sendMessage(prefix + geenpermissie);
                }


            } else if (e.getSlot() == 13) {
                if (p.hasPermission("inkoop.food")) {

                    FoodInventory.openFoodMenu(p);

                } else {
                    p.sendMessage(prefix + geenpermissie);
                }


            } else if (e.getSlot() == 15) {
                if (p.hasPermission("inkoop.vitamines")) {

                    VitamineMenu.openVitamineMenu(p);

                } else {

                    p.sendMessage(prefix + geenpermissie);
                }


            } else if (e.getSlot() == 9) {


                AlgemeenMenu.openVitamineMenu(p);


            } else if (e.getSlot() == 17) {
                if (p.hasPermission("inkoop.hats")) {

                    HatsInventory.openComputerMenu(p);


                } else {

                    p.sendMessage(prefix + geenpermissie);
                }


            } else if (e.getSlot() == 29) {
                if (p.hasPermission("inkoop.kleding")) {

                    SchoenenInventory.openSchoenenMenu(p);

                } else {
                    p.sendMessage(prefix + geenpermissie);
                }


            } else {
                p.closeInventory();
                p.sendMessage(binnenkort);
            }


        }


    }

}
