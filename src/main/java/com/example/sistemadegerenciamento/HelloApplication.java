package com.example.sistemadegerenciamento;

import com.example.sistemadegerenciamento.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Gerenc. Microcomputadores");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        MainController.main(args);
        //launch();
    }
}