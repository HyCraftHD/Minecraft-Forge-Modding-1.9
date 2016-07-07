package net.hycrafthd.youtubetut.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemTutFood extends ItemFood {

	public ItemTutFood() {
		super(2, 5.5F, false);
		this.setAlwaysEdible();
	}

	@Override
	public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote) {
			player.addPotionEffect(new PotionEffect(MobEffects.levitation, 40, 20));
			player.addExperience(50);
		}
	}

}
