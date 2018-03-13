package me.GideonDM.CountryTown.Inkoop.Food;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public enum FoodEnum {

    CARROT("Wortel", 320, Material.CARROT_ITEM, 0),
    APPEL("Appel", 640, Material.APPLE, 0),
    BROOD("Brood", 640, Material.BREAD, 0),
    RABBIT("Spies", 960, Material.COOKED_RABBIT, 0),
    PORKCHOP("Bacon", 960, Material.GRILLED_PORK, 0),
    POTATO("Friet", 960, Material.BAKED_POTATO, 0),
    FISH("Kibbeling", 1250, Material.COOKED_FISH, 0),
    FISH1("Zalm", 1600, Material.COOKED_FISH, 1),
    MUTTON("Hotdog", 1260, Material.COOKED_MUTTON, 0),
    MELON("Meloen", 1940, Material.MELON, 0),
    STEAK("Hamburger", 1920, Material.COOKED_BEEF, 0),
    CHICKEN("Kippenpoot", 960, Material.COOKED_CHICKEN, 0);


    String naam;
    int Prijs;
    Material material;
    int ID;

    FoodEnum(String naam, int prijs, Material material, int ID) {

        this.naam = naam;
        this.Prijs = prijs;
        this.material = material;
        this.ID = ID;


    }

    public String getPrijs() {

        return ChatColor.GRAY + " " + Prijs;
    }

    public String getName() {

        return ChatColor.RED + "" + ChatColor.ITALIC + naam;
    }

    public String getRawName() {

        return naam;
    }

    public Material getMaterial() {

        return material;
    }

    public int getPrijsInt() {
        return Prijs;
    }

    public int getID() {

        return ID;
    }
}
