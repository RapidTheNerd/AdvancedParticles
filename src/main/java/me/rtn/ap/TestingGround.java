package me.rtn.ap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by George on 04-Apr-17 on Apr at 2:54 PM.
 */
public class TestingGround implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        final Player player = event.getPlayer();
    }
}
