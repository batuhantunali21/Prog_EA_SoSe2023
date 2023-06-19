package com.example.prog2.model.gameobject.hardware;

import java.util.Collection;

public class RotorStructure {
    private int numberOfRotors;
    private Collection<Rotor> rotors;

    public RotorStructure(int numberOfRotors, Collection<Rotor> rotors) {
        this.numberOfRotors = numberOfRotors;
        this.rotors = rotors;
    }

    public double getPowerConsumption() {
        return rotors.stream().mapToDouble(Rotor::getPowerConsumption).sum();
    }
}