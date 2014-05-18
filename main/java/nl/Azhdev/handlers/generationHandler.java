package nl.Azhdev.handlers;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import nl.Azhdev.blocks.AzhdevBlocks;
import cpw.mods.fml.common.IWorldGenerator;

public class generationHandler implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		generateSpinnies(world, random, chunkX, chunkZ);
	}

	private void generateSpinnies(World world, Random random, int chunkX, int chunkZ) {
		int x = chunkX + random.nextInt(16);
		int y = 256;
		int z = chunkZ + random.nextInt(16);
		
		for(int i = 0; i > 256; i++){
			if(world.isAirBlock(x, y, z)){
				y--;
			}else{
				break;
			}
		}
		
		world.setBlock(x, y, z, AzhdevBlocks.spinny);
	}

}
