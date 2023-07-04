package com.exampleaddon.entity.gem.abilities;

import com.gempire.entities.abilities.base.Ability;
import com.gempire.entities.abilities.interfaces.IAttributeAbility;
import com.exampleaddon.entity.gem.abilities.AddonAbilities;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class AttributeAbility extends Ability implements IAttributeAbility {

    public AttributeAbility(){
        this.ability = AddonAbilities.ATTRIBUTE_TEST;
    }

    @Override
    public Attribute attribute() {
        //defines the attribute that you want to edit, for example flying speed
        return Attributes.FLYING_SPEED;
    }

    @Override
    public double baseValue() {
        //changes that attribute
        return this.holder.getAttributeValue(Attributes.FLYING_SPEED) + 8.0D;
    }

    @Override
    public Component getName() {
        return Component.translatable("ability.exampleaddon.attribute_test");
    }
}
