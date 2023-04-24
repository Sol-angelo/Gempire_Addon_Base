package com.gamer.crystalparadise.client.entity.model;

import com.gempire.client.entity.model.ModelGem;
import com.gempire.entities.bases.EntityGem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ModelTest<T extends EntityGem> extends ModelGem<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gempire", "ruby"), "main");
    public ModelPart head;
    public ModelPart body;
    public ModelPart armr;
    public ModelPart arml;
    public ModelPart legl;
    public ModelPart legr;

    public ModelTest(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.arml = root.getChild("arml");
        this.armr = root.getChild("armr");
        this.legl = root.getChild("legl");
        this.legr = root.getChild("legr");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -11.0F, -4.5F, 14.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -4.5F, -2.5F, 8.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.5F, 0.0F));
        partdefinition.addOrReplaceChild("legr", CubeListBuilder.create().texOffs(42, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 18.0F, 0.0F));
        partdefinition.addOrReplaceChild("legl", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 18.0F, 0.0F));
        partdefinition.addOrReplaceChild("armr", CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 10.0F, 0.0F));
        partdefinition.addOrReplaceChild("arml", CubeListBuilder.create().texOffs(42, 20).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 10.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 42);
    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        armr.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        legr.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        legl.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        arml.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.head, headPitch * 0.9F * 0.017453292F, netHeadYaw * 0.017453292F, 0.0F);
        this.setRotateAngle(this.arml, Mth.cos(limbSwing * 0.5F + 3.1415927F) * 1.5F * limbSwingAmount * 0.8F, 0.0F, 0.0F);
        this.setRotateAngle(this.armr, Mth.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount * 0.8F, 0.0F, 0.0F);
        this.setRotateAngle(this.legl, Mth.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount * 0.8F, 0.0F, 0.0F);
        this.setRotateAngle(this.legr, Mth.cos(limbSwing * 0.5F + 3.1415927F) * 1.5F * limbSwingAmount * 0.8F, 0.0F, 0.0F);
    }

    public void setRotateAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
