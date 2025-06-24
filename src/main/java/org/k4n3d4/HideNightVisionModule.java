package org.k4n3d4;

import org.rusherhack.client.api.feature.module.ModuleCategory;
import org.rusherhack.client.api.feature.module.ToggleableModule;

public class HideNightVisionModule extends ToggleableModule{
    public static boolean IsEnable = true;

    public HideNightVisionModule() {
        super("HideNightVision", "Hide NightVision effect on the HUD", ModuleCategory.CLIENT);
    }

    @Override
    public void onEnable() {
        IsEnable = true;
    }

    @Override
    public void onDisable() {
        IsEnable = false;
    }
}