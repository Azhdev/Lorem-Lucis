package nl.Azhdev.client.renderers;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import nl.Azhdev.client.models.modelSpinny;

public class renderSpinnyBlock extends TileEntitySpecialRenderer{

	private modelSpinny model;
	
	public renderSpinnyBlock(modelSpinny model){
		this.model = model;
	}
	
	private static final ResourceLocation texture = new ResourceLocation("non", "textures/models/spinny.png");
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float var8) {
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.5F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		model.RenderTile(0, 0, 0, 0, 0, 0.0625F);
		
		GL11.glPopMatrix();
	}

}
