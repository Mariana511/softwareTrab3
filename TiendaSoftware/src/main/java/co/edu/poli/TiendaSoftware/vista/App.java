package co.edu.poli.TiendaSoftware.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class App extends Application {
	@Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/poli/TiendaSoftware/vista/vista.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 500, 600); 
            stage.setTitle("Gestión de Pedido - TiendaSoftware");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar la interfaz FXML.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
