package dgtools.common.items.tools;

import dgtools.common.DGMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import thaumcraft.api.IWarpingGear;

public class ItemOsmiumShovel extends ItemSpade implements IWarpingGear
{
    public ItemOsmiumShovel (Item.ToolMaterial m)
	{
		super(m);
		this.setCreativeTab(DGMain.dgTab);
		this.setTextureName("dg:ItemOsmiumShovel");
		this.setUnlocalizedName("ItemOsmiumShovel");
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
