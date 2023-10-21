package dev.andrewd1.something.block.custom;

import dev.andrewd1.something.block.ModBlocks;
import dev.andrewd1.something.block.entity.custom.EmptyBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class OilDerrickBlock extends BaseEntityBlock {
    public final ArrayList<EmptyBlockEntity> EMPTY_BLOCKS = new ArrayList<>();

    public OilDerrickBlock() {
        super(Properties.copy(Blocks.COBBLESTONE).noOcclusion());
    }

    @Override
    public void setPlacedBy(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @Nullable LivingEntity pPlacer, @NotNull ItemStack pStack) {
        BlockPos relativePos;

        relativePos = pPos.above();
        pLevel.setBlock(relativePos, ModBlocks.EMPTY_BLOCK.get().defaultBlockState().setValue(EmptyBlock.Y_OFFSET, -1), 0);
        EMPTY_BLOCKS.add((EmptyBlockEntity) pLevel.getBlockEntity(relativePos));

        relativePos = pPos.offset(1, 0, 0);
        pLevel.setBlock(relativePos, ModBlocks.EMPTY_BLOCK.get().defaultBlockState().setValue(EmptyBlock.ENERGY, true).setValue(EmptyBlock.NX_OFFSET, 1), 0);
        EMPTY_BLOCKS.add((EmptyBlockEntity) pLevel.getBlockEntity(relativePos));

        relativePos = pPos.offset(-1, 0, 0);
        pLevel.setBlock(relativePos, ModBlocks.EMPTY_BLOCK.get().defaultBlockState().setValue(EmptyBlock.ENERGY, true).setValue(EmptyBlock.X_OFFSET, 1), 0);
        EMPTY_BLOCKS.add((EmptyBlockEntity) pLevel.getBlockEntity(relativePos));

        relativePos = pPos.offset(0, 0, 1);
        pLevel.setBlock(relativePos, ModBlocks.EMPTY_BLOCK.get().defaultBlockState().setValue(EmptyBlock.ENERGY, true).setValue(EmptyBlock.NZ_OFFSET, 1), 0);
        EMPTY_BLOCKS.add((EmptyBlockEntity) pLevel.getBlockEntity(relativePos));

        relativePos = pPos.offset(0, 0, -1);
        pLevel.setBlock(relativePos, ModBlocks.EMPTY_BLOCK.get().defaultBlockState().setValue(EmptyBlock.ENERGY, true).setValue(EmptyBlock.Z_OFFSET, 1), 0);
        EMPTY_BLOCKS.add((EmptyBlockEntity) pLevel.getBlockEntity(relativePos));
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState) {
        return null;
    }
}
