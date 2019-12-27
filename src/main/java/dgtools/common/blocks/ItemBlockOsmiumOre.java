package dgtools.common.blocks;

import dgtools.common.DGMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemBlockOsmiumOre extends Block
{
    public IIcon icon;
    public IIcon iconEnd;
    public IIcon iconNether;
    
    public ItemBlockOsmiumOre ()
    {
            super(Material.rock);
            this.setCreativeTab(DGMain.dgTab);
            this.setBlockTextureName("dg:ItemBlockOsmiumOre");
            this.setBlockName("ItemBlockOsmiumOre");
            this.setHardness(5.0F);
            this.setResistance(5.0F);
            this.setHarvestLevel("pickaxe", 2);
    }
    
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.icon = iconRegister.registerIcon("dg:blockosmiumore/" + "ItemBlockOsmiumOre");
        this.iconEnd = iconRegister.registerIcon("dg:blockosmiumore/" + "ItemBlockOsmiumOre_End");
        this.iconNether = iconRegister.registerIcon("dg:blockosmiumore/" + "ItemBlockOsmiumOre_Nether");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        World world = Minecraft.getMinecraft().theWorld;
        int dim = world != null && world.provider != null ? world.provider.dimensionId : 0;

        if (dim == -1)
        {
            return this.iconNether;
        }
        if (dim == 1)
        {
            return this.iconEnd;
        }
        return this.icon;
    }
    
    
    
    
}
