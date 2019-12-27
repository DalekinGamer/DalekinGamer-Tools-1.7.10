package dgtools.common.items.wand.foci;

import dgtools.common.DGMain;
import dgtools.common.entities.EntityDarkMatter;
import dgtools.common.entities.EntityDiffusion;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.FocusUpgradeType;
import thaumcraft.api.wands.ItemFocusBasic;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.items.wands.ItemWandCasting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFocusDarkMatter extends ItemFocusBasic
{
	IIcon depthIcon = null;

	private static final AspectList cost = new AspectList().add(Aspect.ENTROPY, 20).add(Aspect.FIRE, 20);
	private static final AspectList costSanity = new AspectList().add(Aspect.ENTROPY, 20).add(Aspect.FIRE, 50).add(Aspect.ORDER, 50);
	private static final AspectList costCorrosive = new AspectList().add(Aspect.ENTROPY, 20).add(Aspect.FIRE, 50).add(Aspect.WATER, 20);

	public ItemFocusDarkMatter ()
	{
		this.setCreativeTab(DGMain.dgTab);
		this.setUnlocalizedName("ItemFocusDarkMatter");
	}

	@SideOnly (Side.CLIENT)
        @Override
	public void registerIcons (IIconRegister ir)
	{
		this.icon = ir.registerIcon("dg:ItemFocusDarkMatter");
		this.depthIcon = ir.registerIcon("dg:ItemFocusDarkMatter_depth");
	}

        @Override
	public IIcon getFocusDepthLayerIcon (ItemStack s)
	{
		return this.depthIcon;
	}

        @Override
	public String getSortingHelper (ItemStack s)
	{
		return "ELDRITCH" + super.getSortingHelper(s);
	}

        @Override
	public int getFocusColor (ItemStack s)
	{
		return 0x000018;
	}

        @Override
	public AspectList getVisCost (ItemStack s)
	{
		return isUpgradedWith(s, FocusUpgrades.corrosive) ? costCorrosive : isUpgradedWith(s, FocusUpgrades.sanity) ? costSanity : cost;
	}

        @Override
	public int getActivationCooldown (ItemStack s)
	{
		return isUpgradedWith(s, FocusUpgrades.diffusion) ? -1 : 1000;
	}

        @Override
	public boolean isVisCostPerTick (ItemStack s)
	{
		return isUpgradedWith(s, FocusUpgrades.diffusion);
	}

        @Override
	public ItemFocusBasic.WandFocusAnimation getAnimation (ItemStack s)
	{
		return isUpgradedWith(s, FocusUpgrades.diffusion) ? ItemFocusBasic.WandFocusAnimation.CHARGE : ItemFocusBasic.WandFocusAnimation.WAVE;
	}

        @Override
	public ItemStack onFocusRightClick (ItemStack s, World w, EntityPlayer p, MovingObjectPosition mop)
	{
		ItemWandCasting wand = (ItemWandCasting) s.getItem();

		if (isUpgradedWith(wand.getFocusItem(s), FocusUpgrades.diffusion))
		{
			p.setItemInUse(s, 2147483647);
		}
		else
		{
			if (!w.isRemote)
			{
				if (wand.consumeAllVis(s, p, getVisCost(s), true, false))
				{
					EntityDarkMatter proj = new EntityDarkMatter(w, p, 16F + wand.getFocusPotency(s), isUpgradedWith(wand.getFocusItem(s), FocusUpgrades.corrosive));
					w.spawnEntityInWorld(proj);
					if (!isUpgradedWith(wand.getFocusItem(s), FocusUpgrades.sanity))
					{
						if (w.rand.nextInt(20) == 0)
						{
							Thaumcraft.addStickyWarpToPlayer(p, 1);
						}
					}
				}
				w.playSoundAtEntity(p, "thaumcraft:egattack", 0.4F, 1.0F + w.rand.nextFloat() * 0.1F);
			}
			p.swingItem();
		}
		return s;
	}

        @Override
	public void onUsingFocusTick (ItemStack s, EntityPlayer p, int i)
	{
		ItemWandCasting wand = (ItemWandCasting) s.getItem();
		if (!wand.consumeAllVis(s, p, getVisCost(s), false, false))
		{
			p.stopUsingItem();
			return;
		}
		if (!p.worldObj.isRemote && p.ticksExisted % 5 == 0) p.worldObj.playSoundAtEntity(p, "thaumcraft:wind", 0.33F, 5.0F * (float) Math.random());

		if (!p.worldObj.isRemote && wand.consumeAllVis(s, p, getVisCost(s), true, false))
		{
			for (int a = 0; a < 2 + wand.getFocusPotency(s); a++)
			{
				EntityDiffusion proj = new EntityDiffusion(p.worldObj, p, isUpgradedWith(wand.getFocusItem(s), FocusUpgradeType.enlarge) ? 15.0F : 8.0F, 12F + wand.getFocusPotency(s), isUpgradedWith(wand.getFocusItem(s), FocusUpgrades.corrosive));
				proj.posX += proj.motionX;
				proj.posY += proj.motionY;
				proj.posZ += proj.motionZ;
				p.worldObj.spawnEntityInWorld(proj);
				if (!isUpgradedWith(wand.getFocusItem(s), FocusUpgrades.sanity))
				{
					if (p.worldObj.rand.nextInt(200) == 0)
					{
						Thaumcraft.addStickyWarpToPlayer(p, 1);
					}
				}
			}
		}
	}

        @Override
	public FocusUpgradeType[] getPossibleUpgradesByRank (ItemStack s, int r)
	{
		switch (r)
		{
		case 1 :
			return new FocusUpgradeType[]{
					FocusUpgradeType.frugal,
					FocusUpgradeType.potency };
		case 2 :
			return new FocusUpgradeType[]{
					FocusUpgradeType.frugal,
					FocusUpgradeType.potency };
		case 3 :
			return new FocusUpgradeType[]{
					FocusUpgradeType.frugal,
					FocusUpgradeType.potency,
					FocusUpgrades.diffusion,
					FocusUpgrades.sanity };
		case 4 :
			return new FocusUpgradeType[]{
					FocusUpgradeType.frugal,
					FocusUpgradeType.potency };
		case 5 :
			return new FocusUpgradeType[]{
					FocusUpgradeType.frugal,
					FocusUpgradeType.potency,
					FocusUpgrades.corrosive };
		}
		return null;
	}
}
