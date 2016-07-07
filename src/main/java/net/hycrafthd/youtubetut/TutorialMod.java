package net.hycrafthd.youtubetut;

import net.hycrafthd.youtubetut.creativetab.CreativeTabTut;
import net.hycrafthd.youtubetut.handler.*;
import net.hycrafthd.youtubetut.proxy.CommonProxy;
import net.hycrafthd.youtubetut.world.TutorialWorldgeneration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
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

	@SuppressWarnings("unused")
	private TutorialConfig config;
	@SuppressWarnings("unused")
	private TutorialItems items;
	@SuppressWarnings("unused")
	private TutorialBlocks blocks;
	@SuppressWarnings("unused")
	private TutorialSounds sounds;

	@SuppressWarnings("unused")
	private TutorialEntity entity;
	private TutorialCrafting crafting;
	private TutorialSmelting smelting;

	@SuppressWarnings("unused")
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
