package dev.andrewd1.something.block.entity;

import dev.andrewd1.something.SomethingMod;
import dev.andrewd1.something.block.ModBlocks;
import dev.andrewd1.something.block.entity.custom.EmptyBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SomethingMod.MOD_ID);

//    public static final RegistryObject<BlockEntityType<EmptyBlockEntity>> EMPTY_BLOCK_E =
//            BLOCK_ENTITIES.register("empty_block_entity", () ->
//                    BlockEntityType.Builder.of(() -> new EmptyBlockEntity(), ModBlocks.EMPTY_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
