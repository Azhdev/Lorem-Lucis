package nl.Azhdev.non.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nl.Azhdev.non.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.non.handlers.soundHandler;
import nl.Azhdev.non.items.nonItems;

public class blockSpinny extends Block implements ITileEntityProvider{

	public blockSpinny(Material mat) {
		super(mat);
		setBlockName("spinny");
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName("non:spinny");
		setBlockBounds(0, 0, 0, 1, 2, 1);
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
	public boolean onBlockActivated(World world, int x,	int y, int z, EntityPlayer player, int p_149727_6_, float hitx, float hity, float hitz) {
		if(!world.isRemote){
			TileEntitySpinny s = (TileEntitySpinny)world.getTileEntity(x, y, z);
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == nonItems.upgrade){
				if(!s.isOP){
					s.setOP();
					s.shouldCount = true;
					player.getCurrentEquippedItem().stackSize--;
					soundHandler.playSound("upgrade", world, player, 1, 1);
				}
				
			}else{
				if(s.canUse){
					s.performRandomEffect(world, x, y, z, player);
				}
			}
		}
		return true;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity ent){
		if(ent instanceof EntityArrow){
			if(ent.isBurning()){
				world.createExplosion(null, x, y, z, 4, true);
			}
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
