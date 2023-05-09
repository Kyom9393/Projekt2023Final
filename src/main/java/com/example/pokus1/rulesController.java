package com.example.pokus1;
import javafx.scene.control.Hyperlink;
import java.io.IOException;



public class rulesController {
    public void goBack() {

        HelloApplication ha = new HelloApplication();
        try {
            ha.changeScene("hello-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void openGit() {
        Hyperlink link = new Hyperlink("https://github.com/Kyom9393");
        link.isVisited();
        link.setVisited(true);



    }
}