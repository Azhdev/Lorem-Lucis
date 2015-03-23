package nl.Azhdev.core.api.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block.SoundType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class PacketPlaySound extends LocationDoublePacket<PacketPlaySound>{

	private String sound;
	private Float volume, pitch;
	private double x, y, z;
	private World worldObj;
	public PacketPlaySound(){}
	
	public PacketPlaySound(String sound, double x, double y, double z, float volume, float pitch, World world){
		super();
		this.sound = sound;
		this.volume = volume;
		this.pitch = pitch;
		this.x = x;
		this.y = y;
		this.z = z;
		this.worldObj = world;
	}
	
	public PacketPlaySound(String sound, EntityPlayer player, float volume, float pitch, World world){
		super();
		this.sound = sound;
		this.volume = volume;
		this.pitch = pitch;
		this.x = player.posX;
		this.y = player.posY;
		this.z = player.posZ;
		this.worldObj = world;
	}
	
	public PacketPlaySound(SoundType sound, double x, double y, double z, float volume, float pitch, World world){
		super();
		this.sound = sound.soundName;
		this.volume = volume;
		this.pitch = pitch;
		this.x = x;
		this.y = y;
		this.z = z;
		this.worldObj = world;
	}
	
	public PacketPlaySound(SoundType sound, EntityPlayer player, float volume, float pitch, World world){
		super();
		this.sound = sound.soundName;
		this.volume = volume;
		this.pitch = pitch;
		this.x = player.posX;
		this.y = player.posY;
		this.z = player.posZ;
		this.worldObj = world;
	}
	
	@Override
	public void toBytes(ByteBuf buf){
		ByteBufUtils.writeUTF8String(buf, sound);
		buf.writeFloat(volume);
		buf.writeFloat(pitch);
	}
	
	@Override
	public void fromBytes(ByteBuf buf){
		sound = ByteBufUtils.readUTF8String(buf);
		volume = buf.readFloat();
		pitch = buf.readFloat();
	}

	@Override
	public void handleClientSide(PacketPlaySound message, EntityPlayer player) {
		player.playSound(message.sound, message.volume, message.pitch);
		//player.worldObj.playSound(message.x, message.y, message.z, message.sound, message.volume, message.pitch, false);
	}

	@Override
	public void handleServerSide(PacketPlaySound message, EntityPlayer player) {
	}

}
