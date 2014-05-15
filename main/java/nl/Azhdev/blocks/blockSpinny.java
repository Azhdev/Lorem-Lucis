package nl.Azhdev.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nl.Azhdev.blocks.TileEntities.TileEntitySpinny;

public class blockSpinny extends Block implements ITileEntityProvider{

	public blockSpinny(Material mat) {
		super(mat);
		setBlockName("spinny");
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockBounds(0.1F, 0.2F, 0.1F, 0.9F, 0.2F, 0.9F);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntitySpinny();
	}
	
	@Override
	public boolean isNormalCube(){
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int par5, EntityPlayer player) {
		if(!world.isRemote){
			if(!player.capabilities.isCreativeMode){
				world.createExplosion(player, x, y, z, 4, true);
				player.setHealth(0);
			}
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x,	int y, int z, EntityPlayer player, int p_149727_6_,
			float hitx, float hity, float hitz) {
		
		if(!world.isRemote){
			TileEntitySpinny s = (TileEntitySpinny)world.getTileEntity(x, y, z);
			if(s.getUses() == 0){
				s.setUses(1);
			}else if(s.getUses() == 1){
				s.getRandomEffect();
			}

		}
		
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(){
        return false;
    }
	
	public int getRenderType(){
        return -1;
    }
}