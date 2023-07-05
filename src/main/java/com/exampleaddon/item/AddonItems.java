package com.exampleaddon.item;

import com.exampleaddon.ExampleAddon;
import com.gempire.items.ItemGem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AddonItems {
     public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleAddon.MODID);

     public static final RegistryObject<Item> TEST = ITEMS.register("test", () ->
             new Item(new Item.Properties()));

     public static final RegistryObject<Item> TEST_GEM = ITEMS.register("test_gem", () ->
             new ItemGem(new ItemGem.Properties(), ExampleAddon.MODID));
     }


