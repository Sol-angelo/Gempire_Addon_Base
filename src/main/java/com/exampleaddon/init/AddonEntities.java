package com.exampleaddon.init;

import com.exampleaddon.entity.entities.EntityTest;
import com.exampleaddon.entity.entities.EntityVaryingTest;
import com.exampleaddon.ExampleAddon;
import com.gempire.Gempire;
import com.gempire.init.AddonHandler;
import com.gempire.init.ModEntities;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;

public class AddonEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Gempire.MODID);
    public static final RegistryObject<EntityType<EntityTest>> TEST = ENTITIES.register("test",
            () -> EntityType.Builder.of(EntityTest::new, MobCategory.CREATURE)
                    .sized(.75f, 1.5f) // Hitbox Size
                    //Name of the gem (same as above) and where it will exist
                    .build(new ResourceLocation(ExampleAddon.MODID, "test").toString()));

    public static final RegistryObject<EntityType<EntityVaryingTest>> VARYTEST = ENTITIES.register("varytest",
            () -> EntityType.Builder.of(EntityVaryingTest::new, MobCategory.CREATURE)
                    .sized(.95f, 1.8f)
                    .build(new ResourceLocation(ExampleAddon.MODID, "varytest").toString()));

    public static void registerCruxes() {
        //register cruxes
        /*ModEntities.CRUXTOGEM.put("test", AddonCruxes.TEST_CONDITIONS());
        ModEntities.CRUXTOGEM.put("varytest", AddonCruxes.VARYTEST_CONDITIONS());
        //possible to be injected with tier one (can be both)
        GemFormation.POSSIBLE_GEMS_TIER_1.add("test");
        //possible to be injected with tier two (can be both)
        GemFormation.POSSIBLE_GEMS_TIER_2.add("test");
        GemFormation.POSSIBLE_GEMS_TIER_2.add("varytest");*/
    }

    public static void setAddonGems(){
        //registers entity as a gem
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        HashMap<Item, Integer> map = new HashMap<>();
        map.put(Items.ACACIA_FENCE, 1);
        map.put(Items.HONEYCOMB, 4);

        AddonHandler.addon.put("test", true);
        AddonHandler.createIncubatedAddonGem("test", AddonItems.TEST_GEM.get(),
                AddonEntities.class, AddonItems.class, false, 50, list, map, false);
        AddonHandler.ENTITY_ADDON_ENTITY_REGISTRIES.put("test", AddonEntities.class);
        AddonHandler.ENTITY_ADDON_ITEM_REGISTRIES.put("test", AddonItems.class);
        AddonHandler.ENTITY_ADDON_ENTITY_REGISTRIES.put("varytest", AddonEntities.class);

        //AddonHandler.ADDON_ENTITY_REGISTRIES.put("exampleaddon", AddonEntities.class);
    }
}
