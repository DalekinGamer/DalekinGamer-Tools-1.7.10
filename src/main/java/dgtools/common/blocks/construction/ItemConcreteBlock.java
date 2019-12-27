package dgtools.common.blocks.construction;

import dgtools.common.DGMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ItemConcreteBlock extends Block
{
	public ItemConcreteBlock ()
	{
            super(Material.rock);
            this.setCreativeTab(DGMain.dgTabConstruction);
            this.setBlockTextureName("dg:ItemConcreteBlock");
            this.setBlockName("ItemConcreteBlock");
            this.setHardness(300.0F);
            this.setResistance(300.0F);
            this.setHarvestLevel("pickaxe", 3);
        }
        
       
}