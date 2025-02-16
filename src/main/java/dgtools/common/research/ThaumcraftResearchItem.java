package dgtools.common.research;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.api.research.ResearchCategoryList;

public class ThaumcraftResearchItem extends ResearchItem
{
	public ResearchItem original;

	public ThaumcraftResearchItem (String tag, String category, String origin, String originCategory, int col, int row, ResourceLocation icon)
	{
		super(tag, category, new AspectList(), col, row, 1, icon);
		original = ((ResearchCategoryList) ResearchCategories.researchCategories.get(originCategory)).research.get(origin);
		bindToOriginal();
		setStub();
		setHidden();

	}

	public ThaumcraftResearchItem (String tag, String category, String origin, String originCategory, int col, int row, ItemStack icon)
	{
		super(tag, category, new AspectList(), col, row, 1, icon);
		original = ((ResearchCategoryList) ResearchCategories.researchCategories.get(originCategory)).research.get(origin);
		bindToOriginal();
		setStub();
		setHidden();
	}

	private void bindToOriginal ()
	{
		if (original.siblings == null) original.setSiblings(new String[]{ key });
		else
		{
			String[] family = original.siblings;
			String[] newFamily = new String[family.length + 1];
			for (int x = 0; x < family.length; x++)
			{
				newFamily[x] = family[x];
			}
			newFamily[family.length] = key;
			original.setSiblings(newFamily);
		}
		if (original.isSecondary())
		{
			this.setSecondary();
		}
	}

        @Override
	public ResearchPage[] getPages ()
	{
		return original.getPages();
	}

	@SideOnly (Side.CLIENT)
        @Override
	public String getName ()
	{
		return original.getName();
	}

	@SideOnly (Side.CLIENT)
        @Override
	public String getText ()
	{
		return original.getText();
	}

        @Override
	public boolean isStub ()
	{
		return true;
	}

        @Override
	public boolean isHidden ()
	{
		return true;
	}

        @Override
	public int getComplexity ()
	{
		return 1;
	}
}