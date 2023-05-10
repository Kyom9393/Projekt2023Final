package com.example.pokus1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

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
        stage.getIcons().add(new Image("https://i.ibb.co/XDbLG6P/Keyboard-Project.png"));


        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource(fxml)));
        s.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}