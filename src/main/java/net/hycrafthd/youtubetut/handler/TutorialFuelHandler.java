package net.hycrafthd.youtubetut.handler;

import net.hycrafthd.youtubetut.TutorialItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class TutorialFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem().equals(TutorialItems.tutitem)) {
			return 200;
		}
		return 0;
	}

}
