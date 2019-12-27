package dgtools.common.registry;

import dgtools.common.DGMain;
import dgtools.common.research.DGToolsResearchItem;
import dgtools.common.research.ThaumcraftResearchItem;
import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ItemApi;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;

public class ResearchRegistry
{
	public static final String DGT = "DGT";
	public static HashMap recipes = new HashMap();

	public static void initResearch ()
	{
            ResearchCategories.registerCategory(DGT, new ResourceLocation("dg:textures/misc/IconThaumonomiconTab.png"), DGMain.configHandler.useCustomResearchTabBackground ? new ResourceLocation("dg:textures/gui/GUIThaumonomiconTab.png") : new ResourceLocation("thaumcraft:textures/gui/gui_researchback.png"));
            
           
            /**
             * Thaumcraft research items
             */
            new ThaumcraftResearchItem("DGTELDRITCHMAJOR", DGT, "ELDRITCHMAJOR", "ELDRITCH", 7, -7, new ResourceLocation("thaumcraft:textures/misc/r_eldritchmajor.png")).setSpecial().setConcealed().setRound().registerResearchItem();
            new ThaumcraftResearchItem("DGTFOCUSFIRE", DGT, "FOCUSFIRE", "THAUMATURGY", 7, 3, new ItemStack(ConfigItems.itemFocusFire)).setConcealed().registerResearchItem();
            new ThaumcraftResearchItem("DGTARMORFORTRESS", DGT, "ARMORFORTRESS", "ARTIFICE", 11, 1, new ItemStack(ConfigItems.itemHelmetFortress)).setConcealed().registerResearchItem();

            /**
             * DGTools research items
            */
            
            new DGToolsResearchItem("DGTools", DGT, new AspectList(), 2, -1, 0, ItemApi.getItem("itemShard", 6)).setRound().setAutoUnlock().setPages(new ResearchPage[]{ new ResearchPage("1"), new ResearchPage("2") }).registerResearchItem();
            // 1
            new DGToolsResearchItem("MYSTICALSHARD", DGT, new AspectList().add(Aspect.CRYSTAL, 4).add(Aspect.DARKNESS, 4), 4, -1, 0, new ItemStack(ItemRegistry.ItemSimple, 0)).setParents("DGTools").setConcealed().setSecondary().setPages(new ResearchPage[]{ new ResearchPage("1"), new ResearchPage((CrucibleRecipe) recipes.get("ItemSimple:0")) }).registerResearchItem();
            // 1.2
            new DGToolsResearchItem("MYSTICALTREE", DGT, new AspectList().add(Aspect.MAGIC, 4).add(Aspect.PLANT, 4).add(Aspect.LIFE, 4).add(Aspect.TREE, 4), 6, -2, 0, new ItemStack(BlockRegistry.ItemBlockMysticalwoodSapling)).setParents("MYSTICALSHARD").setConcealed().setPages(new ResearchPage[]{ new ResearchPage("1"), new ResearchPage((InfusionRecipe) recipes.get("ItemBlockMysticalwoodSapling")), new ResearchPage((IRecipe) recipes.get("ItemBlockMysticalwoodPlanks")) }).registerResearchItem();
            // 1.3
            new DGToolsResearchItem("ROD_mysticalwood", DGT, new AspectList().add(Aspect.TREE, 4).add(Aspect.DARKNESS, 4).add(Aspect.ELDRITCH, 4), 7, -1, 0, new ItemStack(ItemRegistry.ItemMysticalwoodWandRod, 1, 0)).setParents("MYSTICALTREE").setConcealed().setPages(new ResearchPage[]{ new ResearchPage("1"), new ResearchPage((InfusionRecipe) recipes.get("ItemMysticalwoodWandRod:0")) }).registerResearchItem();
            ThaumcraftApi.addWarpToResearch("ROD_mysticalwood", 5);
            // 1.4
            new DGToolsResearchItem("ROD_mysticalwood_staff", DGT, new AspectList().add(Aspect.TREE, 4).add(Aspect.DARKNESS, 4).add(Aspect.ELDRITCH, 4), 8, -1, 0, new ItemStack(ItemRegistry.ItemMysticalwoodWandRod, 1, 1)).setConcealed().setParents("ROD_mysticalwood").setPages(new ResearchPage[]{ new ResearchPage("1"), new ResearchPage((IArcaneRecipe) recipes.get("ItemMysticalwoodWandRod:1")) }).setSecondary().registerResearchItem();

          
            // 2
            new DGToolsResearchItem("OSMIUM", DGT, new AspectList().add(Aspect.METAL, 1).add(Aspect.DARKNESS, 1).add(Aspect.MAGIC, 1), 0, 1, 0, new ItemStack(BlockRegistry.ItemBlockOsmiumOre)).setParents("DGTools").setConcealed().setPages(new ResearchPage[]{ new ResearchPage("1"), new ResearchPage((CrucibleRecipe) recipes.get("ItemBlockOsmiumOre")), new ResearchPage(new ItemStack(BlockRegistry.ItemBlockOsmiumOre)), new ResearchPage((IRecipe) recipes.get("ItemOsmiumPickaxe")), new ResearchPage((IRecipe) recipes.get("ItemOsmiumShovel")), new ResearchPage((IRecipe) recipes.get("ItemOsmiumAxe")), new ResearchPage((IRecipe) recipes.get("ItemOsmiumHoe")), new ResearchPage((IRecipe) recipes.get("ItemOsmiumSword")) }).registerResearchItem();
            
            new DGToolsResearchItem("CAP_osmium", DGT, new AspectList().add(Aspect.METAL, 1).add(Aspect.DARKNESS, 1).add(Aspect.MAGIC, 1), 2, 1, 0, new ItemStack(ItemRegistry.OsmiumWandCap, 1, 1)).setParents("OSMIUM").setConcealed().setPages(new ResearchPage[]{ new ResearchPage("1"), new ResearchPage((IArcaneRecipe) recipes.get("ItemOsmiumWandCap:0")), new ResearchPage((InfusionRecipe) recipes.get("ItemOsmiumWandCap:1")) }).registerResearchItem();

        
        
        
        }
           
            
            
            
            
            
}
        
