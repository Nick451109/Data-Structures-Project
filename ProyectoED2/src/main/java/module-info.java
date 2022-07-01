module com.mycompany.proyectoed2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyectoed2 to javafx.fxml;
    exports com.mycompany.proyectoed2;

    opens com.mycompany.controllers to javafx.fxml;
    exports com.mycompany.controllers;
}
