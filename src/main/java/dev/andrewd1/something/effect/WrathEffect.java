package dev.andrewd1.something.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class WrathEffect extends MobEffect {
    public WrathEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x000000);
        addAttributeModifier(Attributes.ATTACK_SPEED, "739c1047-3da3-4c4b-9aa3-d4f5d25592f3", 1.0D, AttributeModifier.Operation.ADDITION);
    }
}
