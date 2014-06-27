package nl.Azhdev.non.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class soundHandler {
	
	public static void playSound(String name, World world, Entity ent, float volume, float pitch){
		world.playSoundAtEntity(ent, "non:" + name, volume, pitch);		
	}
}
