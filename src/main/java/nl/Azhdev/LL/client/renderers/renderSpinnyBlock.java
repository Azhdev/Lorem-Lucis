package nl.Azhdev.LL.client.renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import nl.Azhdev.LL.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.LL.client.models.modelSpinny;

import org.lwjgl.opengl.GL11;

public class renderSpinnyBlock extends TileEntitySpecialRenderer{

	private modelSpinny model;
	
	public renderSpinnyBlock(modelSpinny model, boolean d){
		this.model = model;
	}
	
	private static ResourceLocation texture = new ResourceLocation("ll", "textures/blocks/spinny.png");

	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float var8, int par6) {
		TileEntitySpinny spinny = (TileEntitySpinny)var1;
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		model.RenderTile(spinny, 0, 0, 0, 0, 0, 0.125F);
		
		GL11.glPopMatrix();
	}
}