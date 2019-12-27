package dgtools.common.items.tools;

import dgtools.common.DGMain;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemBlackOsmiumAxe extends ItemAxe
{
    public ItemBlackOsmiumAxe (Item.ToolMaterial m)
	{
		super(m);
		this.setCreativeTab(DGMain.dgTab);
		this.setTextureName("dg:ItemBlackOsmiumAxe");
		this.setUnlocalizedName("ItemBlackOsmiumAxe");
	}

        @Override
	public EnumRarity getRarity (ItemStack s)
	{
		return EnumRarity.uncommon;
	}   
    
}
