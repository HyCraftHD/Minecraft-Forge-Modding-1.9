package net.hycrafthd.youtubetut;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class TutorialUtils {

	public static void setNames(Object obj, String name) {
		if (obj instanceof Block) {
			Block block = (Block) obj;
			block.setUnlocalizedName(name);
			block.setRegistryName(name);
		} else if (obj instanceof Item) {
			Item item = (Item) obj;
			item.setUnlocalizedName(name);
			item.setRegistryName(name);
		} else {
			throw new IllegalArgumentException("Item or Block required!");
		}
	}

}
