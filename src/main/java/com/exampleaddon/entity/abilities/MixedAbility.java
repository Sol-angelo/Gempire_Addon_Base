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

public class MixedAbility extends Ability implements IMeleeAbility, IEffectAbility, IEmotionalAbility, IViolentAbility {

    // This ability implements multiple ability types
    // you can implement multiple to have them interact
    // for example, this ability applies darkness to the target with a 1/5 chance
    // it also has an emotional outburst, which applies darkness to all gems and players nearby
    public MixedAbility() {
        // The id and weight of your ability
        // the id should be in a new 100s digit depending on your addon
        // this prevents compat issues
        // the weight is what determines how likely gems are to have the ability
        super(103, 5);
    }

    @Override
    public Component getName() {
        return Component.translatable("ability.exampleaddon.mixed_test");
    }

    @Override
    public void fight(LivingEntity entityIn, double damage) {
        PathfinderMob entity = null;
        if(entityIn instanceof PathfinderMob){
            entity = (PathfinderMob) entityIn;
        }
        else{
            return;
        }
        Random rand = new Random();
        if (rand.nextInt(5) == 0) entity.addEffect(this.effect());
    }

    @Override
    public void outburst() {
        List<PathfinderMob> entities = this.holder.level.<PathfinderMob>getEntitiesOfClass(PathfinderMob.class, this.holder.getBoundingBox().inflate(20.0D, 10.0D, 20.0D));
        for(PathfinderMob entity : entities){
            if(entity instanceof EntityGem || this.holder.isOwner(entity.getUUID())){
                continue;
            }
            entity.addEffect(effect());
        }
    }

    @Override
    public MobEffectInstance effect() {
        return new MobEffectInstance(MobEffects.DARKNESS, 100, 0, false, false);
    }
}
