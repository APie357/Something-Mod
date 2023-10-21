package dev.andrewd1.something.util;

import net.minecraftforge.energy.EnergyStorage;

public abstract class ModEnergyStorage extends EnergyStorage {
    public ModEnergyStorage() { this(64000, 8000); }
    public ModEnergyStorage(int capacity) { super(capacity); }
    public ModEnergyStorage(int capacity, int maxTransfer) { super(capacity, maxTransfer); }
    public ModEnergyStorage(int capacity, int maxReceive, int maxExtract) { super(capacity, maxReceive, maxExtract); }
    public ModEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) { super(capacity, maxReceive, maxExtract, energy);}


    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int extractedEnergy = super.extractEnergy(maxExtract, simulate);
        if (extractedEnergy != 0) { onEnergyChanged(); }
        return extractedEnergy;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int receivedEnergy = super.receiveEnergy(maxReceive, simulate);
        if (receivedEnergy != 0) { onEnergyChanged(); }
        return receivedEnergy;
    }

    public int setEnergy(int energy) {
        this.energy = energy;
        return this.energy;
    }

    public abstract void onEnergyChanged();
}
