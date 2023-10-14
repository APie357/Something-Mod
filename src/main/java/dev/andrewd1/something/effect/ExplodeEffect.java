package dev.andrewd1.something.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ExplodeEffect extends MobEffect {
    public ExplodeEffect() {
        super(MobEffectCategory.HARMFUL, 0xff4444);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        Level.ExplosionInteraction intr = Level.ExplosionInteraction.MOB;
        if (livingEntity.level().isClientSide) { return; }
        livingEntity.level().explode(
                null,
                livingEntity.getX(),
                livingEntity.getY()+1,
                livingEntity.getZ(),
                4f + ((amplifier + 1) * 2),
                intr
        );
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration == 1;
    }
}
