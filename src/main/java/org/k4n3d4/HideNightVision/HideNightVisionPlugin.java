package org.k4n3d4.HideNightVision;

import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.plugin.Plugin;

public class HideNightVisionPlugin extends Plugin {
	
	public static long minecraftInitTime = 0L;
	public static HideNightVisionPlugin INSTANCE;
	
	@Override
	public void onLoad() {
		INSTANCE = this;

		final HideNightVisionModule hideNightVisionModule = new HideNightVisionModule();
		RusherHackAPI.getModuleManager().registerFeature(hideNightVisionModule);

		this.getLogger().info("HideNightVision plugin loaded");
	}

	@Override
	public void onUnload() {
		this.getLogger().info("HideNightVision plugin unloaded!");
	}
	
}