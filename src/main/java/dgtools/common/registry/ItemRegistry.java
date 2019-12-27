package dgtools.common.registry;

import dgtools.common.items.equipment.ItemMithrilArmor;
import dgtools.common.items.equipment.ItemMithrilBoots;
import dgtools.common.items.equipment.ItemBlackOsmiumArmor;
import dgtools.common.items.tools.ItemBlackOsmiumAxe;
import dgtools.common.items.tools.ItemBlackOsmiumHoe;
import dgtools.common.items.tools.ItemBlackOsmiumPickaxe;
import dgtools.common.items.tools.ItemBlackOsmiumShovel;
import dgtools.common.items.tools.ItemBlackOsmiumSword;
import dgtools.common.items.tools.energyic2.ItemRedOsmiumPickaxe;
import dgtools.common.items.tools.energyic2.ItemRedOsmiumSword;
import dgtools.common.items.tools.special.ItemThorHammer;
import dgtools.common.items.wand.ItemBlackOsmiumWandCap;
import dgtools.common.lib.LibToolMaterials;
import dgtools.common.handler.WandHandler;
import dgtools.common.items.ItemSimple;
import dgtools.common.items.tools.ItemKatana;
import dgtools.common.items.tools.ItemOsmiumAxe;
import dgtools.common.items.tools.ItemOsmiumHoe;
import dgtools.common.items.tools.ItemOsmiumPickaxe;
import dgtools.common.items.tools.ItemOsmiumShovel;
import dgtools.common.items.tools.ItemOsmiumSword;
import dgtools.common.items.wand.ItemMysticalwoodWandRod;
import dgtools.common.items.wand.ItemOsmiumWandCap;
import dgtools.common.items.wand.foci.ItemFocusDarkMatter;
import dgtools.common.items.wand.foci.ItemFocusLumos;
import dgtools.common.items.wand.foci.ItemFocusMageMace;
import dgtools.common.items.wand.foci.ItemFocusMeteorology;
import dgtools.common.items.wand.foci.ItemFocusTaint;
import dgtools.common.items.wand.foci.ItemFocusTaintedShockwave;
import dgtools.common.items.wand.foci.ItemFocusTime;
import dgtools.common.items.wand.foci.ItemFocusVisShard;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.wands.StaffRod;
import thaumcraft.api.wands.WandCap;
import thaumcraft.api.wands.WandRod;

