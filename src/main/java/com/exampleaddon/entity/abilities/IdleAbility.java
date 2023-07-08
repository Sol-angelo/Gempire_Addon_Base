package com.exampleaddon.entity.abilities;

import com.gempire.entities.abilities.base.Ability;
import com.gempire.entities.abilities.interfaces.IIdleAbility;
import net.minecraft.network.chat.Component;

public class IdleAbility extends Ability implements IIdleAbility {

    //Idle abilities are used for abilities like torch bearer, or beastmaster
    public IdleAbility() {
        // The id and weight of your ability
        // the id should be in a new 100s digit depending on your addon
        // this prevents compat issues
        // the weight is what determines how likely gems are to have the ability
        super(102,5);
    }

    @Override
    public Component getName() {
        return Component.translatable("ability.exampleaddon.idle_test");
    }

    @Override
    public void execute() {
        // write what you want the ability to do

    }
}
