package dgtools.common.items.equipment;

import dgtools.common.DGMain;
import static dgtools.common.registry.ItemRegistry.ItemBlackOsmiumBoots;
import static dgtools.common.registry.ItemRegistry.ItemBlackOsmiumHelmet;
import static dgtools.common.registry.ItemRegistry.ItemBlackOsmiumLeggings;
import static dgtools.common.registry.ItemRegistry.ItemBlackOsmiumChestplate;

import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemBlackOsmiumArmor extends ItemArmor
{
    
    public ItemBlackOsmiumArmor(ItemArmor.ArmorMaterial material, int armorType, String name)
    {
	super(material, 0, armorType);
	setUnlocalizedName(name);
	setTextureName("dg:" + name);
        setCreativeTab(DGMain.dgTab);
    }
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
        {
            if(stack.getItem() == ItemBlackOsmiumHelmet || stack.getItem() == ItemBlackOsmiumChestplate || stack.getItem() == ItemBlackOsmiumBoots)
            {
                return "dg:models/armor/Black_Osmium_layer_1.png";
            }
            else if(stack.getItem() == ItemBlackOsmiumLeggings)
            {
		return "dg:models/armor/Black_Osmium_layer_2.png";
            }
		return null;
	}
        @Override
	public EnumRarity getRarity (ItemStack s)
	{
		return EnumRarity.uncommon;
	}
}