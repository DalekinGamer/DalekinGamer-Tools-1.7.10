package dgtools.common.research;

import dgtools.common.DGMain;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DGToolsResearchItem extends ResearchItem
{
	public DGToolsResearchItem (String key, String category)
	{
		super(key, category);
	}

	public DGToolsResearchItem (String key, String category, AspectList tags, int col, int row, int complex, ItemStack icon)
	{
		super(key, category, tags, col, row, complex, icon);
	}

	public DGToolsResearchItem (String key, String category, AspectList tags, int col, int row, int complex, ResourceLocation icon)
	{
		super(key, category, tags, col, row, complex, icon);
	}

	@SideOnly (Side.CLIENT)
        @Override
	public String getName ()
	{
		return StatCollector.translateToLocal("dg.name." + this.key);
	}

	@SideOnly (Side.CLIENT)
        @Override
	public String getText ()
	{
		return (DGMain.configHandler.researchTags ? "[DG] " : "") + StatCollector.translateToLocal(new StringBuilder("dg.tag.").append(this.key).toString());
	}

	@Override
	public ResearchItem setPages (ResearchPage... par)
	{
		for (ResearchPage page : par)
		{
			if (page.type == ResearchPage.PageType.TEXT)
			{
				page.text = ("dg.text." + this.key + "." + page.text);
			}
			if (page.type != ResearchPage.PageType.INFUSION_CRAFTING) continue;
			if ( (this.parentsHidden == null) || (this.parentsHidden.length == 0))
			{
				this.parentsHidden = new String[]{ "INFUSION" };
			}
			else
			{
				String[] newParents = new String[this.parentsHidden.length + 1];
				newParents[0] = "INFUSION";
				for (int i = 0; i < this.parentsHidden.length; i++)
					newParents[ (i + 1)] = this.parentsHidden[i];
				this.parentsHidden = newParents;
			}
		}
		return super.setPages(par);
	}
}