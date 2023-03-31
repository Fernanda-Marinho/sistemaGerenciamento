package com.example.sistemadegerenciamento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

<<<<<<< HEAD

=======
>>>>>>> fc4fb0f7e0a540b44104c7c19a4c2641d7138dc4
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
<<<<<<< HEAD
        stage.setTitle("Gerenc. Microcomputadores");
=======
        stage.setTitle("Hello World!"); 
>>>>>>> fc4fb0f7e0a540b44104c7c19a4c2641d7138dc4
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}