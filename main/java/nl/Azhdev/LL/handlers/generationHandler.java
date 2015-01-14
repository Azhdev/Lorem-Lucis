package nl.Azhdev.LL.handlers;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import nl.Azhdev.LL.blocks.AzhdevBlocks;

import java.util.Random;

public class generationHandler implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		generateSpinnies(world, random, chunkX, chunkZ);
	}

	private void generateSpinnies(World world, Random random, int chunkX, int chunkZ) {
		int x = chunkX * random.nextInt(16);
		int y = 256;
		int z = chunkZ * random.nextInt(16);
		
		while(world.isAirBlock(x, y, z)){
			y--;
		}
		if(random.nextInt(1000) <= 1){
			world.setBlock(x, y, z, AzhdevBlocks.spinny);
		}

	}

}
