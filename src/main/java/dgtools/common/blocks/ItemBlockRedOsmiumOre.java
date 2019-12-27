package dgtools.common.blocks;

import dgtools.common.DGMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ItemBlockRedOsmiumOre extends Block
{
	public ItemBlockRedOsmiumOre ()
	{
            super(Material.rock);
            this.setCreativeTab(DGMain.dgTab);
            this.setBlockTextureName("dg:ItemBlockRedOsmiumOre");
            this.setBlockName("ItemBlockRedOsmiumOre");
            this.setHardness(5.0F);
            this.setResistance(5.0F);
            this.setHarvestLevel("pickaxe", 4);
        }
        
       
}