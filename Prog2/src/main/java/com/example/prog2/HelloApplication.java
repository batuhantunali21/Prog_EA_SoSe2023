package com.example.prog2;

import com.example.prog2.control.JSONController;
import com.example.prog2.control.PositionData;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HelloApplication extends Application {
    private HelloController helloController;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        VBox root = fxmlLoader.load();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        // Get reference to HelloController
        helloController = fxmlLoader.getController();
        helloController.setApplication(this);

        // Start a client to communicate with Unity server
        startUnityCommunication();
    }

    public void startUnityCommunication() {
        new Thread(() -> {
            Socket socket = null;
            BufferedReader reader = null;
            try {
                System.out.println("Connecting to Unity server...");
                socket = new Socket("127.0.0.1", 10668); // Use the same port as the Unity client
                System.out.println("Connected to Unity server");

                // Input stream to receive data
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                JSONController jsonController = new JSONController();

                // Keep reading the coordinates from Unity and updating the UI
                String coordinates;
                while ((coordinates = reader.readLine()) != null) {
                    PositionData data = (PositionData) jsonController.jsonToObjectStatic(coordinates, PositionData.class);
                    helloController.updateCoordinates(data.getX(), data.getY(), data.getZ());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null)
                        reader.close();
                    if (socket != null)
                        socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
