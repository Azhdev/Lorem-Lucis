package nl.Azhdev.LL.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.Azhdev.LL.blocks.blockSpinny;
import nl.Azhdev.LL.blocks.invBlock;
import nl.Azhdev.LL.blocks.TileEntities.TileEntitySpinny;

public class LLBlocks {
    public static Block Spinny;
    public static Block invisiBlock;

    public static void initBlocks(){
        Spinny = new blockSpinny(Material.iron);
        GameRegistry.registerBlock(Spinny, "spinny");

        invisiBlock = new invBlock(Material.iron);
        GameRegistry.registerBlock(invisiBlock, "invisiBlock");

    }

    public static void intTileEntities(){
        GameRegistry.registerTileEntity(TileEntitySpinny.class, "spinny");
    }
}