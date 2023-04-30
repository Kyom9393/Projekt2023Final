package com.example.pokus1;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage s;


    @Override
    public void start(Stage stage) throws IOException {
        s = stage;
        //Uživatel nebude moct změit velikost obrazovky
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Speed Typing Program");

        //Nastaví ikonu stage
        //Ikona musí být 32x32 nebo 16x16 px
        stage.getIcons().add(new Image("C:\\Users\\42073\\Desktop\\Projekt2023\\src\\Images\\test.jpg"));


        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = (Parent)FXMLLoader.load(this.getClass().getResource(fxml));
        s.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}