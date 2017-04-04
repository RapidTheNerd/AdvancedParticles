package me.rtn.ap;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.stream.Stream;

/**
 * Created by George on 04-Apr-17 on Apr at 2:52 PM.
 */
public class Main extends JavaPlugin implements Listener {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable(){

        instance = this;
        Stream.of(
                new DirectionalParticles()
        ).forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
    }

    @Override
    public void onDisable(){

    }
}
