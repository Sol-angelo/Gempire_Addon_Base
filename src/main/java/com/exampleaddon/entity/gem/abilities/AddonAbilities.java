package com.exampleaddon.entity.gem.abilities;

import com.gempire.util.Abilities;

public enum AddonAbilities implements Abilities {
    ATTRIBUTE_TEST(100, 10),
    CRAFTING_TEST(101, 5);

    public final int id;
    public final int weight;
    AddonAbilities(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }
}
