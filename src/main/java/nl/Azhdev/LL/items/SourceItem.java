package nl.Azhdev.LL.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nl.Azhdev.LL.creativetab.CreativeTab;
import nl.Azhdev.LL.reference.Reference;

public class SourceItem extends Item
{
    public SourceItem()
    {
        super();
        this.setCreativeTab(CreativeTab.LL_TAB);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }


    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

}