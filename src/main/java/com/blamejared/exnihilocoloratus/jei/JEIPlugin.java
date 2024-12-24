package com.blamejared.exnihilocoloratus.jei;

import com.blamejared.exnihilocoloratus.EXNCBlocks;
import com.blamejared.exnihilocoloratus.ExNihiloColoratus;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import net.minecraft.resources.ResourceLocation;
import novamachina.exnihilosequentia.common.compat.jei.RecipeTypes;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Nonnull
    @Override
    public ResourceLocation getPluginUid() {
        return ExNihiloColoratus.rl("builtin");
    }

    @Override
    public void registerRecipeCatalysts(@Nonnull final IRecipeCatalystRegistration registration) {
        Stream.concat(Stream.of(EXNCBlocks.NONE_CRUCIBLE), EXNCBlocks.CRUCIBLES.values().stream()).forEach(blockDefinition -> {
            registration.addRecipeCatalyst(blockDefinition.itemStack(), RecipeTypes.MELTING, RecipeTypes.HEAT);
        });

        Stream.concat(Stream.of(EXNCBlocks.NONE_BARREL), EXNCBlocks.BARRELS.values().stream()).forEach(blockDefinition -> {
            registration.addRecipeCatalyst(
                    blockDefinition.itemStack(),
                    RecipeTypes.SOLIDIFYING,
                    RecipeTypes.TRANSITION,
                    RecipeTypes.PRECIPITATE,
                    RecipeTypes.COMPOST);
        });
    }

}