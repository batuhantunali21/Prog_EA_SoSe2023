package com.example.prog2.threads;

public class NetworkAdapter extends Thread {
    private String ipAddress;
    private int port;
    private int status;

    public NetworkAdapter() {
        this.ipAddress = "127.0.0.2"; // Set default to localhost
        this.port = 10666; // Unity port
        this.status = 0; // Default status
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public void run() {
        // Netzwerklogik implementieren
        // z.B. Verbindung zu einem Server aufbauen, Daten senden/empfangen usw. JSON??
    }
}

