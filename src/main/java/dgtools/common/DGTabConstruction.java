package dgtools.common;

import dgtools.common.registry.BlockRegistry;
import dgtools.common.registry.ItemRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DGTabConstruction extends CreativeTabs
{
    public DGTabConstruction(String name)
    {
        super(name);
        
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack()
    {
        return new ItemStack(BlockRegistry.ItemConcreteBlock);
    }
    
    @Override
    public boolean hasSearchBar()
    {
        return false;
    }
    
    @Override
    public Item getTabIconItem()
    {
        return ItemRegistry.ItemBlackOsmiumSword; 
    }

}
