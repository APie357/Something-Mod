package dev.andrewd1.something.block.custom;

import net.minecraft.world.level.block.BarrierBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class EmptyBlock extends BarrierBlock {
    public static IntegerProperty X_OFFSET =
            IntegerProperty.create("x_offset", -16, 16);
    public static IntegerProperty Y_OFFSET =
            IntegerProperty.create("y_offset", -16, 16);
    public static IntegerProperty Z_OFFSET =
            IntegerProperty.create("z_offset", -16, 16);

    public EmptyBlock() {
        super(Properties.copy(Blocks.BARRIER));
        this.registerDefaultState(this.defaultBlockState()
                .setValue(X_OFFSET, 0)
                .setValue(Y_OFFSET, 0)
                .setValue(Z_OFFSET, 0)
        );
    }


}
