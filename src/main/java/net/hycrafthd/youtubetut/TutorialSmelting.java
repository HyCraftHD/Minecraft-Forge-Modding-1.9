package net.hycrafthd.youtubetut;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialSmelting {

	public TutorialSmelting() {
		register();
	}

	private void register() {
		GameRegistry.addSmelting(Blocks.dirt, new ItemStack(TutorialItems.tutitem, 2), 1.0F);
		GameRegistry.addSmelting(TutorialItems.tutitem, new ItemStack(TutorialBlocks.tutblock, 1), 10.0F);
	}

}
