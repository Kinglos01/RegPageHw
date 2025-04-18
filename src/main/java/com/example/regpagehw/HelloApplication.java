package com.example.regpagehw;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    /**
     * Represents the primary {@code Scene} object for the JavaFX application.
     * This variable holds the current scene displayed in the application's main stage.
     * The scene is initialized in the {@code start} method of the {@code HelloApplication} class
     * and can be dynamically updated or reconfigured as needed during runtime.
     */

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reg-page.fxml"));
        scene = new Scene(fxmlLoader.load(), 620, 480);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.getStylesheets().add(HelloApplication.class.getResource("drip.css").toExternalForm());
    }


    public static void main(String[] args) {
        launch();
    }


    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));

        return fxmlLoader.load();
    }
}