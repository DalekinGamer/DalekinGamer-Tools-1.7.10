package dgtools.common;

import dgtools.common.helper.DgToolsHelper;
import dgtools.common.registry.ItemRegistry;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.items.wands.ItemWandCasting;

public class DGTab extends CreativeTabs
{
    public List list = new ArrayList();
    
    public DGTab(String name)
    {
        super(name);
        
    }

    @Override
    public Item getTabIconItem()
    {
        return null;
    }
    
    @Override
    public void displayAllReleventItems (List l)
    {
            super.displayAllReleventItems(l);
            ItemStack wand = new ItemStack(ConfigItems.itemWandCasting);
            ItemWandCasting wandCasting = (ItemWandCasting) wand.getItem();

            wandCasting.setCap(wand, ItemRegistry.WAND_CAP_OSMIUM);
            wandCasting.setRod(wand, ItemRegistry.STAFF_ROD_MYSTICALWOOD);
            wandCasting.storeAllVis(wand, DgToolsHelper.getPrimals(200000));
            
            if (l != null) l.add(0, wand);

            wand = new ItemStack(ConfigItems.itemWandCasting);
            wandCasting = (ItemWandCasting) wand.getItem();

            wandCasting.setCap(wand, ItemRegistry.WAND_CAP_OSMIUM);
            wandCasting.setRod(wand, ItemRegistry.WAND_ROD_MYSTICALWOOD);
            wandCasting.storeAllVis(wand, DgToolsHelper.getPrimals(150000));
           
            if (l != null) l.add(1, wand);
            
            
    }

    @Override
    public ItemStack getIconItemStack ()
    {
		ItemStack wand = new ItemStack(ConfigItems.itemWandCasting);
		ItemWandCasting wandCasting = (ItemWandCasting) wand.getItem();

		wandCasting.setCap(wand, ItemRegistry.WAND_CAP_BLACKOSMIUM);
		wandCasting.setRod(wand, ItemRegistry.WAND_ROD_MYSTICALWOOD);

		return wand;
    }
    
    
    
    @Override
    public boolean hasSearchBar()
    {
        return false;
    } 
}
