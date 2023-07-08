package com.exampleaddon.client;

import com.exampleaddon.ExampleAddon;
import com.exampleaddon.client.entity.model.ModelTest;
import com.exampleaddon.client.entity.model.ModelVaryTest;
import com.exampleaddon.client.entity.render.RenderTest;
import com.exampleaddon.client.entity.render.RenderVaryTest;
import com.exampleaddon.init.AddonEntities;
import com.exampleaddon.init.AddonItemProperties;
import com.exampleaddon.init.AddonItems;
import com.gempire.Gempire;
import com.gempire.init.ModBlocks;
import com.gempire.init.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy {

    @Mod.EventBusSubscriber(modid = ExampleAddon.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModBusEvents {


        @SubscribeEvent
        public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(AddonEntities.TEST.get(), m -> new RenderTest(m, new ModelTest<>(m.bakeLayer(ModelTest.LAYER_LOCATION))));
            event.registerEntityRenderer(AddonEntities.VARYTEST.get(), m -> new RenderVaryTest(m, new ModelVaryTest<>(m.bakeLayer(ModelVaryTest.LAYER_LOCATION))));
        }

        @SubscribeEvent
        public static void doSetup(FMLClientSetupEvent event) {
            AddonItemProperties.addCustomItemProperties();
        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            //register layers here
            event.registerLayerDefinition(ModelVaryTest.LAYER_LOCATION, ModelVaryTest::createBodyLayer);
            event.registerLayerDefinition(ModelTest.LAYER_LOCATION, ModelTest::createBodyLayer);
        }

        @SubscribeEvent
        public void buildContents(CreativeModeTabEvent.Register event) {
            event.registerCreativeModeTab(new ResourceLocation(ExampleAddon.MODID, "gems"), builder ->
                    // Set name of tab to display
                    builder.title(Component.translatable("itemGroup.gems"))
                            // Set icon of creative tab
                            .icon(() -> new ItemStack(AddonItems.WHITE_VARYTEST_GEM.get()))
                            // Add default items to tab
                            .displayItems((params, populator) -> {
                                populator.accept(AddonItems.WHITE_VARYTEST_GEM.get());
                                populator.accept(AddonItems.PINK_VARYTEST_GEM.get());
                                populator.accept(AddonItems.BLUE_VARYTEST_GEM.get());
                                populator.accept(AddonItems.YELLOW_VARYTEST_GEM.get());
                                populator.accept(AddonItems.TEST_GEM.get());
                            })
            );
        }

    }
}
