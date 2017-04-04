package me.rtn.ap.reflection;

import me.rtn.ap.Main;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by George on 05-Apr-17 on Apr at 12:36 AM.
 */
public class ParticleReflection {

    public ParticleReflection() throws ClassNotFoundException, NoSuchMethodException {
    }

    private Class<?> getNMSClass(String nmsClass) throws ClassNotFoundException{
        String ver = Main.getInstance().getServer().getClass().getPackage().getName().replace(".", "")
                .split(",")[3] + ".";
        String name = "net.minecraft.server" + ver + nmsClass.toString();

        return Class.forName(name);
    }

    private Object getConnection(Player player) throws SecurityException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Method getHandle = player.getClass().getMethod("getHandle");
        Object nmsPlayer = getHandle.invoke(player);
        Field cField = nmsPlayer.getClass().getField("playerConnection");
        Object con = cField.get(nmsPlayer);

        return con;
    }
    public void sendParticle(Player player, String particle, float x, float y, float z, float xOffset, float zOffset,
                             float yOffzet, float data, int amount){

    }

    Class<?> packetClass = this.getNMSClass("PacketPlayOutWorldParticles");
    Constructor<?> packetConstructor = packetClass.getConstructor(String.class, float.class,
            float.class, float.class, float.class, float.class, float.class, float.class, int.class);
}
