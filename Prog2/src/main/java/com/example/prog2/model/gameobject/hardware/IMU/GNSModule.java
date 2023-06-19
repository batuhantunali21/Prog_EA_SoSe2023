package com.example.prog2.model.gameobject.hardware.IMU;

public class GNSModule {
    private double[] positionCoordinates;

    public GNSModule() {
        this.positionCoordinates = new double[3]; // Initialize with zeros
    }

    public double[] getPositionCoordinates() {
        return positionCoordinates;
    }

    public void setPositionCoordinates(double[] positionCoordinates) {
        this.positionCoordinates = positionCoordinates;
    }
}
