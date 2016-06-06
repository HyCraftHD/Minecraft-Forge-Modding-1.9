package net.hycrafthd.youtubetut.proxy;

import net.hycrafthd.youtubetut.TutorialBlocks;
import net.hycrafthd.youtubetut.TutorialItems;
import net.hycrafthd.youtubetut.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ClientProxy extends CommonProxy {

	public void registerModels() {
		registerModel(TutorialItems.tutitem, 0);

		registerModel(TutorialItems.tutfood, 0);

		registerModel(TutorialItems.tutsword, 0);
		registerModel(TutorialItems.tutaxe, 0);
		registerModel(TutorialItems.tutpickaxe, 0);
		registerModel(TutorialItems.tutshovel, 0);
		registerModel(TutorialItems.tuthoe, 0);

		registerModel(TutorialItems.tutbow, 0);

		registerModel(TutorialItems.tuthelmet, 0);
		registerModel(TutorialItems.tutchestplate, 0);
		registerModel(TutorialItems.tutleggings, 0);
		registerModel(TutorialItems.tutboots, 0);

		registerModel(TutorialBlocks.tutblock, 0);
		registerModel(TutorialBlocks.tutblock2, 0);
	}

	private void registerModel(Object obj, int meta) {

		Item item;
		if (obj instanceof Item) {
			item = (Item) obj;
		} else if (obj instanceof Block) {
			item = Item.getItemFromBlock((Block) obj);
		} else {
			throw new IllegalArgumentException("Only item and block instances");
		}
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
