package com.blamejared.exnihilocoloratus.client;

import com.blamejared.exnihilocoloratus.EXNCBlockEntityTypes;
import com.blamejared.exnihilocoloratus.ExNihiloColoratus;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import novamachina.exnihilosequentia.client.render.BarrelRender;
import novamachina.exnihilosequentia.client.render.CrucibleRender;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(
        modid = ExNihiloColoratus.MODID,
        value = Dist.CLIENT,
        bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    private ClientSetup() {
    }

    public static void init(@Nonnull final FMLClientSetupEvent event) {

        BarrelRender.register(EXNCBlockEntityTypes.WOODEN_BARREL_ENTITY.getType());
        CrucibleRender.register(EXNCBlockEntityTypes.WOODEN_CRUCIBLE_ENTITY.getType());
    }
}
