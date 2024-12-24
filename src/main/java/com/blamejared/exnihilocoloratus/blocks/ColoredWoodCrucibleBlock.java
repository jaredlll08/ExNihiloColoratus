package com.blamejared.exnihilocoloratus.blocks;

import com.blamejared.exnihilocoloratus.EXNCBlockEntityTypes;
import com.blamejared.exnihilocoloratus.EXNCBlocks;
import com.blamejared.exnihilocoloratus.ExNihiloColoratus;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import novamachina.exnihilosequentia.world.level.block.WoodCrucibleBlock;
import novamachina.exnihilosequentia.world.level.block.entity.WoodBarrelBlockEntity;
import novamachina.exnihilosequentia.world.level.block.entity.WoodCrucibleBlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ColoredWoodCrucibleBlock extends WoodCrucibleBlock {

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand handIn, @NotNull BlockHitResult hit) {

        ItemStack stack = player.getItemInHand(handIn);
        if (level.getBlockEntity(pos) instanceof WoodCrucibleBlockEntity be) {
            Block newBlock = null;
            if (be.getFluidAmount() == 0) {
                if (stack.getItem() instanceof DyeItem dyeItem) {
                    newBlock = EXNCBlocks.CRUCIBLES.get(dyeItem.getDyeColor()).block();
                } else if(stack.is(ExNihiloColoratus.NONE_DYE_TAG)) {
                    newBlock = EXNCBlocks.NONE_CRUCIBLE.block();
                }
            }

            if (newBlock != null) {
                level.setBlock(pos, newBlock.withPropertiesOf(state), 4);
                level.setBlockEntity(be);
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                return InteractionResult.sidedSuccess(true);
            }

        }
        return super.use(state, level, pos, player, handIn, hit);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new WoodCrucibleBlockEntity(EXNCBlockEntityTypes.WOODEN_CRUCIBLE_ENTITY.getType(), pos, state);
    }
}
