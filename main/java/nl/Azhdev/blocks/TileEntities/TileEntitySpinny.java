package nl.Azhdev.blocks.TileEntities;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntitySpinny extends TileEntity {

	private int uses = 0;
	private float rotation;
	private float bobpos;
	Random random = new Random();
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

	public boolean isActive(){
		if(uses >= 2){
			return true;
		}else{
			return false;
		}
	}
	
	public void performRandomEffect(World world, int x, int y, int z, EntityPlayer player) {
		if(random.nextBoolean()){
			performPositiveEffect(world, x, y, z, player);
		}else{
			performNegativeEffect(world, x, y, z, player);
		}
	}

	private void performPositiveEffect(World world, int x, int y, int z, EntityPlayer player){
		if(random.nextInt(12) == 1){
			world.setBlock(x, y + 2, z, Blocks.diamond_ore);
		}else if (random.nextInt(12) == 2){
			if(player.getHealth() <= 10){
				player.setHealth(16);
			}else if(player.getHealth() <= 15 && player.getHealth() >= 10){
				player.setHealth(16);
			}else{
				player.setHealth(1);
			}
		}else if(random.nextInt(12) == 3){
			
		}
}
	
	
	private void performNegativeEffect(World world, int x, int y, int z, EntityPlayer player){
		int i = random.nextInt(12);
		if(i == 1){
			player.setHealth(1);
			player.setSprinting(true);
		}else if(i == 2){
			world.createExplosion(player, x, y, z, 4, true);
			player.setHealth(0);
		}
	}
	
	public float getRotation() {
		return rotation;
	}

	public float getBobPos() {
		return -6 -Math.abs((float)Math.sin(bobpos) * 5.5F);
	}
}
