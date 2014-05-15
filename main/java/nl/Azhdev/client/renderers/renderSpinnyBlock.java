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
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		GL11.glPushMatrix();
		
		GL11.glTranslatef(-1F, -1F, 1F);
		GL11.glScalef(0, 0, 0);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		model.RenderTile(0, 0, 0, 0, 0, 0.0625F);
		
		GL11.glPopMatrix();
	}

}
