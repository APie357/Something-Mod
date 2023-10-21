package dev.andrewd1.something.block.entity.custom;

import dev.andrewd1.something.block.MultiBlockMachine;
import dev.andrewd1.something.block.custom.OilDerrickBlock;
import dev.andrewd1.something.util.ModEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Objects;

public class OilDerrickBlockEntity extends MultiBlockMachine {
    private final ArrayList<EmptyBlockEntity> EMPTY_BLOCKS = ((OilDerrickBlock) getBlockState().getBlock()).EMPTY_BLOCKS;
    private static final int ENERGY_CONSUMPTION = 32;
    private LazyOptional<IEnergyStorage> lazyEnergyStorage = LazyOptional.empty();
    private final ModEnergyStorage ENERGY_STORAGE = new ModEnergyStorage() {
        @Override
        public void onEnergyChanged() {
            for (EmptyBlockEntity emptyBlock : EMPTY_BLOCKS) {
                emptyBlock.setLevel(Objects.requireNonNull(getLevel()));
            }
        }
    };

    public OilDerrickBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.literal("PLACEHOLDER");  // TODO: translation
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pPlayerInventory, @NotNull Player pPlayer) {
        return null;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyEnergyStorage = LazyOptional.of(() -> ENERGY_STORAGE);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyEnergyStorage.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
    }

    @Override
    public void onDestroy() {
        for (EmptyBlockEntity emptyBlock : EMPTY_BLOCKS) {
            assert level != null;
            level.setBlock(emptyBlock.getBlockPos(), Blocks.AIR.defaultBlockState(), 0);
        }
    }
}
