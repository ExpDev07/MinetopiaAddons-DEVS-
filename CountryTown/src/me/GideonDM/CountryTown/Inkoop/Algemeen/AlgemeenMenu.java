package me.GideonDM.CountryTown.Inkoop.Algemeen;

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

public class AlgemeenMenu implements Listener {


    public static Inventory algm;
    public static String prijs = ChatColor.RED + "Prijs:";

    public static String algemeennaam = ChatColor.translateAlternateColorCodes('&', "&4&lVitamine inkoop menu");


    public static void openVitamineMenu(Player p) {

        Inventory algm = Bukkit.createInventory(null, 27, algemeennaam);

        foodItem(AlgemeenEnum.BOOKANDQUILL.getMaterial(), 0, algm, 13, AlgemeenEnum.BOOKANDQUILL.getName(), AlgemeenEnum.BOOKANDQUILL.getPrijs());


        p.openInventory(algm);
    }

    public static void foodItem(Material mat, int data, Inventory inv, int slot, String name, int Prijs) {
        ItemStack item = new ItemStack(mat, 64, (short) data);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + name);
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(prijs);
        Lore.add(ChatColor.GRAY + "" + Prijs);


        meta.setLore(Lore);
        item.setItemMeta(meta);
        inv.setItem(slot, item);
    }


    //API SHIT//

    public static void menuItem0(Material mat, int data, int amn, Inventory inv, int slot, String name) {
        ItemStack item = new ItemStack(mat, amn, (short) data);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);


        item.setItemMeta(meta);
        inv.setItem(slot, item);
    }

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

        if (e.getInventory().getName().equals(algemeennaam)) {

            Player p = (Player) e.getWhoClicked();

            e.setCancelled(true);

            if (e.getSlot() == 13) {

                Main.KoopAlgemeen(p, AlgemeenEnum.BOOKANDQUILL);

            }

        }

    }


}
