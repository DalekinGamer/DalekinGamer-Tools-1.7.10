package dgtools.client;

import dgtools.common.CommonProxy;
import dgtools.common.entities.EntityDarkMatter;
import dgtools.common.entities.EntityDiffusion;
import dgtools.common.entities.EntityGlowpet;
import dgtools.common.entities.EntityHomingShard;
import dgtools.common.entities.EntityTaintBubble;
import dgtools.client.handler.ClientHandler;
import dgtools.client.handler.HUDHandler;
import dgtools.common.registry.ItemRegistry;
import dgtools.client.renderer.RenderEntityDiffusion;
import dgtools.client.renderer.RenderEntityGlowpet;
import dgtools.client.renderer.RenderEntityHomingShard;
import dgtools.client.renderer.RenderEntityTaintBubble;
import dgtools.client.renderer.RenderItemKatana;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import thaumcraft.client.renderers.entity.RenderEldritchOrb;

public class ClientProxy extends CommonProxy
{

        @Override
	public void registerClientHandlers ()
	{
		MinecraftForge.EVENT_BUS.register(new HUDHandler());
		MinecraftForge.EVENT_BUS.register(new ClientHandler());
	}

        @Override
	public void registerRenderers ()
	{
		// Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityTaintBubble.class, new RenderEntityTaintBubble());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkMatter.class, new RenderEldritchOrb());
		RenderingRegistry.registerEntityRenderingHandler(EntityHomingShard.class, new RenderEntityHomingShard());
		RenderingRegistry.registerEntityRenderingHandler(EntityGlowpet.class, new RenderEntityGlowpet());
		RenderingRegistry.registerEntityRenderingHandler(EntityDiffusion.class, new RenderEntityDiffusion());

		// Items
		MinecraftForgeClient.registerItemRenderer(ItemRegistry.ItemKatana, new RenderItemKatana());
	}

        @Override
	public EntityPlayer getClientPlayer ()
	{
		return Minecraft.getMinecraft().thePlayer;
	}

        @Override
	public World getClientWorld ()
	{
		return FMLClientHandler.instance().getClient().theWorld;
	}
}