public class ItemRegistry
{
	public static void init ()
	{
	
        // ItemSimple
        ItemSimple = new ItemSimple();
	GameRegistry.registerItem(ItemSimple, "ItemSimple");
        
        // Armor
        
        ItemBlackOsmiumHelmet = new ItemBlackOsmiumArmor(LibToolMaterials.armorBlackOsmium, 0, "ItemBlackOsmiumHelmet");
	GameRegistry.registerItem(ItemBlackOsmiumHelmet, "ItemBlackOsmiumHelmet");
        
        ItemBlackOsmiumChestplate = new ItemBlackOsmiumArmor(LibToolMaterials.armorBlackOsmium, 1, "ItemBlackOsmiumChestplate");
        GameRegistry.registerItem(ItemBlackOsmiumChestplate, "ItemBlackOsmiumChestplate");
        
        ItemBlackOsmiumLeggings = new ItemBlackOsmiumArmor(LibToolMaterials.armorBlackOsmium, 2, "ItemBlackOsmiumLeggings");
	GameRegistry.registerItem(ItemBlackOsmiumLeggings, "ItemBlackOsmiumLeggings");
        
        ItemBlackOsmiumBoots = new ItemBlackOsmiumArmor(LibToolMaterials.armorBlackOsmium, 3, "ItemBlackOsmiumBoots");
	GameRegistry.registerItem(ItemBlackOsmiumBoots, "ItemOsmioBlackBoots");

        ItemMithrilArmorHelmet = new ItemMithrilArmor(LibToolMaterials.armorMithril, 4, 0).setUnlocalizedName("ItemMithrilArmorHelmet");
	GameRegistry.registerItem(ItemMithrilArmorHelmet, "ItemMithrilArmorHelmet");
        
        ItemMithrilArmorChestplate = new ItemMithrilArmor(LibToolMaterials.armorMithril, 4, 1).setUnlocalizedName("ItemMithrilArmorChestplate");
	GameRegistry.registerItem(ItemMithrilArmorChestplate, "ItemMithrilArmorChestplate");
                
        ItemMithrilArmorLeggings = new ItemMithrilArmor(LibToolMaterials.armorMithril, 4, 2).setUnlocalizedName("ItemMithrilArmorLeggings");
	GameRegistry.registerItem(ItemMithrilArmorLeggings, "ItemMithrilArmorLeggings");
                
        ItemMithrilBoots = new ItemMithrilBoots(LibToolMaterials.armorMithril, 4, 3).setUnlocalizedName("ItemMithrilBoots");
	GameRegistry.registerItem(ItemMithrilBoots, "ItemMithrilBoots");
        
        // Wands and Staves
        ItemMysticalwoodWandRod = new ItemMysticalwoodWandRod();
        GameRegistry.registerItem(ItemMysticalwoodWandRod, "ItemMysticalwoodWandRod");
        
        WAND_ROD_MYSTICALWOOD = new WandRod("mysticalwood", 1500, new ItemStack(ItemMysticalwoodWandRod, 1, 0), 16, new WandHandler(), new ResourceLocation("dg:models/ModelWAND_ROD_MYSTICALWOOD.png"));
	WAND_ROD_MYSTICALWOOD.setGlowing(true);

	STAFF_ROD_MYSTICALWOOD = new StaffRod("mysticalwood", 2000, new ItemStack(ItemMysticalwoodWandRod, 1, 1), 20, new WandHandler(), new ResourceLocation("dg:models/ModelWAND_ROD_MYSTICALWOOD.png"));
	STAFF_ROD_MYSTICALWOOD.setRunes(true);
	STAFF_ROD_MYSTICALWOOD.setGlowing(true);
        
        
        OsmiumWandCap = new ItemOsmiumWandCap();
        GameRegistry.registerItem(OsmiumWandCap, "OsmiumWandCap");
        
        WAND_CAP_OSMIUM = new WandCap("osmium", 0.95F, new ItemStack(OsmiumWandCap, 1, 1), 3);
	WAND_CAP_OSMIUM.setTexture(new ResourceLocation("dg:models/WandCapOsmium.png"));
       
        BlackOsmiumWandCap = new ItemBlackOsmiumWandCap();
	GameRegistry.registerItem(BlackOsmiumWandCap, "BlackOsmiumWandCap");

	WAND_CAP_BLACKOSMIUM = new WandCap("blackosmium", 0.85F, new ItemStack(BlackOsmiumWandCap, 1, 1), 4);
	WAND_CAP_BLACKOSMIUM.setTexture(new ResourceLocation("dg:models/WandCapBlackOsmium.png"));
        
        
        
        // Foci
	ItemFocusTaint = new ItemFocusTaint();
	GameRegistry.registerItem(ItemFocusTaint, "ItemFocusTaint");

	ItemFocusDarkMatter = new ItemFocusDarkMatter();
	GameRegistry.registerItem(ItemFocusDarkMatter, "ItemFocusDarkMatter");

	ItemFocusMeteorology = new ItemFocusMeteorology();
	GameRegistry.registerItem(ItemFocusMeteorology, "ItemFocusMeteorology");

	ItemFocusTime = new ItemFocusTime();
	GameRegistry.registerItem(ItemFocusTime, "ItemFocusTime");

	ItemFocusMageMace = new ItemFocusMageMace();
	GameRegistry.registerItem(ItemFocusMageMace, "ItemFocusMageMace");

	ItemFocusTaintedShockwave = new ItemFocusTaintedShockwave();
	GameRegistry.registerItem(ItemFocusTaintedShockwave, "ItemFocusTaintedShockwave");

	ItemFocusVisShard = new ItemFocusVisShard();
	GameRegistry.registerItem(ItemFocusVisShard, "ItemFocusVisShard");

	ItemFocusLumos = new ItemFocusLumos();
	GameRegistry.registerItem(ItemFocusLumos, "ItemFocusLumos");

     
        // TOOLS
	
        ItemOsmiumSword = new ItemOsmiumSword(LibToolMaterials.toolOsmium);
        GameRegistry.registerItem(ItemOsmiumSword, "ItemOsmiumSword");
        
        ItemOsmiumPickaxe = new ItemOsmiumPickaxe(LibToolMaterials.toolOsmium);
        GameRegistry.registerItem(ItemOsmiumPickaxe, "ItemOsmiumPickaxe");
        
        ItemOsmiumAxe = new ItemOsmiumAxe(LibToolMaterials.toolOsmium);
        GameRegistry.registerItem(ItemOsmiumAxe, "ItemOsmiumAxe");
        
        ItemOsmiumHoe = new ItemOsmiumHoe(LibToolMaterials.toolOsmium);
        GameRegistry.registerItem(ItemOsmiumHoe, "ItemOsmiumHoe");
        
        ItemOsmiumShovel = new ItemOsmiumShovel(LibToolMaterials.toolOsmium);
        GameRegistry.registerItem(ItemOsmiumShovel, "ItemOsmiumShovel");
        
        
        ItemBlackOsmiumSword = new ItemBlackOsmiumSword(LibToolMaterials.toolBlackOsmium);
        GameRegistry.registerItem(ItemBlackOsmiumSword, "ItemBlackOsmiumSword");
        
        ItemBlackOsmiumPickaxe = new ItemBlackOsmiumPickaxe(LibToolMaterials.toolBlackOsmium);
        GameRegistry.registerItem(ItemBlackOsmiumPickaxe, "ItemBlackOsmiumPickaxe");
        
        ItemBlackOsmiumAxe = new ItemBlackOsmiumAxe(LibToolMaterials.toolBlackOsmium);
        GameRegistry.registerItem(ItemBlackOsmiumAxe, "ItemBlackOsmiumAxe");
        
        ItemBlackOsmiumHoe = new ItemBlackOsmiumHoe(LibToolMaterials.toolBlackOsmium);
        GameRegistry.registerItem(ItemBlackOsmiumHoe, "ItemBlackOsmiumHoe");
        
        ItemBlackOsmiumShovel = new ItemBlackOsmiumShovel(LibToolMaterials.toolBlackOsmium);
        GameRegistry.registerItem(ItemBlackOsmiumShovel, "ItemBlackOsmiumShovel");
        
        
        // Tools Ic2
        
        RedOsmiumPickaxe = new ItemRedOsmiumPickaxe(LibToolMaterials.toolRedOsmium);
	GameRegistry.registerItem(RedOsmiumPickaxe, "RedOsmiumPickaxe");
        
        RedOsmiumSword = new ItemRedOsmiumSword(LibToolMaterials.toolRedOsmium);
	GameRegistry.registerItem(RedOsmiumSword, "ItemRedOsmiumSword");

        // Tools Specials
        
        ItemThorHammer = new ItemThorHammer(LibToolMaterials.ThorHammer);
        GameRegistry.registerItem(ItemThorHammer, "ItemThorHammer");
        
        ItemKatana = new ItemKatana();
	GameRegistry.registerItem(ItemKatana, "ItemKatana");
        
        
	}
        // ItemSimple
        public static Item ItemSimple;
         
