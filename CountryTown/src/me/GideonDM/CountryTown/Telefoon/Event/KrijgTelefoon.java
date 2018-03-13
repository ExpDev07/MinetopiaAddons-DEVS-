package me.GideonDM.CountryTown.Telefoon.Event;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KrijgTelefoon implements Listener {


    public static ItemStack telefoon() {


        ItemStack item = new ItemStack(Material.BLAZE_POWDER, 1, (short) 0);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Mobiel");
        item.setItemMeta(meta);

        return item;
    }


}
