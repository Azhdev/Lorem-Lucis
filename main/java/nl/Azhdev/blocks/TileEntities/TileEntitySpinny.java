package nl.Azhdev.blocks.TileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySpinny extends TileEntity {

	private int uses = 0;
	private float rotation;
	private float bobpos;
	
	
	@Override
	public void updateEntity(){
		if(worldObj.isRemote){
			rotation += 0.02F;
			bobpos += 0.02F;
		}else{
			
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setInteger("uses", uses);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		uses = compound.getInteger("uses");
	}
	
	public int getUses() {
		return uses;
	}

	public void setUses(int i) {
		uses = i;
	}

	public void getRandomEffect() {
		
	}

	public float getRotation() {
		return rotation;
	}

	public float getBobPos() {
		return -6 -Math.abs((float)Math.sin(bobpos) * 5.5F);
	}
}
