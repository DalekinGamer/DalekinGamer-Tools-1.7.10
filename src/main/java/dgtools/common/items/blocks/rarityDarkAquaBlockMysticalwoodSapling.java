package dgtools.common.items.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dgtools.common.DGMain;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class rarityDarkAquaBlockMysticalwoodSapling extends ItemBlock
{
	public rarityDarkAquaBlockMysticalwoodSapling (Block b)
	{
		super(b);
	}

	@SideOnly (Side.CLIENT)
        @Override
	public EnumRarity getRarity (ItemStack s)
	{
		return DGMain.rarityDarkAqua;
	}
}
