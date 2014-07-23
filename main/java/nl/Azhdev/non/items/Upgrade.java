package nl.Azhdev.non.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Upgrade extends Item {
	public Upgrade(){
		super();
		setUnlocalizedName("azhdev.upgrade");
		setCreativeTab(CreativeTabs.tabMisc);
		setTextureName("non:upgrade");
	}
}
