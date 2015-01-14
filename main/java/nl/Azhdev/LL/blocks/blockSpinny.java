package nl.Azhdev.LL.blocks;

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
import nl.Azhdev.core.api.packet.NetworkHandler;
import nl.Azhdev.core.api.packet.PacketPlaySound;
import nl.Azhdev.LL.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.LL.items.LLItems;

import java.util.Random;

public class blockSpinny extends Block implements ITileEntityProvider{

	public blockSpinny(Material mat) {
		super(mat);
		setBlockName("spinny");
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName("LL:spinny");
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
	public void onBlockAdded(World world, int x, int y, int z){
		world.setBlock(x, y + 1, z, AzhdevBlocks.invisiBlock);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x,	int y, int z, EntityPlayer player, int p_149727_6_, float hitx, float hity, float hitz) {
		if(!world.isRemote){
			TileEntitySpinny s = (TileEntitySpinny)world.getTileEntity(x, y, z);
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == LLItems.upgrade){
				if(!s.isOP){
					s.setOP();
					s.shouldCount = true;
					player.getCurrentEquippedItem().stackSize--;
					NetworkHandler.INSTANCE.sendToAll(new PacketPlaySound("LL:upgrade", x, y, z, 1, 1));
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
	
	@Override
	public void breakBlock(World p_149749_1_, int x, int y, int z, Block p_149749_5_, int p_149749_6_){
		p_149749_1_.setBlockToAir(x, y + 1, z);
	}
}
