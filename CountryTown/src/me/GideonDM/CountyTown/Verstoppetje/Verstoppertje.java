package me.GideonDM.CountyTown.Verstoppetje;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class Verstoppertje {


    public static HashMap<Player, Boolean> ingame = new HashMap<Player, Boolean>();
    public static boolean gameStarted = false;
    public static boolean preGame = false;


    public static void addPlayer(Player p) {

        if (preGame && !gameStarted) {


        }

    }
}
