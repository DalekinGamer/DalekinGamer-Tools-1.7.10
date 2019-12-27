package dgtools.common.handler;

import dgtools.common.DGMain;
import dgtools.common.lib.LibInfo;
import java.net.URL;
import java.util.Scanner;


import net.minecraft.util.EnumChatFormatting;

public class UpdateHandler
{
	private static String currentVersion = LibInfo.MOD_VERSION;
	private static String newestVersion;
	public static String updateStatus = null;
	public static boolean show = false;

	public static void init ()
	{
		getNewestVersion();

		if (newestVersion != null)
		{
			if (newestVersion.equalsIgnoreCase(currentVersion))
			{
				show = false;
			}
			else if (!newestVersion.equalsIgnoreCase(currentVersion))
			{
				show = true;
				updateStatus = (EnumChatFormatting.RED + "DGTools is out of date! The latest version is " + EnumChatFormatting.GREEN + newestVersion);
				DGMain.log.info("Mod out of date! You're still running: " + currentVersion + ", Latest Version: " + newestVersion);
			}
		}
		else
		{
			show = true;
			updateStatus = (EnumChatFormatting.RED + "DGTools failed to connect to update server!");
			DGMain.log.info("Failed to connect to update server...");
		}
	}

	private static void getNewestVersion ()
	{
		try
		{
			URL url = new URL("");
			Scanner s = new Scanner(url.openStream());
			newestVersion = s.next();
			s.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			DGMain.log.info("Could not connect to GitHub repository!");
		}
	}
}
