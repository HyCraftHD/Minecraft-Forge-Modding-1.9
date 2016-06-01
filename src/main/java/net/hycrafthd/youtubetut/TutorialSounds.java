package net.hycrafthd.youtubetut;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialSounds {

	public static SoundEvent greeting;

	public TutorialSounds() {
		init();
		register();
	}

	private void init() {
		greeting = new SoundEvent(new ResourceLocation(TutorialMod.MODID, "greeting")).setRegistryName(new ResourceLocation(TutorialMod.MODID, "greeting"));
	}

	private void register() {
		registerSound(greeting);
	}

	private void registerSound(SoundEvent sound) {
		GameRegistry.register(sound);
	}

}
