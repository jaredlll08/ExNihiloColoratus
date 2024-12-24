package com.blamejared.exnihilocoloratus.data.tags;

import com.blamejared.exnihilocoloratus.EXNCBlocks;
import com.blamejared.exnihilocoloratus.ExNihiloColoratus;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import novamachina.exnihilosequentia.tags.ExNihiloTags;
import novamachina.exnihilosequentia.world.level.block.WoodBarrelBlock;
import novamachina.exnihilosequentia.world.level.block.WoodCrucibleBlock;
import novamachina.novacore.data.tags.TagProvider;
import novamachina.novacore.world.level.block.BlockDefinition;

import java.util.concurrent.CompletableFuture;

public class EXNCTagProvider extends TagProvider {
    public EXNCTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExNihiloColoratus.MODID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        addToTag(ExNihiloTags.CRUCIBLE, EXNCBlocks.getDefinitions().stream().map(BlockDefinition::block).filter(block -> block instanceof WoodCrucibleBlock).toArray(Block[]::new));
        addToTag(ExNihiloTags.BARREL, EXNCBlocks.getDefinitions().stream().map(BlockDefinition::block).filter(block -> block instanceof WoodBarrelBlock).toArray(Block[]::new));
        addToTag(BlockTags.MINEABLE_WITH_AXE, EXNCBlocks.getDefinitions().stream().map(BlockDefinition::block).toArray(Block[]::new));
    }

}
