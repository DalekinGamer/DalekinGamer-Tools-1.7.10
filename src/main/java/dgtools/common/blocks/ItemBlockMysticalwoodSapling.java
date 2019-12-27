package dgtools.common.blocks;

import dgtools.common.DGMain;
import dgtools.common.world.WorldGenMysticalwoodTree;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import dgtools.common.registry.BlockRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockMysticalwoodSapling extends BlockSapling
{
	public ItemBlockMysticalwoodSapling ()
	{
		super();
		this.setCreativeTab(DGMain.dgTab);
		this.setBlockName("ItemBlockMysticalwoodSapling");
		this.setStepSound(soundTypeGrass);
	}

	@Override
	public void func_149878_d (World world, int x, int y, int z, Random rand)
	{
		if (!world.isRemote)
		{
			int meta = world.getBlockMetadata(x, y, z);

			world.setBlockToAir(x, y, z);

			WorldGenMysticalwoodTree tree = new WorldGenMysticalwoodTree(true, BlockRegistry.ItemBlockMysticalwoodLog, BlockRegistry.ItemBlockMysticalwoodLeaves);

			if (!tree.generate(world, rand, x, y, z))
			{
				world.setBlock(x, y, z, this, meta, 2);
			}
		}
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void getSubBlocks (Item s, CreativeTabs t, List l)
	{
		l.add(new ItemStack(this, 1, 0));
	}

	@Override
	public Item getItemDropped (int i, Random random, int i2)
	{
		return Item.getItemFromBlock(this);
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void registerBlockIcons (IIconRegister ir)
	{
		this.blockIcon = ir.registerIcon("dg:mysticalwoodsapling");
	}

	@SideOnly (Side.CLIENT)
	@Override
	public IIcon getIcon (int side, int meta)
	{
		return this.blockIcon;
	}
}