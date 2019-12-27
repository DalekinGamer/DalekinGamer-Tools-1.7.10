package dgtools.common.lib;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class LibToolMaterials
{
	
    
    // Tools
    public static ToolMaterial toolOsmium = EnumHelper.addToolMaterial("OSMIUM", 3, 1200, 8.5F, 3.0F, 20);
    public static ToolMaterial toolBlackOsmium = EnumHelper.addToolMaterial("BLACKOSMIUM", 4, 2200, 17.0F, 6.0F, 30);
    public static ToolMaterial toolRedOsmium = EnumHelper.addToolMaterial("REDOSMIUM", 5, 100, 18.0F, 12.0F, 40);
    public static ToolMaterial toolSIGMetal = EnumHelper.addToolMaterial("SIGMetal", 6, 100, 8.0F, 0, 25);
    public static ToolMaterial toolexemple2 = EnumHelper.addToolMaterial("toolexemple2", 3, 512, 16.0F, 14.5F, 28);
    
    // Tools Specials
    public static ToolMaterial ThorHammer = EnumHelper.addToolMaterial("THORHAMMER", 40, 22000, 170.0F, 60.0F, 300);
    public static ToolMaterial ThaumiumDrill = EnumHelper.addToolMaterial("THAUMIUMDRILL", 5, 2300, 18.0F, 7.0F, 40);
    
    // Armor
    public static ArmorMaterial armorBlackOsmium = EnumHelper.addArmorMaterial("OSMIOBLACK", 2500, new int[]{ 4, 10, 6, 4 }, 30);
    public static ArmorMaterial armorMithril = EnumHelper.addArmorMaterial("MITHRIL", 5500, new int[]{ 10, 15, 13, 10 }, 50);
    public static ArmorMaterial armorexemple2 = EnumHelper.addArmorMaterial("armorexemple2", 500, new int[]{ 4, 6, 6, 4 }, 25);
    public static ArmorMaterial armorexemple3 = EnumHelper.addArmorMaterial("armorexemple3", 300, new int[]{ 4, 8, 6, 0 }, 20);
	
}
