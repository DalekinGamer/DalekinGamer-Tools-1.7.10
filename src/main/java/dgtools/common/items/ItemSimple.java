package dgtools.common.items;

import dgtools.common.DGMain;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSimple extends Item
{
	public int SUBTYPES = 11;
	public IIcon[] icons = new IIcon[SUBTYPES];

	public ItemSimple ()
	{
		this.setCreativeTab(DGMain.dgTab);
		this.setUnlocalizedName("ItemSimple");
		this.setHasSubtypes(true);
	}

        @Override
	public EnumRarity getRarity (ItemStack s)
	{
		int m = s.getItemDamage();
		switch (m)
		{
		case 0 :
			return EnumRarity.uncommon;
		case 1 :
			return EnumRarity.uncommon;
		case 2 :
			return EnumRarity.uncommon;
                case 3 :
			return DGMain.rarityDarkGreen;
                case 4 :
			return DGMain.rarityDarkGreen;
                case 5 :
			return EnumRarity.uncommon;
                case 6 :
			return EnumRarity.uncommon;
                case 7 :
			return DGMain.rarityRed;
                case 8 :
			return DGMain.rarityRed;
                case 9 :
			return DGMain.rarityDarkAqua;
                case 10 :
			return DGMain.rarityDarkAqua;
		}
		return EnumRarity.common;
	}

	@SideOnly (Side.CLIENT)
        @Override
	public void registerIcons (IIconRegister ir)
	{
		for (int i = 0; i < icons.length; i++)
			this.icons[i] = ir.registerIcon("dg:ItemSimple" + i);
	}

	@SideOnly (Side.CLIENT)
        @Override
	public IIcon getIconFromDamage (int i)
	{
		return this.icons[i];
	}

	@SideOnly (Side.CLIENT)
        @Override
	public void getSubItems (Item item, CreativeTabs c, List l)
	{
		for (int i = 0; i < SUBTYPES; i++)
			l.add(new ItemStack(this, 1, i));
	}

        @Override
	public String getUnlocalizedName (ItemStack s)
	{
		return super.getUnlocalizedName() + "." + s.getItemDamage();
	}
}