        // Wand
	public static Item ItemMysticalwoodWandRod;
        public static WandRod WAND_ROD_MYSTICALWOOD;
	public static StaffRod STAFF_ROD_MYSTICALWOOD;
        public static Item OsmiumWandCap;
        public static WandCap WAND_CAP_OSMIUM;
        public static Item BlackOsmiumWandCap;
        public static WandCap WAND_CAP_BLACKOSMIUM;
        
        
        // Foci
	public static Item ItemFocusTaint;
	public static Item ItemFocusDarkMatter;
	public static Item ItemFocusMeteorology;
	public static Item ItemFocusTime;
	public static Item ItemFocusMageMace;
	public static Item ItemFocusTaintedShockwave;
	public static Item ItemFocusVisShard;
	public static Item ItemFocusLumos;


        // Tools
	
        public static ItemSword ItemOsmiumSword;
        public static ItemPickaxe ItemOsmiumPickaxe;
        public static ItemAxe ItemOsmiumAxe;
        public static ItemHoe ItemOsmiumHoe;
        public static ItemSpade ItemOsmiumShovel;
        
        public static ItemSword ItemBlackOsmiumSword;
        public static ItemPickaxe ItemBlackOsmiumPickaxe;
        public static ItemAxe ItemBlackOsmiumAxe;
        public static ItemHoe ItemBlackOsmiumHoe;
        public static ItemSpade ItemBlackOsmiumShovel;
        
        
        
       
        // Tools ic2
        
        public static ItemPickaxe RedOsmiumPickaxe;
        public static ItemSword RedOsmiumSword;

        // Tools Special
        
        public static ItemSword ItemThorHammer;
        public static Item ItemKatana;

        // Armor
        
        public static Item ItemBlackOsmiumHelmet;
        public static Item ItemBlackOsmiumChestplate;
        public static Item ItemBlackOsmiumLeggings;
        public static Item ItemBlackOsmiumBoots;
        
        public static Item ItemMithrilArmorHelmet;
        public static Item ItemMithrilArmorChestplate;
        public static Item ItemMithrilArmorLeggings;
        public static Item ItemMithrilBoots;
}

