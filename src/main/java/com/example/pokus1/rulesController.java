package com.example.pokus1;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URI;


public class rulesController {
    public void goBack(ActionEvent actionEvent) {

        HelloApplication ha = new HelloApplication();
        try {
            ha.changeScene("hello-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void openGit(ActionEvent actionEvent) {
    }
}

