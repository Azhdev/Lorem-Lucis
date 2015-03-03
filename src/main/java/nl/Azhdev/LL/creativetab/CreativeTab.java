package nl.Azhdev.LL.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nl.Azhdev.LL.init.LLBlocks;
import nl.Azhdev.LL.reference.Reference;

public class CreativeTab
{
    public static final CreativeTabs LL_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(LLBlocks.Spinny);
        }

    };
}