package com.example.prog2.model.gameobject.hardware;

public class Rotor {
    private double thrust;
    private double powerConsumption;
    private double[] orientation;

    public Rotor(double thrust, double powerConsumption, double[] orientation) {
        this.thrust = thrust;
        this.powerConsumption = powerConsumption;
        this.orientation = orientation;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public double getThrust() {
        return thrust;
    }

    public void setThrust(double thrust) {
        this.thrust = thrust;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double[] getOrientation() {
        return orientation;
    }

    public void setOrientation(double[] orientation) {
        this.orientation = orientation;
    }
}