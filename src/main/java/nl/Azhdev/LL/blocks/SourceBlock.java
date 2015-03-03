package nl.Azhdev.LL.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import nl.Azhdev.LL.creativetab.CreativeTab;
import nl.Azhdev.LL.reference.Reference;

public class SourceBlock extends Block {

    public SourceBlock(Material material) {

        super(material);
        this.setCreativeTab(CreativeTab.LL_TAB);

    }

    public SourceBlock() {
        this(Material.rock);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }


    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
