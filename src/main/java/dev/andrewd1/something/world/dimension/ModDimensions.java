package dev.andrewd1.something.world.dimension;

import dev.andrewd1.something.SomethingMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceLocation KETCHUP_PATH =
            new ResourceLocation(SomethingMod.MOD_ID, "ketchup");
    public static final ResourceKey<Level> KETCHUP_KEY =
            ResourceKey.create(Registries.DIMENSION, KETCHUP_PATH);
    public static final ResourceKey<DimensionType> KETCHUP_TYPE =
            ResourceKey.create(Registries.DIMENSION_TYPE, KETCHUP_PATH);

    public static void register() { }
}
