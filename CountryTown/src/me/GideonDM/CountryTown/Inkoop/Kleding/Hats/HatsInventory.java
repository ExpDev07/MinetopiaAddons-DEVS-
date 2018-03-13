package me.GideonDM.CountryTown.Inkoop.Kleding.Hats;


import me.GideonDM.CountryTown.Inkoop.Kleding.ChestPants.KledingEnum;
import me.GideonDM.CountryTown.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class HatsInventory implements Listener {


    public static Inventory computerh;
    public static String inkoop = ChatColor.translateAlternateColorCodes('&', "&cInkoop progamma");
    public static String inkooplore = ChatColor.translateAlternateColorCodes('&', "&cKlik hier om het inkoop progamma te openen!");
    public static String geenpermissie = ChatColor.translateAlternateColorCodes('&', "&f&4Jij hebt deze KVK niet, vraag jouw gemeente om hulp!");


    public static void openComputerMenu(Player p) {

        String computerm = ChatColor.translateAlternateColorCodes('&', "&4&lHats inkoop");

        Inventory computerh = Bukkit.createInventory(null, 27, computerm);


        Pet(computerh, 9, KledingEnum.ZWARTEPET);

        Kleding(computerh, 11, KledingEnum.CASUALMUTS);
        Kleding(computerh, 13, KledingEnum.EARLYGREYMUTS);
        Kleding(computerh, 15, KledingEnum.BOSSBLUEMUTS);
        Kleding(computerh, 17, KledingEnum.RANGEREDMUTS);


        p.openInventory(computerh);


    }

    public static void Kleding(Inventory inv, int slot, KledingEnum kleding) {
        inv.setItem(slot, kleding.getItemStackInventory());
    }

    public static void Pet(Inventory inv, int slot, KledingEnum kleding) {
        inv.setItem(slot, kleding.getItemStackInventoryITEM());
    }

    @EventHandler

    public void clickInventory(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        String computerm = ChatColor.translateAlternateColorCodes('&', "&4&lHats inkoop");

        if (e.getClickedInventory().getName().equalsIgnoreCase(computerm)) {


            e.setCancelled(true);

            if (p.hasPermission("inkoop.hats") || p.isOp()) {


                if (e.getSlot() == 9) {

                    Main.KoopHeads(p, KledingEnum.ZWARTEPET);

                }

                if (e.getSlot() == 11) {

                    Main.KoopKleding(p, KledingEnum.CASUALMUTS);

                }

                if (e.getSlot() == 13) {

                    Main.KoopKleding(p, KledingEnum.EARLYGREYMUTS);

                }

                if (e.getSlot() == 15) {

                    Main.KoopKleding(p, KledingEnum.BOSSBLUEMUTS);

                }

                if (e.getSlot() == 17) {

                    Main.KoopKleding(p, KledingEnum.RANGEREDMUTS);

                }

            } else {
                p.sendMessage(geenpermissie);
            }
        }


    }
}



