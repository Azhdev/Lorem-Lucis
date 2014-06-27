package nl.Azhdev.non.client.sounds;

import net.minecraft.client.audio.ISound;
import net.minecraft.util.ResourceLocation;

public class boneyScream implements ISound{

	private final Float Volume;
	private final Float pitch;
	
	public boneyScream(Float Volume, Float Pitch){
		this.Volume = Volume;
		this.pitch = Pitch;
	}
	
	@Override
	public ResourceLocation getPositionedSoundLocation() {
		return null;
	}

	@Override
	public boolean canRepeat() {
		return false;
	}

	@Override
	public int getRepeatDelay() {
		return 0;
	}

	@Override
	public float getVolume() {
		return Volume;
	}

	@Override
	public float getPitch() {
		return pitch;
	}

	@Override
	public float getXPosF() {
		return 0;
	}

	@Override
	public float getYPosF() {
		return 0;
	}

	@Override
	public float getZPosF() {
		return 0;
	}

	@Override
	public AttenuationType getAttenuationType() {
		return null;
	}

}
