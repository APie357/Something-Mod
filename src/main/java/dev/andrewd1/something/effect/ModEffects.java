package dev.andrewd1.something.effect;

import dev.andrewd1.something.SomethingMod;
import dev.andrewd1.something.effect.custom.ExplodeEffect;
import dev.andrewd1.something.effect.custom.WrathEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SomethingMod.MOD_ID);

    public static final RegistryObject<MobEffect> EXPLODE =
            EFFECTS.register("explode", ExplodeEffect::new);
    public static final RegistryObject<MobEffect> WRATH =
            EFFECTS.register("wrath", WrathEffect::new);

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
