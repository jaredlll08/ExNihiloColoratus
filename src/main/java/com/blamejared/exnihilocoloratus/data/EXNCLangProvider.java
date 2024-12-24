package com.blamejared.exnihilocoloratus.data;

import com.blamejared.exnihilocoloratus.EXNCBlocks;
import com.blamejared.exnihilocoloratus.ExNihiloColoratus;
import net.minecraft.data.PackOutput;
import novamachina.novacore.data.AbstractLangGenerator;

public class EXNCLangProvider extends AbstractLangGenerator {

    public EXNCLangProvider(PackOutput output, String locale) {
        super(output, ExNihiloColoratus.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + ExNihiloColoratus.MODID, "Ex Nihilo: Coloratus");
        EXNCBlocks.getDefinitions().forEach(this::addBlockName);
    }

}
