package com.example.prog2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label coordinatesText;
    @FXML
    private Label coordinatesLabel;
    private HelloApplication application;

    public void setApplication(HelloApplication application) {
        this.application = application;
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    // Method to update the coordinates label

    @FXML
    protected void onShowCoordinatesClick() {
        if (application != null) {
            application.startUnityCommunication();
        }
    }


    public void updateCoordinates(float x, float y, float z) {
        System.out.println("updateCoordinates called"); // Debug-Nachricht
        Platform.runLater(() -> {
            coordinatesLabel.setText(String.format("Coordinates: X - %.2f, Y - %.2f, Z - %.2f", x, y, z));
            System.out.println(String.format("Received coordinates: X - %.2f, Y - %.2f, Z - %.2f", x, y, z));
        });
    }

}