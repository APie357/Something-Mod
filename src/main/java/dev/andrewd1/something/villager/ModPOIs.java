package dev.andrewd1.something.villager;

import com.google.common.collect.ImmutableSet;
import dev.andrewd1.something.SomethingMod;
import dev.andrewd1.something.block.ModBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPOIs {
    public static final DeferredRegister<PoiType> POI =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, SomethingMod.MOD_ID);

    public static final RegistryObject<PoiType> KETCHUP_PORTAL =
            POI.register("ketchup_portal", () -> new PoiType(ImmutableSet.copyOf(ModBlocks.KETCHUP_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));

    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}
