package com.exampleaddon;

import com.exampleaddon.entity.AddonEntities;
import com.exampleaddon.entity.gem.entities.EntityTest;
import com.gempire.init.EventHandler;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleAddon.MODID)
public class ExampleAddon
{

    public static final String MODID = "exampleaddon";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public ExampleAddon()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        // Register the commonSetup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::EntityAttributes);
        modEventBus.addListener(this::commonSetup);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    public void EntityAttributes(final EntityAttributeCreationEvent event) {
        //register entity attributes, these are set in the EntityTestGem class
        event.put(AddonEntities.TEST.get(), EntityTest.registerAttributes().build());
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        AddonEntities.setAddonGems();
        AddonEntities.registerCruxes();
    }
}
