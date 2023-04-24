package com.gamer.crystalparadise;

import com.gamer.crystalparadise.entity.ModEntities;
import com.gamer.crystalparadise.item.ModItems;
import com.gempire.items.ItemGem;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static void init() {
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}

