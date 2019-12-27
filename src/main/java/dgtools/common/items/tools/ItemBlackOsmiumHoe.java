package dgtools.common.items.tools;

import dgtools.common.DGMain;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemBlackOsmiumHoe extends ItemHoe
{
    public ItemBlackOsmiumHoe (Item.ToolMaterial m)
	{
		super(m);
		this.setCreativeTab(DGMain.dgTab);
		this.setTextureName("dg:ItemBlackOsmiumHoe");
		this.setUnlocalizedName("ItemBlackOsmiumHoe");
	}

        @Override
	public EnumRarity getRarity (ItemStack s)
	{
		return EnumRarity.uncommon;
	}
    
}
