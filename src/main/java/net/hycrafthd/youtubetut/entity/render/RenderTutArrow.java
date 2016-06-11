package net.hycrafthd.youtubetut.entity.render;

import net.hycrafthd.youtubetut.TutorialMod;
import net.hycrafthd.youtubetut.entity.EntityTutArrow;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.sys.process.processInternal;

@SideOnly(Side.CLIENT)
public class RenderTutArrow extends RenderArrow<EntityTutArrow> {

	public static final ResourceLocation res = new ResourceLocation(TutorialMod.MODID, "textures/entity/projectiles/tutarrow.png");

	public RenderTutArrow(RenderManager rm) {
		super(rm);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityTutArrow entity) {
		return res;
	}

}