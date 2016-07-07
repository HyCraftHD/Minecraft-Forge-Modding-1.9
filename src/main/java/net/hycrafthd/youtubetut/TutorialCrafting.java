package net.hycrafthd.youtubetut;

import java.util.*;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.*;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialCrafting {

	public TutorialCrafting() {
		register();
	}

	private void register() {
		GameRegistry.addShapedRecipe(new ItemStack(TutorialItems.tutitem, 2), new Object[] { "#x#", "dxx", "#x#", 'd', new ItemStack(Blocks.dirt), 'x', new ItemStack(Items.dye, 1, 4) });
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialBlocks.tutblock, 3), Blocks.diamond_block, TutorialItems.tutitem);

		ItemStack stack = new ItemStack(Items.iron_sword);
		stack.setStackDisplayName("§4§lCOOL SWORD!§r");
		stack.stackSize = 2;
		stack.addEnchantment(Enchantments.sharpness, 1);
		stack.setItemDamage(241);
		stack.addAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", 10, 0), EntityEquipmentSlot.MAINHAND);

		GameRegistry.addShapelessRecipe(stack, TutorialBlocks.tutblock);
	}

	public void unregister() {
		Iterator<?> recipes = CraftingManager.getInstance().getRecipeList().iterator();
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
