package me.rtn.ap;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

/**
 * Created by George on 05-Apr-17 on Apr at 12:53 AM.
 */
public class SomeGlobeThing implements Listener {

    private void activateParticle(PlayerInteractEvent event){

        Player player = event.getPlayer();
        Location loc = player.getLocation();
        Vector vec  = loc.getDirection().normalize();
        World world = Main.getInstance().getServer().getWorld("world");

        if(event.getAction() == Action.LEFT_CLICK_AIR){
            new BukkitRunnable() {

                double phi = 0;
                double theta = 0;

                @Override
                public void run() {

                    phi *= Math.PI /10;

                    world.spawnParticle(Particle.DRIP_LAVA, loc, 0, 0, 0, 0, 1);
                    
                }
            }.runTaskTimer(Main.getInstance(), 0, 1);
        }
    }
}
