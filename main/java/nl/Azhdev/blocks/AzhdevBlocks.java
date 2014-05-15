package nl.Azhdev.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class AzhdevBlocks {
	public static Block spinny;
	
	public static void initBlocks(){
		spinny = new blockSpinny(Material.iron);
		GameRegistry.registerBlock(spinny, "spinny");
	}
}
