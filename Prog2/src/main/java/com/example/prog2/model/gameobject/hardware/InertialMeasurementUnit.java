package com.example.prog2.model.gameobject.hardware;

import com.example.prog2.model.gameobject.hardware.IMU.Accelerometer;
import com.example.prog2.model.gameobject.hardware.IMU.GNSModule;
import com.example.prog2.model.gameobject.hardware.IMU.Gyroscope;

public class InertialMeasurementUnit extends Thread {
    private Accelerometer accelerometer;
    private Gyroscope gyroscope;
    private GNSModule gnsModule;
    private boolean running;

    public InertialMeasurementUnit() {
        this.accelerometer = new Accelerometer();
        this.gyroscope = new Gyroscope();
        this.gnsModule = new GNSModule();
        this.running = true;
    }

    @Override
    public void run() {
        while(running) {
            // Update the sensor data here. For simplicity, we will just generate random data

            //TODO
            /**accelerometer.setAcceleration(new double[] {Math.random(), Math.random(), Math.random()});
            gyroscope.setOrientation(new double[] {Math.random(), Math.random(), Math.random()});
            gnsModule.setLocation(new double[] {Math.random(), Math.random(), Math.random()});
             */

            try {
                Thread.sleep(1000); // Pause for a second
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopUpdating() {
        this.running = false;
    }

    // Getter and Setter methods

    public Accelerometer getAccelerometer() {
        return accelerometer;
    }

    public void setAccelerometer(Accelerometer accelerometer) {
        this.accelerometer = accelerometer;
    }

    public Gyroscope getGyroscope() {
        return gyroscope;
    }

    public void setGyroscope(Gyroscope gyroscope) {
        this.gyroscope = gyroscope;
    }

    public GNSModule getGnsModule() {
        return gnsModule;
    }

    public void setGnsModule(GNSModule gnsModule) {
        this.gnsModule = gnsModule;
    }
}
