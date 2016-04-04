package net.hycrafthd.youtubetut;

import net.hycrafthd.youtubetut.block.BlockTut;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialBlocks {

	public static Block tutblock;

	public TutorialBlocks() {
		init();
		register();
	}

	private void init() {
		tutblock = new BlockTut().setCreativeTab(TutorialMod.tab);
		TutorialUtils.setNames(tutblock, "tutblock");
	}

	private void register() {
		this.registerBlock(tutblock);
	}

	private void registerBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setUnlocalizedName(block.getUnlocalizedName()).setRegistryName(block.getRegistryName()));
	}

}
