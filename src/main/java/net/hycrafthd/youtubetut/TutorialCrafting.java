package net.hycrafthd.youtubetut;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialCrafting {

	public TutorialCrafting() {
		register();
	}

	private void register() {
		GameRegistry.addShapedRecipe(new ItemStack(TutorialItems.tutitem, 2), new Object[] {
			"#x#",
			"dxx",
			"#x#",
			'd', new ItemStack(Blocks.dirt),
			'x', new ItemStack(Items.dye, 1, 4)			
		});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialBlocks.tutblock, 3), Blocks.diamond_block, TutorialItems.tutitem);
	}

}
