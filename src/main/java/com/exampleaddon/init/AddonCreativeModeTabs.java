package com.exampleaddon.init;

import com.exampleaddon.ExampleAddon;
import com.gempire.init.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AddonCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleAddon.MODID);

    public static final RegistryObject<CreativeModeTab> ADDON_TAB = CREATIVE_MODE_TABS.register("addon_tab",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.addon_tab"))
                    // Set icon of creative tab
                    .icon(() -> new ItemStack(AddonItems.BLUE_VARYTEST_GEM.get()))
                    .displayItems((params, populator) -> {
                        populator.accept(AddonItems.WHITE_VARYTEST_GEM.get());
                        populator.accept(AddonItems.BLUE_VARYTEST_GEM.get());
                        populator.accept(AddonItems.YELLOW_VARYTEST_GEM.get());
                        populator.accept(AddonItems.PINK_VARYTEST_GEM.get());
                        populator.accept(AddonItems.TEST_GEM.get());
                    })
                    .build()
    );
}
