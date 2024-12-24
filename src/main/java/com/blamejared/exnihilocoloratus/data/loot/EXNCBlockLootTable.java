package com.blamejared.exnihilocoloratus.data.loot;

import com.blamejared.exnihilocoloratus.EXNCBlocks;
import novamachina.novacore.data.loot.table.BlockLootTables;
import novamachina.novacore.world.level.block.BlockDefinition;

public class EXNCBlockLootTable extends BlockLootTables {
    @Override
    protected void generate() {
        add(this::createSingleItemTable, EXNCBlocks.getDefinitions().toArray(BlockDefinition[]::new));
    }
}
