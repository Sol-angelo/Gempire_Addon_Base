package com.gamer.crystalparadise.entity.gem.other;

import com.gempire.systems.injection.Crux;
import com.gempire.systems.injection.GemConditions;
import com.gempire.util.CruxType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;

public class ModCruxes {
    private static final int stoneCruxValue = 1;

    public static GemConditions TEST_CONDITIONS(){
        //this is always like this
        ArrayList<Crux> gemCruxes = new ArrayList<>();
        //add temperatures, these are biome temperatures, reference other gems to set these
        float gemTemperatureMin = 0f;
        float gemTemperatureMax = 2f;
        //add a primer (doesnt work in 2.0.2)
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
}
