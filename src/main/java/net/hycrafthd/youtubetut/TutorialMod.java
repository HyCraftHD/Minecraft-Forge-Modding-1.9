package net.hycrafthd.youtubetut;

import net.hycrafthd.youtubetut.creativetab.CreativeTabTut;
import net.hycrafthd.youtubetut.handler.TutorialFuelHandler;
import net.hycrafthd.youtubetut.handler.TutorialGuiHandler;
import net.hycrafthd.youtubetut.proxy.CommonProxy;
import net.hycrafthd.youtubetut.world.TutorialWorldgeneration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = TutorialMod.MODID, version = TutorialMod.VERSION)
public class TutorialMod {

	public static final String MODID = "tutorial";
	public static final String VERSION = "0.1";

	@Instance(MODID)
	public static TutorialMod INSTANCE = new TutorialMod();

	@SidedProxy(serverSide = "net.hycrafthd.youtubetut.proxy.CommonProxy", clientSide = "net.hycrafthd.youtubetut.proxy.ClientProxy", modId = MODID)
	public static CommonProxy PROXY = new CommonProxy();
	
	public static CreativeTabs tab;

	private TutorialConfig config;
	private TutorialItems items;
	private TutorialBlocks blocks;
	private TutorialSounds sounds;

	private TutorialEntity entity;
	private TutorialCrafting crafting;
	private TutorialSmelting smelting;

	private TutorialAchievements achievements;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		config = new TutorialConfig(event.getSuggestedConfigurationFile());
		tab = new CreativeTabTut();
		items = new TutorialItems();
		blocks = new TutorialBlocks();
		sounds = new TutorialSounds();
		PROXY.registerRenderer();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new TutorialWorldgeneration(), 0);
		GameRegistry.registerFuelHandler(new TutorialFuelHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new TutorialGuiHandler());

		PROXY.registerEventHandler();

		entity = new TutorialEntity();
		crafting = new TutorialCrafting();
		smelting = new TutorialSmelting();

		achievements = new TutorialAchievements();
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		PROXY.registerModels();

		crafting.unregister();
		smelting.unregister();
	}
}
