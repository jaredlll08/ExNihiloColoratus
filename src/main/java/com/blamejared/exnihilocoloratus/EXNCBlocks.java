package com.blamejared.exnihilocoloratus;

import com.blamejared.exnihilocoloratus.blocks.ColoredWoodBarrelBlock;
import com.blamejared.exnihilocoloratus.blocks.ColoredWoodCrucibleBlock;
import com.google.common.collect.ImmutableMap;
import net.minecraft.Util;
import net.minecraft.world.item.DyeColor;
import novamachina.exnihilosequentia.world.level.block.BarrelBlock;
import novamachina.exnihilosequentia.world.level.block.CrucibleBlock;
import novamachina.novacore.core.registries.BlockRegistry;
import novamachina.novacore.world.level.block.BlockDefinition;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EXNCBlocks {
    private static final BlockRegistry BLOCKS = new BlockRegistry(ExNihiloColoratus.MODID);

    public static final BlockDefinition<CrucibleBlock> NONE_CRUCIBLE = BLOCKS.burnableBlock("Colorless Crucible", "none_crucible", () -> new ColoredWoodCrucibleBlock(Optional.empty()));
    public static final BlockDefinition<BarrelBlock> NONE_BARREL = BLOCKS.burnableBlock("Colorless Barrel", "none_barrel", () -> new ColoredWoodBarrelBlock(Optional.empty()));
    public static final Map<DyeColor, BlockDefinition<CrucibleBlock>> CRUCIBLES = Util.make(() -> {
        ImmutableMap.Builder<DyeColor, BlockDefinition<CrucibleBlock>> builder = ImmutableMap.builder();
        for (DyeColor value : DyeColor.values()) {
            builder.put(value, BLOCKS.burnableBlock(titleCase(value.getName()) + " Crucible", value.getName() + "_crucible", () -> new ColoredWoodCrucibleBlock(Optional.of(value))));
        }
        return builder.build();
    });

    public static final Map<DyeColor, BlockDefinition<BarrelBlock>> BARRELS = Util.make(() -> {
        ImmutableMap.Builder<DyeColor, BlockDefinition<BarrelBlock>> builder = ImmutableMap.builder();
        for (DyeColor value : DyeColor.values()) {
            builder.put(value, BLOCKS.burnableBlock(titleCase(value.getName()) + " Barrel", value.getName() + "_barrel", () -> new ColoredWoodBarrelBlock(Optional.of(value))));
        }
        return builder.build();
    });

    private static String titleCase(String name) {
        return Arrays.stream(name.split("_"))
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    public static List<BlockDefinition<?>> getDefinitions() {
        return BLOCKS.getRegistry();
    }

    private EXNCBlocks() {
    }
}
