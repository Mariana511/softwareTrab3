module co.edu.poli.TiendaSoftware {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.TiendaSoftware to javafx.fxml;
    exports co.edu.poli.TiendaSoftware;
}
