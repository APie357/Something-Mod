package dev.andrewd1.something.block.custom;

import dev.andrewd1.something.block.MultiBlockMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EmptyBlock extends BaseEntityBlock {
    public static IntegerProperty X_OFFSET =
            IntegerProperty.create("x_offset", 0, 16);
    public static IntegerProperty Y_OFFSET =
            IntegerProperty.create("y_offset", 0, 16);
    public static IntegerProperty Z_OFFSET =
            IntegerProperty.create("z_offset", 0, 16);
    public static IntegerProperty NX_OFFSET =
            IntegerProperty.create("nx_offset", 0, 16);
    public static IntegerProperty NY_OFFSET =
            IntegerProperty.create("ny_offset", 0, 16);
    public static IntegerProperty NZ_OFFSET =
            IntegerProperty.create("nz_offset", 0, 16);
    public static BooleanProperty ENERGY =
            BooleanProperty.create("energy");
    public static BooleanProperty FLUID =
            BooleanProperty.create("fluid");

    public EmptyBlock() {
        super(Properties.copy(Blocks.BARRIER));
        this.registerDefaultState(this.defaultBlockState()
                .setValue(X_OFFSET, 0)
                .setValue(Y_OFFSET, 0)
                .setValue(Z_OFFSET, 0)
                .setValue(NX_OFFSET, 0)
                .setValue(NY_OFFSET, 0)
                .setValue(NZ_OFFSET, 0)
                .setValue(ENERGY, false)
                .setValue(FLUID, false)
        );
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState pState) {
        return RenderShape.INVISIBLE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState) {
        return null;
    }

    @Override
    public void destroy(@NotNull LevelAccessor pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState) {
        BlockPos originPos = pPos.offset(getXOffset(pState), getYOffset(pState), getZOffset(pState));
        MultiBlockMachine origin = (MultiBlockMachine) pLevel.getBlockState(pPos).getBlock();
        origin.destroy(pLevel, originPos);
    }

    public int getXOffset(BlockState state) {
        return state.getValue(X_OFFSET) - state.getValue(NX_OFFSET);
    }

    public int getYOffset(BlockState state) {
        return state.getValue(Y_OFFSET) - state.getValue(NY_OFFSET);
    }

    public int getZOffset(BlockState state) {
        return state.getValue(Z_OFFSET) - state.getValue(NZ_OFFSET);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(X_OFFSET);
        builder.add(Y_OFFSET);
        builder.add(Z_OFFSET);
        builder.add(NX_OFFSET);
        builder.add(NY_OFFSET);
        builder.add(NZ_OFFSET);
        builder.add(ENERGY);
        builder.add(FLUID);
        super.createBlockStateDefinition(builder);
    }
}
