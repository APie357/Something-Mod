package dev.andrewd1.something.block;

import dev.andrewd1.something.SomethingMod;
import dev.andrewd1.something.item.ModItems;
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

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SomethingMod.MOD_ID);

    public static final RegistryObject<Block> KETCHUP_BLOCK =
            registerBlock("ketchup_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> SALB_BLOCK =
            registerBlock("salb", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE_SLAB)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String id, RegistryObject<T> block) {
        return ModItems.item(id, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String id, Supplier<T> supplier) {
        RegistryObject<T> toReturn = BLOCKS.register(id, supplier);
        registerBlockItem(id, toReturn);
        return toReturn;
    }
}