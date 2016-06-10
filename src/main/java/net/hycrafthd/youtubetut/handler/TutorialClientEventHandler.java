package net.hycrafthd.youtubetut.handler;

import net.hycrafthd.youtubetut.TutorialItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TutorialClientEventHandler {

	@SubscribeEvent
	public void onFOVUpdate(FOVUpdateEvent event) {
		EntityPlayer player = event.getEntity();
		if (player.isHandActive() && player.getActiveItemStack() != null && player.getActiveItemStack().getItem() == TutorialItems.tutbow) {

			int i = player.getItemInUseMaxCount();
			float f1 = (float) i / 5.0F;

			if (f1 > 1.0F) {
				f1 = 1.0F;
			} else {
				f1 = f1 * f1;
			}

			event.setNewfov(event.getFov() * 1.0F - f1 * 0.5F);
		}
	}

}
