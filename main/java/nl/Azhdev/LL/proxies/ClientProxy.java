package nl.Azhdev.LL.proxies;

import nl.Azhdev.LL.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.LL.client.models.modelSpinny;
import nl.Azhdev.LL.client.renderers.renderSpinnyBlock;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends commonProxy{
	
	@Override
	public void initRendering(){
		modelSpinny model = new modelSpinny();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpinny.class, new renderSpinnyBlock(model, false));
	}
}
