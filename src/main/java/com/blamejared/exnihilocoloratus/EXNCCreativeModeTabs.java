package com.blamejared.exnihilocoloratus;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import novamachina.novacore.core.registries.CreativeModeTabRegistry;
import novamachina.novacore.world.item.CreativeModeTabDefinition;

import javax.annotation.Nonnull;
import java.util.List;

public class EXNCCreativeModeTabs {

    private static final CreativeModeTabRegistry CREATIVE_MODE_TABS = new CreativeModeTabRegistry(ExNihiloColoratus.MODID);

    public static List<CreativeModeTabDefinition> getDefinitions() {
        return CREATIVE_MODE_TABS.getRegistry();
    }

    @Nonnull
    public static final CreativeModeTabDefinition EXN = CREATIVE_MODE_TABS.creativeModeTab("creative_tab", CreativeModeTab.builder().icon(() -> EXNCBlocks.CRUCIBLES.get(DyeColor.GREEN).itemStack()).title(Component.literal("Ex Nihilo: Coloratus")).displayItems((parameters, output) -> {
        EXNCBlocks.getDefinitions().forEach(output::accept);
    }).build());
}
