package dev.andrewd1.something.block;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public interface IMultiBlockMachine {
    @NotNull Component getDisplayName();
    default void setOriginPower(int power) { }
    default int getPower() { return 0; }
    void onDestroy();
}
