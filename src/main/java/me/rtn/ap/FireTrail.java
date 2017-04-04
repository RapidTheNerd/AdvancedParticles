package me.rtn.ap;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by George on 04-Apr-17 on Apr at 2:54 PM.
 */
public class FireTrail implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Location loc = player.getLocation();


        if(event.getAction() == Action.LEFT_CLICK_AIR){
            new BukkitRunnable(){
                public void run(){

                    double t = 0;
                    double r = 2;
                    t = t + Math.PI/16;

                    double x = r*Math.cos(t);
                    double y = 0.5*t;
                    double z = r*Math.sin(t);

                    loc.add(x,y,z);

                    loc.getWorld().spawnParticle(Particle.FLAME, loc, 0,0,0,0,1);
                    loc.subtract(x,y,z);
                    if(t > Math.PI * 8){
                        this.cancel();
                    }
                }
            }.runTaskTimer(Main.getInstance(), 0, 1);
        }
    }
}
