package net.hycrafthd.youtubetut;

import net.hycrafthd.youtubetut.item.ItemTut;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialItems {

	public static Item tutitem;

	public TutorialItems() {
		init();
		register();
	}

	private void init() {
		tutitem = new ItemTut().setUnlocalizedName("tutitem");
	}

	private void register() {
		GameRegistry.registerItem(tutitem, tutitem.getUnlocalizedName().substring(5));
	}

}
