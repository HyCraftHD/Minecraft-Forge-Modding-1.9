package net.hycrafthd.youtubetut.handler;

import net.hycrafthd.youtubetut.TutorialAchievements;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class TutorialEventHandler {

	@SubscribeEvent
	public void onPlayerJoin(PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
		player.addChatMessage(new TextComponentString("Hey " + player.getDisplayNameString()));
		player.addStat(TutorialAchievements.tutjoin);
	}

}
