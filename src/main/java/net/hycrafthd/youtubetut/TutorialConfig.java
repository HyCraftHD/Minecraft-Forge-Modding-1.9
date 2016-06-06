package net.hycrafthd.youtubetut;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class TutorialConfig {

	public static Configuration cfg;

	public static String greeting;

	public TutorialConfig(File suggestedConfigurationFile) {
		cfg = new Configuration(suggestedConfigurationFile, TutorialMod.VERSION);
		cfg.load();
		setup();
	}

	private void setup() {
		greeting = cfg.get("Messages", "greeting", "Hey %player").getString();
		cfg.save();
	}

	public static void updateGreeting(String newGreeting) {
		greeting = newGreeting;
		cfg.load();
		cfg.get("Messages", "greeting", "Hey %player").set(newGreeting);
		cfg.save();
	}

}
