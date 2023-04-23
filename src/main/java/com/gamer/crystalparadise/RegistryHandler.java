package com.gamer.crystalparadise;

import com.gempire.init.ModItems;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RegistryHandler {

    public static void init() {
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());}}

