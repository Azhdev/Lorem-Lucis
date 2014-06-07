package nl.Azhdev.non.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nl.Azhdev.non.blocks.TileEntities.TileEntitySpinny;

public class blockSpinny extends Block implements ITileEntityProvider{

	public blockSpinny(Material mat) {
		super(mat);
		setBlockName("spinny");
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockBounds(0, 0, 0, 1, 1, 1);
		setBlockTextureName("non:spinny");
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
	public boolean onBlockActivated(World world, int x,	int y, int z, EntityPlayer player, int p_149727_6_,
			float hitx, float hity, float hitz) {
		
		if(!world.isRemote){
			TileEntitySpinny s = (TileEntitySpinny)world.getTileEntity(x, y, z);
			if(!s.isActivated()){
				s.performRandomEffect(world, x, y, z, player);
				s.activate();
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
		
	}
	
	@Override
	public Item getItemDropped(int i, Random random, int j){
		return null;
	}
	
	@Override
	public boolean isOpaqueCube(){
        return false;
    }
	
	public int getRenderType(){
        return -1;
    }
}
