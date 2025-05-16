
module co.edu.poli.TiendaSoftware {
    requires java.base;
    requires javafx.controls;
    requires javafx.fxml;

    exports co.edu.poli.TiendaSoftware.controller;
    exports co.edu.poli.TiendaSoftware.modelo;
    exports co.edu.poli.TiendaSoftware.Vista;

    opens co.edu.poli.TiendaSoftware.Vista to javafx.fxml;
    opens co.edu.poli.TiendaSoftware.controller to javafx.fxml;
}