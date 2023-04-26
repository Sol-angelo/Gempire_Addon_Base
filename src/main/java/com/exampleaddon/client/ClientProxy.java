package com.exampleaddon.client;

import com.exampleaddon.ExampleAddon;
import com.exampleaddon.client.entity.model.ModelTest;
import com.exampleaddon.client.entity.render.RenderTest;
import com.exampleaddon.entity.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientProxy {

    @Mod.EventBusSubscriber(modid = ExampleAddon.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModBusEvents {


        @SubscribeEvent
        public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModEntities.TEST.get(), m -> new RenderTest(m, new ModelTest<>(m.bakeLayer(ModelTest.LAYER_LOCATION))));
        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            //register layers here
            event.registerLayerDefinition(ModelTest.LAYER_LOCATION, ModelTest::createBodyLayer);
        }

    }
}
