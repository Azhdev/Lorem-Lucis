package nl.Azhdev.LL.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nl.Azhdev.LL.init.LLBlocks;
import nl.Azhdev.LL.init.LLItems;
import nl.Azhdev.LL.reference.Reference;
import sun.org.mozilla.javascript.internal.ast.Block;

public class CreativeTab
{
    public static final CreativeTabs LL_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        public Item getTabIconItem()
        {
            return LLItems.Upgrade;
        } //return Item.getItemFromBlock(LLBlocks.spinny);

    };
}