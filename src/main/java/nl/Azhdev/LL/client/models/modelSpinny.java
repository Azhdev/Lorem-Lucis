package nl.Azhdev.LL.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import nl.Azhdev.LL.blocks.TileEntities.TileEntitySpinny;

import java.util.ArrayList;

public class modelSpinny extends ModelBase{
	private ArrayList<ModelRenderer> parts;
	private ArrayList<ModelRenderer> sides;
	private ModelRenderer mainTwistPart;
	private ModelRenderer centerPart;
	
	public modelSpinny(){
		parts = new ArrayList<ModelRenderer>();
		textureHeight = textureWidth = 128;
		
		
		mainTwistPart = new ModelRenderer(this);
		mainTwistPart.addBox(-5, -10, -5, 10, 20, 10);
		mainTwistPart.setRotationPoint(0, 10, 0);
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
		frontd.addBox(-4, -5, 5, 8, 10, 4);
		frontd.setRotationPoint(0, 0, 0);
		frontd.rotateAngleY = (float)(Math.PI / 2);
		mainTwistPart.addChild(frontd);
		
		ModelRenderer top1 = new ModelRenderer(this, 0, 44);
		top1.addBox(-4.5F, -0.5F, -4.5F, 9, 1, 9);
		top1.setRotationPoint(0, 10.5F, 0);
		mainTwistPart.addChild(top1);
		
		ModelRenderer top2 = new ModelRenderer(this, 27, 37);
		top2.addBox(-4, -0.5F, -4, 8, 1, 8);
		top2.setRotationPoint(0, 11.5F, 0);
		mainTwistPart.addChild(top2);
		
		
		ModelRenderer base = new ModelRenderer(this, 0, 54);
		base.addBox(-7F, -1.5F, -7F, 14, 3, 14);
		base.setRotationPoint(0, -24, 0);
		parts.add(base);
		
		ModelRenderer base2 = new ModelRenderer(this, 0, 71);
		base2.addBox(-6, -1.5F, -6, 12, 3, 12);
		base2.setRotationPoint(0, -22.5F, 0);
		parts.add(base2);
	}
	
