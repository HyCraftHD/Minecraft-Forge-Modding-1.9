package net.hycrafthd.youtubetut;

import net.hycrafthd.youtubetut.entity.EntityTutArrow;
import net.hycrafthd.youtubetut.entity.EntityTutGrenade;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class TutorialEntity {

	public static int tutarrow = 0;
	public static int tutgrenade = 1;

	public TutorialEntity() {
		register();
	}

	private void register() {
		EntityRegistry.registerModEntity(EntityTutArrow.class, "tutarrow", tutarrow, TutorialMod.INSTANCE, 64, 1, true);
		EntityRegistry.registerModEntity(EntityTutGrenade.class, "tutgrenade", tutgrenade, TutorialMod.INSTANCE, 64, 1, true);
	}

}
