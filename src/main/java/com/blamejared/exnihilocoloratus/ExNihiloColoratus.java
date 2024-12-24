package com.blamejared.exnihilocoloratus;

import com.blamejared.exnihilocoloratus.client.ClientSetup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import novamachina.novacore.bootstrap.ForgeBlockEntityTypeRegistry;
import novamachina.novacore.bootstrap.ForgeBlockRegistry;
import novamachina.novacore.bootstrap.ForgeCreativeModeTabRegistry;
import novamachina.novacore.bootstrap.ForgeItemRegistry;
import novamachina.novacore.world.item.CreativeModeTabDefinition;
import novamachina.novacore.world.level.block.BlockDefinition;
import novamachina.novacore.world.level.block.BlockEntityTypeDefinition;

@Mod(ExNihiloColoratus.MODID)
public class ExNihiloColoratus {

    public static final String MODID = "exnihilocoloratus";

    public static final TagKey<Item> NONE_DYE_TAG = ItemTags.create(new ResourceLocation("forge:dyes/none"));

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }

    public ExNihiloColoratus() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
        FMLJavaModLoadingContext.get()
                .getModEventBus()
                .addListener((RegisterEvent event) -> {
                    if (event.getRegistryKey().equals(BuiltInRegistries.BLOCK.key())) {
                        ForgeBlockRegistry registry = new ForgeBlockRegistry();
                        for (BlockDefinition<?> definition : EXNCBlocks.getDefinitions()) {
                            registry.register(definition);
                        }
                    }
                    if (event.getRegistryKey().equals(BuiltInRegistries.BLOCK_ENTITY_TYPE.key())) {
                        ForgeBlockEntityTypeRegistry registry = new ForgeBlockEntityTypeRegistry();
                        for (BlockEntityTypeDefinition<?> definition : EXNCBlockEntityTypes.getDefinitions()) {
                            registry.register(definition);
                        }
                    }
                    if (event.getRegistryKey().equals(BuiltInRegistries.ITEM.key())) {
                        ForgeItemRegistry registry = new ForgeItemRegistry();
                        for (BlockDefinition<?> definition : EXNCBlocks.getDefinitions()) {
                            registry.register(definition);
                        }
                    }
                    if (event.getRegistryKey().equals(BuiltInRegistries.CREATIVE_MODE_TAB.key())) {
                        ForgeCreativeModeTabRegistry registry = new ForgeCreativeModeTabRegistry();
                        for (CreativeModeTabDefinition definition : EXNCCreativeModeTabs.getDefinitions()) {
                            registry.register(definition);
                        }
                    }
                });
    }
}
