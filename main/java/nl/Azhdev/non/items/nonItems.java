package nl.Azhdev.non.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import nl.Azhdev.non.blocks.AzhdevBlocks;

public class nonItems {
	public static Item upgrade;
	public static Item staff;
	public static Item debug;
	
	public static void init(){
		upgrade = new Upgrade();
		GameRegistry.registerItem(upgrade, "azhdev.upgrade");
		
		staff = new Staff();
		GameRegistry.registerItem(staff, "azhdev.staff");
		
		debug = new debugItem();
		GameRegistry.registerItem(debug, "debugitem");
	}
}
