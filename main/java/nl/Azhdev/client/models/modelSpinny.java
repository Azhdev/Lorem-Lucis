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
		
		ModelRenderer side1 = new ModelRenderer(this, 0, 30);
		side1.addBox(-5, -2.5F, 5, 10, 5, 2);
		side1.setRotationPoint(0, 0, 0);
		mainTwistPart.addChild(side1);
		
		ModelRenderer side2 = new ModelRenderer(this, 0, 37);
		side2.addBox(-5, -2.5F, 5, 10, 5, 2);
		side2.rotateAngleY = (float)(Math.PI * 2);
		side2.setRotationPoint(0, 0, 0);
		mainTwistPart.addChild(side2);
		
		ModelRenderer back = new ModelRenderer(this, 24, 30);
		back.addBox(-7, -2.5F, 5, 14, 5, 2);
		back.setRotationPoint(0, 0, 0);
		back.rotateAngleY = (float)(Math.PI * 1.5F);
		mainTwistPart.addChild(back);
	}
	
	public void RenderTile(float rotation, float pos, float a, float b, float c, float mult){
		for(ModelRenderer part : parts){
			part.render(mult);
		}
	}
}
