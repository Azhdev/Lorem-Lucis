package nl.Azhdev.client.models;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class modelSpinny extends ModelBase{
	private ArrayList<ModelRenderer> parts;
	private ModelRenderer mainTwistPart;
	
	public modelSpinny(){
		parts = new ArrayList<ModelRenderer>();
		textureHeight = textureWidth = 128;
		
		
		mainTwistPart = new ModelRenderer(this);
		mainTwistPart.addBox(-5, -10, -5, 10, 20, 10);
		mainTwistPart.setRotationPoint(0, 0, 0);
		parts.add(mainTwistPart);
		
			
		
		
	}
	
	public void RenderTile(float rotation, float pos, float a, float b, float c, float mult){
		for(ModelRenderer part : parts){
			part.render(mult);
		}
	}
}
