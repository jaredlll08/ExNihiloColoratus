package com.blamejared.exnihilocoloratus.data;

import com.blamejared.exnihilocoloratus.EXNCBlocks;
import com.blamejared.exnihilocoloratus.ExNihiloColoratus;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import novamachina.exnihilosequentia.data.AbstractBlockStateGenerator;
import novamachina.exnihilosequentia.world.level.block.WoodBarrelBlock;
import novamachina.exnihilosequentia.world.level.block.WoodCrucibleBlock;

import javax.annotation.Nonnull;

public class EXNCBlockStateGenerator extends AbstractBlockStateGenerator {

    public EXNCBlockStateGenerator(@Nonnull final PackOutput output, @Nonnull final ExistingFileHelper exFileHelper) {
        super(output, ExNihiloColoratus.MODID, exFileHelper);
    }

    protected void createCrucible(Block block, ResourceLocation texture, ResourceLocation particle) {
        ConfiguredModel model = new ConfiguredModel(this.models().getBuilder(this.getRegistryName(block)).parent(new ModelFile.UncheckedModelFile(this.exnihiloLoc("block/crucible_base"))).texture("particle", particle).texture("texture", texture).renderType("cutout_mipped"));
        this.simpleItemBlock(block, model.model);
    }

    protected void createBarrel(Block block, ResourceLocation texture, ResourceLocation particle) {
        ConfiguredModel model = new ConfiguredModel(this.models().getBuilder(this.getRegistryName(block)).parent(new ModelFile.UncheckedModelFile(this.exnihiloLoc("block/barrel_base"))).texture("texture", texture).texture("particle", particle).renderType("cutout_mipped"));
        this.simpleItemBlock(block, model.model);
    }

    @Override
    protected void registerStatesAndModels() {
        EXNCBlocks.getDefinitions().forEach(blockDefinition -> {
            ResourceLocation rl = ExNihiloColoratus.rl("block/" + blockDefinition.getId().getPath());
            if (blockDefinition.block() instanceof WoodBarrelBlock) {
                createBarrel(blockDefinition.block(), rl, rl);
            } else if (blockDefinition.block() instanceof WoodCrucibleBlock) {
                createCrucible(blockDefinition.block(), rl, rl);
            }
        });
    }

}
