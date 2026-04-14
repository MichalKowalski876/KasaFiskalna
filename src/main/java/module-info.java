module com.example.kasa_fiskalna {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kasa_fiskalna to javafx.fxml;
    exports com.example.kasa_fiskalna;
}