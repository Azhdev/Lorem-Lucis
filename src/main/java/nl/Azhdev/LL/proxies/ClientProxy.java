package nl.Azhdev.LL.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import nl.Azhdev.LL.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.LL.client.models.modelSpinny;
import nl.Azhdev.LL.client.renderers.renderSpinnyBlock;
import nl.Azhdev.LL.init.LLBlocks;
import nl.Azhdev.LL.init.LLItems;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void initRendering(){
		modelSpinny model = new modelSpinny();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpinny.class, new renderSpinnyBlock(model, false));
	}

    @Override
    	public void registerRenders()
    	{
            LLItems.registerRender();
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(LLBlocks.Spinny), 0, new ModelResourceLocation("ll:spinny", "inventory"));
        }
}
