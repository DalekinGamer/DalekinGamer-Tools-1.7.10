package dgtools.common.items.wand;

import dgtools.common.DGMain;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;


public class ItemMysticalwoodWandRod extends Item
{
	public int SUBTYPES = 2;
	public IIcon[] icons = new IIcon[SUBTYPES];

	public ItemMysticalwoodWandRod ()
	{
		this.setCreativeTab(DGMain.dgTab);
		this.setUnlocalizedName("ItemMysticalwoodWandRod");
		this.setHasSubtypes(true);
	}

        @Override
	public EnumRarity getRarity (ItemStack s)
	{
		return DGMain.rarityDarkAqua;
	}

	@SideOnly (Side.CLIENT)
        @Override
	public void registerIcons (IIconRegister ir)
	{
		for (int i = 0; i < icons.length; i++)
			this.icons[i] = ir.registerIcon("dg:ItemMysticalwoodWandRod" + i);
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
