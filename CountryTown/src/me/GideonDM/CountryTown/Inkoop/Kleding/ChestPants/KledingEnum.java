package me.GideonDM.CountryTown.Inkoop.Kleding.ChestPants;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;

public enum KledingEnum {

    //CHESTPLATES//
    RANGEREDCHEST("Range red", ChatColor.RED, 255, 8, 0, Material.LEATHER_CHESTPLATE, true, "10-01", 150000),
    BOSSBLUECHEST("Boss blue", ChatColor.BLUE, 0, 110, 255, Material.LEATHER_CHESTPLATE, true, "10-01", 60000),
    EARLYGREYCHEST("Early grey", ChatColor.GRAY, 144, 139, 139, Material.LEATHER_CHESTPLATE, false, "10-01", 30000),
    CASSCHEST("Casual", ChatColor.WHITE, 160, 101, 64, Material.LEATHER_CHESTPLATE, false, "10-01", 5000),

    //BROEKEN

    RANGEREDBROEK("Range red", ChatColor.RED, 255, 8, 0, Material.LEATHER_LEGGINGS, true, "10-01", 150000),
    BOSSBLUEBROEK("Boss blue", ChatColor.BLUE, 0, 110, 255, Material.LEATHER_LEGGINGS, true, "10-01", 60000),
    EARLYGREYBROEK("Early grey", ChatColor.GRAY, 144, 139, 139, Material.LEATHER_LEGGINGS, false, "10-01", 30000),
    CASSBROEK("Casual", ChatColor.WHITE, 160, 101, 64, Material.LEATHER_LEGGINGS, false, "10-01", 5000),

    //SCHOENEN//

    RANGEREDSCHOENEN("Range red", ChatColor.RED, 255, 8, 0, Material.LEATHER_BOOTS, true, "10-01", 112500),
    BOSSBLUESCHOENEN("Boss blue", ChatColor.BLUE, 0, 110, 255, Material.LEATHER_BOOTS, true, "10-01", 45000),
    EARLYGREYSCHOENEN("Early grey", ChatColor.GRAY, 144, 139, 139, Material.LEATHER_BOOTS, false, "10-01", 22500),
    CASSSCHOENEN("Casual", ChatColor.WHITE, 160, 101, 64, Material.LEATHER_BOOTS, false, "10-01", 3750),

    //HATS//
    RANGEREDMUTS("Range red", ChatColor.RED, 255, 8, 0, Material.LEATHER_HELMET, false, "10-01", 75000),
    ZWARTEPET("Zwarte pet", ChatColor.WHITE, 160, 101, 64, Material.LAPIS_ORE, false, "10-01", 7500),
    EARLYGREYMUTS("Early grey", ChatColor.GRAY, 144, 139, 139, Material.LEATHER_HELMET, false, "10-01", 15000),
    BOSSBLUEMUTS("Boss blue", ChatColor.BLUE, 0, 110, 255, Material.LEATHER_HELMET, false, "10-01", 30000),
    CASUALMUTS("Casual", ChatColor.WHITE, 160, 101, 64, Material.LEATHER_HELMET, false, "10-01", 2500);

    String name;
    int red;
    int green;
    int blue;
    Material material;
    boolean enchant;
    String seizoen;
    int prijs;
    ChatColor namekleur;

    KledingEnum(String name, ChatColor namekleur, int red, int green, int blue, Material material, boolean enchant, String seizoen, int prijs) {

        this.name = name;
        this.namekleur = namekleur;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.material = material;
        this.enchant = enchant;
        this.seizoen = seizoen;
        this.prijs = prijs;

    }


    public ItemStack getItemStack() {

        ItemStack lhelmet = new ItemStack(getMaterial(), 1);
        LeatherArmorMeta lam = (LeatherArmorMeta) lhelmet.getItemMeta();
        lam.setColor(Color.fromRGB(getRed(), getGreen(), getBlue()));
        lam.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        lam.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lam.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        if (isEnchant()) {
            lam.addEnchant(Enchantment.PROTECTION_FIRE, 1, true);

        }

        lam.setDisplayName(namekleur + "" + ChatColor.ITALIC + name);


        ArrayList<String> Lore = new ArrayList<String>();

        Lore.add("Seizoen " + seizoen);

        lam.setLore(Lore);

        lhelmet.setItemMeta(lam);


        return (ItemStack) lam;
    }

    public ItemStack getItemStackInventory() {

        ItemStack lhelmet = new ItemStack(getMaterial(), 1);
        LeatherArmorMeta lam = (LeatherArmorMeta) lhelmet.getItemMeta();
        lam.setColor(Color.fromRGB(getRed(), getGreen(), getBlue()));
        lam.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        lam.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lam.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        if (isEnchant()) {
            lam.addEnchant(Enchantment.PROTECTION_FIRE, 1, true);

        }

        lam.setDisplayName(namekleur + "" + ChatColor.ITALIC + name);


        ArrayList<String> Lore = new ArrayList<String>();

        Lore.add("Seizoen " + seizoen);

        Lore.add(ChatColor.translateAlternateColorCodes('&', "&cPrijs:"));
        Lore.add(" ");
        Lore.add(ChatColor.GRAY + "" + prijs);

        lam.setLore(Lore);

        lhelmet.setItemMeta(lam);


        return lhelmet;
    }

    public ItemStack getItemStackITEM() {

        ItemStack lhelmet = new ItemStack(getMaterial(), 1);
        ItemMeta lam = lhelmet.getItemMeta();
        lam.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        lam.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lam.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        if (isEnchant()) {
            lam.addEnchant(Enchantment.PROTECTION_FIRE, 1, true);

        }

        lam.setDisplayName(namekleur + "" + ChatColor.ITALIC + name);


        ArrayList<String> Lore = new ArrayList<String>();

        Lore.add("Seizoen " + seizoen);

        lam.setLore(Lore);

        lhelmet.setItemMeta(lam);


        return (ItemStack) lam;
    }

    public ItemStack getItemStackInventoryITEM() {

        ItemStack lhelmet = new ItemStack(getMaterial(), 1);
        ItemMeta lam = lhelmet.getItemMeta();
        lam.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        lam.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lam.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        if (isEnchant()) {
            lam.addEnchant(Enchantment.PROTECTION_FIRE, 1, true);

        }

        lam.setDisplayName(namekleur + "" + ChatColor.ITALIC + name);


        ArrayList<String> Lore = new ArrayList<String>();

        Lore.add("Seizoen " + seizoen);

        Lore.add(ChatColor.translateAlternateColorCodes('&', "&cPrijs:"));
        Lore.add(" ");
        Lore.add(ChatColor.GRAY + "" + prijs);

        lam.setLore(Lore);

        lhelmet.setItemMeta(lam);


        return lhelmet;
    }

    public int getRed() {

        return red;
    }

    public int getGreen() {

        return green;
    }

    public int getBlue() {

        return blue;
    }

    public Material getMaterial() {

        return material;
    }

    public boolean isEnchant() {
        return enchant;
    }

    public ChatColor namekleur() {


        return namekleur;
    }

    public int getPrijs() {

        return prijs;
    }


    public String getName() {

        return namekleur + name;
    }

    public String getRawName() {

        return name;
    }

    public ChatColor getChatColor() {

        return namekleur;
    }

    public String getSeizoen() {

        return seizoen;
    }
}
