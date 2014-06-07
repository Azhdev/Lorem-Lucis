package nl.Azhdev.non.client.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import nl.Azhdev.non.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.non.client.models.modelSpinny;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class renderSpinnyBlock extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler{

	private modelSpinny model;
	
	public renderSpinnyBlock(modelSpinny model){
		this.model = model;
	}
	
	private static final ResourceLocation texture = new ResourceLocation("non", "textures/models/spinny.png");
	private static final ResourceLocation texture_new = new ResourceLocation("non", "textures/models/spinny_new.png");
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float var8) {
		TileEntitySpinny spinny = (TileEntitySpinny)var1;
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture_new);
		model.RenderTile(spinny, 0, 0, 0, 0, 0, 0.125F);
		
		GL11.glPopMatrix();
	}

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
}
