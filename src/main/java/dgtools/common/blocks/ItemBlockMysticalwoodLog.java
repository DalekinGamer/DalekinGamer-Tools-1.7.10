package dgtools.common.blocks;

import dgtools.common.DGMain;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockMysticalwoodLog extends BlockRotatedPillar
{
	private IIcon side;
	private IIcon top;

	public ItemBlockMysticalwoodLog ()
	{
		super(Material.wood);
		this.setCreativeTab(DGMain.dgTab);
		this.setHardness(2.5F);
		this.setStepSound(soundTypeWood);
		this.setBlockName("ItemBlockMysticalwoodLog");
	}

	@SideOnly (Side.CLIENT)
        @Override
	protected IIcon getTopIcon (int i)
	{
		return this.top;
	}

	@SideOnly (Side.CLIENT)
        @Override
	protected IIcon getSideIcon (int i)
	{
		return this.side;
	}

	@SideOnly (Side.CLIENT)
        @Override
	public void registerBlockIcons (IIconRegister ir)
	{
		this.side = ir.registerIcon("dg:mysticalwoodside");
		this.top = ir.registerIcon("dg:mysticalwoodtop");
	}

        @Override
	public boolean canSustainLeaves (IBlockAccess w, int x, int y, int z)
	{
		return true;
	}

        @Override
	public boolean isWood (IBlockAccess w, int x, int y, int z)
	{
		return true;
	}

        @Override
	public int getFlammability (IBlockAccess w, int x, int y, int z, ForgeDirection face)
	{
		return 0;
	}

        @Override
	public int getFireSpreadSpeed (IBlockAccess w, int x, int y, int z, ForgeDirection face)
	{
		return 0;
	}
}
