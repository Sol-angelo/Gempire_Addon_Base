package com.exampleaddon.item;

import com.gempire.init.ModItemProperties;

public class AddonItemProperties {
    public static void addCustomItemProperties() {
        ModItemProperties.makeGem(AddonItems.TEST_GEM.get());
    }
}
