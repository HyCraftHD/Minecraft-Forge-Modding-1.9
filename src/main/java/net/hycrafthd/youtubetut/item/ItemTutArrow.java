package net.hycrafthd.youtubetut.item;

import net.hycrafthd.youtubetut.entity.EntityTutArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTutArrow extends ItemArrow {

	public ItemTutArrow() {
		super();
	}

	@Override
	public EntityArrow makeTippedArrow(World world, ItemStack itemstack, EntityLivingBase shooter) {
		return new EntityTutArrow(world, shooter);
	}

}
