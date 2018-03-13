package me.GideonDM.CountryTown.Computer;

import me.GideonDM.CountryTown.Inkoop.InkoopInventory;
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

public class ComputerInventory implements Listener {


    public static Inventory computerh;
    public static String inkoop = ChatColor.translateAlternateColorCodes('&', "&cInkoop progamma");
    public static String inkooplore = ChatColor.translateAlternateColorCodes('&', "&cKlik hier om het inkoop progamma te openen!");
    public static String lening = ChatColor.translateAlternateColorCodes('&', "&cLening progamma");
    public static String leninglore = ChatColor.translateAlternateColorCodes('&', "&cKlik hier om het lening progamma te openen!");
    public static String geenpermissie = ChatColor.translateAlternateColorCodes('&', "&f&4Jij hebt deze KVK niet, vraag jouw gemeente om hulp!");


    public static void openComputerMenu(Player p) {

        String computerm = ChatColor.translateAlternateColorCodes('&', "&4&lComputer van " + p.getName());

        Inventory computerh = Bukkit.createInventory(null, 27, computerm);


        menuItem1(Material.COOKED_BEEF, 0, 1, computerh, 12, inkoop, inkooplore);
        menuItem1(Material.REDSTONE, 0, 1, computerh, 14, lening, leninglore);


        p.openInventory(computerh);


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

    @EventHandler

    public void clickInventory(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        String computerm = ChatColor.translateAlternateColorCodes('&', "&4&lComputer van " + p.getName());

        if (e.getClickedInventory().getName().equalsIgnoreCase(computerm)) {


            e.setCancelled(true);

            if (e.getSlot() == 12) {
                if (p.hasPermission("inkoop.kleding") ||
                        p.hasPermission("inkoop.vitamines") || p.hasPermission("inkoop.food") ||
                        p.hasPermission("inkoop.drank") || p.hasPermission("inkoop.hats") || p.isOp()) {


                    InkoopInventory.openInKoopHoofdMenu(p);

                } else {
                    p.closeInventory();
                    p.sendMessage(geenpermissie);
                }
            }

            if (e.getSlot() == 14) {

                LeningProgamma.openComputerMenu(p);

            }

        }
    }
}
