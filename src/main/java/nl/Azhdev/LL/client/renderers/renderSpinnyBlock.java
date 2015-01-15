package nl.Azhdev.LL.client.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import nl.Azhdev.LL.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.LL.client.models.modelSpinny;

import org.lwjgl.opengl.GL11;

public class renderSpinnyBlock extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler{

	private static modelSpinny model;
	
	public renderSpinnyBlock(modelSpinny model, boolean d){
		this.model = model;
	}
	
	private static ResourceLocation texture = new ResourceLocation("ll", "textures/models/spinny.png");
	private static final ResourceLocation texture_new = new ResourceLocation("LL", "textures/models/spinny_new2.png");
	/**
	public static void refresh(TileEntity ent, int x, int y, int z){
		TileEntitySpinny spinny = (TileEntitySpinny)ent;
		if(spinny.shine){
			texture = texture_new;
		}else{
			texture = new ResourceLocation("LL", "textures/models/spinny.png");
		}
		renderTileEntity(ent, x, y, z);
	}
	
	public static void renderTileEntity(TileEntity var1, double x, double y, double z) {
		TileEntitySpinny spinny = (TileEntitySpinny)var1;
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		if(spinny.shine){
			Minecraft.getMinecraft().getTextureManager().bindTexture(texture_new);
		}else{
			Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		}
		model.RenderTile(spinny, 0, 0, 0, 0, 0, 0.125F);
		
		GL11.glPopMatrix();
	}*/

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		
		GL11.glPushMatrix();
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		model.renderInv(0.0625F);
		
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return -1;
	}

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
