package com.example.prog2.model.gameobject.gameobject;

import com.example.prog2.control.MovementController;
import com.example.prog2.control.NetworkController;
import com.example.prog2.model.gameobject.hardware.InertialMeasurementUnit;
import com.example.prog2.model.gameobject.hardware.RotorStructure;
import com.example.prog2.threads.Battery;
import com.example.prog2.threads.DistanceSensor;
import com.example.prog2.threads.NetworkAdapter;

public class Drone extends GameObject {
    private InertialMeasurementUnit IMU;
    private DistanceSensor distanceSensor;
    private RotorStructure rotors;
    private Battery battery;
    private NetworkAdapter networkAdapter;
    private int status;
    private NetworkController networkController;
    private MovementController movementController;

    public Drone(String name, InertialMeasurementUnit IMU, DistanceSensor distanceSensor, RotorStructure rotors, Battery battery, NetworkAdapter networkAdapter) {
        super(name);
        this.IMU = IMU;
        this.distanceSensor = distanceSensor;
        this.rotors = rotors;
        this.battery = battery;
        this.networkAdapter = networkAdapter;
        this.status = 0; // assuming 0 means off or idle

        this.networkController = new NetworkController(10666); // Unity
        this.movementController = new MovementController();
    }

    public InertialMeasurementUnit getIMU() {
        return IMU;
    }

    public void setIMU(InertialMeasurementUnit IMU) {
        this.IMU = IMU;
    }

    public DistanceSensor getDistanceSensor() {
        return distanceSensor;
    }

    public void setDistanceSensor(DistanceSensor distanceSensor) {
        this.distanceSensor = distanceSensor;
    }

    public RotorStructure getRotors() {
        return rotors;
    }

    public void setRotors(RotorStructure rotors) {
        this.rotors = rotors;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public NetworkAdapter getNetworkAdapter() {
        return networkAdapter;
    }

    public void setNetworkAdapter(NetworkAdapter networkAdapter) {
        this.networkAdapter = networkAdapter;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public NetworkController getNetworkController() {
        return networkController;
    }

    public void setNetworkController(NetworkController networkController) {
        this.networkController = networkController;
    }

    public MovementController getMovementController() {
        return movementController;
    }

    public void setMovementController(MovementController movementController) {
        this.movementController = movementController;
    }

    // Methods
    public void startup() {
        // logic for starting up the drone
    }

    public void shutdown() {
        // logic for shutting down the drone
    }

    public void determineStatus() {
        // logic for determining the status of the drone
    }

    public int getRemainingFlightTime() {
        // logic for calculating remaining flight time based on current battery level
        return 0; // placeholder
    }

    @Override
    public void update() {
        // Logik für die Aktualisierung des Drone-Objekts
    }

    @Override
    public void render() {
        // Logik
    }
}
