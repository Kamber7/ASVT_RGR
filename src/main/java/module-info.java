module com.example.asvt_rgr {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.asvt_rgr to javafx.fxml;
    exports com.example.asvt_rgr;
}