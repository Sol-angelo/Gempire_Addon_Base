package com.exampleaddon.init;

import com.exampleaddon.entity.abilities.*;
import com.gempire.init.ModAbilities;

public class AddonAbilities {
    public static void registerAbilities() {
        ModAbilities.abilities.add(new AttributeAbility());
        ModAbilities.abilities.add(new CraftingAbility());
        ModAbilities.abilities.add(new EffectAbility());
        ModAbilities.abilities.add(new IdleAbility());
        ModAbilities.abilities.add(new MeleeAbility());
        ModAbilities.abilities.add(new MixedAbility());
    }
}
