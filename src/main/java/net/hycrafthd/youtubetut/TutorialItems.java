package net.hycrafthd.youtubetut;

import net.hycrafthd.youtubetut.item.ItemTut;
import net.hycrafthd.youtubetut.item.ItemTutAxe;
import net.hycrafthd.youtubetut.item.ItemTutFood;
import net.hycrafthd.youtubetut.item.ItemTutHoe;
import net.hycrafthd.youtubetut.item.ItemTutPickaxe;
import net.hycrafthd.youtubetut.item.ItemTutSpade;
import net.hycrafthd.youtubetut.item.ItemTutSword;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialItems {

	public static Item tutitem;
	public static Item tutfood;

	public static ToolMaterial tuttoolmaterial;

	public static Item tutsword;
	public static Item tutaxe;
	public static Item tutpickaxe;
	public static Item tutshovel;
	public static Item tuthoe;

	public TutorialItems() {
		init();
		register();
	}

	private void init() {

		tuttoolmaterial = EnumHelper.addToolMaterial("tuttool", 3, 50, 30.0F, 5.0F, 50);

		tutitem = new ItemTut().setCreativeTab(TutorialMod.tab);
		TutorialUtils.setNames(tutitem, "tutitem");
		tutfood = new ItemTutFood().setCreativeTab(TutorialMod.tab);
		TutorialUtils.setNames(tutfood, "tutfood");
		tutsword = new ItemTutSword(tuttoolmaterial).setCreativeTab(TutorialMod.tab);
		TutorialUtils.setNames(tutsword, "tutsword");
		tutaxe = new ItemTutAxe(tuttoolmaterial).setCreativeTab(TutorialMod.tab);
		TutorialUtils.setNames(tutaxe, "tutaxe");
		tutpickaxe = new ItemTutPickaxe(tuttoolmaterial).setCreativeTab(TutorialMod.tab);
		TutorialUtils.setNames(tutpickaxe, "tutpickaxe");
		tutshovel = new ItemTutSpade(tuttoolmaterial).setCreativeTab(TutorialMod.tab);
		TutorialUtils.setNames(tutshovel, "tutshovel");
		tuthoe = new ItemTutHoe(tuttoolmaterial).setCreativeTab(TutorialMod.tab);
		TutorialUtils.setNames(tuthoe, "tuthoe");

	}

	private void register() {
		GameRegistry.register(tutitem);
		GameRegistry.register(tutfood);
		GameRegistry.register(tutsword);
		GameRegistry.register(tutaxe);
		GameRegistry.register(tutpickaxe);
		GameRegistry.register(tutshovel);
		GameRegistry.register(tuthoe);
	}

}
