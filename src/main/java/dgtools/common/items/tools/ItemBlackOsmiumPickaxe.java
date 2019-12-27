package dgtools.common.items.tools;

import dgtools.common.DGMain;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemBlackOsmiumPickaxe extends ItemPickaxe
{
    public ItemBlackOsmiumPickaxe (Item.ToolMaterial m)
	{
		super(m);
		this.setCreativeTab(DGMain.dgTab);
		this.setTextureName("dg:ItemBlackOsmiumPickaxe");
		this.setUnlocalizedName("ItemBlackOsmiumPickaxe");
	}

        @Override
	public EnumRarity getRarity (ItemStack s)
	{
		return EnumRarity.uncommon;
	}
    
}
