package dev.andrewd1.something.mixin;

import dev.andrewd1.something.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class SalbMixin {
    @Inject(method = "shouldRenderFace", at = @At("RETURN"), cancellable = true)
    private static void shouldRenderFace(BlockState pState, BlockGetter pLevel, BlockPos pOffset, Direction pFace, BlockPos pPos, CallbackInfoReturnable<Boolean> cir) {
        if (pState.getBlock() == ModBlocks.SALB_BLOCK.get()) {
             cir.setReturnValue(!(pLevel.getBlockState(pPos.relative(pFace)).getBlock() == ModBlocks.SALB_BLOCK.get()));
        }
    }
}
