package net.hycrafthd.youtubetut.item;

import net.hycrafthd.youtubetut.TutorialMod;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;

public class ItemTutArmor extends ItemArmor {

	public ItemTutArmor(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, 0, equipmentSlotIn);
		this.setCreativeTab(TutorialMod.tab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (slot == EntityEquipmentSlot.HEAD || slot == EntityEquipmentSlot.CHEST || slot == EntityEquipmentSlot.FEET) {
			return TutorialMod.MODID + ":textures/models/armor/tut_layer_1.png";
		} else if (slot == EntityEquipmentSlot.LEGS) {
			return TutorialMod.MODID + ":textures/models/armor/tut_layer_2.png";
		} else {
			return null;
		}
	}

}
