package com.example.pokus1;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;

public class Controller2 {

    @FXML
    private TextField username;

    public void submit() throws IOException {
        String name = username.getText();
        FileWriter myObj = new FileWriter("username.txt");
        myObj.write(name);
        myObj.close();

        HelloApplication ha = new HelloApplication();
        ha.changeScene("hello-view.fxml");
    }

}
