package me.GideonDM.CountryTown.Inkoop.Algemeen;

import org.bukkit.Material;

public enum AlgemeenEnum {

    BOOKANDQUILL("Boek", Material.BOOK_AND_QUILL, 640);


    String name;
    Material material;
    int prijs;


    AlgemeenEnum(String name, Material material, int prijs) {


        this.name = name;
        this.material = material;
        this.prijs = prijs;
    }


    public String getName() {

        return name;

    }

    public Material getMaterial() {
        return material;
    }

    public int getPrijs() {
        return prijs;
    }
}
