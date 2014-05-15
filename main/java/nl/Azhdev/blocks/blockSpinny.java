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
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntitySpinny();
	}
	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int par5, EntityPlayer player) {
		if(!world.isRemote){
			if(!player.capabilities.isCreativeMode){
				world.createExplosion(player, x, y, z, 4, true);
				player.setDead();
			}
		}
	}
}
