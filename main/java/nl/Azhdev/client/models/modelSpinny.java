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
		side2.rotateAngleY = (float)(Math.PI);
		side2.setRotationPoint(0, 0, 0);
		mainTwistPart.addChild(side2);
		
		ModelRenderer back = new ModelRenderer(this, 24, 30);
		back.addBox(-7, -2.5F, 5, 14, 5, 2);
		back.setRotationPoint(0, 0, 0);
		back.rotateAngleY = (float)(Math.PI * 1.5F);
		mainTwistPart.addChild(back);
		
		ModelRenderer front1 = new ModelRenderer(this, 40, 0);
		front1.addBox(4, -2.5F, 5, 3, 5, 2);
		front1.setRotationPoint(0, 0, 0);
		front1.rotateAngleY = (float) (Math.PI / 2);
		mainTwistPart.addChild(front1);
		
		ModelRenderer front2 = new ModelRenderer(this, 40, 0);
		front2.addBox(-7, -2.5F, 5, 3, 5, 2);
		front2.setRotationPoint(0, 0, 0);
		front2.rotateAngleY = (float)(Math.PI / 2);
		mainTwistPart.addChild(front2);
		
		ModelRenderer frontd = new ModelRenderer(this, 40, 7);
		frontd.addBox(-4, -2.5F, 5, 8, 5, 4);
		frontd.setRotationPoint(0, 0, 0);
		frontd.rotateAngleY = (float)(Math.PI / 2);
		mainTwistPart.addChild(frontd);
	}
	
	public void RenderTile(float rotation, float pos, float a, float b, float c, float mult){
		for(ModelRenderer part : parts){
			part.render(mult);
		}
	}
}
