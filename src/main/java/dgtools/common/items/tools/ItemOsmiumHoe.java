package dgtools.common.items.tools;

import dgtools.common.DGMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import thaumcraft.api.IWarpingGear;

public class ItemOsmiumHoe extends ItemHoe implements IWarpingGear
{
    public ItemOsmiumHoe (Item.ToolMaterial m)
	{
		super(m);
		this.setCreativeTab(DGMain.dgTab);
		this.setTextureName("dg:ItemOsmiumHoe");
		this.setUnlocalizedName("ItemOsmiumHoe");
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
