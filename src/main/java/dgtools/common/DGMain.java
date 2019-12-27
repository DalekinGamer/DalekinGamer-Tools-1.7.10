package dgtools.common;

import dgtools.common.handler.ConfigHandler;
import dgtools.common.handler.DGEventHandler;
import dgtools.common.handler.UpdateHandler;
import dgtools.common.items.wand.foci.FocusUpgrades;
import dgtools.common.lib.LibInfo;
import dgtools.common.network.PacketHandler;
import dgtools.common.registry.BlockRegistry;
import dgtools.common.registry.ItemRegistry;
import dgtools.common.registry.ModEntityRegistry;
import dgtools.common.registry.OreDictionaryRegistry;
import dgtools.common.registry.RecipeRegistry;
import dgtools.common.registry.ResearchRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod (modid= LibInfo.MOD_ID, name= LibInfo.MOD_NOME, version= LibInfo.MOD_VERSION, dependencies = LibInfo.DEPENDENCIES)

public class DGMain
{
    @Mod.Instance
    public static DGMain instance;
    
    // Proxies
    @SidedProxy(clientSide = "dgtools.client.ClientProxy", serverSide = "dgtools.common.CommonProxy")
    public static CommonProxy proxy;
    
    public static DGEventHandler DGToolsEvents;
    public static CreativeTabs dgTab = new DGTab("dgTab");
    public static ConfigHandler configHandler;
    public static CreativeTabs dgTabConstruction = new DGTabConstruction("dgTabConstruction");
    
    public static final Logger log = LogManager.getLogger("DGTools");
    
    public static EnumRarity rarityGold = EnumHelper.addRarity("CREATION", EnumChatFormatting.GOLD, "Creation");
    public static EnumRarity rarityRed = EnumHelper.addRarity("CREATION", EnumChatFormatting.RED, "Creation");
    public static EnumRarity rarityDarkAqua = EnumHelper.addRarity("CREATION", EnumChatFormatting.DARK_AQUA, "Creation");
    public static EnumRarity rarityBlue = EnumHelper.addRarity("CREATION", EnumChatFormatting.BLUE, "Creation");
    public static EnumRarity rarityDarkGreen = EnumHelper.addRarity("CREATION", EnumChatFormatting.DARK_GREEN, "Creation");
    
        // Pre init
        @EventHandler
	public static void preInit(FMLPreInitializationEvent event)
        {
            log.info("Please stand back... Pre-initializing DGTools!");

            // Config
            configHandler.config = new Configuration(event.getSuggestedConfigurationFile());
            configHandler.init();
            
            proxy.registerClientHandlers();
            
            PacketHandler.init();
            ItemRegistry.init();
            BlockRegistry.init();
            BlockRegistry.initTiles();
            ModEntityRegistry.init();
            RecipeRegistry.init();
            
            OreDictionaryRegistry.init();
            
            if (configHandler.useUpdateHandler) UpdateHandler.init();
	}
	
        // Init
	@EventHandler
	public static void init(FMLInitializationEvent event)
        {
            log.info("Things seem to be going smoothly... Initializing DGTools!");
		
            DGToolsEvents = new DGEventHandler();

            MinecraftForge.EVENT_BUS.register(DGToolsEvents);
            FMLCommonHandler.instance().bus().register(DGToolsEvents);

            proxy.registerRenderers();
            FocusUpgrades.init();
	}
	
        // Post init
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
        {
	
            log.info("Almost done... Post-initializing DGTools!");

            ResearchRegistry.initResearch();

            log.info("Phew! DGTools has finished loading, enjoy!");
            
            
	}
        
        
}
