package nl.Azhdev.blocks.TileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySpinny extends TileEntity {

	private int uses = 0;
	
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
	
	public int getNextUse(){
		return uses + 1;
	}
}
