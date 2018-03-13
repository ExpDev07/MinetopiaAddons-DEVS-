package me.GideonDM.CountryTown.Safety;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class SafetyJoin implements Listener {

    @EventHandler

    public void onJoin(PlayerJoinEvent e) {

        if (!e.getPlayer().isOp()) {
            if (e.getPlayer().getGameMode() != GameMode.SURVIVAL) {

                e.getPlayer().setGameMode(GameMode.SURVIVAL);
            }

            e.getPlayer().setGameMode(GameMode.SURVIVAL);
        }
    }


    @EventHandler

    public void place(BlockPlaceEvent e) {

        if (!e.getPlayer().isOp()) {

            e.setCancelled(true);
        }


    }


}
