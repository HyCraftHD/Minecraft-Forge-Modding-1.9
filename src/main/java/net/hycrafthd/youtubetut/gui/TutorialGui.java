package net.hycrafthd.youtubetut.gui;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.config.GuiButtonExt;
import net.minecraftforge.fml.client.config.GuiSlider;

public class TutorialGui extends GuiScreen {

	static int i = 0;
	GuiSlider slider;
	
	@Override
	public void initGui() {
		buttonList.add(new GuiButtonExt(1, width/2-100, 20, 200, 20, "Hallo Welt."));
		buttonList.add(slider = new GuiSlider(2, width/2-100, 45, 200, 20, "Value: ", " %", 0, 100, 50, true, true));
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		case 1:
			i++;
			break;
		}
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {

		drawCenteredString(fontRendererObj, "Counter: " + i, width/2, 65, Color.WHITE.getRGB());
		drawCenteredString(fontRendererObj, "Slider: " + slider.getValue() , width/2, 75, Color.GREEN.getRGB());

		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
