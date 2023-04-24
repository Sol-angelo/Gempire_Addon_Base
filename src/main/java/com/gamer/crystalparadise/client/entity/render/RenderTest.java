package com.gamer.crystalparadise.client.entity.render;

import com.gamer.crystalparadise.client.entity.model.ModelTest;
import com.gamer.crystalparadise.entity.gem.entities.EntityTest;
import com.gempire.Gempire;
import com.gempire.client.entity.render.layers.*;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class RenderTest extends MobRenderer<EntityTest, ModelTest<EntityTest>> {

    public RenderTest(EntityRendererProvider.Context renderManagerIn, ModelTest<EntityTest> baseModel) {
        super(renderManagerIn, baseModel, .25f);
        this.addLayer(new SkinLayer(this));
        this.addLayer(new FaceLayer(this));
        this.addLayer(new HairLayer(this));
        this.addLayer(new OutfitLayer(this));
        this.addLayer(new InsigniaLayer(this));
        this.addLayer(new GemPlacementLayer(this));
    }

    @Override
    protected void scale(EntityTest entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(.8f, .8f, .8f);
        super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityTest entity) {
        return new ResourceLocation(Gempire.MODID + ":textures/entity/ruby/blank.png");
    }

    @Override
    protected void renderNameTag(EntityTest entityIn, Component displayNameIn, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        super.renderNameTag(entityIn, Component.literal("<" + entityIn.getFacet() + " " + entityIn.getCut() + ">"), matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.translate(0.0D, (double) (9.0F * 1.15F * 0.025F), 0.0D);
        super.renderNameTag(entityIn, displayNameIn, matrixStackIn, bufferIn, packedLightIn);
        super.shadowRadius = 0;
    }
}
