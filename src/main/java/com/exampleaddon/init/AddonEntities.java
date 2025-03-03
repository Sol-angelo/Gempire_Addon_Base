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

    }

    public static void setAddonGems(){
        ArrayList<Integer> testEssences = new ArrayList<>();
        //set 2 essences required for incubation (numbers 0-3)
        testEssences.add(1);
        testEssences.add(1);
        HashMap<Item, Integer> testCruxes = new HashMap<>();
        //add crux items to gem - 1 is least wanted 4 is most wanted
        testCruxes.put(Items.ACACIA_FENCE, 1);
        testCruxes.put(Items.HONEYCOMB, 4);

        ArrayList<Integer> varyTestEssences = new ArrayList<>();
        //set 2 essences required for incubation (numbers 0-3)
        varyTestEssences.add(0);
        varyTestEssences.add(3);

        HashMap<Item, Integer> varyTestCruxes = new HashMap<>();
        //add crux items to gem - 1 is least wanted 4 is most wanted
        varyTestCruxes.put(Items.END_CRYSTAL, 1);
        varyTestCruxes.put(Items.CLAY_BALL, 4);


        AddonHandler.createIncubatedAddonGem("test", AddonItems.TEST_GEM.get(),
                AddonEntities.class, AddonItems.class, false, 50, testEssences, testCruxes, false);

        AddonHandler.createIncubatedAddonGem("varytest", AddonItems.TEST_GEM.get(),
                AddonEntities.class, AddonItems.class, true, 50, varyTestEssences, varyTestCruxes, false);
    }
}
