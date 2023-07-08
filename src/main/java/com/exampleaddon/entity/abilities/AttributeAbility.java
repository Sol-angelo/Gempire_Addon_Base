package com.exampleaddon.entity.abilities;

import com.gempire.entities.abilities.base.Ability;
import com.gempire.entities.abilities.interfaces.IAttributeAbility;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class AttributeAbility extends Ability implements IAttributeAbility {

    // this ability increases speed
    public AttributeAbility(){
        // The id and weight of your ability
        // the id should be in a new 100s digit depending on your addon
        // this prevents compat issues
        // the weight is what determines how likely gems are to have the ability
        super(101,5);
    }

    @Override
    public Attribute attribute() {
        //defines the attribute that you want to edit, for example speed
        return Attributes.MOVEMENT_SPEED;
    }

    @Override
    public double baseValue() {
        //changes that attribute
        return this.holder.getAttributeValue(attribute()) + 8.0D;
    }

    @Override
    public Component getName() {
        return Component.translatable("ability.exampleaddon.attribute_test");
    }
}
