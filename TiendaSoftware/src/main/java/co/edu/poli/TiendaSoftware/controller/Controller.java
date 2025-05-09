package co.edu.poli.TiendaSoftware.controller;

import co.edu.poli.TiendaSoftware.modelo.AgregarProductoCommand;
import co.edu.poli.TiendaSoftware.modelo.Cliente;
import co.edu.poli.TiendaSoftware.modelo.Pedido;
import co.edu.poli.TiendaSoftware.modelo.Producto;
import co.edu.poli.TiendaSoftware.modelo.QuitarProductoCommand;
import co.edu.poli.TiendaSoftware.servicio.EmpaqueServicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
	 	@FXML private TextField txtCliente;
	    @FXML private TextField txtProducto;
	    @FXML private ListView<Producto> listViewProductos;
	    @FXML private Label lblMensaje;
	    
	    @FXML private ComboBox<String> comboEmpaque;
	    @FXML private Label labelResultado;

	    private Pedido pedido;
	    private ObservableList<Producto> productosObservable = FXCollections.observableArrayList();

	    @FXML
	    public void initialize() {
	        listViewProductos.setItems(productosObservable);
	        comboEmpaque.getItems().addAll("Regalo", "Ecológico", "Estandar");
	    }

	    @FXML
	    private void crearPedido() {
	        String nombreCliente = txtCliente.getText();
	        if (nombreCliente.isEmpty()) {
	            lblMensaje.setText("Nombre de cliente vacío.");
	            return;
	        }

	        pedido = new Pedido(new Cliente(nombreCliente));
	        lblMensaje.setText("Pedido creado para " + nombreCliente);
	        productosObservable.clear();
	    }

	    @FXML
	    private void agregarProducto() {
	        if (pedido == null) {
	            lblMensaje.setText("Primero crea un pedido.");
	            return;
	        }

	        String nombreProducto = txtProducto.getText();
	        if (nombreProducto.isEmpty()) {
	            lblMensaje.setText("Nombre de producto vacío.");
	            return;
	        }

	        Producto producto = new Producto(nombreProducto);
	        AgregarProductoCommand command = new AgregarProductoCommand(pedido, producto);
	        command.ejecutar();
	        productosObservable.add(producto);
	        lblMensaje.setText("Producto agregado.");
	    }

	    @FXML
	    private void quitarProducto() {
	        Producto productoSeleccionado = listViewProductos.getSelectionModel().getSelectedItem();
	        if (productoSeleccionado == null || pedido == null) {
	            lblMensaje.setText("Selecciona un producto.");
	            return;
	        }

	        QuitarProductoCommand command = new QuitarProductoCommand(pedido, productoSeleccionado);
	        command.ejecutar();
	        productosObservable.remove(productoSeleccionado);
	        lblMensaje.setText("Producto quitado.");
	    }
	    
	    private EmpaqueServicio empaqueServicio = new EmpaqueServicio();
	    
	    @FXML
	    private void empacarProducto() {
	        Producto productoSeleccionado = listViewProductos.getSelectionModel().getSelectedItem();
	        if (productoSeleccionado == null) {
	            labelResultado.setText("Selecciona un producto para empacar.");
	            return;
	        }

	        String tipo = comboEmpaque.getValue();
	        String resultado = empaqueServicio.procesarEmpaque(productoSeleccionado, tipo);
	        labelResultado.setText(resultado);
	    }
}


