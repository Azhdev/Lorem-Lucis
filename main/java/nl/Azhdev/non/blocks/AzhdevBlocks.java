package nl.Azhdev.non.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import nl.Azhdev.non.blocks.TileEntities.TileEntitySpinny;
import cpw.mods.fml.common.registry.GameRegistry;

public class AzhdevBlocks {
	public static Block spinny;
	
	public static void initBlocks(){
		spinny = new blockSpinny(Material.iron);
		GameRegistry.registerBlock(spinny, "spinny");
		
	
	}
	
	public static void intTileEntities(){
		GameRegistry.registerTileEntity(TileEntitySpinny.class, "spinny");
	}
}
