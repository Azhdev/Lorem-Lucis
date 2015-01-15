package nl.Azhdev.LL.blocks;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class invBlock extends Block {

	public invBlock(Material p_i45394_1_) {
		super(p_i45394_1_);
		setBlockTextureName("LL:spinny");
		setBlockName("spinny");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean isBlockNormalCube(){
		return false;
	}
	
	@Override
	public int getRenderType(){
		 return -1; 
	 }
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x,	int y, int z, EntityPlayer player, int p_149727_6_, float hitx, float hity, float hitz) {
		world.getBlock(x, y-1, z).onBlockActivated(world, x, y - 1, z, player, p_149727_6_, hitx, hity, hitz);
		return true;
	}
	
	@Override
	public void breakBlock(World p_149749_1_, int x, int y, int z, Block p_149749_5_, int p_149749_6_){
		p_149749_1_.setBlockToAir(x, y - 1, z);
	}
}
