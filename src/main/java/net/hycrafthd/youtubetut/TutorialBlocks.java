package net.hycrafthd.youtubetut;

import com.sun.org.apache.xml.internal.security.Init;

import net.hycrafthd.youtubetut.block.BlockTut;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialBlocks {

	public static Block tutblock;

	public TutorialBlocks() {
		init();
		register();
	}

	private void init() {
		tutblock = new BlockTut().setUnlocalizedName("tutblock");
	}

	private void register() {
		GameRegistry.registerBlock(tutblock, tutblock.getUnlocalizedName().substring(5));
	}

}
