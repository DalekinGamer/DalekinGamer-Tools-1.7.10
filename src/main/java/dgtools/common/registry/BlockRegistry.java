package dgtools.common.registry;

import dgtools.common.items.blocks.RarityDarkAquaBlockMithrilOre;
import dgtools.common.blocks.ItemBlockMithrilOre;
import dgtools.common.blocks.ItemBlockBlackOsmiumOre;
import dgtools.common.blocks.ItemBlockOsmiumOre;
import dgtools.common.blocks.ItemBlockRedOsmiumOre;
import dgtools.common.items.blocks.RarityRedBlockRedOsmiumOre;
import dgtools.common.items.blocks.UncommonBlockBlackOsmiumOre;
import dgtools.common.items.blocks.rarityDarkGreenBlockOsmiumOre;
import dgtools.common.blocks.BlockLumos;
import dgtools.common.blocks.ItemBlockMysticalwoodLeaves;
import dgtools.common.blocks.ItemBlockMysticalwoodLog;
import dgtools.common.blocks.ItemBlockMysticalwoodPlanks;
import dgtools.common.blocks.ItemBlockMysticalwoodSapling;
import dgtools.common.blocks.construction.ItemConcreteBlock;
import dgtools.common.items.blocks.rarityDarkAquaBlockMysticalwoodSapling;
import dgtools.common.blocks.tile.TileLumos;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockRegistry
{
	public static void init ()
	{
	// Osmio Ore and Block
	ItemBlockOsmiumOre = new ItemBlockOsmiumOre();
	GameRegistry.registerBlock(ItemBlockOsmiumOre, rarityDarkGreenBlockOsmiumOre.class, "BlockOsmiumOre");
        
        // Black Osmium Ore and Block
	ItemBlockBlackOsmiumOre = new ItemBlockBlackOsmiumOre();
	GameRegistry.registerBlock(ItemBlockBlackOsmiumOre, UncommonBlockBlackOsmiumOre.class, "BlockBlackOsmiumOre");
        
        // Red Osmium Ore and Block
        ItemBlockRedOsmiumOre = new ItemBlockRedOsmiumOre();
	GameRegistry.registerBlock(ItemBlockRedOsmiumOre, RarityRedBlockRedOsmiumOre.class, "BlockRedOsmiumOre");
        
        // Mithril Ore and Block
        ItemBlockMithrilOre = new ItemBlockMithrilOre();
	GameRegistry.registerBlock(ItemBlockMithrilOre, RarityDarkAquaBlockMithrilOre.class, "BlockMithrilOre");
        
        // Mysticalwood Log
	ItemBlockMysticalwoodLog = new ItemBlockMysticalwoodLog();
	GameRegistry.registerBlock(ItemBlockMysticalwoodLog, "ItemBlockMysticalwoodLog");
        
        // Mysticalwood Planks
	ItemBlockMysticalwoodPlanks = new ItemBlockMysticalwoodPlanks();
	GameRegistry.registerBlock(ItemBlockMysticalwoodPlanks, "ItemBlockMysticalwoodPlanks");

        
        // Mysticalwood Leaves
	ItemBlockMysticalwoodLeaves = new ItemBlockMysticalwoodLeaves();
	GameRegistry.registerBlock(ItemBlockMysticalwoodLeaves, "ItemBlockMysticalwoodLeaves");

        // Mysticalwood Sapling
	ItemBlockMysticalwoodSapling = new ItemBlockMysticalwoodSapling();
	GameRegistry.registerBlock(ItemBlockMysticalwoodSapling, rarityDarkAquaBlockMysticalwoodSapling.class, "BlockMysticalwoodSapling");

        // Decoration
        ItemConcreteBlock = new ItemConcreteBlock();
	GameRegistry.registerBlock(ItemConcreteBlock, "ConcreteBlock");
        
        // Lumos sparkles
	BlockLumos = new BlockLumos();
	GameRegistry.registerBlock(BlockLumos, "BlockLumos");
        
        
	}
        
        public static void initTiles ()
	{
		// Lumos
		GameRegistry.registerTileEntity(TileLumos.class, "TileLumos");
	}

        public static Block ItemBlockOsmiumOre;
        public static Block ItemBlockBlackOsmiumOre;
        public static Block ItemBlockRedOsmiumOre;
        public static Block ItemBlockMithrilOre;
        public static Block ItemBlockMysticalwoodLog;
	public static Block ItemBlockMysticalwoodPlanks;
        public static Block ItemBlockMysticalwoodLeaves;
        public static Block ItemBlockMysticalwoodSapling;
        public static Block ItemConcreteBlock;
        public static Block BlockLumos;
}