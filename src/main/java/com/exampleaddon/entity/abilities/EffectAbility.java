package com.exampleaddon.entity.abilities;

import com.gempire.entities.abilities.base.Ability;
import com.gempire.entities.abilities.interfaces.IEffectAbility;
import com.gempire.entities.abilities.interfaces.IEmotionalAbility;
import com.gempire.entities.abilities.interfaces.IMeleeAbility;
import com.gempire.entities.abilities.interfaces.IViolentAbility;
import com.gempire.entities.bases.EntityGem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;

import java.util.List;
import java.util.Random;

public class EffectAbility extends Ability implements IEffectAbility {

    // this ability applies conduit power to all gems and players nearby

    public EffectAbility() {
        // The id and weight of your ability
        // the id should be in a new 100s digit depending on your addon
        // this prevents compat issues
        // the weight is what determines how likely gems are to have the ability
        super(105, 5);
    }

    @Override
    public Component getName() {
        return Component.translatable("ability.exampleaddon.mixed_test");
    }

    @Override
    public MobEffectInstance effect() {
        return new MobEffectInstance(MobEffects.CONDUIT_POWER, 100, 0, false, false);
    }
}
