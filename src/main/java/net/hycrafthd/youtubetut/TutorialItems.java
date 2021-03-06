package net.hycrafthd.youtubetut;

import net.hycrafthd.youtubetut.item.*;
import net.hycrafthd.youtubetut.util.NameUtil;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialItems {

	public static Item tutitem;
	public static Item tutfood;

	public static ToolMaterial tuttoolmaterial;
	public static ArmorMaterial tutarmormaterial;

	public static Item tutsword;
	public static Item tutaxe;
	public static Item tutpickaxe;
	public static Item tutshovel;
	public static Item tuthoe;

	public static Item tutbow;
	public static Item tutarrow;

	public static Item tuthelmet;
	public static Item tutchestplate;
	public static Item tutleggings;
	public static Item tutboots;

	public static Item tutgrenade;

	public TutorialItems() {
		init();
		register();
	}

	private void init() {

		tuttoolmaterial = EnumHelper.addToolMaterial("tuttool", 3, 50, 30.0F, 5.0F, 50);
		tutarmormaterial = EnumHelper.addArmorMaterial("tutarmor", "", 20, new int[] { 5, 5, 5, 5 }, 50, SoundEvents.block_lava_pop);

		tutitem = new ItemTut().setCreativeTab(TutorialMod.tab);
		NameUtil.setNames(tutitem, "tutitem");

		tutfood = new ItemTutFood().setCreativeTab(TutorialMod.tab);
		NameUtil.setNames(tutfood, "tutfood");

		tutsword = new ItemTutSword(tuttoolmaterial).setCreativeTab(TutorialMod.tab);
		NameUtil.setNames(tutsword, "tutsword");
		tutaxe = new ItemTutAxe(tuttoolmaterial).setCreativeTab(TutorialMod.tab);
		NameUtil.setNames(tutaxe, "tutaxe");
		tutpickaxe = new ItemTutPickaxe(tuttoolmaterial).setCreativeTab(TutorialMod.tab);
		NameUtil.setNames(tutpickaxe, "tutpickaxe");
		tutshovel = new ItemTutSpade(tuttoolmaterial).setCreativeTab(TutorialMod.tab);
		NameUtil.setNames(tutshovel, "tutshovel");
		tuthoe = new ItemTutHoe(tuttoolmaterial).setCreativeTab(TutorialMod.tab);
		NameUtil.setNames(tuthoe, "tuthoe");

		tutbow = new ItemTutBow().setCreativeTab(TutorialMod.tab);
		NameUtil.setNames(tutbow, "tutbow");
		tutarrow = new ItemTutArrow().setCreativeTab(TutorialMod.tab);
		NameUtil.setNames(tutarrow, "tutarrow");

		tuthelmet = new ItemTutArmor(tutarmormaterial, EntityEquipmentSlot.HEAD);
		NameUtil.setNames(tuthelmet, "tuthelmet");
		tutchestplate = new ItemTutArmor(tutarmormaterial, EntityEquipmentSlot.CHEST);
		NameUtil.setNames(tutchestplate, "tutchestplate");
		tutleggings = new ItemTutArmor(tutarmormaterial, EntityEquipmentSlot.LEGS);
		NameUtil.setNames(tutleggings, "tutleggings");
		tutboots = new ItemTutArmor(tutarmormaterial, EntityEquipmentSlot.FEET);
		NameUtil.setNames(tutboots, "tutboots");

		tutgrenade = new ItemTutGrenade().setCreativeTab(TutorialMod.tab);
		NameUtil.setNames(tutgrenade, "tutgrenade");

	}

	private void register() {
		registerItem(tutitem);
		registerItem(tutfood);

		registerItem(tutsword);
		registerItem(tutaxe);
		registerItem(tutpickaxe);
		registerItem(tutshovel);
		registerItem(tuthoe);

		registerItem(tutbow);
		registerItem(tutarrow);

		registerItem(tuthelmet);
		registerItem(tutchestplate);
		registerItem(tutleggings);
		registerItem(tutboots);

		registerItem(tutgrenade);

	}

	private void registerItem(Item item) {
		GameRegistry.register(item);
	}

}
