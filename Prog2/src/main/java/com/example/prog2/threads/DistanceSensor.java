package com.example.prog2.threads;

public class DistanceSensor extends Thread {
    private double[][] distanceToEnvironment;

    public DistanceSensor(double[][] distanceToEnvironment) {
        this.distanceToEnvironment = distanceToEnvironment;
    }

    public double[][] getDistanceToEnvironment() {
        return distanceToEnvironment;
    }

    public void setDistanceToEnvironment(double[][] distanceToEnvironment) {
        this.distanceToEnvironment = distanceToEnvironment;
    }

    // Diese Methode gibt den kleinsten Wert im Array zurück, was das nächste Hindernis darstellt
    public double returnClosestObstacle() {
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < distanceToEnvironment.length; i++) {
            for (int j = 0; j < distanceToEnvironment[i].length; j++) {
                if (distanceToEnvironment[i][j] < minDistance) {
                    minDistance = distanceToEnvironment[i][j];
                }
            }
        }
        return minDistance;
    }

    @Override
    public void run() {
        // Hier können Sie Logik hinzufügen, um regelmäßig die Entfernung zur Umgebung zu aktualisieren
    }
}
