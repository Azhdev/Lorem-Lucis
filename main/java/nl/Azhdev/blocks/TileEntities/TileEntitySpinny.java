package nl.Azhdev.blocks.TileEntities;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntitySpinny extends TileEntity {

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
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setFloat("rotation", rotation);
		compound.setFloat("bobpos", bobpos);
		compound.setBoolean("activated", isActivated);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		rotation = compound.getFloat("rotation");
		bobpos = compound.getFloat("bobpos");
		isActivated = compound.getBoolean("activated");
	}

	public void activate(){
		isActivated = true;
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
		int i = random.nextInt(12);
		switch(i){
		case 0:
			world.setBlock(x, y + 2, z, Blocks.diamond_ore);
			
		case 1:
			if(player.getHealth() <= 10){
				player.setHealth(16);
			}else if(player.getHealth() <= 15 && player.getHealth() >= 10){
				player.setHealth(16);
			}else if(player.getHealth() >= 16){
				player.setHealth(20);
			}
			
		case 2:
			player.addPotionEffect(new PotionEffect(13, 1200));
		case 3:
			player.addPotionEffect(new PotionEffect(12, 9600));
		case 4:
			player.addPotionEffect(new PotionEffect(10, 1200));
		}
}
	
	
	private void performNegativeEffect(World world, int x, int y, int z, EntityPlayer player){
		int i = random.nextInt(12);
		if(i == 1){
			player.setHealth(1);
		}else if(i == 2){
			world.createExplosion(player, x, y, z, 4, true);
			player.setHealth(0);
		}else if(i == 3){
			player.addExhaustion(10);
		}else if(i == 4){
			player.addPotionEffect(new PotionEffect(4, 1200));
		}
	}
	
	public float getRotation() {
		return rotation;
	}

	public float getBobPos() {
		return -6 -Math.abs((float)Math.sin(bobpos) * 5.5F);
	}
}
