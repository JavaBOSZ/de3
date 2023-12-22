module com.example.exel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exel to javafx.fxml;
    exports com.example.exel;
}