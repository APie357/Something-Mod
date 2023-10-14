package dev.andrewd1.something.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TestMixin extends Screen {
    protected TestMixin(Component pTitle) { super(pTitle); }

    @Inject(method = "render", at = @At("HEAD"))
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick, CallbackInfo ci) {
        pGuiGraphics.drawString(Minecraft.getInstance().font, "TEST", 10, 10, 0xffffff, true);
    }
}
