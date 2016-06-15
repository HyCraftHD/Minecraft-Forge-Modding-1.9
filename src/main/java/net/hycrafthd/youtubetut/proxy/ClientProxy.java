package net.hycrafthd.youtubetut.proxy;

import net.hycrafthd.youtubetut.TutorialBlocks;
import net.hycrafthd.youtubetut.TutorialItems;
import net.hycrafthd.youtubetut.entity.EntityTutArrow;
import net.hycrafthd.youtubetut.entity.EntityTutGrenade;
import net.hycrafthd.youtubetut.entity.render.RenderTutArrow;
import net.hycrafthd.youtubetut.handler.TutorialClientEventHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
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
		registerModel(TutorialItems.tutarrow, 0);

		registerModel(TutorialItems.tuthelmet, 0);
		registerModel(TutorialItems.tutchestplate, 0);
		registerModel(TutorialItems.tutleggings, 0);
		registerModel(TutorialItems.tutboots, 0);

		registerModel(TutorialItems.tutgrenade, 0);

		registerModel(TutorialBlocks.tutblock, 0);
		registerModel(TutorialBlocks.tutblock2, 0);
	}

	public void registerRenderer() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTutArrow.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				return new RenderTutArrow(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityTutGrenade.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				return new RenderSnowball<EntityTutGrenade>(manager, TutorialItems.tutgrenade, Minecraft.getMinecraft().getRenderItem());
			}
		});
	}

	public void registerEventHandler() {
		MinecraftForge.EVENT_BUS.register(new TutorialClientEventHandler());
		super.registerEventHandler();
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
