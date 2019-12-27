package dgtools.common.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ItemApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.crafting.CraftingManager;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.common.config.ConfigItems;

public class RecipeRegistry
{
    public static void init ()
    {
	initCrafting();
        initSmelting();
        initCrucible();
	initInfusion();
	initArcane();
		
    }
    public static void initCrafting ()
    {
    // Black Osmium
    ResearchRegistry.recipes.put("ItemOsmiumPickaxe", GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.ItemOsmiumPickaxe), new Object[]{ "AAA", " B ", " B ", Character.valueOf('A'), new ItemStack(ItemRegistry.ItemSimple, 1, 3), Character.valueOf('B'), new ItemStack(Items.stick) }));

    ResearchRegistry.recipes.put("ItemOsmiumAxe", CraftingManager.getInstance().addRecipe(new ItemStack(ItemRegistry.ItemOsmiumAxe), new Object[]{ "AA ", "AB ", " B ", Character.valueOf('A'), new ItemStack(ItemRegistry.ItemSimple, 1, 3), Character.valueOf('B'), new ItemStack(Items.stick) }));

    ResearchRegistry.recipes.put("ItemOsmiumShovel", CraftingManager.getInstance().addRecipe(new ItemStack(ItemRegistry.ItemOsmiumShovel), new Object[]{ " A ", " B ", " B ", Character.valueOf('A'), new ItemStack(ItemRegistry.ItemSimple, 1, 3), Character.valueOf('B'), new ItemStack(Items.stick) }));

    ResearchRegistry.recipes.put("ItemOsmiumHoe", CraftingManager.getInstance().addRecipe(new ItemStack(ItemRegistry.ItemOsmiumHoe), new Object[]{ "AA ", " B ", " B ", Character.valueOf('A'), new ItemStack(ItemRegistry.ItemSimple, 1, 3), Character.valueOf('B'), new ItemStack(Items.stick) }));

    ResearchRegistry.recipes.put("ItemOsmiumSword", GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.ItemOsmiumSword), new Object[]{ " A ", " A ", " B ", Character.valueOf('A'), new ItemStack(ItemRegistry.ItemSimple, 1, 3), Character.valueOf('B'), new ItemStack(Items.stick) }));

        
    ResearchRegistry.recipes.put("ItemBlockMysticalwoodPlanks", CraftingManager.getInstance().addRecipe(new ItemStack(BlockRegistry.ItemBlockMysticalwoodPlanks, 4), new Object[]{ "A", Character.valueOf('A'), new ItemStack(BlockRegistry.ItemBlockMysticalwoodLog) }));
    
    
    }
    
    public static void initSmelting ()
    {
    // Osmium
    GameRegistry.addSmelting(BlockRegistry.ItemBlockOsmiumOre, new ItemStack(ItemRegistry.ItemSimple, 1, 3), 2.0F);    

    // Black Osmium
    GameRegistry.addSmelting(BlockRegistry.ItemBlockBlackOsmiumOre, new ItemStack(ItemRegistry.ItemSimple, 1, 5), 3.0F);
        

    // Red Osmium
    GameRegistry.addSmelting(BlockRegistry.ItemBlockRedOsmiumOre, new ItemStack(ItemRegistry.ItemSimple, 1, 7), 4.0F);
        
    }

    public static void initInfusion ()
    {
    // Mysticalwood Sapiling    
    ResearchRegistry.recipes.put("ItemBlockMysticalwoodSapling", ThaumcraftApi.addInfusionCraftingRecipe("MYSTICALTREE", new ItemStack(BlockRegistry.ItemBlockMysticalwoodSapling), 3, new AspectList().add(Aspect.MAGIC, 8).add(Aspect.TREE, 8).add(Aspect.LIFE, 8), new ItemStack(Blocks.sapling, 1, Short.MAX_VALUE), new ItemStack[]{ new ItemStack(ItemRegistry.ItemSimple, 1, 0), ItemApi.getItem("itemShard", 6), new ItemStack(ItemRegistry.ItemSimple, 0), ItemApi.getItem("itemShard", 6) }));
    
    // Mysticalwood Rod
    ResearchRegistry.recipes.put("ItemMysticalwoodWandRod:0", ThaumcraftApi.addInfusionCraftingRecipe("ROD_mysticalwood", new ItemStack(ItemRegistry.ItemMysticalwoodWandRod, 1, 0), 8, new AspectList().add(Aspect.ELDRITCH, 65).add(Aspect.DARKNESS, 30).add(Aspect.TREE, 12).add(Aspect.MAGIC, 45).add(Aspect.AURA, 35), new ItemStack(BlockRegistry.ItemBlockMysticalwoodLog), new ItemStack[]{ new ItemStack(ItemRegistry.ItemSimple, 0), ItemApi.getItem("itemShard", 0), ItemApi.getItem("itemShard", 1), ItemApi.getItem("itemShard", 2), ItemApi.getItem("itemShard", 6), ItemApi.getItem("itemShard", 3), ItemApi.getItem("itemShard", 4), ItemApi.getItem("itemShard", 5) }));
    
    // Osmium Wand Cap
    ResearchRegistry.recipes.put("ItemOsmiumWandCap:1", ThaumcraftApi.addInfusionCraftingRecipe("CAP_osmium", new ItemStack(ItemRegistry.OsmiumWandCap, 1, 1), 8, new AspectList().add(Aspect.AURA, 55).add(Aspect.ENERGY, 47).add(Aspect.MAGIC, 52), new ItemStack(ItemRegistry.OsmiumWandCap, 1, 0), new ItemStack[]{ new ItemStack(ItemRegistry.ItemSimple, 1, 3), new ItemStack(ItemRegistry.ItemSimple, 1, 0), ItemApi.getItem("itemResource", 14), new ItemStack(ItemRegistry.ItemSimple, 1, 0), new ItemStack(ItemRegistry.ItemSimple, 1, 3), new ItemStack(ItemRegistry.ItemSimple, 1, 0), ItemApi.getItem("itemResource", 14), new ItemStack(ItemRegistry.ItemSimple, 1, 0) }));

       
        
        
    }
    
    public static void initArcane ()
    {
    
    ResearchRegistry.recipes.put("ItemOsmiumWandCap:0", ThaumcraftApi.addArcaneCraftingRecipe("CAP_osmium", new ItemStack(ItemRegistry.OsmiumWandCap, 1, 0), new AspectList().add(Aspect.EARTH, 25).add(Aspect.FIRE, 25).add(Aspect.ENTROPY, 25).add(Aspect.ORDER, 25), new Object[]{ "AAA", "ABA", Character.valueOf('A'), new ItemStack(ItemRegistry.ItemSimple, 1, 4), Character.valueOf('B'), ItemApi.getItem("itemResource", 14) }));
        
    ResearchRegistry.recipes.put("ItemMysticalwoodWandRod:1", ThaumcraftApi.addArcaneCraftingRecipe("ROD_mysticalwood_staff", new ItemStack(ItemRegistry.ItemMysticalwoodWandRod, 1, 1), new AspectList().add(Aspect.ORDER, 120).add(Aspect.WATER, 120).add(Aspect.EARTH, 120).add(Aspect.AIR, 120).add(Aspect.FIRE, 120).add(Aspect.ENTROPY, 120), new Object[]{ "  A", " B ", "B  ", Character.valueOf('A'), new ItemStack(ConfigItems.itemEldritchObject, 1, 3), Character.valueOf('B'), new ItemStack(ItemRegistry.ItemMysticalwoodWandRod, 1, 0) }));
    
        

    }
    
    public static void initCrucible ()
    {
        
    ResearchRegistry.recipes.put("ItemBlockOsmiumOre", ThaumcraftApi.addCrucibleRecipe("OSMIUM", new ItemStack(BlockRegistry.ItemBlockOsmiumOre, 2), new ItemStack(BlockRegistry.ItemBlockOsmiumOre), new AspectList().merge(Aspect.MAGIC, 64)));
		
        
    ResearchRegistry.recipes.put("ItemSimple:0", ThaumcraftApi.addCrucibleRecipe("MYSTICALSHARD", new ItemStack(ItemRegistry.ItemSimple, 0), ItemApi.getItem("itemShard", 6), new AspectList().merge(Aspect.MAGIC, 4)));
		
        	
        
    }
    
}
