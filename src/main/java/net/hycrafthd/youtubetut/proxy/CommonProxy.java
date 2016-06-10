package net.hycrafthd.youtubetut.proxy;

import net.hycrafthd.youtubetut.handler.TutorialCommonEventHandler;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	// Client Stuff
	public void registerModels() {
	}

	public void registerEventHandler() {
		MinecraftForge.EVENT_BUS.register(new TutorialCommonEventHandler());
	}

}
