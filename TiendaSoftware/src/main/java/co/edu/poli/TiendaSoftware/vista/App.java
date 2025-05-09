package co.edu.poli.TiendaSoftware.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/co/edu/poli/TiendaSoftware/vista/vista.fxml"));
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Gestión de Pedido - Command Pattern");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
