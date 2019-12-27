package dgtools.common.registry;


import dgtools.common.DGMain;
import dgtools.common.entities.EntityDarkMatter;
import dgtools.common.entities.EntityDiffusion;
import dgtools.common.entities.EntityGlowpet;
import dgtools.common.entities.EntityHomingShard;
import dgtools.common.entities.EntityTaintBubble;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntityRegistry
{
	public static void init ()
	{
		int ID = 0;
		EntityRegistry.registerModEntity(EntityTaintBubble.class, "EntityTaintBubble", ID++, DGMain.instance, 64, 20, true);
		EntityRegistry.registerModEntity(EntityDarkMatter.class, "EntityDarkMatter", ID++, DGMain.instance, 64, 21, true);
		EntityRegistry.registerModEntity(EntityHomingShard.class, "EntityHomingShard", ID++, DGMain.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityGlowpet.class, "EntityGlowpet", ID++, DGMain.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityDiffusion.class, "EntityDiffusion", ID++, DGMain.instance, 64, 20, true);
	}
}
