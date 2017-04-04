package me.rtn.ap;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

/**
 * Created by George on 04-Apr-17 on Apr at 4:00 PM.
 */
public class DirectionalParticles implements Listener {

    private boolean active = false;
    private int uses = 0;

    @EventHandler
    public void activeParticle(PlayerInteractEvent event){

        Player player = event.getPlayer();
        Location loc = player.getLocation();
        Vector vec = loc.getDirection().normalize();

        if(event.getAction() == Action.LEFT_CLICK_AIR){
            new BukkitRunnable(){
                double t = 0;

                @Override
                public void run() {

                    double x = vec.getX() * t;
                    double y = vec.getY() * t;
                    double z = vec.getZ() * t;

                    loc.add(x,y,z);

                    loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc, 0, 0, 0, 0,1);
                    loc.subtract(x,y,z);
                    if(t  > 30){
                        this.cancel();
                    }
                }
            }.runTaskTimer(Main.getInstance(), 0, 1);
        }
    }
}
