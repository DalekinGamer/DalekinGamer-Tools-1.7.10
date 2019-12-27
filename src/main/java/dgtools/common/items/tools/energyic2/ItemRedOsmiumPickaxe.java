package dgtools.common.items.tools.energyic2;

import dgtools.common.DGMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRedOsmiumPickaxe extends ItemPickaxe implements IElectricItem {

	public int maxCharge = 2000000;
	public int cost;
	public int tier = 4;
	public double transferLimit = 500;

	public ItemRedOsmiumPickaxe(Item.ToolMaterial m)
        {
		super(m);
		this.setCreativeTab(DGMain.dgTab);
		this.setMaxStackSize(1);
                this.setUnlocalizedName("ItemRedOsmiumPickaxe");
                
	}
        
        @Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("dg:ItemRedOsmiumPickaxe");
	}
        
        @Override
        public EnumRarity getRarity (ItemStack s)
	{
		return EnumRarity.rare;
	}

	
        @SideOnly(Side.CLIENT)
        @Override
	public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List itemList) {
		ItemStack itemStack = new ItemStack(this, 1);
		if (getChargedItem(itemStack) == this) {
			ItemStack charged = new ItemStack(this, 1);
			ElectricItem.manager.charge(charged, 2147483647, 2147483647, true, false);
			itemList.add(charged);
		}
		if (getEmptyItem(itemStack) == this) {
			itemList.add(new ItemStack(this, 1, getMaxDamage()));
		}
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int par4, int par5, int par6, EntityLivingBase entityLiving)
        {
		if (true)
                {
                    cost = 5000;
                }
		
		ElectricItem.manager.use(stack, cost, entityLiving);
		return true;
	}

	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta)
        {
		if (!ElectricItem.manager.canUse(stack, cost))
                {
			return 1.0F;
		}

		if (Items.wooden_pickaxe.getDigSpeed(stack, block, meta) > 1.0F || Items.wooden_shovel.getDigSpeed(stack, block, meta) > 1.0F)
                {
			return efficiencyOnProperMaterial;
		}
		else
                {
			return super.getDigSpeed(stack, block, meta);
		}
	}

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1) {
		return true;
	}

	@Override
	public boolean isRepairable()
        {
		return false;
	}

	@Override
	public int getItemEnchantability()
        {
		return 4;
	}

	@Override
	public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2)
        {
		return true;
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		return false;
	}

	@Override
	public double getMaxCharge(ItemStack itemStack) {
		return maxCharge;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		return tier;
	}

	@Override
	public double getTransferLimit(ItemStack itemStack) {
		return transferLimit;
	}

	@Override
	public Item getChargedItem(ItemStack itemStack) {
		return this;
	}

	@Override
	public Item getEmptyItem(ItemStack itemStack) {
		return this;
	}
}
