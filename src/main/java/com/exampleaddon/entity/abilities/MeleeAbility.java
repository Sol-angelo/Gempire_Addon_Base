package com.exampleaddon.entity.abilities;

import com.gempire.entities.abilities.base.Ability;
import com.gempire.entities.abilities.interfaces.IMeleeAbility;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class MeleeAbility extends Ability implements IMeleeAbility {

    public MeleeAbility() {
        // The id and weight of your ability
        // the id should be in a new 100s digit depending on your addon
        // this prevents compat issues
        // the weight is what determines how likely gems are to have the ability
        super(104, 6);
    }

    @Override
    public Component getName() {
        return Component.translatable("ability.exampleaddon.melee_test");
    }

    @Override
    public void fight(LivingEntity livingEntity, double v) {
        // write what you want the ability to do when the gem attacks
        livingEntity.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
        // for example, this sets the targets chestplate slot to emtpy
    }
}
