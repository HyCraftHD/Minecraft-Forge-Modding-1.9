package net.hycrafthd.youtubetut;

import net.hycrafthd.youtubetut.creativetab.CreativeTabTut;
import net.hycrafthd.youtubetut.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TutorialMod.MODID, version = TutorialMod.VERSION)
public class TutorialMod {

	public static final String MODID = "tutorial";
	public static final String VERSION = "0.1";

	@Instance(MODID)
	public static TutorialMod INSTANCE = new TutorialMod();

	@SidedProxy(serverSide = "net.hycrafthd.youtubetut.proxy.CommonProxy", clientSide = "net.hycrafthd.youtubetut.proxy.ClientProxy", modId = MODID)
	public static CommonProxy PROXY = new CommonProxy();

	private TutorialCrafting crafting;
	private TutorialSmelting smelting;

	public static CreativeTabs tab;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		tab = new CreativeTabTut();
		new TutorialItems();
		new TutorialBlocks();
		crafting = new TutorialCrafting();
		smelting = new TutorialSmelting();
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		PROXY.registerModels();
		crafting.unregister();
		smelting.unregister();
	}
}
