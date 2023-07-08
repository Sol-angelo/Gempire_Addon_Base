package com.exampleaddon.init;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RegistryHandler {

    public static void init() {
        AddonItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        AddonEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}

