package net.hycrafthd.youtubetut.handler;

import net.hycrafthd.youtubetut.TutorialAchievements;
import net.hycrafthd.youtubetut.TutorialMod;
import net.hycrafthd.youtubetut.TutorialSounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketCustomSound;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class TutorialEventHandler {

	@SubscribeEvent
	public void onPlayerJoin(PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
		player.addChatMessage(new TextComponentString("Hey " + player.getDisplayNameString()));
		player.addStat(TutorialAchievements.tutjoin);
		if (player instanceof EntityPlayerMP) {
			((EntityPlayerMP) player).playerNetServerHandler.sendPacket(new SPacketCustomSound(TutorialSounds.greeting.getRegistryName().toString(), player.getSoundCategory(), player.posX, player.posY, player.posZ, 1.0F, 1.0F));
		}
	}

}
