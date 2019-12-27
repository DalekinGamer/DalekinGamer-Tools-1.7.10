package dgtools.common.blocks;

import dgtools.common.DGMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ItemBlockBlackOsmiumOre extends Block
{
	public ItemBlockBlackOsmiumOre ()
	{
            super(Material.rock);
            this.setCreativeTab(DGMain.dgTab);
            this.setBlockTextureName("dg:ItemBlockBlackOsmiumOre");
            this.setBlockName("ItemBlockBlackOsmiumOre");
            this.setHardness(5.0F);
            this.setResistance(5.0F);
            this.setHarvestLevel("pickaxe", 3);
        }
        
       
}