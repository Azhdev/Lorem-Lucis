package nl.Azhdev.non.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nl.Azhdev.non.blocks.AzhdevBlocks;

public class debugItem extends Item {
	public debugItem(){
		super();
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_){
		world.setBlock(x, y + 1, z, AzhdevBlocks.spinny);
		return true;
	}
}
