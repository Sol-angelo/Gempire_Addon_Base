package com.exampleaddon.init;

import com.exampleaddon.ExampleAddon;
import com.gempire.Gempire;
import com.gempire.items.ItemGem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AddonItems {
     public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleAddon.MODID);

     public static final RegistryObject<Item> TEST_GEM = ITEMS.register("test_gem", () ->
             new ItemGem(new Item.Properties(), ExampleAddon.MODID));

     public static final RegistryObject<Item> WHITE_VARYTEST_GEM = ITEMS.register("varytest_gem_0", () ->
             new ItemGem(new Item.Properties(), ExampleAddon.MODID));
     public static final RegistryObject<Item> YELLOW_VARYTEST_GEM = ITEMS.register("varytest_gem_4", () ->
             new ItemGem(new Item.Properties(), ExampleAddon.MODID));
     public static final RegistryObject<Item> BLUE_VARYTEST_GEM = ITEMS.register("varytest_gem_11", () ->
             new ItemGem(new Item.Properties(), ExampleAddon.MODID));
     public static final RegistryObject<Item> PINK_VARYTEST_GEM = ITEMS.register("varytest_gem_6", () ->
             new ItemGem(new Item.Properties(), ExampleAddon.MODID));
}


