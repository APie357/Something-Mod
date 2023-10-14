package dev.andrewd1.something.item;

import dev.andrewd1.something.SomethingMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SomethingMod.MOD_ID);

    public static final RegistryObject<Item> TOMATO_SOUP = bowlFood("tomato_soup", ModFoods.TOMATO_SOUP);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static RegistryObject<Item> item(String id) {
        return item(id, () -> new Item(new Item.Properties()));
    }

    public static RegistryObject<Item> item(String id, Supplier<? extends Item> supplier) {
        return ITEMS.register(id, supplier);
    }

    public static RegistryObject<Item> food(String id, FoodProperties food) {
        return item(id, () -> new Item(new Item.Properties().food(food)));
    }

    public static RegistryObject<Item> bowlFood(String id, FoodProperties food) {
        return item(id, () -> new BowlFoodItem(new Item.Properties().food(food)));
    }
}
