package net.hycrafthd.youtubetut;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class TutorialAchievements {

	public static Achievement tutjoin;
	public static Achievement tutuseitem;

	public TutorialAchievements() {
		init();
		register();
	}

	private void init() {
		tutjoin = new Achievement("achievement.tutjoin", "tutjoin", 0, 0, TutorialBlocks.tutblock, (Achievement) null).initIndependentStat().setSpecial();
		tutuseitem = new Achievement("achievement.tutuseitem", "tutuseitem", 2, 1, TutorialItems.tutitem, tutjoin);
	}

	private void register() {
		tutjoin.registerStat();
		tutuseitem.registerStat();
		AchievementPage.registerAchievementPage(new AchievementPage("Tutorial Achievements", new Achievement[] { tutuseitem, tutjoin }));
	}

}
