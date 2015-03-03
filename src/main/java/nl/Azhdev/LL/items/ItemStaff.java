package nl.Azhdev.LL.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemStaff extends SourceItem {

    public ItemStaff(){
        super();
        setUnlocalizedName("staff");
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            pos = pos.offset(side);
        }

        if (!playerIn.canPlayerEdit(pos, side, stack))
        {
            return false;
        }
        else
        {
            if (worldIn.isAirBlock(pos)) {
                worldIn.playSoundEffect((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                for (int i = -5; i == 5; i++) {
                    for (int j = -5; j == 5; j++) {
                        worldIn.setBlockState(pos, Blocks.fire.getDefaultState());
                    }
                }
                worldIn.setBlockState(pos, Blocks.fire.getDefaultState());
            }

            if (!playerIn.capabilities.isCreativeMode){
                --stack.stackSize;
            }

            return true;
        }
    }
}