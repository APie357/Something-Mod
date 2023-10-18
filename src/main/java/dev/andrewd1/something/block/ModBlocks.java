package dev.andrewd1.something.block;

import dev.andrewd1.something.SomethingMod;
import dev.andrewd1.something.item.ModItems;
import net.minecraft.util.datafix.fixes.RemoveGolemGossipFix;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SomethingMod.MOD_ID);
    public static final ArrayList<RegistryObject<Block>> BLOCKS_NO_ITEM =
            new ArrayList<>();

    public static final RegistryObject<Block> KETCHUP_BLOCK =
            registerBlock("ketchup_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> KETCHUP_PORTAL =
            registerBlockWithoutItem("ketchup_portal", KetchupPortal::new);
    public static final RegistryObject<Block> SALB_BLOCK =
            registerBlock("salb", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE_SLAB)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static <T extends Block> RegistryObject<Item> registerBlockItem(String id, RegistryObject<T> block) {
        return ModItems.item(id, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String id, Supplier<T> supplier) {
        RegistryObject<T> toReturn = BLOCKS.register(id, supplier);
        registerBlockItem(id, toReturn);
        return toReturn;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String id, Supplier<T> supplier) {
        RegistryObject<T> toReturn = BLOCKS.register(id, supplier);
        BLOCKS_NO_ITEM.add((RegistryObject<Block>) toReturn);
        return toReturn;
    }
}
