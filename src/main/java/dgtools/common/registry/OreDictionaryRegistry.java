package dgtools.common.registry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryRegistry
{
	public static void init ()
	{
            OreDictionary.registerOre("oreOsmium", new ItemStack(BlockRegistry.ItemBlockOsmiumOre));
            OreDictionary.registerOre("oreBlackOsmium", new ItemStack(BlockRegistry.ItemBlockBlackOsmiumOre));
            OreDictionary.registerOre("oreRedOsmium", new ItemStack(BlockRegistry.ItemBlockRedOsmiumOre));
            OreDictionary.registerOre("oreMithril", new ItemStack(BlockRegistry.ItemBlockMithrilOre));
        
	}
}
