package dev.andrewd1.something.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties TOMATO_SOUP =
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(0.2f)
                    .build();

    public static final FoodProperties KETCHUP_BOTTLE =
            new FoodProperties.Builder()
                    .nutrition(16)
                    .saturationMod(0.6f)
                    .build();

    public static final FoodProperties KETCHUP_PACKET =
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.1f)
                    .build();
}
