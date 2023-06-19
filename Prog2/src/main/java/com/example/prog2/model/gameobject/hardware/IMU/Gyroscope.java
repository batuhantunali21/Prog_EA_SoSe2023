package com.example.prog2.model.gameobject.hardware.IMU;

public class Gyroscope {
    private double[] angularAcceleration;
    private double[] angularVelocity;
    private double[] orientation;

    public Gyroscope() {
        this.angularAcceleration = new double[3]; // Initialize with zeros
        this.angularVelocity = new double[3]; // Initialize with zeros
        this.orientation = new double[3]; // Initialize with zeros
    }

    public double[] getAngularAcceleration() {
        return angularAcceleration;
    }

    public void setAngularAcceleration(double[] angularAcceleration) {
        this.angularAcceleration = angularAcceleration;
    }

    public double[] getAngularVelocity() {
        return angularVelocity;
    }

    public void setAngularVelocity(double[] angularVelocity) {
        this.angularVelocity = angularVelocity;
    }

    public double[] getOrientation() {
        return orientation;
    }

    public void setOrientation(double[] orientation) {
        this.orientation = orientation;
    }
}
