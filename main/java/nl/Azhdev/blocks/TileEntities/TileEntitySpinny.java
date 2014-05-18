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
	private boolean isActivated = false;
	Random random = new Random();
	
	
	@Override
	public void updateEntity(){
		if(worldObj.isRemote){
			if(!isActivated()){
				rotation += 0.02F;
				bobpos += 0.02F;
			}else{
				rotation = 0;
				bobpos = 0;
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setInteger("uses", uses);
		compound.setFloat("rotation", rotation);
		compound.setFloat("bobpos", bobpos);
		compound.setBoolean("activated", isActivated);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		uses = compound.getInteger("uses");
		rotation = compound.getFloat("rotation");
		bobpos = compound.getFloat("bobpos");
		isActivated = compound.getBoolean("activated");
	}
	
	public int getUses() {
		return uses;
	}

	public void setUses(int i) {
		uses = i;
	}

	public boolean isActivated(){
		return isActivated;
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
			}else if(player.getHealth() >= 16){
				player.setHealth(20);
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
