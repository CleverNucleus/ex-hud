package com.github.clevernucleus.exhud;

import java.text.DecimalFormat;

import com.github.clevernucleus.exhud.config.ExHUDConfig;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;

public class ExHUD implements ClientModInitializer {
	public static final String MODID = "exhud";
	public static final Identifier GUI_HEALTH_BARS = new Identifier(MODID, "textures/gui/health_bars.png");
	public static final Identifier GUI_LEVEL_BARS = new Identifier(MODID, "textures/gui/level_bars.png");
	public static final DecimalFormat FORMAT = new DecimalFormat("#.##");
	
	public static boolean renderCustomHealthbar() {
		return ExHUDConfig.renderCustomHealthbar;
	}
	
	public static boolean renderCustomUtilities() {
		return ExHUDConfig.renderCustomUtilities;
	}
	
	public static boolean enableFoodStat() {
		return ExHUDConfig.enableFoodStat;
	}
	
	public static int healthbarTexture(final LivingEntity livingEntity) {
		return livingEntity.hasStatusEffect(StatusEffects.POISON) ? 16 : (livingEntity.hasStatusEffect(StatusEffects.WITHER) ? 24 : (livingEntity.isFrozen() ? 32 : 8));
	}
	
	public static void drawBorderedText(TextRenderer textRenderer, MatrixStack matrices, String text, float s, float x, float y, int colour, int borderColour) {
		textRenderer.draw(matrices, text, s * (x - 0.25F), s * y, borderColour);
		textRenderer.draw(matrices, text, s * x, s * (float)(y - 0.25F), borderColour);
		textRenderer.draw(matrices, text, s * (x + 0.25F), s * y, borderColour);
		textRenderer.draw(matrices, text, s * x, s * (float)(y + 0.25F), borderColour);
		textRenderer.draw(matrices, text, s * x, s * y, colour);
	}
	
	@Override
	public void onInitializeClient() {
		MidnightConfig.init(MODID, ExHUDConfig.class);
	}
}
