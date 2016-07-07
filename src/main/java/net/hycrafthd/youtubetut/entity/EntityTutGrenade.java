package net.hycrafthd.youtubetut.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityTutGrenade extends EntityThrowable {

	public EntityTutGrenade(World worldIn) {
		super(worldIn);
	}

	public EntityTutGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	@Override
	public void onImpact(RayTraceResult result) {
		if (!worldObj.isRemote) {
			this.setDead();
			this.worldObj.createExplosion((Entity) null, posX, posY, posZ, 4.5F, true);
		}
	}

}
