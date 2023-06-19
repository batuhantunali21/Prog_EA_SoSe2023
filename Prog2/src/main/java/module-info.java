module com.example.prog2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.prog2 to javafx.fxml;
    exports com.example.prog2;
    exports com.example.prog2.model.gameobject;
    opens com.example.prog2.model.gameobject to javafx.fxml;
    exports com.example.prog2.model.gameobject.hardware;
    opens com.example.prog2.model.gameobject.hardware to javafx.fxml;
    exports com.example.prog2.model.gameobject.hardware.IMU;
    opens com.example.prog2.model.gameobject.hardware.IMU to javafx.fxml;
    exports com.example.prog2.model.gameobject.gameobject;
    opens com.example.prog2.model.gameobject.gameobject to javafx.fxml;
}