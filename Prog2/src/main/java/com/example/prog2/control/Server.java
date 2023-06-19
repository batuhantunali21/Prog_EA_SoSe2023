package com.example.prog2.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream outputStream;
    private BufferedReader bufferedReader;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            // Wait for a client to connect
            clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Initialize input and output streams
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            outputStream.flush();
            bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Start listening for messages
            listenForMessages();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                outputStream.close();
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listenForMessages() throws IOException {
        while (true) {
            String message = bufferedReader.readLine();
            if (message != null) {
                System.out.println("Received message from client: " + message);
                // Parse and process the coordinates received from the client
                String[] coordinates = message.split(",");
                if (coordinates.length == 3) {
                    float x = Float.parseFloat(coordinates[0]);
                    float y = Float.parseFloat(coordinates[1]);
                    float z = Float.parseFloat(coordinates[2]);

                    // Handle the coordinates (e.g., update UI, perform calculations, etc.)
                    handleCoordinates(x, y, z);
                }
            }
        }
    }

    private void handleCoordinates(float x, float y, float z) {
        // TODO: Implement the logic to handle the coordinates
        // In this method, you can perform actions such as updating the UI, performing calculations, etc.
        // For now, let's just print the coordinates in the console

        System.out.println("Coordinates: x=" + x + ", y=" + y + ", z=" + z);
    }
}
