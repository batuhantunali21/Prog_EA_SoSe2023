package com.example.prog2.threads;

public class Battery extends Thread {
    private double capacity;
    private double charge;
    private double dischargeRate;
    private boolean running;

    public Battery(double capacity, double charge, double dischargeRate) {
        this.capacity = capacity;
        this.charge = charge;
        this.dischargeRate = dischargeRate;
        this.running = true;
    }

    @Override
    public void run() {
        while(running) {
            if (charge > 0) {
                charge -= dischargeRate;
                if (charge < 0) {
                    charge = 0;
                }
            }

            try {
                Thread.sleep(1000); // Pause for a second
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopDischarging() {
        this.running = false;
    }

    // Getter and Setter methods

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public double getDischargeRate() {
        return dischargeRate;
    }

    public void setDischargeRate(double dischargeRate) {
        this.dischargeRate = dischargeRate;
    }
}
