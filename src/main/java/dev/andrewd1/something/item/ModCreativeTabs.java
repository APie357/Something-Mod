package dev.andrewd1.something.item;

import dev.andrewd1.something.SomethingMod;
import dev.andrewd1.something.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SomethingMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SOMETHING_TAB =
            TABS.register("something", () ->
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.TOMATO_SOUP.get()))
                            .title(Component.translatable("creative_tab.something"))
                            .displayItems((parameters, output) -> {
                                for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                                    output.accept(item.get());
                                }
                                for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
                                    if (ModBlocks.BLOCKS_NO_ITEM.contains(block)) { continue; }
                                    output.accept(block.get());
                                }
                            })
                            .build()
            );

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