	public modelSpinny(boolean n){
		parts = new ArrayList<ModelRenderer>();
		sides = new ArrayList<ModelRenderer>();
		textureHeight = textureWidth = 128;
		
		centerPart = new ModelRenderer(this);
		centerPart.addBox(-4, -8, -1, 8, 16, 8);
		centerPart.setRotationPoint(0, 0, 0);
		parts.add(centerPart);
		
		ModelRenderer top = new ModelRenderer(this, 32, 0);
		top.addBox(-6, -1.5F, -6, 12, 3, 12);
		top.setRotationPoint(0, 13.5F, 0);
		centerPart.addChild(top);
		
		ModelRenderer top2 = new ModelRenderer(this, 34, 48);
		top2.addBox(-8, 15, -8, 16, 1, 16);
		top2.setRotationPoint(0, 0, 0);
		centerPart.addChild(top2);
		
		ModelRenderer bottom = new ModelRenderer(this, 32, 0);
		bottom.addBox(-6, -1.5F, -6, 12, 3, 12);
		bottom.setRotationPoint(0, -13.5F, 0);
		centerPart.addChild(bottom);
		
		ModelRenderer bottom2 = new ModelRenderer(this, 34, 48);
		bottom2.addBox(-8, -16, -8, 16, 1, 16);
		bottom2.setRotationPoint(0, 0, 0);
		centerPart.addChild(bottom2);

		ModelRenderer side1 = new ModelRenderer(this, 0, 24);
		side1.addBox(-8.95F, -14.995F, -8.95F, 18, 30, 3);
		side1.setRotationPoint(0, 0, 0);
		side1.rotateAngleY = (float) (Math.PI /2);
		sides.add(side1);
		
		ModelRenderer side2 = new ModelRenderer(this, 0, 24);
		side2.addBox(-8.95F, -14.995F, -8.95F, 18, 30, 3);
		side2.setRotationPoint(0, 0, 0);
		side2.rotateAngleY = (float) (Math.PI  * 1.5F);
		sides.add(side2);
		
		ModelRenderer back = new ModelRenderer(this, 0, 24);
		back.addBox(-9, -15, -9, 18, 30, 3);
		back.setRotationPoint(0, 0, 0);
		sides.add(back);

		ModelRenderer side3 = new ModelRenderer(this, 0, 57);
		side3.addBox(-8, -14, 9, 16, 28, 1);
		side3.setRotationPoint(0, 0, 0);
		side3.rotateAngleY = (float) (Math.PI / 2);
		sides.add(side3);
		
		ModelRenderer side4 = new ModelRenderer(this, 0, 57);
		side4.addBox(-8, -14, 9, 16, 28, 1);
		side4.setRotationPoint(0, 0, 0);
		side4.rotateAngleY = (float) (Math.PI * 1.5F);
		sides.add(side4);
		
		ModelRenderer side5 = new ModelRenderer(this, 34, 68);
		side5.addBox(-6, -12, 10, 12, 24, 1);
		side5.setRotationPoint(0, 0, 0);
		side5.rotateAngleY = (float) (Math.PI /2);
		centerPart.addChild(side5);
		
		ModelRenderer side6 = new ModelRenderer(this, 34, 68);
		side6.addBox(-6, -12, 10, 12, 24, 1);
		side6.setRotationPoint(0, 0, 0);
		side6.rotateAngleY = (float) (Math.PI * 1.5);
		centerPart.addChild(side6);
		
		ModelRenderer back2 = new ModelRenderer(this, 0, 57);
		back2.addBox(-8, -14, 9, 16, 28, 1);
		back2.setRotationPoint(0, 0, 0);
		back2.rotateAngleY = (float) Math.PI;
		sides.add(back2);
		
		ModelRenderer back3 = new ModelRenderer(this, 34, 68);
		back3.addBox(-6, -12, 10, 12, 24, 1);
		back3.setRotationPoint(0, 0, 0);
		back3.rotateAngleY = (float)Math.PI;
		centerPart.addChild(back3);
		
		ModelRenderer front_bottom = new ModelRenderer(this, 42, 15);
		front_bottom.addBox(-6, -15, 4, 12, 7, 5);
		front_bottom.setRotationPoint(0, 0, 0);
		centerPart.addChild(front_bottom);
		
		ModelRenderer front_top = new ModelRenderer(this, 42, 15);
		front_top.addBox(-6, -14.995F, 4, 12, 7, 5);
		front_top.setRotationPoint(0, 0, 0);
		front_top.rotateAngleX = front_top.rotateAngleY = (float) Math.PI;
		centerPart.addChild(front_top);
		
		ModelRenderer front_side1 = new ModelRenderer(this, 42, 27);
		front_side1.addBox(-6, -7.995F, 4, 2, 16, 5);
		front_side1.setRotationPoint(0, 0, 0);
		centerPart.addChild(front_side1);
		
		ModelRenderer front_side2 = new ModelRenderer(this, 42, 27);
		front_side2.addBox(-6, -7.995F, 4, 2, 16, 5);
		front_side2.setRotationPoint(0, 0, 0);
		front_side2.rotateAngleZ = (float) Math.PI;
		centerPart.addChild(front_side2);
		
		ModelRenderer pad1 = new ModelRenderer(this, 34, 48);
		pad1.addBox(-8, -24, -8, 16, 4, 16);
		pad1.setRotationPoint(0, 0, 0);
		parts.add(pad1);
		
		for(ModelRenderer side : sides){
			centerPart.addChild(side);
		}
	}
	
	public void renderInv(float mult){
		for(ModelRenderer part : parts){
			part.render(mult);
		}
	}
	
	public void RenderTile(TileEntitySpinny spinny, float rotation, float pos, float a, float b, float c, float mult){
		
		mainTwistPart.rotateAngleY = spinny.getRotation();
		mainTwistPart.rotationPointY = spinny.getBobPos();
		
		for(ModelRenderer part : parts){
			part.render(mult);
		}
	}
}