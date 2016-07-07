package net.hycrafthd.youtubetut;

import net.hycrafthd.youtubetut.block.*;
import net.hycrafthd.youtubetut.util.NameUtil;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialBlocks {

	public static Block tutblock;
	public static Block tutblock2;

	public TutorialBlocks() {
		init();
		register();
	}

	private void init() {
		tutblock = new BlockTut().setCreativeTab(TutorialMod.tab);
		NameUtil.setNames(tutblock, "tutblock");
		tutblock2 = new BlockTut2().setCreativeTab(TutorialMod.tab);
		NameUtil.setNames(tutblock2, "tutblock2");
	}

	private void register() {
		registerBlock(tutblock);
		registerBlock(tutblock2);
	}

	private void registerBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setUnlocalizedName(block.getUnlocalizedName()).setRegistryName(block.getRegistryName()));
	}

}
