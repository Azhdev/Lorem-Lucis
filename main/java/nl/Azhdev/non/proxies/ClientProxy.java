package nl.Azhdev.non.proxies;

import nl.Azhdev.non.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.non.client.models.modelSpinny;
import nl.Azhdev.non.client.renderers.renderSpinnyBlock;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends commonProxy{
	
	@Override
	public void initRendering(){
		modelSpinny model = new modelSpinny();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpinny.class, new renderSpinnyBlock(model));
		
	}
}
