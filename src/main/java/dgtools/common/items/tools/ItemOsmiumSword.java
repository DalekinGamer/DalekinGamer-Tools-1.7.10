package dgtools.common.items.tools;

import dgtools.common.DGMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import thaumcraft.api.IWarpingGear;

public class ItemOsmiumSword extends ItemSword implements IWarpingGear
{
	public ItemOsmiumSword (ToolMaterial m)
	{
		super(m);
		this.setCreativeTab(DGMain.dgTab);
		this.setTextureName("dg:ItemOsmiumSword");
		this.setUnlocalizedName("ItemOsmiumSword");
	}

        @Override
	public int getWarp (ItemStack s, EntityPlayer p)
	{
		return 2;
	}
        
        @Override
	public EnumRarity getRarity (ItemStack s)
	{
		return DGMain.rarityDarkGreen;
	}
}
