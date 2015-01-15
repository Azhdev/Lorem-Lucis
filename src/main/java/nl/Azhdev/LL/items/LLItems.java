package nl.Azhdev.LL.items;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class LLItems {
	public static Item upgrade;
	public static Item staff;
	public static Item debug;
	
	public static void init(){
		upgrade = new Upgrade();
		GameRegistry.registerItem(upgrade, "azhdev.upgrade");
		
		staff = new Staff();
		GameRegistry.registerItem(staff, "azhdev.staff");
	}
}
