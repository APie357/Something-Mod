package dev.andrewd1.something.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties TOMATO_SOUP =
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(0.2f)
                    .build();
}
