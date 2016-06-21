package net.hycrafthd.youtubetut.handler;

import net.hycrafthd.youtubetut.gui.TutorialGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class TutorialGuiHandler implements IGuiHandler {
	
	public static int TUTGUIID = 1;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID==TUTGUIID) {
			return new TutorialGui();
		}
		return null;
	}

}
