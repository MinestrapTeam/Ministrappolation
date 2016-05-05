package minestrapteam.mods.minestrappolation.inventory.gui;

import minestrapteam.mods.minestrappolation.inventory.InventoryBackpack;
import minestrapteam.mods.minestrappolation.inventory.container.ContainerSatchel;
import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiSatchel extends GuiContainer
{
	private static final ResourceLocation texture = new ResourceLocation(MReference.MODID, "textures/gui/crate.png");
	private InventoryBackpack backpack;

	public GuiSatchel(ContainerSatchel backpack)
	{
		super(backpack);
		this.backpack = backpack.inventory;
		this.ySize = 148;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj
			.drawString(StatCollector.translateToLocal(this.backpack.invStack.getDisplayName()), 7, 7, 4210752);
		this.fontRendererObj
			.drawString(StatCollector.translateToLocal("container.inventory"), 7, this.ySize - 92, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
	{
		// Bind the image texture of our custom container
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		// Draw the image
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
