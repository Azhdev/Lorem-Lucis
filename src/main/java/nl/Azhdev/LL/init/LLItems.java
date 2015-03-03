package nl.Azhdev.LL.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nl.Azhdev.LL.items.ItemStaff;
import nl.Azhdev.LL.items.ItemUpgrade;
import nl.Azhdev.LL.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class LLItems {

    public static Item Upgrade;
    public static Item Staff;

    public static void init() {
        Upgrade = new ItemUpgrade();
        GameRegistry.registerItem(Upgrade, "upgrade");

        Staff = new ItemStaff();
        GameRegistry.registerItem(Staff, "staff");

    }
    @SideOnly(Side.CLIENT)
    public static void registerRender()
    {
        registerRenders(Upgrade);
        registerRenders(Staff);
    }

    public static void registerRenders(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + item.getUnlocalizedName().toLowerCase().substring(5), "inventory"));
    }
}