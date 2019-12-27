package dgtools.common.items.tools;

import dgtools.common.DGMain;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemBlackOsmiumShovel extends ItemSpade
{
    public ItemBlackOsmiumShovel (Item.ToolMaterial m)
	{
		super(m);
		this.setCreativeTab(DGMain.dgTab);
		this.setTextureName("dg:ItemBlackOsmiumShovel");
		this.setUnlocalizedName("ItemBlackOsmiumShovel");
	}

        @Override
	public EnumRarity getRarity (ItemStack s)
	{
		return EnumRarity.uncommon;
	}
    
}
