package net.hycrafthd.youtubetut.proxy;

import net.hycrafthd.youtubetut.TutorialBlocks;
import net.hycrafthd.youtubetut.TutorialItems;
import net.hycrafthd.youtubetut.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy {

	public void registerModels() {
		registerItemModel(TutorialItems.tutitem, 0);
		registerBlockModel(TutorialBlocks.tutblock, 0);
	}

	private void registerItemModel(Item item, int meta) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(
				TutorialMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

	private void registerBlockModel(Block block, int meta) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta,
				new ModelResourceLocation(TutorialMod.MODID + ":" + block.getUnlocalizedName().substring(5),
						"inventory"));
	}

}
