package dev.andrewd1.something.block;

import net.minecraft.world.level.block.BarrierBlock;
import net.minecraft.world.level.block.Blocks;

public class EmptyBlock extends BarrierBlock {
    public EmptyBlock() {
        super(Properties.copy(Blocks.BARRIER));
    }
}
