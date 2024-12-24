package com.blamejared.exnihilocoloratus;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import novamachina.exnihilosequentia.world.level.block.entity.WoodBarrelBlockEntity;
import novamachina.exnihilosequentia.world.level.block.entity.WoodCrucibleBlockEntity;
import novamachina.novacore.core.registries.BlockEntityTypeRegistry;
import novamachina.novacore.world.level.block.BlockDefinition;
import novamachina.novacore.world.level.block.BlockEntityTypeDefinition;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EXNCBlockEntityTypes {

    private static final BlockEntityTypeRegistry BLOCK_ENTITY_TYPES = new BlockEntityTypeRegistry(ExNihiloColoratus.MODID);

    private EXNCBlockEntityTypes() {
    }

    public static List<BlockEntityTypeDefinition<? extends BlockEntity>> getDefinitions() {
        return BLOCK_ENTITY_TYPES.getRegistry();
    }

    @Nonnull
    public static final BlockEntityTypeDefinition<WoodCrucibleBlockEntity> WOODEN_CRUCIBLE_ENTITY =
            BLOCK_ENTITY_TYPES.create(
                    "crucibles",
                    WoodCrucibleBlockEntity::new,
                    Stream.concat(Stream.of(EXNCBlocks.NONE_CRUCIBLE), Arrays.stream(DyeColor.values()).map(EXNCBlocks.CRUCIBLES::get)).toArray(BlockDefinition[]::new));
    @Nonnull
    public static final BlockEntityTypeDefinition<WoodBarrelBlockEntity> WOODEN_BARREL_ENTITY =
            BLOCK_ENTITY_TYPES.create(
                    "barrels",
                    WoodBarrelBlockEntity::new,
                    Stream.concat(Stream.of(EXNCBlocks.NONE_BARREL), Arrays.stream(DyeColor.values()).map(EXNCBlocks.BARRELS::get)).toArray(BlockDefinition[]::new));


}
