package me.rtn.ap;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by George on 05-Apr-17 on Apr at 12:53 AM.
 */
public class SomeGlobeThing implements Listener {

    public void activateParticle(PlayerInteractEvent event){

        Player player = event.getPlayer();
        Location loc = player.getLocation();
        World world = Main.getInstance().getServer().getWorld("world");

        if(event.getAction() == Action.LEFT_CLICK_AIR){
            new BukkitRunnable() {

                double phi = 0;

                @Override
                public void run() {

                    phi *= Math.PI /10;

                    for(double theta = 0; theta <= 2*Math.PI; theta+= Math.PI / 40){
                        double radius = 1.5;
                        double x = radius*Math.cos(theta) * Math.sin(phi);
                        double y = radius*Math.cos(phi) + 1.5;
                        double z = Math.sin(theta) * Math.sin(phi);

                        loc.add(x,y,z);
                        world.spawnParticle(Particle.DRIP_WATER, loc, 0, 0, 0, 0, 1);

                        if(theta > Math.PI){
                            this.cancel();
                        }
                    }
                }
            }.runTaskTimer(Main.getInstance(), 0, 1);
        }
    }
}
