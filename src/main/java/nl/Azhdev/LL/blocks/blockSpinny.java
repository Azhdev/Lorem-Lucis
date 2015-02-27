package nl.Azhdev.LL.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import nl.Azhdev.LL.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.LL.init.LLBlocks;
import nl.Azhdev.LL.init.LLItems;
import nl.Azhdev.core.api.packet.NetworkHandler;
import nl.Azhdev.core.api.packet.PacketPlaySound;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class BlockSpinny extends SourceBlock implements ITileEntityProvider{

	public BlockSpinny(Material mat) {
		super(mat);
		setUnlocalizedName("spinny");
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntitySpinny();
	}
	
	@Override
	public boolean isNormalCube(){
		return false;
	}
	
	
	public void onBlockAdded(World world, BlockPos pos, IBlockState state){
		world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), LLBlocks.invisiBlock.getDefaultState());
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote){
            TileEntitySpinny s = (TileEntitySpinny)worldIn.getTileEntity(pos);
			if(playerIn.getCurrentEquippedItem() != null && playerIn.getCurrentEquippedItem().getItem() == LLItems.Upgrade){
				if(!s.isOP){
					s.setOP();
					s.shouldCount = true;
					playerIn.getCurrentEquippedItem().stackSize--;
					NetworkHandler.INSTANCE.sendToAll(new PacketPlaySound("LL:upgrade", pos.getX(), pos.getY(), pos.getZ(), 1, 1));
				}
				
			}else{
				if(s.canUse){
					s.performRandomEffect(worldIn, pos, playerIn);
				}
			}
		}
		return true;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity ent){
		if(ent instanceof EntityArrow){
			if(ent.isBurning()){
				worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4F, true);
			}
		}
	}
	 
	@Override
	public Item getItemDropped(IBlockState state, Random random, int j){
		return null;
	}
	
	@Override
	public boolean isOpaqueCube(){
        return false;
    }

    @Override
	public int getRenderType(){
        return -1;
    }
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
	}
}
