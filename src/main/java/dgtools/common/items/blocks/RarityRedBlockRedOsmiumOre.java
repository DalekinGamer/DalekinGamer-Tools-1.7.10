package dgtools.common.items.blocks;

import dgtools.common.DGMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class RarityRedBlockRedOsmiumOre extends ItemBlock
{
    public RarityRedBlockRedOsmiumOre (Block a)
	{
		super(a);
	}

	@SideOnly (Side.CLIENT)
        @Override
	public EnumRarity getRarity (ItemStack s)
	{
		return DGMain.rarityRed;
	}
   
    
    
}