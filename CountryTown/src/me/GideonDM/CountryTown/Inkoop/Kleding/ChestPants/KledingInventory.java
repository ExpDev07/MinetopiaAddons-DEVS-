package me.GideonDM.CountryTown.Inkoop.Kleding.ChestPants;

import me.GideonDM.CountryTown.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class KledingInventory implements Listener {


    public static Inventory kledingmenu;
    public static String kledingm = ChatColor.translateAlternateColorCodes('&', "&4&lKleding inkoop menu");


    public static void openKledingMenu(Player p) {

        Inventory kledingmenu = Bukkit.createInventory(null, 18, kledingm);

        // CHESTPLATES
        Kleding(kledingmenu, 1, KledingEnum.RANGEREDCHEST);
        Kleding(kledingmenu, 3, KledingEnum.BOSSBLUECHEST);
        Kleding(kledingmenu, 5, KledingEnum.EARLYGREYCHEST);
        Kleding(kledingmenu, 7, KledingEnum.CASSCHEST);

        // LEGGINGS

        Kleding(kledingmenu, 10, KledingEnum.RANGEREDBROEK);
        Kleding(kledingmenu, 12, KledingEnum.BOSSBLUEBROEK);
        Kleding(kledingmenu, 14, KledingEnum.EARLYGREYBROEK);
        Kleding(kledingmenu, 16, KledingEnum.CASSBROEK);


        p.openInventory(kledingmenu);
    }

    public static void Kleding(Inventory inv, int slot, KledingEnum kleding) {
        inv.setItem(slot, kleding.getItemStackInventory());
    }


    @EventHandler
    public void inventoryClick(InventoryClickEvent e) {

        if (e.getInventory().getName().equals(kledingm)) {

            Player p = (Player) e.getWhoClicked();

            e.setCancelled(true);

            if (e.getSlot() == 1) {

                Main.KoopKleding(p, KledingEnum.RANGEREDCHEST);
            }

            if (e.getSlot() == 3) {

                Main.KoopKleding(p, KledingEnum.BOSSBLUECHEST);

            }

            if (e.getSlot() == 5) {

                Main.KoopKleding(p, KledingEnum.EARLYGREYCHEST);
            }

            if (e.getSlot() == 7) {

                Main.KoopKleding(p, KledingEnum.CASSCHEST);
            }

            if (e.getSlot() == 10) {

                Main.KoopKleding(p, KledingEnum.RANGEREDBROEK);

            }

            if (e.getSlot() == 12) {

                Main.KoopKleding(p, KledingEnum.BOSSBLUEBROEK);

            }

            if (e.getSlot() == 14) {

                Main.KoopKleding(p, KledingEnum.EARLYGREYBROEK);

            }

            if (e.getSlot() == 16) {

                Main.KoopKleding(p, KledingEnum.CASSBROEK);

            }

        }
    }
}
