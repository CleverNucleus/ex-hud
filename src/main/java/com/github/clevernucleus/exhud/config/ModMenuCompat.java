package com.github.clevernucleus.exhud.config;

import com.github.clevernucleus.exhud.ExHUD;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import eu.midnightdust.lib.config.MidnightConfig;

public class ModMenuCompat implements ModMenuApi {
	
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> MidnightConfig.getScreen(parent, ExHUD.MODID);
	}
}
