package com.example.prog2.control;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {
    private Socket socket;
    private ObjectOutputStream outputStream;
    private BufferedReader bufferedReader;

    public void run() {
        try {
            String serverAddress = "localhost";
            int port = 10668;

            socket = new Socket(serverAddress, port);
            System.out.println("Connected to server: " + serverAddress);

            // Initialize input and output streams
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.flush();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedReader.mark(0);

            // Start listening for messages
            listenForMessages();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listenForMessages() throws IOException {
        while (true) {
            String message = bufferedReader.readLine();
            if (message != null) {
                System.out.println("Received message from server: " + message);
                // Parse and process the coordinates received from the server
                String[] coordinates = message.split(",");
                if (coordinates.length == 3) {
                    float x = Float.parseFloat(coordinates[0]);
                    float y = Float.parseFloat(coordinates[1]);
                    float z = Float.parseFloat(coordinates[2]);

                    // Do something with the coordinates (e.g., update UI, perform calculations, etc.)
                    handleCoordinates(x, y, z);
                }
            }
        }
    }

    private void handleCoordinates(float x, float y, float z) {
        // TODO: Implement the logic to handle the coordinates received from the server
        // In this method, you can perform actions such as updating the UI, performing calculations, etc.
        // For now, let's just print the coordinates in the console

        System.out.println("Received coordinates: x=" + x + ", y=" + y + ", z=" + z);
    }

    public void sendCoordinates(float x, float y, float z) {
        try {
            String coordinates = x + "," + y + "," + z;
            outputStream.writeObject(coordinates);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
