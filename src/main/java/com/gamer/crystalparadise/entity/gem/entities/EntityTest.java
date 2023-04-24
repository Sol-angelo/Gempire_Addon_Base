package com.gamer.crystalparadise.entity.gem.entities;

import com.gempire.entities.ai.*;
import com.gempire.entities.bases.EntityGem;
import com.gempire.util.Abilities;
import com.gempire.util.GemPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityTest extends EntityGem {
    public EntityTest(EntityType<? extends PathfinderMob> type, Level worldIn) {
        super(type, worldIn);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.4D)
                .add(Attributes.ATTACK_DAMAGE, 3.0D)
                .add(Attributes.ATTACK_SPEED, 1.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new FloatGoal(this));
        this.goalSelector.addGoal(6, new PanicGoal(this, 1.1D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 4.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new EntityAIFollowAssigned(this, 1.0D));
        this.goalSelector.addGoal(7, new EntityAIWander(this, 1.0D));
        this.goalSelector.addGoal(7, new EntityAIFollowOwner(this, 1.0D));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 1, false, false, (p_234199_0_) -> p_234199_0_.getClassification(true) == MobCategory.MONSTER));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityGem.class, 1, false, false, this::checkRebel));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.1D, false));
        this.targetSelector.addGoal(2, new OwnerHurtByTargetGemGoal(this));
        this.targetSelector.addGoal(3, new OwnerHurtTargetGemGoal(this));
    }

    @Override
    public int generateSkinVariant() {
        return 0;
    }

    @Override
    public GemPlacements[] getPlacements() {
        return new GemPlacements[] {
                GemPlacements.TOP_OF_HEAD, GemPlacements.FOREHEAD, GemPlacements.BACK_OF_HEAD, GemPlacements.LEFT_EYE, GemPlacements.RIGHT_EYE, GemPlacements.NOSE, GemPlacements.LEFT_CHEEK, GemPlacements.RIGHT_CHEEK, GemPlacements.LEFT_EAR, GemPlacements.RIGHT_EAR,
                GemPlacements.CHEST, GemPlacements.BACK, GemPlacements.BELLY, GemPlacements.LEFT_SHOULDER, GemPlacements.RIGHT_SHOULDER, GemPlacements.LEFT_HAND, GemPlacements.RIGHT_HAND, GemPlacements.LEFT_PALM, GemPlacements.RIGHT_PALM, GemPlacements.LEFT_THIGH,
                GemPlacements.RIGHT_THIGH, GemPlacements.LEFT_ANKLE, GemPlacements.RIGHT_ANKLE
        };
    }

    @Override
    public int generateHairVariant() {
        return this.random.nextInt(1);    }

    @Override
    public int generateOutfitVariant() {
        return this.random.nextInt(1);    }

    @Override
    public int generateInsigniaVariant() {
        return this.random.nextInt(1);    }

    @Override
    public int generateSkinColorVariant() {
        return this.random.nextInt(1);
    }

    @Override
    public boolean hasSkinColorVariant() {
        return false;
    }

    @Override
    public boolean generateIsEmotional() {
        return false;
    }

    @Override
    public byte EmotionThreshold() {
        return 0;
    }

    @Override
    public boolean canChangeUniformColorByDefault() {
        return true;
    }

    @Override
    public boolean canChangeInsigniaColorByDefault() {
        return true;
    }

    @Override
    public Abilities[] possibleAbilities() {
        return new Abilities[] {
                Abilities.NO_ABILITY, Abilities.HYDROKINESIS, Abilities.LUCK
        };
    }

    @Override
    public Abilities[] definiteAbilities() {
        return new Abilities[] {
                Abilities.TECHNICIAN
        };
    }
}
