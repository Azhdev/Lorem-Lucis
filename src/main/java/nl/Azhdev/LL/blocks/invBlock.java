package nl.Azhdev.LL.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nl.Azhdev.LL.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.LL.init.LLItems;
import nl.Azhdev.core.api.packet.NetworkHandler;
import nl.Azhdev.core.api.packet.PacketPlaySound;

public class invBlock extends Block {

    public invBlock(Material p_i45394_1_) {
        super(p_i45394_1_);
    }

    @Override
    public boolean isFullBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isTranslucent() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            TileEntitySpinny s = (TileEntitySpinny) worldIn.getTileEntity(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));
            if (playerIn.getCurrentEquippedItem() != null && playerIn.getCurrentEquippedItem().getItem() == LLItems.Upgrade) {
                if (!s.isOP) {
                    s.setOP();
                    s.shouldCount = true;
                    playerIn.getCurrentEquippedItem().stackSize--;
                    NetworkHandler.INSTANCE.sendToAll(new PacketPlaySound("LL:upgrade", pos.getX(), pos.getY(), pos.getZ(), 1, 1, worldIn));
                }

            } else {
                if (s.canUse) {
                    s.performRandomEffect(worldIn, pos, playerIn);
                }
            }
        }
        return true;
    }




	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
		worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean addDestroyEffects(World world, BlockPos pos, net.minecraft.client.particle.EffectRenderer effectRenderer){
		NetworkHandler.INSTANCE.sendToAll(new PacketPlaySound(this.stepSound.getBreakSound(), pos.getX(), pos.getY(), pos.getZ(), 1, 1, world));
		return true;
    }
}
