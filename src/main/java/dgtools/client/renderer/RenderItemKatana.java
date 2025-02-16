package dgtools.client.renderer;

import dgtools.common.DGMain;
import dgtools.common.items.tools.ItemKatana;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.IItemRenderer;
import thaumcraft.client.lib.UtilsFX;

@SideOnly (Side.CLIENT)
public class RenderItemKatana implements IItemRenderer
{
	@Override
	public boolean handleRenderType (ItemStack s, IItemRenderer.ItemRenderType t)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper (IItemRenderer.ItemRenderType t, ItemStack s, IItemRenderer.ItemRendererHelper h)
	{
		return true;
	}

	@Override
	public void renderItem (IItemRenderer.ItemRenderType t, ItemStack s, Object... data)
	{
		EntityPlayer p = DGMain.proxy.getClientPlayer();

		GL11.glPushMatrix();

		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glScalef(1.4F, 1.4F, 1.4F);

		if ( (p.getHeldItem() == null || p.getHeldItem() != s) && t != IItemRenderer.ItemRenderType.EQUIPPED)
		{
			GL11.glPushMatrix();
			if (t == IItemRenderer.ItemRenderType.ENTITY)
			{
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				GL11.glTranslatef(0F, 0.5F, 0F);
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
			}
			else if (t == IItemRenderer.ItemRenderType.INVENTORY)
			{
				GL11.glScalef(0.4F, 0.4F, 0.4F);
				GL11.glRotatef(-65, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(-50, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(1F, 1F, 0.0F);
			}
			else
			{
				GL11.glTranslatef(0.0F, -0.7F, 0.0F);
			}
			
			UtilsFX.bindTexture(ItemKatana.getTexture(s));
			ItemKatana.saya.render(0.0625F);
			
			GL11.glPopMatrix();
		}

		GL11.glPushMatrix();

		if (t == IItemRenderer.ItemRenderType.ENTITY)
		{
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			GL11.glTranslatef(0F, 0.5F, 0F);
			GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
		}

		else if (t == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)
		{
			if (p.isUsingItem())
			{
				GL11.glTranslatef(5.0F, 1.0F, -0.2F);
				GL11.glRotatef(155.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-20.0F, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(0.0F, -0.25F, 0.0F);
			}
			GL11.glScalef(1.5F, 1.5F, 1.5F);
			GL11.glTranslatef(2.0F, 1.85F, -0.25F);
			GL11.glRotatef(-10F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-10F, 0.0F, 0.0F, 1.0F);
		}
		else if (t == IItemRenderer.ItemRenderType.INVENTORY)
		{
			GL11.glScalef(0.4F, 0.4F, 0.4F);
			GL11.glRotatef(-65, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-50, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(1F, 1F, 0.0F);
		}
		else
		{
			GL11.glRotatef(60, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-40, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(70, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.0F, 2F, 0.65F);
		}

		UtilsFX.bindTexture(ItemKatana.getTexture(s));

		ItemKatana.katana.render(0.0625F);

		// Runes
		if (ItemKatana.hasAnyInscription(s))
		{
			GL11.glPushMatrix();
			int j = 200;
			int k = j % 65536;
			int l = j / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, k / 1.0F, l / 1.0F);

			GL11.glEnable(GL11.GL_BLEND);

			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
			GL11.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
			for (int a = 0; a < 14; a++)
			{
				int rune = (a * 3) % 16;
				drawRune(-1.65D + a * 0.14D, 0D, -0.03D, rune, p);
			}
			GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
			for (int a = 0; a < 14; a++)
			{
				int rune = (a + 1 * 3) % 16;
				drawRune(-1.65D + a * 0.14D, 0D, -0.03D, rune, p);
			}
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glDisable(GL11.GL_BLEND);

			GL11.glPopMatrix();
		}

		GL11.glPopMatrix();

		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glEnable(GL11.GL_CULL_FACE);

		GL11.glPopMatrix();
	}

	/**
	 * TC method to draw runes on runed staves
	 */
	public static void drawRune (double x, double y, double z, int rune, EntityPlayer player)
	{
		GL11.glPushMatrix();
		
		UtilsFX.bindTexture("textures/misc/script.png");
		
		float r = MathHelper.sin( (player.ticksExisted + rune * 5) / 5.0F) * 0.1F + 0.88F;
		float g = MathHelper.sin( (player.ticksExisted + rune * 5) / 7.0F) * 0.1F + 0.63F;
		float alpha = MathHelper.sin( (player.ticksExisted + rune * 5) / 10.0F) * 0.3F;

		GL11.glColor4f(r, g, 0.2F, alpha + 0.6F);
		
		GL11.glRotated(90.0D, 0.0D, 0.0D, 1.0D);
		GL11.glTranslated(x, y, z);

		Tessellator t = Tessellator.instance;
		
		float f = 0.0625F * rune;
		float f1 = f + 0.0625F;
		float f2 = 0.0F;
		float f3 = 1.0F;
		
		t.startDrawingQuads();
		
		t.setColorRGBA_F(r, g, 0.2F, alpha + 0.6F);
		
		t.addVertexWithUV(-0.06D - alpha / 40.0F, 0.06D + alpha / 40.0F, 0.0D, f1, f3);
		t.addVertexWithUV(0.06D + alpha / 40.0F, 0.06D + alpha / 40.0F, 0.0D, f1, f2);
		t.addVertexWithUV(0.06D + alpha / 40.0F, -0.06D - alpha / 40.0F, 0.0D, f, f2);
		t.addVertexWithUV(-0.06D - alpha / 40.0F, -0.06D - alpha / 40.0F, 0.0D, f, f3);
		
		t.draw();

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		GL11.glPopMatrix();
	}
}