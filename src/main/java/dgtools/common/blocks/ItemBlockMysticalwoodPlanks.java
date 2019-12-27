package dgtools.common.blocks;

import dgtools.common.DGMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ItemBlockMysticalwoodPlanks extends Block
{
	public ItemBlockMysticalwoodPlanks ()
	{
		super(Material.wood);
		this.setCreativeTab(DGMain.dgTab);
		this.setBlockName("ItemBlockMysticalwoodPlanks");
		this.setBlockTextureName("dg:mysticalwoodplanks");
		this.setHardness(0.8F);
		this.setStepSound(soundTypeWood);
	}
}
