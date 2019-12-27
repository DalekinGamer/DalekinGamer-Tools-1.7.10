package dgtools.common.blocks;

import dgtools.common.DGMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ItemBlockMithrilOre extends Block
{
	public ItemBlockMithrilOre ()
	{
            super(Material.rock);
            this.setCreativeTab(DGMain.dgTab);
            this.setBlockTextureName("dg:ItemBlockMithrilOre");
            this.setBlockName("ItemBlockMithrilOre");
            this.setHardness(8.0F);
            this.setResistance(8.0F);
            this.setHarvestLevel("pickaxe", 5);
        }
        
       
}