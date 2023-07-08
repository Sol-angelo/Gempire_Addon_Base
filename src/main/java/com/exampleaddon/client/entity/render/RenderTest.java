package com.exampleaddon.client.entity.render;

import com.exampleaddon.ExampleAddon;
import com.exampleaddon.client.entity.model.ModelTest;
import com.exampleaddon.entity.entities.EntityTest;
import com.exampleaddon.entity.entities.EntityVaryingTest;
import com.gempire.client.entity.render.layers.*;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class RenderTest extends MobRenderer<EntityTest, ModelTest<EntityTest>> {

    public RenderTest(EntityRendererProvider.Context renderManagerIn, ModelTest<EntityTest> baseModel) {
        super(renderManagerIn, baseModel, .25f);
        this.addLayer(new SkinLayer(this));
        this.addLayer(new FaceLayer(this));
        this.addLayer(new OutfitLayer(this));
        this.addLayer(new InsigniaLayer(this));
        this.addLayer(new HairLayer(this));
        this.addLayer(new VisorLayer(this));
        this.addLayer(new GemPlacementLayer(this));
        this.addLayer(new ItemInHandLayer(this, renderManagerIn.getItemInHandRenderer()));
    }

    @Override
    protected void scale(EntityTest entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(entitylivingbaseIn.getXScale(), entitylivingbaseIn.getYScale(), entitylivingbaseIn.getZScale());
        super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityTest entity) {
        return new ResourceLocation(ExampleAddon.MODID + ":textures/entity/test/blank.png");
    }

    @Override
    protected void renderNameTag(EntityTest entityIn, Component displayNameIn, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        super.renderNameTag(entityIn, Component.literal("<"+entityIn.getFacet()+" "+entityIn.getCut()+">"), matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.translate(0.0D, (double)(9.0F * 1.15F * 0.025F), 0.0D);
        if (entityIn.hasCustomName()) {
            super.renderNameTag(entityIn, entityIn.getCustomName(), matrixStackIn, bufferIn, packedLightIn);
        } else {
            super.renderNameTag(entityIn, Component.literal(entityIn.getNickname().getString()), matrixStackIn, bufferIn, packedLightIn);
        }
        super.shadowRadius = 0;
    }
}
