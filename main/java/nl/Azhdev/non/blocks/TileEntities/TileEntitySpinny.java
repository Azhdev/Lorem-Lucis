package nl.Azhdev.non.blocks.TileEntities;

import java.util.Random;

import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import nl.Azhdev.non.client.renderers.renderSpinnyBlock;
import nl.Azhdev.non.handlers.soundHandler;

public class TileEntitySpinny extends TileEntity {

	private float rotation;
	private float bobpos;
	private boolean isActivated = false;
	Random random = new Random();
	public boolean shine;
	private boolean first = true;
	public boolean isOP = false;
	private int cooldown = 0;
	public boolean canUse = true;
	public boolean shouldCount = false;
	
	
	@Override
	public void updateEntity(){
		if(worldObj.isRemote){
			rotation += 0.01F;
			bobpos += 0.02F;
			
		}else{
			if(isOP){
				if(shouldCount){
					if(cooldown < 1200){
						cooldown++;
					}else{
						cooldown = 0;
						shouldCount = false;
						canUse = true;
					}
				}
			}
			//refreshTexture();
		}
	}
	
	private void refreshTexture() {
		if(worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord) && worldObj.isDaytime()){
			shine = true;
		}else{
			shine = false;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setFloat("rotation", rotation);
		compound.setFloat("bobpos", bobpos);
		compound.setBoolean("activated", isActivated);
		compound.setBoolean("isOP", isOP);
		compound.setInteger("cooldown", cooldown);
		compound.setBoolean("canUse", canUse);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		rotation = compound.getFloat("rotation");
		bobpos = compound.getFloat("bobpos");
		isActivated = compound.getBoolean("activated");
		isOP = compound.getBoolean("isOP");
		cooldown = compound.getInteger("cooldown");
		canUse = compound.getBoolean("canUse");
	}
	
	public void setOP(){
		isOP = true;
	}
	
	public void performRandomEffect(World world, int x, int y, int z, EntityPlayer player) {
		if(canUse){
			if(random.nextBoolean()){
				performPositiveEffect(world, x, y, z, player);
			}else{
				performNegativeEffect(world, x, y, z, player);
			}
			if(isOP){
				shouldCount = true;
			}
			canUse = false;
		}
	}

	private void performPositiveEffect(World world, int x, int y, int z, EntityPlayer player){
		int i = random.nextInt(12);
		if(i == 0){
			world.setBlock(x, y + 2, z, Blocks.diamond_ore);
		}else if(i == 1){
			if(player.getHealth() <= 10){
				player.setHealth(16);
			}else if(player.getHealth() <= 15 && player.getHealth() >= 10){
				player.setHealth(16);
			}else if(player.getHealth() >= 16){
				player.setHealth(20);
			}
		}else if(i == 2){
			player.addPotionEffect(new PotionEffect(13, 1200));
		}else if(i == 3){
			player.addPotionEffect(new PotionEffect(12, 9600));
		}else if (i == 4){
			player.addPotionEffect(new PotionEffect(10, 1200));
		}else if(i == 5){
			player.addPotionEffect(new PotionEffect(16, 1200));
		}else if(i == 6){
			player.addPotionEffect(new PotionEffect(8, 200));
			player.addPotionEffect(new PotionEffect(1, 200));
		}else if(i == 7){
			EntityPig pig = new EntityPig(world);
			pig.setPosition(x, y+1, z);
			world.spawnEntityInWorld(pig);
		}else if(i == 8){
			player.addExperienceLevel(5);
		}else if(i == 9){
			player.addPotionEffect(new PotionEffect(3, 1200));
		}else if(i == 10){
			world.setBlock(x, y + 2, z, Blocks.mycelium);
		}else if(i ==11){
			player.addExperience(50);
		}else if(i == 12){
			world.setBlock(x, y + 2, z, Blocks.jukebox);
		}
		soundHandler.playSound("bleep", world, player, 1, 1);
}
	
	
	private void performNegativeEffect(World world, int x, int y, int z, EntityPlayer player){
		int i = random.nextInt(12);
		if(i == 1){
			if(!player.capabilities.isCreativeMode){
				player.setHealth(1);
			}else{
				player.addChatComponentMessage(new ChatComponentText("i was going to reduce your health but you're in creative mode :("));
			}
		}else if(i == 2){
			if(!player.capabilities.isCreativeMode){
				world.createExplosion(player, x, y, z, 4, true);
				player.setHealth(0);
				
			}else{
				player.addChatComponentMessage(new ChatComponentText("i was going to kill you but you're in creative mode :("));
			}
		}else if(i == 3){
			player.addExhaustion(10);
		}else if(i == 4){
			player.addPotionEffect(new PotionEffect(4, 1200));
		}else if(i == 5){
			player.addPotionEffect(new PotionEffect(17, 600));
		}else if(i == 6){
			player.addPotionEffect(new PotionEffect(20, 200));
		}else if(i == 7){
			player.addPotionEffect(new PotionEffect(18, 1200));
		}else if(i == 8){
			player.setFire(10);
		}else if(i == 9){
			EntityCreeper creeper = new EntityCreeper(world);
			creeper.setPosition(x, y + 1, z);
			world.spawnEntityInWorld(creeper);
		}else if(i == 10){
			EntityWither wither = new EntityWither(world);
			wither.setPosition(x, y + 5, z);
			world.spawnEntityInWorld(wither);
		}else if(i == 11){
			player.addPotionEffect(new PotionEffect(9, 600));
		}else if(i == 12){
			player.destroyCurrentEquippedItem();
		}
		if(i == 1 || i == 2){
			soundHandler.playSound("boneyScream", world, player, 1, 1);
		}else{
			soundHandler.playSound("bleep", world, player, 1, 1);
		}
	}
	
	public float getRotation() {
		return rotation;
	}

	public float getBobPos() {
		return -4 -Math.abs((float)Math.sin(bobpos) * 5.5F);
	}
}
