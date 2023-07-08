package com.exampleaddon.init;

import com.gempire.init.ModItemProperties;

public class AddonItemProperties {
    public static void addCustomItemProperties() {
        ModItemProperties.makeGem(AddonItems.TEST_GEM.get());
        ModItemProperties.makeGem(AddonItems.WHITE_VARYTEST_GEM.get());
        ModItemProperties.makeGem(AddonItems.PINK_VARYTEST_GEM.get());
        ModItemProperties.makeGem(AddonItems.YELLOW_VARYTEST_GEM.get());
        ModItemProperties.makeGem(AddonItems.BLUE_VARYTEST_GEM.get());
    }
}
