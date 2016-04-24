package net.hycrafthd.youtubetut;

import java.util.Iterator;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialCrafting {

	public TutorialCrafting() {
		register();
	}

	private void register() {
		GameRegistry.addShapedRecipe(new ItemStack(TutorialItems.tutitem, 2), new Object[] { "#x#", "dxx", "#x#", 'd', new ItemStack(Blocks.dirt), 'x', new ItemStack(Items.dye, 1, 4) });
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialBlocks.tutblock, 3), Blocks.diamond_block, TutorialItems.tutitem);
	}

	public void unregister() {
		Iterator recipes = CraftingManager.getInstance().getRecipeList().iterator();
		while (recipes.hasNext()) {
			ItemStack output = ((IRecipe) recipes.next()).getRecipeOutput();
			if (output != null && output.getItem() != null) {
				if (output.isItemEqual(new ItemStack(Blocks.iron_block))) {
					recipes.remove();
				}
				if (output.isItemEqual(new ItemStack(Blocks.iron_bars))) {
					recipes.remove();
				}
			}
		}
	}

}
