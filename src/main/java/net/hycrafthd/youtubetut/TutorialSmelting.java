package net.hycrafthd.youtubetut;

import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialSmelting {

	public TutorialSmelting() {
		register();
	}

	private void register() {
		GameRegistry.addSmelting(Blocks.dirt, new ItemStack(TutorialItems.tutitem, 2), 1.0F);
		GameRegistry.addSmelting(TutorialItems.tutitem, new ItemStack(TutorialBlocks.tutblock, 1), 10.0F);
	}

	public void unregister() {
		Iterator<?> recipes = FurnaceRecipes.instance().getSmeltingList().entrySet().iterator();
		while (recipes.hasNext()) {
			Entry<?, ?> entry = (Entry<?, ?>) recipes.next();
			ItemStack input = (ItemStack) entry.getKey();
			ItemStack output = (ItemStack) entry.getValue();
			if (input != null && input.getItem() != null) {
				if (input.getItem() == Item.getItemFromBlock(Blocks.iron_ore)) {
					recipes.remove();
				}
			}
			if (output != null && output.getItem() != null) {
				if (output.isItemEqual(new ItemStack(Items.gold_ingot))) {
					recipes.remove();
				}
			}
		}
	}
}
