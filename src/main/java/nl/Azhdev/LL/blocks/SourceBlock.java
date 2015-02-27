package nl.Azhdev.LL.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import nl.Azhdev.LL.creativetab.CreativeTab;

public class SourceBlock extends Block {

    public SourceBlock(Material material) {

        super(material);
        this.setCreativeTab(CreativeTab.LL_TAB);

    }

    public SourceBlock() {
        this(Material.rock);
    }
}
