package dev.andrewd1.something.block;

import dev.andrewd1.something.block.custom.EmptyBlock;
import dev.andrewd1.something.block.entity.custom.EmptyBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;

public abstract class MultiBlockMachine extends BaseEntityBlock {
    public final ArrayList<EmptyBlockEntity> EMPTY_BLOCKS = new ArrayList<>();

    protected MultiBlockMachine(Properties pProperties) {
        super(pProperties);
    }

    public void setOriginPower(int power) { }
    public int getPower() { return 0; }
    public void onDestroy(LevelAccessor level, BlockPos pos) { }

    public final void addEmptyBlock(int xOffset, int yOffset, int zOffset, boolean energy, boolean fluid, BlockPos pos, Level level) throws IllegalArgumentException {
        if (xOffset <= -16 || xOffset >= 16) { throw new IllegalArgumentException("The variable xOffset must be in the range -16 - 16."); }
        if (yOffset <= -16 || yOffset >= 16) { throw new IllegalArgumentException("The variable yOffset must be in the range -16 - 16."); }
        if (zOffset <= -16 || zOffset >= 16) { throw new IllegalArgumentException("The variable zOffset must be in the range -16 - 16."); }

        BlockState state = ModBlocks.EMPTY_BLOCK.get().defaultBlockState();
        if (xOffset > 0) {
            state.setValue(EmptyBlock.X_OFFSET, xOffset);
        } else {
            state.setValue(EmptyBlock.NX_OFFSET, xOffset);
        }

        if (yOffset > 0) {
            state.setValue(EmptyBlock.Y_OFFSET, yOffset);
        } else {
            state.setValue(EmptyBlock.NY_OFFSET, yOffset);
        }

        if (zOffset > 0) {
            state.setValue(EmptyBlock.Z_OFFSET, zOffset);
        } else {
            state.setValue(EmptyBlock.NZ_OFFSET, zOffset);
        }

        state.setValue(EmptyBlock.ENERGY, energy);
        state.setValue(EmptyBlock.FLUID, fluid);

        level.setBlock(pos, state, 2);
    }

    public final void destroy(LevelAccessor level, BlockPos pos) {
        assert level != null;
        for (EmptyBlockEntity emptyBlock : EMPTY_BLOCKS) {
            level.setBlock(emptyBlock.getBlockPos(), Blocks.AIR.defaultBlockState(), 2);
        }

        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
        onDestroy(level, pos);
    }

    public final ArrayList<EmptyBlockEntity> getEmptyBlocks() {
        return EMPTY_BLOCKS;
    }
}
