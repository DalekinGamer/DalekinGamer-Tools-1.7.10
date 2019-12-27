package dgtools.common.handler;

import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.wands.IWandRodOnUpdate;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.config.Config;
import thaumcraft.common.items.wands.ItemWandCasting;
import net.minecraft.entity.player.EntityPlayer;

public class WandHandler implements IWandRodOnUpdate
{
Aspect aspect;
Aspect primals[] = Aspect.getPrimalAspects().toArray(new Aspect[0]);

    @Override
    public void onUpdate (ItemStack itemstack, EntityPlayer player)
    {
	if (!player.isPotionActive(Config.potionWarpWardID))
	{
            int permwarp = Thaumcraft.proxy.getPlayerKnowledge().getWarpPerm(player.getCommandSenderName());

            int x = permwarp;
            if (x == 0) return;

            double fx = 20 * coth(x / 250.0D);
            int rfx = Math.min((int) Math.round(fx), 200);
			
            if (player.ticksExisted % rfx == 0)
            {
                for (int i = 0; i < primals.length; i++)
                {
                    ((ItemWandCasting) itemstack.getItem()).addVis(itemstack, this.primals[i], 1, true);
                }
            }
	}
    }

	public double coth (double x)
	{
		return Math.cosh(x) / Math.sinh(x);
	}
}