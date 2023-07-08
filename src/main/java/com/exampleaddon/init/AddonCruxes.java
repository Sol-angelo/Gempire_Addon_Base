package com.exampleaddon.init;

import com.gempire.systems.injection.Crux;
import com.gempire.systems.injection.GemConditions;
import com.gempire.util.CruxType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;

public class AddonCruxes {
    private static final int stoneCruxValue = 1;

    public static GemConditions TEST_CONDITIONS(){
        ArrayList<Crux> gemCruxes = new ArrayList<>();
        //add temperatures, these are biome temperatures, reference other gems to set these
        float gemTemperatureMin = 0f;
        float gemTemperatureMax = 2f;
        //add a primer
        Item primer = Items.ANCIENT_DEBRIS;
        //add essences
        String essences = "white";
        //add crux blocks
        gemCruxes.add(new Crux(Blocks.STONE.defaultBlockState(), stoneCruxValue, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.TERRACOTTA.defaultBlockState(), 2, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.DEEPSLATE.defaultBlockState(), stoneCruxValue, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.SANDSTONE.defaultBlockState(), stoneCruxValue, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.RED_SANDSTONE.defaultBlockState(), stoneCruxValue, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.COPPER_ORE.defaultBlockState(), 4, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.GRANITE.defaultBlockState(), stoneCruxValue, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.DIORITE.defaultBlockState(), stoneCruxValue, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.MAGMA_BLOCK.defaultBlockState(), 3, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.IRON_ORE.defaultBlockState(), 3, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.NETHER_QUARTZ_ORE.defaultBlockState(), 5, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.AMETHYST_BLOCK.defaultBlockState(), 9, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.QUARTZ_BLOCK.defaultBlockState(), 16, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        //set a rarity to make the gem more/less rare
        int rarity = 1;
        return new GemConditions(gemCruxes, essences, primer, gemTemperatureMin, gemTemperatureMax, rarity);
    }

    public static GemConditions VARYTEST_CONDITIONS(){
        ArrayList<Crux> gemCruxes = new ArrayList<>();
        float gemTemperatureMin = 1f;
        float gemTemperatureMax = 1.5f;
        Item primer = Items.GOLD_BLOCK;
        String essences = "yellow";
        gemCruxes.add(new Crux(Blocks.STONE.defaultBlockState(), stoneCruxValue, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.GRANITE.defaultBlockState(), stoneCruxValue, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.DIORITE.defaultBlockState(), 2, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.DEEPSLATE.defaultBlockState(), stoneCruxValue, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.GILDED_BLACKSTONE.defaultBlockState(), 3, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.NETHER_GOLD_ORE.defaultBlockState(), 4, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.COAL_ORE.defaultBlockState(), 2, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.DEEPSLATE_COAL_ORE.defaultBlockState(), 2, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.SAND.defaultBlockState(), stoneCruxValue, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.CLAY.defaultBlockState(), stoneCruxValue, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.ANDESITE.defaultBlockState(), stoneCruxValue, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.GOLD_ORE.defaultBlockState(), 4, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState(), 4, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.RAW_GOLD_BLOCK.defaultBlockState(), 5, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.GOLD_BLOCK.defaultBlockState(), 16, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        return new GemConditions(gemCruxes, essences, primer, gemTemperatureMin, gemTemperatureMax, 4);
    }
}
