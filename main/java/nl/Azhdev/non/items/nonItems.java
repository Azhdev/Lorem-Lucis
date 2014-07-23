package nl.Azhdev.non.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class nonItems {
	public static Item upgrade;
	
	public static void init(){
		upgrade = new Upgrade();
		GameRegistry.registerItem(upgrade, "azhdev.upgrade");
	}
}
