package dev.andrewd1.something.block.entity.custom;

import dev.andrewd1.something.block.ModBlocks;
import dev.andrewd1.something.block.MultiBlockMachine;
import dev.andrewd1.something.block.custom.EmptyBlock;
import dev.andrewd1.something.block.entity.ModBlockEntities;
import dev.andrewd1.something.util.ModEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class EmptyBlockEntity extends BlockEntity {
    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();
    public final BlockPos originPos;
    public final BlockState origin;
    public final MultiBlockMachine originMachine;
    private final ModEnergyStorage ENERGY_STORAGE = new ModEnergyStorage() {
        @Override
        public void onEnergyChanged() {
            originMachine.setOriginPower(getEnergyStored());
            setChanged();
        }
    };

    public EmptyBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.EMPTY_BE.get(), pPos, pBlockState);
        assert level != null;
        originPos = pPos.offset(pBlockState.getValue(EmptyBlock.X_OFFSET), pBlockState.getValue(EmptyBlock.Y_OFFSET), pBlockState.getValue(EmptyBlock.Z_OFFSET));
        origin = level.getBlockState(originPos);
        originMachine = (MultiBlockMachine) level.getBlockState(originPos).getBlock();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if (cap == ForgeCapabilities.ENERGY && getBlockState().getValue(EmptyBlock.ENERGY)) {
            return lazyEnergyHandler.cast();
        }

        return super.getCapability(cap);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyEnergyHandler.invalidate();
    }
}
