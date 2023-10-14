package dev.andrewd1.something;

import com.mojang.logging.LogUtils;
import dev.andrewd1.something.effect.ModEffects;
import dev.andrewd1.something.item.ModCreativeTabs;
import dev.andrewd1.something.item.ModItems;
import dev.andrewd1.something.potion.ModPotions;
import dev.andrewd1.something.util.BrewingRecipe;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SomethingMod.MOD_ID)
public class SomethingMod {
    public static final String MOD_ID = "something";
    private static final Logger LOGGER = LogUtils.getLogger();
    public SomethingMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeTabs.register(eventBus);
        ModEffects.register(eventBus);
        ModPotions.register(eventBus);
        ModItems.register(eventBus);
        eventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.TOMATO_SOUP);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                    Potions.THICK,
                    Items.TNT,
                    ModPotions.EXPLODE.get()
            ));

            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                    ModPotions.EXPLODE.get(),
                    Items.REDSTONE,
                    ModPotions.EXPLODE_D.get()
            ));

            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                    ModPotions.EXPLODE.get(),
                    Items.GLOWSTONE_DUST,
                    ModPotions.EXPLODE_II.get()
            ));
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
