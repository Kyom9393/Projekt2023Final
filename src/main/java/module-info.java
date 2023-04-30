module com.example.pokus1 {
    requires javafx.controls;
    requires javafx.fxml;
            
            requires com.dlsc.formsfx;
                        
    opens com.example.pokus1 to javafx.fxml;
    exports com.example.pokus1;
}