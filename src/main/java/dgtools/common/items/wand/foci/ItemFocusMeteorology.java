package dgtools.common.items.wand.foci;

import dgtools.common.DGMain;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.ItemFocusBasic;
import thaumcraft.client.fx.ParticleEngine;
import thaumcraft.client.fx.particles.FXWisp;
import thaumcraft.common.items.wands.ItemWandCasting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFocusMeteorology extends ItemFocusBasic
{
	public IIcon depthIcon;
	public IIcon iconOverlay;

	private static final AspectList cost = new AspectList().add(Aspect.AIR, 1000).add(Aspect.WATER, 1000).add(Aspect.FIRE, 1000).add(Aspect.EARTH, 1000).add(Aspect.ORDER, 1000).add(Aspect.ENTROPY, 1000);

	public ItemFocusMeteorology ()
	{
		this.setCreativeTab(DGMain.dgTab);
		this.setUnlocalizedName("ItemFocusMeteorology");
	}

	@SideOnly (Side.CLIENT)
        @Override
	public void registerIcons (IIconRegister ir)
	{
		this.icon = ir.registerIcon("dg:ItemFocusMeteorology");
		this.iconOverlay = ir.registerIcon("dg:ItemFocusTime_overlay");
		this.depthIcon = ir.registerIcon("dg:ItemFocusMeteorology_depth");
	}

        @Override
	public IIcon getFocusDepthLayerIcon (ItemStack s)
	{
		return this.depthIcon;
	}

        @Override
	public String getSortingHelper (ItemStack s)
	{
		return "RAIN" + super.getSortingHelper(s);
	}

        @Override
	public int getFocusColor (ItemStack s)
	{
		return 0x23D9EA;
	}

        @Override
	public AspectList getVisCost (ItemStack s)
	{
		return new AspectList().add(Aspect.AIR, 1000).add(Aspect.WATER, 1000).add(Aspect.FIRE, 1000).add(Aspect.EARTH, 1000).add(Aspect.ORDER, 1000).add(Aspect.ENTROPY, 1000);
	}

        @Override
	public int getActivationCooldown (ItemStack s)
	{
		return 30000;
	}

        @Override
	public boolean isVisCostPerTick (ItemStack s)
	{
		return false;
	}

	@SideOnly (Side.CLIENT)
        @Override
	public int getRenderPasses (int m)
	{
		return 2;
	}

	@Override
	@SideOnly (Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass (int meta, int pass)
	{
		return (pass == 0) ? this.icon : this.iconOverlay;
	}

	@SideOnly (Side.CLIENT)
        @Override
	public boolean requiresMultipleRenderPasses ()
	{
		return true;
	}

        @Override
	public ItemFocusBasic.WandFocusAnimation getAnimation (ItemStack s)
	{
		return ItemFocusBasic.WandFocusAnimation.WAVE;
	}

        @Override
	public ItemStack onFocusRightClick (ItemStack s, World w, EntityPlayer p, MovingObjectPosition mop)
	{
		ItemWandCasting wand = (ItemWandCasting) s.getItem();

		if (wand.consumeAllVis(s, p, getVisCost(s), true, false))
		{
			w.getWorldInfo().setRainTime(w.isRaining() ? 24000 : 0);
			w.getWorldInfo().setRaining(!w.isRaining());
			p.playSound("thaumcraft:runicShieldCharge", 0.3F, 1.0F + w.rand.nextFloat() * 0.5F);
			p.playSound("thaumcraft:wand", 0.3F, 1.0F + w.rand.nextFloat() * 0.5F);

			if (w.isRemote) spawnParticles(w, p);
		}
		return s;
	}

	@SideOnly (Side.CLIENT)
        @Override
	public EnumRarity getRarity (ItemStack s)
	{
		return DGMain.rarityGold;
	}

	@SideOnly (Side.CLIENT)
	void spawnParticles (World w, EntityPlayer p)
	{
		for (int i = 1; i < 200; i++)
		{
			double xp = (-Math.random() * 2.0F) + (Math.random() * 2.0F);
			double zp = (-Math.random() * 2.0F) + (Math.random() * 2.0F);
			double yp = (-Math.random() * 2.0F) + (Math.random() * 2.0F);
			double off = Math.random() * 0.1;

			float green = p.worldObj.rand.nextFloat();
			float blue = p.worldObj.rand.nextFloat();

			FXWisp ef = new FXWisp(w, p.posX + xp + off, p.posY + 10 + yp + off, p.posZ + zp + off, 0.5F + ((float) Math.random() * 0.25F), 0.25F, green, blue);
			ef.setGravity(-1.5F);
			ef.shrink = true;
			ef.noClip = true;

			ef.addVelocity(xp * 0.5D, 0.0D, zp * 0.5D);

			ParticleEngine.instance.addEffect(w, ef);
		}
	}
}
