package nl.Azhdev.client.renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import nl.Azhdev.client.models.modelSpinny;

import org.lwjgl.opengl.GL11;

public class renderSpinnyItem implements IItemRenderer{

	private modelSpinny model;
	
	public renderSpinnyItem(modelSpinny model){
		this.model = model;
	}
	
	private static final ResourceLocation texture = new ResourceLocation("non", "textures/models/spinny.png");
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		GL11.glPushMatrix();
		
		switch(type){
		case EQUIPPED:
			GL11.glTranslatef(0.4F, 1, 0.6F);
			break;
		case EQUIPPED_FIRST_PERSON:
			GL11.glTranslatef(0, 0.7F, 0.5F);
			GL11.glRotatef(180, 0, 1, 0);
			break;
		default:
			
		}
		
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		model.render(null, 0, 0, 0, 0, 0, 0.0625F);
		
		GL11.glPopMatrix();
	}

}
