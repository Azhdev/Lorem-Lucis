package nl.Azhdev.LL.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import nl.Azhdev.LL.blocks.TileEntities.TileEntitySpinny;
import cpw.mods.fml.common.registry.GameRegistry;

public class AzhdevBlocks {
	public static Block spinny;
	public static Block invisiBlock;
	
	public static void initBlocks(){
		spinny = new blockSpinny(Material.iron);
		GameRegistry.registerBlock(spinny, "spinny");
		
		invisiBlock = new invBlock(Material.iron);
		GameRegistry.registerBlock(invisiBlock, "invisiBlock");
		
	}
	
	public static void intTileEntities(){
		GameRegistry.registerTileEntity(TileEntitySpinny.class, "spinny");
	}
}
