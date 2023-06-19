package com.example.prog2.model.gameobject.hardware.IMU;

public class Accelerometer {
    private double[] linearAcceleration;
    private double[] linearVelocity;

    public Accelerometer() {
        this.linearAcceleration = new double[3]; // Initialize with zeros
        this.linearVelocity = new double[3]; // Initialize with zeros
    }


    public double[] getLinearAcceleration() {
        return linearAcceleration;
    }

    public void setLinearAcceleration(double[] linearAcceleration) {
        this.linearAcceleration = linearAcceleration;
    }

    public double[] getLinearVelocity() {
        return linearVelocity;
    }

    public void setLinearVelocity(double[] linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

}
