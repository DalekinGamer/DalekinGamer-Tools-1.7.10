package dgtools.common.items.tools;

import dgtools.common.DGMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import thaumcraft.api.IWarpingGear;

public class ItemBlackOsmiumSword extends ItemSword implements IWarpingGear
{
	public ItemBlackOsmiumSword (ToolMaterial m)
	{
		super(m);
		this.setCreativeTab(DGMain.dgTab);
		this.setTextureName("dg:ItemBlackOsmiumSword");
		this.setUnlocalizedName("ItemBlackOsmiumSword");
	}

        @Override
	public int getWarp (ItemStack s, EntityPlayer p)
	{
		return 5;
	}
        
        @Override
	public EnumRarity getRarity (ItemStack s)
	{
		return EnumRarity.uncommon;
	}
}
