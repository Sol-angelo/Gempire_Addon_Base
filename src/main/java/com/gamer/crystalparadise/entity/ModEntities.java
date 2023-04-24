package com.gamer.crystalparadise.entity;

import com.gamer.crystalparadise.CrystalParadise;
import com.gamer.crystalparadise.entity.gem.entities.EntityTest;
import com.gempire.Gempire;
import com.gempire.init.AddonHandler;
import com.gamer.crystalparadise.entity.gem.other.ModCruxes;
import com.gempire.systems.injection.GemConditions;
import com.gempire.systems.injection.GemFormation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Gempire.MODID);
    public static HashMap<String, GemConditions> CRUXTOGEM = new HashMap<>();

    public static final RegistryObject<EntityType<EntityTest>> TEST = ENTITIES.register("test",
            () -> EntityType.Builder.of(EntityTest::new, MobCategory.CREATURE)
                    .sized(.75f, 1.5f) // Hitbox Size
                    //Name of the gem (same as above) and where it will exist
                    .build(new ResourceLocation(CrystalParadise.MODID, "test").toString()));

    public static void registerCruxes() {
        //register cruxes
        ModEntities.CRUXTOGEM.put("test", ModCruxes.TEST_CONDITIONS());
        //possible to be injected with tier one (can be both)
        GemFormation.POSSIBLE_GEMS_TIER_1.add("test");
        //possible to be injected with tier two (can be both)
        GemFormation.POSSIBLE_GEMS_TIER_2.add("test");
    }

    public static void setAddonGems(){
        //registers entity as a gem
        AddonHandler.VANILLA_GEMS.add("test");
        AddonHandler.ADDON_ENTITY_REGISTRIES.put("test", EntityTest.class);
    }
}
