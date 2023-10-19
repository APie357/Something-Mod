package dev.andrewd1.something.item;

import dev.andrewd1.something.block.KetchupPortal;
import dev.andrewd1.something.block.ModBlocks;
import dev.andrewd1.something.world.dimension.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("resource")
public class KetchupBottle extends Item {
    public KetchupBottle() {
        super(new Properties()
                .stacksTo(1)
                .food(ModFoods.KETCHUP_BOTTLE)
        );
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer() != null) {
            if(context.getPlayer().level().dimension() == ModDimensions.KETCHUP_KEY
                    || context.getPlayer().level().dimension() == Level.OVERWORLD) {
                for(Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if(((KetchupPortal) ModBlocks.KETCHUP_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(context.getPlayer(), framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else return InteractionResult.FAIL;
                }
            }
        }
        return InteractionResult.FAIL;
    }
}
