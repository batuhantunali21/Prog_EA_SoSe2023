package com.example.prog2.control;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NetworkController {
    private int port;
    private Socket socket;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;

    public NetworkController(int port) {
        this.port = port;
    }

    public void run() {
        try {
            establishConnection();
            // Logik für die Netzwerkkommunikation
            // sendData();
            // receiveData();
            // ...
            closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPort(int port) {
        this.port = port;
    }

    private void establishConnection() throws IOException {
        socket = new Socket("localhost", port);
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
        // Logik für die Aufbau der Verbindung
    }

    private void sendData() throws IOException {
        // Logik für das Senden von Daten
    }

    private void receiveData() throws IOException {
        // Logik für das Empfangen von Daten
    }

    private void closeConnection() throws IOException {
        inputStream.close();
        outputStream.close();
        socket.close();
        // Logik für das Schließen der Verbindung
    }
}
