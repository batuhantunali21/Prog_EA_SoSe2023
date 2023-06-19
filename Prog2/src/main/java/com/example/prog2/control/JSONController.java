package com.example.prog2.control;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONController {
    private Gson gson;

    public JSONController() {
        this.gson = new Gson();
    }

    public void readJSON(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Lesen des JSON-Dateiinhalts
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }

            // Deserialisieren des JSON-Inhalts
            // Beispiel: Annahme einer Klasse namens DataObject
            DataObject data = gson.fromJson(jsonContent.toString(), DataObject.class);

            // Verwenden der deserialisierten Daten
            // ...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJSON(String filePath, Object object) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Serialisieren des Objekts in JSON
            String json = gson.toJson(object);

            // Schreiben des JSON in die Datei
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String objectToJson(Object object) {
        return gson.toJson(object);
    }

    public static String objectToJsonStatic(Object object) {
        return new Gson().toJson(object);
    }

    public static Object jsonToObjectStatic(String jsonString, Class<?> objectType) {
        return new Gson().fromJson(jsonString, objectType);
    }
}


