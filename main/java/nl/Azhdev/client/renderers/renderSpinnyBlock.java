package nl.Azhdev.client.renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import nl.Azhdev.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.client.models.modelSpinny;

import org.lwjgl.opengl.GL11;

public class renderSpinnyBlock extends TileEntitySpecialRenderer{

	private modelSpinny model;
	
	public renderSpinnyBlock(modelSpinny model){
		this.model = model;
	}
	
	private static final ResourceLocation texture = new ResourceLocation("non", "textures/models/spinny.png");
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float var8) {
		TileEntitySpinny spinny = (TileEntitySpinny)var1;
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		model.RenderTile(spinny, 0, 0, 0, 0, 0, 0.125F);
		
		GL11.glPopMatrix();
	}

}
