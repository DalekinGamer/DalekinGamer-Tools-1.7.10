package dgtools.common.items.tools;

import dgtools.common.DGMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import thaumcraft.api.IWarpingGear;

public class ItemOsmiumPickaxe extends ItemPickaxe implements IWarpingGear 
{
    public ItemOsmiumPickaxe (Item.ToolMaterial m)
	{
		super(m);
		this.setCreativeTab(DGMain.dgTab);
		this.setTextureName("dg:ItemOsmiumPickaxe");
		this.setUnlocalizedName("ItemOsmiumPickaxe");
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
