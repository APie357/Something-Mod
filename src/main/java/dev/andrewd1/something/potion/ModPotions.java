package dev.andrewd1.something.potion;

import dev.andrewd1.something.SomethingMod;
import dev.andrewd1.something.effect.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, SomethingMod.MOD_ID);

    public static final RegistryObject<Potion> EXPLODE =
            potion("explode", ModEffects.EXPLODE, 6000);
    public static final RegistryObject<Potion> EXPLODE_II =
            potion("explode_2", ModEffects.EXPLODE, 6000, 2);
    public static final RegistryObject<Potion> EXPLODE_D =
            potion("explode_duration", ModEffects.EXPLODE, 12000);

    public static final RegistryObject<Potion> WRATH =
            potion("wrath", ModEffects.WRATH, 6000);
    public static final RegistryObject<Potion> WRATH_II =
            potion("wrath_2", ModEffects.WRATH, 6000, 2);
    public static final RegistryObject<Potion> WRATH_D =
            potion("wrath_duration", ModEffects.WRATH, 12000);

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

    public static RegistryObject<Potion> potion(String id, RegistryObject<MobEffect> effect, int duration) {
        return POTIONS.register(id,
                () -> new Potion(new MobEffectInstance(effect.get(), duration)));
    }

    public static RegistryObject<Potion> potion(String id, RegistryObject<MobEffect> effect, int duration, int amplifier) {
        return POTIONS.register(id,
                () -> new Potion(new MobEffectInstance(effect.get(), duration, amplifier)));
    }
}
