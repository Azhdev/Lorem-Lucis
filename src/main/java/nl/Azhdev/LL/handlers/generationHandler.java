package nl.Azhdev.LL.handlers;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import nl.Azhdev.LL.init.LLBlocks;

public class generationHandler implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		generateSpinnies(world, random, chunkX, chunkZ);
	}

	private void generateSpinnies(World world, Random random, int chunkX, int chunkZ) {
		int x = chunkX * random.nextInt(16);
		int y = 256;
		int z = chunkZ * random.nextInt(16);
		
		while(world.isAirBlock(new BlockPos(x, y, z))){
			y--;
		}
		if(random.nextInt(1000) <= 1){
			world.setBlockState(new BlockPos(x, y, z), LLBlocks.Spinny.getDefaultState());
		}

	}

}
