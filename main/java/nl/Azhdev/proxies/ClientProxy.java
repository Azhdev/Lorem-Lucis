package nl.Azhdev.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import nl.Azhdev.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.client.models.modelSpinny;
import nl.Azhdev.client.renderers.renderSpinnyBlock;

public class ClientProxy extends commonProxy{
	
	@Override
	public void initRendering(){
		modelSpinny model = new modelSpinny();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpinny.class, new renderSpinnyBlock(model));
	}
}
