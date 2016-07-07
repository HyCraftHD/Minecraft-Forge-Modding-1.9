package net.hycrafthd.youtubetut.entity;

import net.hycrafthd.youtubetut.TutorialItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityTutArrow extends EntityArrow {

	public EntityTutArrow(World worldIn) {
		super(worldIn);
	}

	public EntityTutArrow(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	public EntityTutArrow(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if (this.worldObj.isRemote && !this.inGround) {
			this.worldObj.spawnParticle(EnumParticleTypes.LAVA, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
		}
	}

	@Override
	public ItemStack getArrowStack() {
		return new ItemStack(TutorialItems.tutarrow);
	}

	@Override
	public void arrowHit(EntityLivingBase living) {
		super.arrowHit(living);
		World world = living.getEntityWorld();
		if (living != shootingEntity) {
			world.createExplosion(shootingEntity, living.posX, living.posY, living.posZ, 4.0F, true);
		}
	}

}